package cn.edu.ncut.cs.springboot.springsecuritydemo.dao;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
}
