package com.example.unit_test_demo;

import com.example.unit_test_demo.Entity.User;
import com.example.unit_test_demo.Repository.UserRepository;
import com.example.unit_test_demo.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestDemoApplicationTests {

    @Test
    public void contextLoads() {
    }


}
