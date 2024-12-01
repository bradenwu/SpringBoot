//package cn.edu.ncut.cs.springboot.springsecuritydemo.config;
//
//import cn.edu.ncut.cs.springboot.springsecuritydemo.service.impl.UserDetailsServiceImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class DemoSecurityConfig {
//    /**
//     * 密码加密器
//     * @return 密码加密器的实例
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    /**
//     * 用户信息服务(配置用户账号、密码、角色)
//     * @param passwordEncoder 密码加密器
//     * @return 在内存用户详细信息管理器中
//     */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("123456"))
//                .roles("user")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("123456"))
//                .roles("user", "admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorizeHttpRequests) ->
//                authorizeHttpRequests
//                        .requestMatchers("/admin/**").hasRole("admin")
//                        .requestMatchers("/**").hasRole("user")
//                        //设置不需要认证的路径，一律允许通过，这种方式会走Spring Security的过滤器链，当遇到这些访问路径时直接允许通过
//                        .antMatchers("/index", "/home").permitAll()
//                        //设置需要角色的路径，表示访问 /user/view 这个接口，需要具备 system 这个角色
//                        .antMatchers("/user/view/**").hasRole("system")
//                        //设置需要权限许可的路径，表示访问 /user/list 这个接口，需要具有“user:list”权限许可
//                        .antMatchers("/user/list").hasAuthority("user:list")
//                        //设置其他路径都需要登录后才可访问
//                        .anyRequest().authenticated()
//                        .and()
//                        //设置登录表单
//                        .formLogin()
//                        //和表单登录相关的接口直接允许通过
//                        .permitAll()
//                        //开启一个新的设置项
//                        .and()
//                        //设置登出（注销登录）
//                        .logout()
//                        //设置登出路径
//                        .logoutUrl("/logout")
//                        //设置登出成功后的处理器
//                        .logoutSuccessHandler(new LogoutSuccessHandler() {
//                            @Override
//                            public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                                resp.setContentType("application/json;charset=utf-8");
//                                PrintWriter out = resp.getWriter();
//                                out.write("logout success");
//                                out.flush();
//                            }
//                        })
//                        //和登出相关的接口允许通过
//                        .permitAll()
//                        .and()
//                        .csrf().disable()
//        );
//        return http.build();
//    }
//}
