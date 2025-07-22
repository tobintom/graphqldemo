package com.example.graphqldemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateUserInput {
	private Integer id;
	private String username;
    private String email;
    private String fullname;
    private CreateUserEmpInput userEmp;
}
