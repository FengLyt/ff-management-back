package com.cheng.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.springboot.mapper.RoleMapper;
import com.cheng.springboot.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List getRoleList(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","name");
        List list = roleMapper.selectList(queryWrapper);
        return list;
    }
}
