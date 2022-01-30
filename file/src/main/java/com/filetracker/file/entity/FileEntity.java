package com.filetracker.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file_entity")
public class FileEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    @Column(nullable = false,length = 50)
    private String fileName;

    @Column(length = 200,nullable = false)
    private String details;

    @Column(nullable = false,length = 20)
    private String organizationCode;

    @Column(nullable = false,unique = true,length = 20)
    private String fileCode;

    @Column(nullable = false,length = 100)
    private String subjectOfFile;

    @Column(nullable = false,length = 20)
    private String senderId;

    @Column(length = 20)
    private String sectionCode;

    @Column(nullable = false,length = 20)
    private String fileLabel;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CheckPoint> checkPoints;
}
