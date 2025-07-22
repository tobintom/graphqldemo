package com.example.graphqldemo.model;

import lombok.Data;

@Data
public class UpdateUserEmpInput {
	private String role;
    private String department;
    private String organization;
}
