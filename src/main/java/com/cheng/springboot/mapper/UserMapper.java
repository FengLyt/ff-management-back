package com.cheng.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cheng.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    //查询全部
    IPage<User> allUser(IPage<User> page);
    /*
     * 模糊查询 搜索
     */
    IPage<User> getUserAsAccount(IPage<User> page,@Param("account")String account);

    User getUserById(@Param("id") int id);

    /**
     * 添加用户
     */
    @Insert("insert into user(account, password, gender, phone, deptid, uid, operatime) values(#{account},#{password},#{gender},#{phone},#{dept.id},#{user.id},now())")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void addUser(User user);
}
