package com.example.unit_test_demo.Service;

import com.example.unit_test_demo.Entity.User;
import com.example.unit_test_demo.Repository.UserRepository;
import com.example.unit_test_demo.UnitTestDemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest extends UnitTestDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;


    @MockBean
    private UserRepository userRepository;

    @Test
    public void addUser() {
        User user = new User("1234", "m9", 99);
        //System.out.println(userService.addUser(user));
        assertEquals(user, userService.addUser(user));
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getUserById(){
/*        String userId = "110";
        User user = userService.getUserById(userId);
        System.out.println(user);
        assertEquals("110", user.getUserId());*/
        String userId = "1234";
        User user = new User("1234567890", "m8", 88);
        when(userRepository.findById(userId).get()).thenReturn(user);

/*        List<User> users = new LinkedList<>();
        users.add(user);
        doReturn(users).when(userRepository.findById(userId));*/

        assertEquals(user, userService.getUserById(userId));
    }

    @Test
    public void getAllUsers(){
        List<User> users = new LinkedList<>();
        users.add(new User("111", "m8", 88));
        users.add(new User("111", "m8", 88));
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(users, userService.getAllUsers());
        assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    public void deleteUser() {
        User user = new User("124", "m10", 100);
        userService.deleteUser(user);
        verify(userRepository, times(1)).delete(user);
    }
}