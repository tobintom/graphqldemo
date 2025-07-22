package com.example.graphqldemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_emp")
public class UserEmp {
    @Id
    private Integer id;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id",nullable = false, unique = true)
    private User user;

    private String role;
    private String department;
    private String organization;

    // Constructors
    public UserEmp() {}

    public UserEmp(User user, String role, String department, String organization) {
        this.user = user;
        this.id = user.getId();
        this.role = role;
        this.department = department;
        this.organization = organization;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }
}