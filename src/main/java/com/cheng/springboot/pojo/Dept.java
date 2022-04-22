package com.cheng.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dept")
public class Dept {
    private int id;
    private String name;
}
