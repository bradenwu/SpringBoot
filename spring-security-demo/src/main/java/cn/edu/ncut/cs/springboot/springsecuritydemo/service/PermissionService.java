package cn.edu.ncut.cs.springboot.springsecuritydemo.service;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Permission;
import org.springframework.lang.NonNull;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissions(@NonNull Long roleId);
}
