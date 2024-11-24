package cn.edu.ncut.cs.springboot.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`student`")
public class Student {
    private Integer id;
    private String username;
    private String password;
    private String phone;
}