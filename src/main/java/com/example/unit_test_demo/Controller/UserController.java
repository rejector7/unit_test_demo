package com.example.unit_test_demo.Controller;

import com.example.unit_test_demo.Entity.User;
import com.example.unit_test_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteById/{userId}")
    public void deleteUserById(@PathVariable String userId){
        User user = userService.getUserById(userId);
        userService.deleteUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}