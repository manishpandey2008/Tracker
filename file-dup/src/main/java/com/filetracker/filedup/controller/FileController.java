package com.filetracker.filedup.controller;

import com.filetracker.filedup.dto.ResponseDto;
import com.filetracker.filedup.entity.CheckPoint;
import com.filetracker.filedup.entity.FileEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/file")
public interface FileController {

    @GetMapping("/info")
    public ResponseDto getServiceInfo();

    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveFile(@RequestBody FileEntity fileEntity);

    @GetMapping("/")
    public ResponseEntity<List<FileEntity>> getAllFiles();

    @GetMapping("/organizationCode/{organizationCode}")
    public ResponseEntity<List<FileEntity>> getAllFilesByOrganizationCode(@PathVariable String organizationCode);

    @GetMapping("/departmentCode/{departmentCode}")
    public ResponseEntity<List<FileEntity>> getAllFilesByDepartmentCode(@PathVariable String departmentCode);

    @GetMapping("/senderId/{senderId}")
    public ResponseEntity<List<FileEntity>> getAllFilesBySenderId(@PathVariable String senderId);

    @GetMapping("/fileCode/{fileCode}")
    public ResponseEntity<Set<CheckPoint>> getAllCheckpointsByFileCode(@PathVariable String fileCode);

}
