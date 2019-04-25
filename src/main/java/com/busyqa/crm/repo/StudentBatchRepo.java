package com.busyqa.crm.repo;
/* 2:13 PM
created by: ajaypalsingh , 2018-12-07
Project: crm
*/


import com.busyqa.crm.pojo.student.StudentBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentBatchRepo extends JpaRepository<StudentBatch, Long> {
}
