package cn.edu.ncut.cs.springboot.springsecuritydemo.dao;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionDao extends JpaRepository<RolePermission, Long> {
}
