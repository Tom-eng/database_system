package com.example.sportmeeting1.controller;


import com.example.sportmeeting1.dao.AthleteJoinMapper;
import com.example.sportmeeting1.dao.AthleteJoinPreliminaryMapper;
import com.example.sportmeeting1.model.Athlete;
import com.example.sportmeeting1.model.AthleteJoin;
import com.example.sportmeeting1.utils.Calculate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.CollationElementIterator;
import java.util.*;

@Controller
public class ShowResultController {
    @Autowired
    AthleteJoinMapper athleteJoinMapper;

    @Autowired
    AthleteJoinPreliminaryMapper athleteJoinPreliminaryMapper;

    //展示个人单项的成绩
    /*
    * 实现思路：
    * 按照项目号将运动员全部取出来存储下来其中运动员的姓名（set）然后用dao层根据项目号和姓名来从数据库取出该运动员的所有
    * 成绩到一个数组里，然后针对该数组去除最大最小值算出平均值，然后用athleteJoin来存储，存到一个list里用list自带的排序功能
    * 对他们进行排序
    * */
    @GetMapping (value = "/individualShow")
    public @ResponseBody Object individualShow(String project_number){
        List<AthleteJoin> individualResults  = athleteJoinMapper.selectByProjectNumber(Integer.parseInt(project_number)); //存储所有的运动员成绩
        //计算运动员的个人成绩
        Set<Integer> athleteNumbers = new HashSet<>();  //记录该项目组里的运动员编号
        for (int i = 0; i < individualResults.size(); i++) {
            if(individualResults.get(i).getScore()!=null) {
                athleteNumbers.add(individualResults.get(i).getAthleteNumber());
            }
        }
        //根据运动员的编号去查找表里该运动员该项目的所有成绩
        List<AthleteJoin> resultsFinal = new ArrayList<>(); //最终的成绩  每一个运动员对应一个经过处理后的平均值成绩
        for (Integer athnum:athleteNumbers) {
            List<AthleteJoin> results = athleteJoinMapper.selectByProjectNumberAndAthleteNumber(Integer.parseInt(project_number),athnum);
            for (int i = 0; i < results.size(); i++) {
                if(results.get(i).getScore()==null){
                    results.remove(i);  //取出来的该成员该项目中的成绩总和如果有记录是空的就移除
                }
            }
            //按照降序排序
            Collections.sort(results, new Comparator<AthleteJoin>() {
                @Override
                public int compare(AthleteJoin o1, AthleteJoin o2) {
                    return o2.getScore().compareTo(o1.getScore());
                }
            });
            //去掉最高分去掉最低分取平均值
            results.remove(0);
            results.remove(results.size()-1);
            Integer score = Calculate.average(results);
            AthleteJoin at = new AthleteJoin();
            //BeanUtils.copyProperties(at,results.get(0));
            results.get(0).setScore(score);
            athleteJoinPreliminaryMapper.insertAthleteJoinPreliminary(results.get(0)); //将初赛的成绩（平均值）录入到初赛成绩表里
            //at.setScore(score);
            resultsFinal.add(results.get(0));
        }
        //针对这个最终成绩表进行排序
        Collections.sort(resultsFinal, new Comparator<AthleteJoin>() {
            @Override
            public int compare(AthleteJoin o1, AthleteJoin o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        return resultsFinal;
    }
    //团体成绩单项排名功能
    @GetMapping(value = "teamShow")
    public @ResponseBody Object teamShow(String project_number)
    {
        List<AthleteJoin> teamResults = athleteJoinPreliminaryMapper.selectByProjectNumber(Integer.parseInt(project_number));
        //用一个set记录表里该项目（project_number）所有的team_id
        Set<String> teamIds = new HashSet<>();
        for(int i=0;i<teamResults.size();i++){
            teamIds.add(teamResults.get(i).getTeamId());
        }
        //最终的成绩  每个国家对于每个项目有一个成绩（平均值）
        List<AthleteJoin> resultsFinal = new ArrayList<>();
        for (String teamid:teamIds) {
            //把同一个队伍的在这个项目下的所有成绩取出来进行操作
            List<AthleteJoin> results = athleteJoinPreliminaryMapper.selectByProjectNumberAndTeamId(Integer.parseInt(project_number),teamid);
            //取得一个队伍的成绩平均值
            Integer score = Calculate.average(results);
            results.get(0).setScore(score);
            resultsFinal.add(results.get(0));
        }
        Collections.sort(resultsFinal, new Comparator<AthleteJoin>() {
            @Override
            public int compare(AthleteJoin o1, AthleteJoin o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        return resultsFinal;
    }


}
