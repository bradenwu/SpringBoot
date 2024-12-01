package cn.edu.ncut.cs.springboot.springsecuritydemo.service.impl;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Role;
import cn.edu.ncut.cs.springboot.springsecuritydemo.repository.RoleRepository;
import cn.edu.ncut.cs.springboot.springsecuritydemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles(@NonNull Long userId) {
        return roleRepository.getRolesById(userId);
    }
}
