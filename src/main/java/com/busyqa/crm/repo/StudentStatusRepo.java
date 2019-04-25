package com.busyqa.crm.repo;
/* 1:53 PM
created by: ajaypalsingh , 2018-12-07
Project: crm
*/


import com.busyqa.crm.pojo.student.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStatusRepo extends JpaRepository<StudentStatus, Long> {

}
