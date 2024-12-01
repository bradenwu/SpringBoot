package cn.edu.ncut.cs.springboot.springsecuritydemo.service.impl;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Permission;
import cn.edu.ncut.cs.springboot.springsecuritydemo.repository.PermissionRepository;
import cn.edu.ncut.cs.springboot.springsecuritydemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getPermissions(Long id) {
        return permissionRepository.getPermissionsById(id);
    }
}
