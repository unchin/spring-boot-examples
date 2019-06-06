package com.steven.demo.teacher;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
}
