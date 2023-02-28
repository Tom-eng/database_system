package com.example.sportmeeting1.controller;


import com.example.sportmeeting1.dao.*;
import com.example.sportmeeting1.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarException;

@Controller
public class MeetingController {
    @Autowired
    JudgeMapper judgeMapper;
    @Autowired
    JudgeJoinMapper judgeJoinMapper;
    @Autowired
    AthleteJoinMapper athleteJoinMapper;
    @Autowired
    SignInMapper signInMapper;
    @Autowired
    ProjectMapper projectMapper;
    Judge judge=new Judge();
    //裁判登录
    @GetMapping(value="/judge")//
    public @ResponseBody Object JudgeTest( String judgeId,String password)
    {
        int judgeId_int =Integer.parseInt(judgeId);

        judge = judgeMapper.selectByPrimaryKey(judgeId_int);

        if(!judge.getPassword().equals(password))
            return null;
        //List<JudgeJoin> judgeJoins=judgeJoinMapper.selectByJudgeId(judgeId_int);
        List<AthleteJoin> athleteJoins= athleteJoinMapper.selectByJudgeId(judgeId_int);
        if(athleteJoins==null)return "juad";
        /*for (JudgeJoin judgeJoin:judgeJoins) {
           athleteJoins.addAll(athleteJoinMapper.selectByProjectNumberAndGroupNumber(judgeJoin.getProjectNumber(),judgeJoin.getGroupNumber()));
        }*/
        List<JudgeShow> judgeShows=new ArrayList<JudgeShow>();
        for(AthleteJoin athleteJoin:athleteJoins)
        {
            JudgeShow judgeShow=new JudgeShow();
            judgeShow.setAthleteNumber(athleteJoin.getAthleteNumber());
            judgeShow.setGroupNumber(athleteJoin.getGroupNumber());
            judgeShow.setProjectNumber(athleteJoin.getProjectNumber());
            judgeShow.setScore(athleteJoin.getScore());
            Project project= projectMapper.selectProjectNumber(athleteJoin.getProjectNumber());
            judgeShow.setProjectTime(project.getProjectTime());
            judgeShow.setProjectAddress(project.getProjectLocation());

            judgeShows.add(judgeShow);
        }
        Map<String,List<JudgeShow>> result=new HashMap<String,List<JudgeShow>>();
        result.put("judgeJoin",judgeShows);
        return result;
    }
    //裁判打分
    @GetMapping(value="/judge/score")//{projectNumber}/{groupNumber}/{athleteNumber}/{score}
    public @ResponseBody Object JudgeGrade(String projectNumber, String groupNumber,String athleteNumber, String score,String judgeId)
    {

        AthleteJoin athleteJoin=athleteJoinMapper.selectByProjectNumberAndGroupNumberAndAthleteNumberAndJudgeId(Integer.parseInt(projectNumber),Integer.parseInt(groupNumber),Integer.parseInt(athleteNumber),Integer.parseInt(judgeId));

        /*for (AthleteJoin athleteJoin1:athleteJoins)
        {
            if(athleteJoin1.getJudgeId()==Integer.parseInt(judgeId));
            athleteJoin=athleteJoin1;
        }*/
        athleteJoin.setScore(Integer.parseInt(score));
        athleteJoinMapper.updateByPrimaryKey(athleteJoin);
        return "打分成功";
    }
    //管理员打开添加队伍页面
    @GetMapping(value="/administrator/team")
    public @ResponseBody Object AdministratorTeamTest()
    {
        List<SignIn> signIns=signInMapper.selectAll();
        if(signIns!=null)
        { Map<String,List<SignIn>> signInsMap=new HashMap<String,List<SignIn>>();
            signInsMap.put("signIns",signIns);
            return signInsMap;}
        else return null;
    }
    //管理员添加队伍
    @GetMapping(value="/administrator/addteam")
    public @ResponseBody Object AdministratorAddTeamTest( String teamId,String password,String teamName)
    {

        SignIn signIn=new SignIn();
        signIn.setTeamId(teamId);
        signIn.setTeamName(teamName);
        signIn.setTeamPassword(password);
        signInMapper.insert(signIn);
        //显示数据库中已有的
        List<SignIn> signIns=signInMapper.selectAll();
        Map<String,List<SignIn>> signInsMap=new HashMap<String,List<SignIn>>();
        signInsMap.put("signIns",signIns);
        return signInsMap;
    }
    //管理员打开添加比赛的页面
    @GetMapping(value="/administrator/project")
    public @ResponseBody Object AdministratorProjectTest()
    {

        return getObject();
    }

    private Object getObject() {
        List<Project> projects=projectMapper.selectAll();
        if(projects!=null)
        { Map<String,List<Project>> projectsMap=new HashMap<String,List<Project>>();
            projectsMap.put("signIns",projects);
            return projectsMap;}
        else return null;
    }

    //管理员输入比赛，赛事安排
    @GetMapping(value="/administrator/addproject")
    public  @ResponseBody Object AdministratorProjectTest(String projectNumber,String projectName,String sexGroup,String ageGroup,String projectTime, String projectLocation)
    {
        Project project=new Project();
        project.setProjectName(projectName);
        project.setProjectNumber(Integer.parseInt(projectNumber));
        project.setSexGroup(sexGroup);
        project.setAgeGroup(ageGroup);
        project.setProjectTime(projectTime);
        project.setProjectLocation(projectLocation);
        projectMapper.insert(project);
        List<AthleteJoin> athleteJoins=athleteJoinMapper.selectByProjectNumber(project.getProjectNumber());
        if(athleteJoins!=null) {
            int j = 8;
            for (AthleteJoin athleteJoin : athleteJoins) {
                athleteJoin.setGroupNumber(j / 8);
                athleteJoinMapper.updateByProjectNumberAndAthleteNumber(athleteJoin);
                j++;
            }
        }
        List<Judge> judges=judgeMapper.selectAll();
        if(judges==null)return "judges is null";
        Map<Integer,Integer> show=new HashMap<Integer,Integer>();//项目号和组号的哈希表
        int group = ((athleteJoins.size() % 8 == 0) ? (athleteJoins.size() / 8 ): (athleteJoins.size() / 8 + 1));
        for (int k = 1; k <= group; k++) {
            show.put(k, project.getProjectNumber());
        }
        for(Map.Entry<Integer,Integer> entry:show.entrySet())
        {
            ProjectManage projectManage=new ProjectManage();
            projectManage.setJudgeIds(new ArrayList<Integer>());
            // Random random=new Random();
            for(int i=0;i<5;i++) {
                // int temp= random.nextInt(judges.size());
                projectManage.addJudgeIds(judges.get(i));
            }
            List<AthleteJoin> athleteJoins1=athleteJoinMapper.selectByProjectNumberAndGroupNumber(entry.getValue(), entry.getKey());//提取出同项目同组的所有记录随机选择裁判
            for(AthleteJoin athleteJoin:athleteJoins1){
                athleteJoinMapper.deleteByPrimaryKey(athleteJoin.getOrderNumber());
                for(int k=0;k<(projectManage.getJudgeIds().size());k++)
                {
                    AthleteJoin athleteJoin2=athleteJoin;
                    athleteJoin2.setJudgeId(projectManage.getJudgeIds().get(k));
                    athleteJoinMapper.insert(athleteJoin2);
                }
            }
        }
        List<AthleteJoin> athleteJoins3 =athleteJoinMapper.selectAll();
        Map<String,List<AthleteJoin>> map=new HashMap<String,List<AthleteJoin>>();
        map.put("athleteJoins",athleteJoins3);
        return map;
    }

}
