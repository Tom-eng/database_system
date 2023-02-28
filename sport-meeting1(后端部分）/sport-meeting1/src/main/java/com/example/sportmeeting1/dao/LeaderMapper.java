package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.Leader;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaderMapper extends BaseMapper<Leader> {
    void insertLeader(Leader l);
}
