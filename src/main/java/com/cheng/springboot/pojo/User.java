package com.cheng.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@TableName("user")
@Data
public class User {
    @TableId
   private Integer id;
   private String account;
   private String password;
   private String gender;
   private int deptid;
   private String phone;
   private Date birthday;
   private int type;
   private int uid;
   private Date operatime;
   @TableField(exist = false)
   private Dept dept;
   @TableField(exist = false)
   private User user;
   @TableField(exist = false)
   private List<Role> roles;
   @TableField(exist = false)
   private int[] roleList;
    @TableField(exist = false)
   private String token;


}
