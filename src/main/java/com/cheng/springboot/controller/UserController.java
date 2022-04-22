package com.cheng.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.springboot.Service.DeptServiceImpl;
import com.cheng.springboot.Service.RoleServiceImpl;
import com.cheng.springboot.Service.UserServiceImlp;
import com.cheng.springboot.common.CommonResult;
import com.cheng.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserServiceImlp userServiceImlp;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    DeptServiceImpl deptService;

    /**
     * 获取全部用户
     * @param currentPage
     * @param PageSize
     * @return
     */
   @RequestMapping("/alluser")
    public Page queryUserAsPage(int currentPage, int PageSize){
       Page<User> userVoPage = (Page<User>) userServiceImlp.selectListPage(currentPage, PageSize);
       return userVoPage;
   }

    /**
     * 根据账户进行模糊查询
     * @param username
     * @param currentPage
     * @param PageSize
     * @return
     */
   @RequestMapping("/UserAsAccount")
   public Page queryUserAsAccount(String username,int currentPage, int PageSize){
       Page<User> userVoPage = (Page<User>) userServiceImlp.selectListPageAsAccount(currentPage, PageSize,username);
       return userVoPage;
   }

    /**
     * 获取角色表
     * @return
     */
   @RequestMapping("/getRoleList")
    public List getRoleList(){
        return roleService.getRoleList();
   }

    /**
     *获取部门表
     * @return
     */
    @RequestMapping("/getDeptList")
    public List getDeptList(){
        return deptService.getDeptList();
    }

    @GetMapping("/getUserById")
    public CommonResult getUserById(int id){
        User userById = userServiceImlp.getUserById(id);
        CommonResult commonResult = new CommonResult(200,"查询成功",userById);
        return commonResult;
    }
    /**
     * 添加用户
     */
    @RequestMapping("/adduser")
    public CommonResult AddUser(@RequestBody User user,@RequestHeader("token") String token){
        user.setToken(token);
        userServiceImlp.AddUser(user);
        return new CommonResult(200,"添加成功");
    }
}
