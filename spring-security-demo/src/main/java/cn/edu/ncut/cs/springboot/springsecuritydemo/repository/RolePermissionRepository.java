package cn.edu.ncut.cs.springboot.springsecuritydemo.repository;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
