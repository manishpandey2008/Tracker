package com.filetracker.file.controller;

import com.filetracker.file.dto.ResponseDto;
import com.filetracker.file.entity.CheckPoint;
import com.filetracker.file.entity.FileEntity;
import com.filetracker.file.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/file")
@Slf4j
public record FileControllerImp(FileService fileService) implements FileController{
    @Override
    public ResponseDto getServiceInfo() {
        return new ResponseDto("File Service is working File");
    }

    @Override
    public ResponseEntity<ResponseDto> saveFile(FileEntity fileEntity) {
        log.info("File has come for save:Controller");
        return new ResponseEntity<>(fileService.saveFile(fileEntity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        log.info("Get all files from DB:Controller");
        return new ResponseEntity<>(fileService.getAllFiles(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FileEntity>> getAllFilesByOrganizationCode(String organizationCode) {
        log.info("Get all files which organization code is "+organizationCode+" :Controller");
        return new ResponseEntity<>(fileService.getAllFilesByOrganizationCode(organizationCode), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FileEntity>> getAllFilesByDepartmentCode(String departmentCode) {
        log.info("Get all files which department code is "+departmentCode+" :Controller");
        return new ResponseEntity<>(fileService.getAllFilesByDepartmentCode(departmentCode), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FileEntity>> getAllFilesBySenderId(String senderId) {
        log.info("Get all files which sender id is "+senderId+" :Controller");
        return new ResponseEntity<>(fileService.getAllFilesBySenderId(senderId), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Set<CheckPoint>> getAllCheckpointsByFileCode(String fileCode) {
        log.info("Get all check points which file code is "+fileCode+" :Controller");
        return new ResponseEntity<>(fileService.getAllCheckpointsByFileCode(fileCode), HttpStatus.OK);
    }
}
