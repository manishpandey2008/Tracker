package com.filetracker.filedup.repo;

import com.filetracker.filedup.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepo extends JpaRepository<FileEntity,Long> {

    Optional<List<FileEntity>> findByOrganizationCodeEquals(String organizationCode);

    Optional<List<FileEntity>> findBySenderIdEquals(String senderId);

    Optional<FileEntity> findByFileCodeEquals(String fileCode);

}
