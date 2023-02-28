package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.JudgeJoin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JudgeJoinMapper extends BaseMapper {
    List<JudgeJoin> selectByJudgeId(Integer judgeId);
}
