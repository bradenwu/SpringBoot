package cn.edu.ncut.cs.springboot.springsecuritydemo.repository;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> getPermissionsById(Long id);
}
