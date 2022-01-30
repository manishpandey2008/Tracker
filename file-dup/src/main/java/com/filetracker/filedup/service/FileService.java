package com.filetracker.filedup.service;

import com.filetracker.filedup.dto.ResponseDto;
import com.filetracker.filedup.entity.CheckPoint;
import com.filetracker.filedup.entity.FileEntity;

import java.util.List;
import java.util.Set;

public interface FileService {
    public ResponseDto saveFile(FileEntity fileEntity);

    public List<FileEntity> getAllFiles();

    public List<FileEntity> getAllFilesByOrganizationCode(String organizationCode);

    public List<FileEntity> getAllFilesByDepartmentCode(String departmentCode);

    public List<FileEntity> getAllFilesBySenderId(String senderId);

    public Set<CheckPoint> getAllCheckpointsByFileCode(String fileCode);

}
