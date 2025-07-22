package com.example.graphqldemo.model;

import lombok.Data;

@Data
public class UpdateUserInput {
	private Integer id;
    private String username;
    private String email;
    private String fullname;
    private UpdateUserEmpInput userEmp;

}
