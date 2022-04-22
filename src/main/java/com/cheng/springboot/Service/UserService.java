package com.cheng.springboot.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.cheng.springboot.mapper.UserMapper;
import com.cheng.springboot.pojo.User;

public interface UserService {
    IPage<User> selectListPage(int Currentpage, int pageSize);


    IPage<User> selectListPageAsAccount(int Currentpage, int pageSize, String account);

    User getUserById(int id);

    void AddUser(User user);
}

