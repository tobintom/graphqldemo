package com.example.graphqldemo.service;

import com.example.graphqldemo.model.*;
import com.example.graphqldemo.repository.UserRepository;
import com.example.graphqldemo.repository.UserEmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
    private final UserEmpRepository userEmpRepository;
    
    @Transactional
    public User createUser(CreateUserInput input) {
        
        if (userRepository.existsByUsername(input.getUsername())) {
            throw new RuntimeException("Username already exists: " + input.getUsername());
        }
        
        // Create user
        User user = new User();
        user.setId(input.getId());
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setFullname(input.getFullname());
                
        // Save user first to get the ID
        user = userRepository.save(user);   
        
        // Create employee details if provided
        if (input.getUserEmp() != null) {
            UserEmp userEmp = new UserEmp();             
            userEmp.setRole(input.getUserEmp().getRole());
            userEmp.setDepartment(input.getUserEmp().getDepartment());
            userEmp.setOrganization(input.getUserEmp().getOrganization());
            userEmp.setUser(user);            
            userEmpRepository.save(userEmp); 
            user.setUserEmp(userEmp);
        }
        
        return user;
    }
    
    @Transactional
    public User updateUser(UpdateUserInput input) {
        User user = userRepository.findById(input.getId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + input.getId()));
        
        // Update user fields if provided
        if (input.getUsername() != null) {
            if (userRepository.existsByUsername(input.getUsername()) && 
                !user.getUsername().equals(input.getUsername())) {
                throw new RuntimeException("Username already exists: " + input.getUsername());
            }
            user.setUsername(input.getUsername());
        }      
        
        
        if (input.getFullname() != null) {
            user.setFullname(input.getFullname());
        }
        
        if (input.getUsername() != null) {
            user.setUsername(input.getUsername());
        }
        if (input.getEmail() != null) {
            user.setEmail(input.getEmail());
        }
        
        // Save user changes
        user = userRepository.save(user);
        
        // Update employee details if provided
        if (input.getUserEmp() != null) {
            UserEmp userEmp = user.getUserEmp();
            
            if (userEmp == null) {
                // Create new employee details
                userEmp = new UserEmp();
                userEmp.setId(user.getId());
                userEmp.setUser(user);
            }
            
            // Update fields if they are provided (not null)
            if (input.getUserEmp().getRole() != null) {
                userEmp.setRole(input.getUserEmp().getRole());
            }
            if (input.getUserEmp().getDepartment() != null) {
                userEmp.setDepartment(input.getUserEmp().getDepartment());
            }
            if (input.getUserEmp().getOrganization() != null) {
                userEmp.setOrganization(input.getUserEmp().getOrganization());
            }
            
            userEmpRepository.save(userEmp);
            user.setUserEmp(userEmp);
        }
        
        return userRepository.findByIdWithEmployeeDetails(user.getId()).orElse(user);
    }
    
    public User getUserById(Integer id) {
        return userRepository.findByIdWithEmployeeDetails(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
