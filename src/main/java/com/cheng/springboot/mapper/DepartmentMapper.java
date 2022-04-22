package com.cheng.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.springboot.pojo.Dept;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper extends BaseMapper<Dept> {
}
