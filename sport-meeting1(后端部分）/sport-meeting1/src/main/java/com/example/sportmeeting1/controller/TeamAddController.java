package com.example.sportmeeting1.controller;


import com.example.sportmeeting1.dao.*;
import com.example.sportmeeting1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.rmi.dgc.Lease;
import java.util.List;

@Controller
//该类表示添加团队成员的信息
public class TeamAddController {

    @Autowired
    AthleteMapper athleteMapper;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    LeaderMapper leaderMapper;

    @Autowired
    JudgeMapper judgeMapper;

    @Autowired
    CoachMapper coachMapper;

    @Autowired
    AthleteJoinMapper athletseJoinMapper;

    //添加参赛的运动员
    @GetMapping(value="/addAthlete")
    public @ResponseBody void addAthlete(String team_name, String team_id, String athlete_name, String athlete_sex,String athlete_age,
                                         String athlete_tel,String athlete_id,String project_number){
        Athlete athlete = new Athlete();
        athlete.setAthleteName(athlete_name);
        athlete.setAthleteAge(Integer.parseInt(athlete_age));
        int curSex = 1;  //当前运动员的性别
        if(athlete_sex=="男"){
            athlete.setAthleteSex(1); //这里1表示男性 0表示女性
            curSex = 1;
        }else if(athlete_sex=="女"){
            athlete.setAthleteSex(0);
            curSex = 0;
        }
        athlete.setAthleteTel(athlete_tel);
        athlete.setId(Integer.parseInt(athlete_id));
        athlete.setTeamName(team_name);
        athlete.setTeamId(team_id);
        //系统计算出运动员的athlete_number
        List<Athlete> athletes = athleteMapper.selectAll();
        int athleteNumber = 000;
        //接下来计算同性别的运动员个数
        Integer athleteMaleMax = -1; //遍历得到最大的男性编号
        Integer athleteFemaleMax = -2; //遍历得到最大的女性编号
        for (int i = 0; i < athletes.size(); i++) {
            if(athletes.size()==0) break;
            if(athletes.get(i).getAthleteSex()==1){
                athleteMaleMax = Math.max(athleteMaleMax,athletes.get(i).getAthleteNumber());
            }else if(athletes.get(i).getAthleteSex() == 0){
                athleteFemaleMax = Math.max(athleteFemaleMax,athletes.get(i).getAthleteNumber());
            }
        }
        if(curSex==1){
            athleteNumber = athleteMaleMax + 2;
        }else if(curSex == 0){
            athleteNumber = athleteFemaleMax + 2;
        }
        athlete.setAthleteNumber(athleteNumber);
        athleteMapper.insertAthlete(athlete);

        //添加运动员参加的比赛项目信息
        AthleteJoin athleteJoin = new AthleteJoin();
        athleteJoin.setAthleteName(athlete_name);
        athleteJoin.setAthleteNumber(athleteNumber);  //添加运动员编号
        athleteJoin.setProjectNumber(Integer.parseInt(project_number));
        athleteJoin.setTeamId(team_id);
        athleteJoin.setAthleteNumber(athleteNumber);
        athletseJoinMapper.insertAthleteJoin(athleteJoin);

    }

    //添加队医信息
    @GetMapping(value = "/addDoctor")//{team_id}/{doctor_name}/{doctor_id}/{doctor_tel}")
    public @ResponseBody void addDoctor( String team_id, String doctor_name, String doctor_id, String doctor_tel){
        Doctor doctor = new Doctor();
        doctor.setDoctorName(doctor_name);
        doctor.setDoctorId(doctor_id);
        doctor.setDoctorTel(doctor_tel);
        doctor.setTeamId(team_id);
        doctorMapper.insertDoctor(doctor);
    }

    //添加领队信息(leader)
    @GetMapping(value = "/addLeader")//{team_id}/{leader_name}/{leader_id}/{leader_tel}")
    public @ResponseBody void addLeader(String team_id,String leader_name, String leader_id, String leader_tel){
        Leader leader = new Leader();
        leader.setLeaderName(leader_name);
        leader.setLeaderId(leader_id);
        leader.setLeaderTel(leader_tel);
        leader.setTeamId(team_id);
        leaderMapper.insertLeader(leader);
    }

    //添加裁判信息
    @GetMapping(value = "/addJudge")  //{team_id}/{judge_name}/{judge_id}/{judge_tel}")
    public @ResponseBody void addJudge(String team_id, String judge_name,String judge_id,String judge_tel){
        Judge judge = new Judge();
        judge.setJudgename(judge_name);
        judge.setJudgeId(Integer.parseInt(judge_id));
        judge.setTel(Integer.parseInt(judge_tel));
        judge.setTeamId(team_id);
        judgeMapper.insertJudge(judge);
    }

    //添加教练员信息
    @GetMapping(value = "/addCoach") //{team_id}/{coach_name}/{coach_id}/{coach_tel}/{coach_sex}")
    public @ResponseBody void addCoach(String team_id, String coach_name, String coach_id, String coach_tel, String coach_sex
                                       ){
        Coach coach = new Coach();
        coach.setCoachName(coach_name);
        coach.setTeamId(team_id);
        coach.setCoachId(coach_id);
        coach.setCoachTel(coach_tel);
        coach.setCoachSex(coach_sex);
        coachMapper.insertCoach(coach);
    }


}
