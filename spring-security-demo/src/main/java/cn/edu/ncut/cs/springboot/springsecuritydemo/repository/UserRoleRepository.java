package cn.edu.ncut.cs.springboot.springsecuritydemo.repository;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}

