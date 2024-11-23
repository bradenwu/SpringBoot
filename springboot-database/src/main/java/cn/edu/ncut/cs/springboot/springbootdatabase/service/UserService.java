package cn.edu.ncut.cs.springboot.springbootdatabase.service;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional findById(Integer id);//Optional类是Java8新引进的一个主要用于解决的问题是臭名昭著的空指针异常（NullPointerException|）的一个类。
    void saveUser(User user);
    void deleteUser(Integer id);
}