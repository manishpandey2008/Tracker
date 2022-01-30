package com.filetracker.file.dto;

import com.filetracker.file.entity.CheckPoint;
import com.filetracker.file.entity.FileEntity;
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
