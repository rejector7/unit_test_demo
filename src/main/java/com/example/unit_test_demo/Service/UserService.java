package com.example.unit_test_demo.Service;

import com.example.unit_test_demo.Entity.User;
import com.example.unit_test_demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        User userSaved = userRepository.save(user);
        System.out.println(userSaved);
        return userSaved;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(String userId){
        User user = userRepository.findById(userId).isPresent()?
                userRepository.findById(userId).get(): null;
        System.out.println(user);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println(users.size());
        return users;
    }

}
