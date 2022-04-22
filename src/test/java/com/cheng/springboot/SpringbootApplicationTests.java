package com.cheng.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.springboot.mapper.UserMapper;
import com.cheng.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MapperScan("com.cheng.springboot.mapper")
@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    //用户批量插入
    @Test
    public void userInster(){
        User user = new User();
        for (int i = 10; i <50 ; i++) {
            user.setId(null);
            user.setAccount("00000" + i);
            user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));
            user.setBirthday(new Date());
            user.setPhone("138903564"+i);
            user.setGender("女");
            user.setDeptid(4);
            user.setType(1);
            userMapper.insert(user);
        }

    }
    @Test
    public void pageTest(){
        Page page = new Page(1, 10);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","account","password");
        userMapper.selectPage(page, queryWrapper);
        List orders = page.orders();
        orders.forEach(System.out::println);

    }
    @Test
    public void test03() throws Exception {
        ArrayList arrayList1 = new ArrayList(0);
        arrayList1.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(1);
        Class aClass = Class.forName("java.util.ArrayList");
        Field elementData = aClass.getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object[] object1 = (Object[])elementData.get(arrayList1);
        Object[] object2 = (Object[])elementData.get(arrayList2);

        System.out.println("ArrayList(0)的容量"+object1.length);

        System.out.println("ArrayList()的容量"+object2.length);
    }
    @Test
//    public void test04(){
//        List allUser = userMapper.getAllUser();
//        allUser.forEach(System.out::println);
//    }
    //添加用户
    public void adduser(){

    }
}
