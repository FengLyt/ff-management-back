package com.cheng.springboot.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.springboot.common.CommonResult;

import com.cheng.springboot.mapper.UserMapper;
import com.cheng.springboot.pojo.User;
import com.cheng.springboot.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class LoginServiceimpl implements LoginService{
    @Autowired
    private UserMapper userMapper;
//登录
    public CommonResult login(User user){
        //获取用户信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","account","password")
                .eq("account",user.getAccount());
        User DbUser = null;
        DbUser= userMapper.selectOne(queryWrapper);
        System.out.println("登录查询出的用户"+DbUser);
        //用户验证
        if (DbUser!=null){
            //密码验证
            String password = DbUser.getPassword();
            if (DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)).equals(password)){
                String token = JWTUtil.token(DbUser.getId(), DbUser.getAccount(), DbUser.getType());
                DbUser.setToken(token);
                CommonResult commonResult = new CommonResult(200,"登陆成功",DbUser);
                return commonResult;
            }else {
                CommonResult commonResult = new CommonResult(201,"账户或密码输入有误");
                return commonResult;
            }
        }else {
            CommonResult commonResult = new CommonResult(201,"账户不存在");
            return commonResult;
        }
    }

}
