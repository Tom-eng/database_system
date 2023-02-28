package com.example.sportmeeting1.dao;

import com.example.sportmeeting1.model.AthleteJoin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AthleteJoinPreliminaryMapper {
    void insertAthleteJoinPreliminary(AthleteJoin aj);
    List<AthleteJoin> selectByProjectNumber(Integer project_number);
    List<AthleteJoin> selectByProjectNumberAndTeamId(@Param("projectNumber") Integer project_number, @Param("teamId") String team_id);
}
