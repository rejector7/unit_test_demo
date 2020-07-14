package com.example.unit_test_demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    @Id
    private String userId;
    @Field(value = "username")
    private String username;
    @Field(value = "age")
    private int age;
}

