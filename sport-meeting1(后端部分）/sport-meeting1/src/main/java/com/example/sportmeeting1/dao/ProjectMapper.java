package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProjectMapper extends BaseMapper {
    Project selectProjectNumber(Integer projectNumber);
    int insert(Project record);
    List<Project> selectAll();
}
