package cn.edu.ncut.cs.springboot.springbootdatabase.service.impl;

import cn.edu.ncut.cs.springboot.springbootdatabase.dao.UserDao;
import cn.edu.ncut.cs.springboot.springbootdatabase.service.UserService;
import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
}
