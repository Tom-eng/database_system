package com.example.sportmeeting1.dao;


import com.example.sportmeeting1.model.Coach;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoachMapper {
    void insertCoach(Coach c);
}
