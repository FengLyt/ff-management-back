package com.cheng.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.springboot.pojo.Dept;
import com.cheng.springboot.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper extends BaseMapper<Dept> {
}
