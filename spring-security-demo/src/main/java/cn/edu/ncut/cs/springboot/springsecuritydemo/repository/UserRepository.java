package cn.edu.ncut.cs.springboot.springsecuritydemo.dao;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> getUserByUsername(String username);
}
