package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.SignIn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SignInMapper extends BaseMapper {
    List<SignIn> selectAll();
    int insert(SignIn record);
}
