package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userEmp WHERE u.id = :id")
    Optional<User> findByIdWithEmployeeDetails(@Param("id") Integer id);
    
    boolean existsByUsername(String username);
}
