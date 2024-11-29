package cn.edu.ncut.cs.springboot.springsecuritydemo.dao;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {
}
