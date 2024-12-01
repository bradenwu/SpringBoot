package cn.edu.ncut.cs.springboot.springsecuritydemo.service;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Role;
import org.springframework.lang.NonNull;

import java.util.List;

public interface RoleService {
    List<Role> getRoles(@NonNull Long userId);
}
