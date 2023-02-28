package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.Athlete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AthleteMapper extends BaseMapper<Athlete> {
    List<Athlete> selectAll();
    void insertAthlete(Athlete a);
}
