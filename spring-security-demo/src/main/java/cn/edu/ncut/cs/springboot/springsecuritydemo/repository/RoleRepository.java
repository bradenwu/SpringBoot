package cn.edu.ncut.cs.springboot.springsecuritydemo.repository;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> getRolesById(Long id);
}
