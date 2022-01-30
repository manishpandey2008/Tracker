package com.filetracker.filedup.dto;

import com.filetracker.filedup.entity.CheckPoint;
import com.filetracker.filedup.entity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponseDto {
    private FileEntity fileEntity;
    private List<CheckPoint> checkPoints;
}
