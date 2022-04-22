package com.cheng.springboot.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.springboot.mapper.DepartmentMapper;
import com.cheng.springboot.mapper.UserMapper;
import com.cheng.springboot.pojo.Role;
import com.cheng.springboot.pojo.User;
import com.cheng.springboot.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImlp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    //用户分页查询
    @Override
    public IPage<User> selectListPage(int Currentpage, int pageSize) {
        Page<User> userVoPage = new Page<>(Currentpage, pageSize);
        IPage<User> allAsPage = userMapper.allUser(userVoPage);
        return allAsPage;
    }

    @Override
        public IPage<User> selectListPageAsAccount(int Currentpage, int pageSize,String account) {
        Page<User> userVoPage = new Page<>(Currentpage, pageSize);
        IPage<User> userAsAccount = userMapper.getUserAsAccount(userVoPage, account);
        return userAsAccount;
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        List<Role> roles = user.getRoles();
        int[] roleList =new int[roles.size()];
        int i=0;
        for (Role role : roles) {
          roleList[i]=role.getId();
           i++;
        }
        user.setRoleList(roleList);
        return user;
    }

    /**
     * 添加用户
     */
     public void AddUser(User user){
         //获取登陆人的id
         DecodedJWT decodedJWT = JWTUtil.getTokenInfo(user.getToken());
         Integer id = decodedJWT.getClaim("id").asInt();
         User opuser = new User();
                opuser.setId(id);
         user.setUser(opuser);
         // 给定初始密码  手机号后6位
         String password = user.getPhone().substring(5, 11);
         user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
         //设定操作时间
         user.setOperatime(new Date());
         user.setDeptid(user.getDept().getId());
         System.out.println(user);
          userMapper.addUser(user);


     }
}
