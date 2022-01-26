package com.filetracker.organization.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long organizationId;

    @Column(nullable = false,length = 50)
    private String organizationName;

    @Column(length = 20)
    private String organizationShortName;

    @Column(length = 20,nullable = false,unique = true)
    private String organizationCode;

    @Column(length = 6)
    private String areaPinCode;

    @Column(length = 30)
    private String countryName;

    @Column(length = 30)
    private String stateName;

    @Column(length = 30)
    private String districtName;

    @Column(length = 200)
    private String organizationAddress;

    @Lob
    private String organizationDetails;

    @Column(length = 4)
    private String organizationStartYear;

    @Column(updatable = false)
    private String createdBy;

    private String updatedBy;

    @Column(updatable = false)
    private Date createdTimestamp;
    private Date updatedTimestamp;

}
