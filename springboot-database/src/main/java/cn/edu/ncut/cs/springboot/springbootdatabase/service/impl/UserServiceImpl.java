package cn.edu.ncut.cs.springboot.springbootdatabase.service.impl;

import cn.edu.ncut.cs.springboot.springbootdatabase.repository.UserRepository;
import cn.edu.ncut.cs.springboot.springbootdatabase.service.UserService;
import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
