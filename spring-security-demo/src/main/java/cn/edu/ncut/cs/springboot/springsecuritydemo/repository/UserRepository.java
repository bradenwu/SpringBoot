package cn.edu.ncut.cs.springboot.springsecuritydemo.repository;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUserByUsername(String username);
}

