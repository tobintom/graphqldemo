package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.UserEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmpRepository extends JpaRepository<UserEmp, Integer> {
}
