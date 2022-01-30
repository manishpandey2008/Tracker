package com.filetracker.file.service;

import com.filetracker.file.dto.ResponseDto;
import com.filetracker.file.entity.CheckPoint;
import com.filetracker.file.entity.FileEntity;
import com.filetracker.file.repo.CheckPointRepo;
import com.filetracker.file.repo.FileRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Slf4j
public record FileServiceImp(FileRepo fileRepo, CheckPointRepo checkPointRepo,ValidationService validationService) implements FileService{
    @Override
    public ResponseDto saveFile(FileEntity fileEntity) {
        AtomicBoolean x= new AtomicBoolean(false);
        fileEntity.getCheckPoints().forEach(e->{
                x.set(validationService.checkPointValidation(e));
        });
        if (x.get()){
            return new ResponseDto("File code "+ fileEntity.getFileCode()+
                    " all ready available ");
        }
        try{
            fileEntity.getCheckPoints().forEach(e->{
                if(e.getCheckPointId()!=null){
                    checkPointRepo.save(e);
                }else{
                    e.setFileCode(fileEntity.getFileCode());
                }
            });
            fileRepo.save(fileEntity);
            return new ResponseDto("File code "+ fileEntity.getFileCode()+" has saved in database");
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return new ResponseDto(e.getMessage());
        }
    }

    @Override
    public List<FileEntity> getAllFiles() {
        try{
            List<FileEntity> allFiles=fileRepo.findAll();
            return allFiles;
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return null;
        }
    }

    @Override
    public List<FileEntity> getAllFilesByOrganizationCode(String organizationCode) {
        try{
            List<FileEntity> allFiles=fileRepo.findByOrganizationCodeEquals(organizationCode).orElse(null);
            return allFiles;
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return null;
        }
    }

    @Override
    public List<FileEntity> getAllFilesByDepartmentCode(String departmentCode) {
        try{
            List<FileEntity> allFiles=fileRepo.findAll();
            List<FileEntity> filterList=new ArrayList<>();
            allFiles.forEach(e->{
                e.getCheckPoints().forEach(c->{
                    if(c.getDepartmentCode().equals(departmentCode)){filterList.add(e);}
                });
            });
            return filterList;
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return null;
        }
    }

    @Override
    public List<FileEntity> getAllFilesBySenderId(String senderId) {
        try{
            List<FileEntity> allFiles=fileRepo.findBySenderIdEquals(senderId).orElse(null);
            return allFiles;
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return null;
        }
    }

    @Override
    public Set<CheckPoint> getAllCheckpointsByFileCode(String fileCode) {
        try{
            FileEntity allFiles=fileRepo.findByFileCodeEquals(fileCode).orElse(null);
            return  allFiles.getCheckPoints();
        }catch (Exception e){
            log.info(String.valueOf(new ResponseDto(e.getMessage())));
            return null;
        }
    }
}
