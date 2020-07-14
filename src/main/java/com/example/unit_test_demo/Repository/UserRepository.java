package com.example.unit_test_demo.Repository;

import com.example.unit_test_demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
