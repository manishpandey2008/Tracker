package com.filetracker.user.signup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false,length = 50)
    private String userFullName;

    @Column(length = 20,unique = true,nullable = false)
    private String username;

    @Column(length = 20,nullable = false)
    private String password;

    @Column(length = 30,nullable = false,unique = true)
    private String userEmail;

    @Column(nullable = false,length = 10,unique = true)
    private String userPhone;

    @Column(nullable = false,length = 20)
    private String organizationCode;

    @Column(nullable = false,length = 20)
    private String departmentCode;

    @Column(nullable = false,length = 20)
    private String userRole;

    @Column(nullable = false,length = 20)
    private String activateCode;

    @Column(nullable = false)
    private boolean activeStatus;
}
