package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.AthleteJoin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AthleteJoinMapper extends BaseMapper {
    List<AthleteJoin> selectByProjectNumberAndGroupNumber(Integer projectNumber,Integer groupNumber);
    List<AthleteJoin> selectAll();
    void insertAthleteJoin(AthleteJoin aj);  //添加运动员信息时添加运动员比赛项目信息到athlete_join表中
    List<AthleteJoin> selectByProjectNumber(Integer projectNumber); //根据项目号来提取运动员
    List<AthleteJoin> selectByProjectNumberAndAthleteNumber(Integer projectNumber,Integer athleteNumber);
    List<AthleteJoin> selectByJudgeId(Integer judgeId);
    void updateByPrimaryKey(AthleteJoin record);
    void updateByProjectNumberAndAthleteNumber(AthleteJoin record);
    int deleteByPrimaryKey(Integer orderNumber);
    AthleteJoin selectByProjectNumberAndGroupNumberAndAthleteNumberAndJudgeId(Integer projectNumber,Integer groupNumber,Integer athleteNumber,Integer judgeId);
}
