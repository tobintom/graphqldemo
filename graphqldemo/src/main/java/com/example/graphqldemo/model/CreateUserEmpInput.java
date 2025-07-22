package com.example.graphqldemo.model;
import lombok.Data;

@Data
public class CreateUserEmpInput {
	private String role;
    private String department;
    private String organization;
}
