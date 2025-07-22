package com.example.graphqldemo.controller;
 
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqldemo.model.CreateUserInput;
import com.example.graphqldemo.model.UpdateUserInput;
import com.example.graphqldemo.model.User;
import com.example.graphqldemo.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @QueryMapping
    public User user(@Argument Integer id) {    	 
        return userService.getUserById(id);
    }
    
    @MutationMapping
    public User createUser(@Argument CreateUserInput input) {
        return userService.createUser(input);
    }
    
    @MutationMapping
    public User updateUser(@Argument UpdateUserInput input) {
        return userService.updateUser(input);
    }
}
