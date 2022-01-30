package com.filetracker.file.service;

import com.filetracker.file.entity.CheckPoint;
import com.filetracker.file.repo.CheckPointRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record ValidationService(CheckPointRepo checkPointRepo) {
    public boolean checkPointValidation(CheckPoint checkPoint){
        Optional<List<CheckPoint>> tempCheckPoint=checkPointRepo.findByDepartmentCodeAndFileCode(checkPoint.getDepartmentCode(),
                                                                                            checkPoint.getFileCode());
        if(tempCheckPoint.isEmpty()){
            return false;
        }
        return true;
    }
}
