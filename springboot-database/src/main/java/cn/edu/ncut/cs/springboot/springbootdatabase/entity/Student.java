package cn.edu.ncut.cs.springboot.springbootdatabase.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long id;

    private String username;

    private String password;

    private Date birthday;

    private String sex;

    private String address;
}
