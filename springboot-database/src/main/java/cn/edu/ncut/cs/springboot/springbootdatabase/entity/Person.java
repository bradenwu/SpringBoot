package cn.edu.ncut.cs.springboot.springbootdatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.IDENTITY是GenerationType枚举的一个值，表示主键由数据库自动增长。
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    private Integer age;

    @Column(name = "email")
    private String email;
}
