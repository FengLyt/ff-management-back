package com.cheng.springboot.controller;

import com.cheng.springboot.Service.LoginServiceimpl;
import com.cheng.springboot.common.CommonResult;
import com.cheng.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private LoginServiceimpl loginServiceimpl;

    @RequestMapping(value = "/login")
    public CommonResult userController(@RequestBody User user){
        CommonResult login = loginServiceimpl.login(user);
        return login;
    }




}
