package com.example.unit_test_demo.Controller;

import com.example.unit_test_demo.Entity.User;
import com.example.unit_test_demo.Service.UserService;
import com.example.unit_test_demo.UnitTestDemoApplicationTests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends UnitTestDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    private ObjectMapper om = new ObjectMapper();
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getUserById() throws Exception {
        MvcResult result = mockMvc.perform(get("/UserController/getUserById/110").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(jsonPath("$.username").value("m11")).andReturn();
    }

    @Test
    public void getAllUsers() throws Exception {
/*        List<User> temp_users = new LinkedList<>();
        temp_users.add(new User("110", "m11", 110));
        temp_users.add(new User("120", "m12", 120));*/

        MvcResult result = mockMvc.perform(get("/UserController/getAllUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<User> users = om.readValue(resultContent, new TypeReference<List<User>>() {});
/*        int count1 = users.size();
        for(User user : temp_users){
            userService.addUser(user);
        }
        MvcResult result2 = mockMvc.perform(get("/UserController/getAllUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent2 = result.getResponse().getContentAsString();
        List<User> users2 = om.readValue(resultContent, new TypeReference<List<User>>() {});
        int count2 = users2.size();*/
        assertEquals(userService.getAllUsers().size(), users.size());
    }
}