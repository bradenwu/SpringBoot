package cn.edu.ncut.cs.springboot.springbootdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.IDENTITY是GenerationType枚举的一个值，表示主键由数据库自动增长。
    @Column(name="id")
    private Integer id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone",nullable = false)
    private String phone;
}
