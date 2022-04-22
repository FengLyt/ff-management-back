package com.cheng.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.springboot.mapper.DeptMapper;
import com.cheng.springboot.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    public List getDeptList(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","name");
        List list = deptMapper.selectList(queryWrapper);
        return list;
    }
}
