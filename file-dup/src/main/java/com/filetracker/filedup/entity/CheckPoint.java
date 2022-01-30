package com.filetracker.filedup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "check_point")
public class CheckPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long checkPointId;

    @Column(nullable = false)
    private Long checkPointIndex;

    @Column(length = 20)
    private String departmentCode;

    private Date entryDate;

    private Date exitDate;

    @Column(length = 10)
    private String stageStatus;

    @Column(length = 20)
    private String fileCode;
}
