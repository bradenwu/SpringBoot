package cn.edu.ncut.cs.springboot.springsecuritydemo.config;

import cn.edu.ncut.cs.springboot.springsecuritydemo.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.io.PrintWriter;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    /**
     * 密码加密器
     * @return 密码加密器的实例
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 用户信息服务(配置用户账号、密码、角色)
     * @param passwordEncoder 密码加密器
     * @return 在内存用户详细信息管理器中
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        return new UserDetailsServiceImpl();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/index", "/home").permitAll()
                        // 设置需要角色的路径，表示访问 /user/manage 这个接口，需要具备 "ROLE_ADMIN" 这个角色
                        .requestMatchers("/user/manage/**").hasRole("ADMIN")
                        // 设置需要权限许可的路径，表示访问 /user/list 这个接口，需要具有 "user:view" 权限许可
                        .requestMatchers("/user/view").hasAuthority("user:view")
                        .requestMatchers("/verifycode").permitAll()
                        // 设置其他路径都需要登录后才可访问
                        .anyRequest().authenticated()
                )
                // 设置登录表单
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                )
                // 设置登出（注销登录）
                .logout(logout -> logout
                        // 设置登出路径
                        .logoutUrl("/logout")
                        // 设置登出成功后的处理器
                        .logoutSuccessHandler(new LogoutSuccessHandler() {
                            @Override
                            public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                                resp.setContentType("application/json;charset=utf-8");
                                PrintWriter out = resp.getWriter();
                                out.write("{\"message\":\"logout success\"}");
                                out.flush();
                            }
                        })
                        // 和登出相关的接口允许通过
                        .permitAll()
                )
                // 禁用 CSRF，仅在开发环境中使用，生产环境中应启用并配置
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}