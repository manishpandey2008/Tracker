package com.filetracker.department.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @Column(length = 50,nullable = false)
    private String departmentName;

    @Column(length = 20,nullable = false)
    private String organizationCode;

    @Column(length = 20,nullable = false)
    private String departmentCode;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    @Column(length = 200)
    private String details;

    @Column(length = 200)
    private String[] openDays;

    @Column(length = 10)
    private String openTime;

    @Column(length = 10)
    private String closeTime;

    @Column(updatable = false,length = 20)
    private String createdBy;

    @Column(length = 20)
    private String updatedBy;

    @Column(updatable = false)
    private Date createdTimestamp;
    private Date updatedTimestamp;
}
