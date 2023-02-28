package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.Judge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JudgeMapper extends BaseMapper {

    void insertJudge(Judge j);
    Judge selectByPrimaryKey(Integer judgeId);

    List<Judge> selectAll();
}
