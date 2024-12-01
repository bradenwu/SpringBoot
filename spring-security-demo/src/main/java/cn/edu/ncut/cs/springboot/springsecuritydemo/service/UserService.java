package cn.edu.ncut.cs.springboot.springsecuritydemo.service;

import cn.edu.ncut.cs.springboot.springsecuritydemo.entity.User;
import cn.edu.ncut.cs.springboot.springsecuritydemo.vo.UserVO;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserVO> findAll();

    /**
     * 通过用户名获取账户
     *
     * @param username
     * @return
     */
    Optional<User> getByUsername(@NonNull String username);

    /**
     * 创建用户账户
     *
     * @param userVO
     * @return
     */
    boolean create(@NonNull UserVO userVO);

    User getById(@NonNull Long id);
}
