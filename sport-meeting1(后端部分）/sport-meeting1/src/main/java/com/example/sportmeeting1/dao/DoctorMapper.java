package com.example.sportmeeting1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportmeeting1.model.Doctor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
    void insertDoctor(Doctor t);
}
