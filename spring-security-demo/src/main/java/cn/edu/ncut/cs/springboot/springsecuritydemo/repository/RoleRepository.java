package cn.edu.ncut.cs.springboot.springsecuritydemo.dao;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
