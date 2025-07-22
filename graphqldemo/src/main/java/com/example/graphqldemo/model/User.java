package com.example.graphqldemo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String fullname;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional = true)
    private UserEmp userEmp;

    // Constructors
    public User() {}

    public User(String username, String email, String fullname) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }    
    public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public UserEmp getUserEmp() { return userEmp; }
    public void setUserEmp(UserEmp userEmp) { this.userEmp = userEmp; }
}