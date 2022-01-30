package com.filetracker.filedup.repo;

import com.filetracker.filedup.entity.CheckPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckPointRepo extends JpaRepository<CheckPoint,Long> {

//    @Query("select u from CheckPoint u where u.departmentCode = :departmentCode or u.fileCode = :fileCode")
//    Optional<List<CheckPoint>> findByDepartmentCodeAndFileCode(@Param("departmentCode") String departmentCode,
//                                                   @Param("fileCode") String fileCode);

    Optional<List<CheckPoint>> findByDepartmentCodeAndFileCode(String departmentCode,String fileCode);
}
