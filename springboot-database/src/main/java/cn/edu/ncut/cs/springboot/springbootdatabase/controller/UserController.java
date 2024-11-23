package cn.edu.ncut.cs.springboot.springbootdatabase.controller;

import cn.edu.ncut.cs.springboot.springbootdatabase.entity.User;
import cn.edu.ncut.cs.springboot.springbootdatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listUser() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody() User user){
        userService.saveUser(user);
        return "add user success!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "delete user success!";
    }
}

