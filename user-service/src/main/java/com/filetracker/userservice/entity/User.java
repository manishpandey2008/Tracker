package com.filetracker.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 50)
    private String userFullName;

    @Column(length = 20,unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
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
    private String activateCode;

    @Column(nullable = false)
    private boolean activeStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();
}
