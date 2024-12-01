package cn.edu.ncut.cs.springboot.springsecuritydemo.service.impl;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Permission;
import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.Role;
import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.User;
import cn.edu.ncut.cs.springboot.springsecuritydemo.service.PermissionService;
import cn.edu.ncut.cs.springboot.springsecuritydemo.service.RoleService;
import cn.edu.ncut.cs.springboot.springsecuritydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.getByUsername(username);
        return user.map(u -> {
            List<Role> roles = roleService.getRoles(u.getId());
            //注意教材此处代码有误，修正为下面的代码            List<Permission> permissions = permissionService.getPermissions(u.getId());
            List<Permission> permissions = roles.stream()
                    .flatMap(role -> permissionService.getPermissions(role.getId()).stream())
                    .toList();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size() + permissions.size());
            /*在Spring Security中，角色和权限统称为GrantAuthority，角色和权限都交给GrantAuthenty管理，而区分角色和权限的方式，就是在角色名称前加前缀ROLE_以表示角色*/
            // 将角色信息转换为SimpleGrantedAuthority对象类型
            List<SimpleGrantedAuthority> roleAuthorities = roles.stream()
                    //给角色名称增加前缀ROLE_
                    .map(role -> "ROLE_" + role.getName())
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            // 将授权许可信息转换为SimpleGrantedAuthority对象类型
            List<SimpleGrantedAuthority> permissionAuthorities = permissions.stream()
                    .map(Permission::getName)
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            /*将角色和授权许可合并到grantedAuthorities列表*/
            grantedAuthorities.addAll(roleAuthorities);
            grantedAuthorities.addAll(permissionAuthorities);
            //设置用户名和密码
            //设置权限列表
            return org.springframework.security.core.userdetails
                    .User.builder()
                    //设置用户名和密码
                    .username(u.getUsername())
                    .password(u.getPassword())
                    //设置权限列表
                    .authorities(grantedAuthorities)
                    .build();
        }).orElse(null);
    }
}
