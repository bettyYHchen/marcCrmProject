package com.busyqa.crm.repo;

import com.busyqa.crm.pojo.student.StudentCourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/* 1:57 PM 
created by: ajaypalsingh , 2018-12-07
Project: crm 
*/

@Repository
public interface StudentCourseTypeRepo extends JpaRepository<StudentCourseType, Long> {



}
