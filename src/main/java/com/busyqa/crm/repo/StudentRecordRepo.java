package com.busyqa.crm.repo;
/* 2:06 PM 
created by: ajaypalsingh , 2018-12-06
Project: crm 
*/


import com.busyqa.crm.pojo.student.StudentRecords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRecordRepo extends PagingAndSortingRepository<StudentRecords, Long> {

  // @Query("select s.id,s.name, s.remarks,s.courseType,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, s.studentCourseType.courseType, s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.name = :terms")
  //@Query("select s from StudentRecords s where s.firstName = :terms")
    //List<StudentRecords> searchStudents(@Param(value = "terms") String terms);


    //@Query("select s.id, s.name, s.remarks, s.course,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.course = :course")
   List<StudentRecords> findByFirstName(@Param(value = "firstName")String firstName);

    //@Query("select s.id,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, s.studentCourseType.courseType, s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.studentEmail = :studentEmail")
   List<StudentRecords> findByStudentEmail(@Param(value = "studentEmail") String studentEmail);

    //List<StudentRecords> findByName(@Param(value = "name") String name);


    //List<StudentRecords> findByEmail(@Param(value= "email") String email);


    List<StudentRecords> findBystudentContact(@Param(value= "studentContact") String studentContact);


    //@Query("select s.id, s.name, s.remarks,s.course,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.course = :course")
//    @Query("select s from StudentRecords s where s.course = :course ")
//    List<StudentRecords> SearchStudentCourseType(@Param(value="course") String course);

//    @Query("select s from StudentRecords s where s.studentCourseType.courseType = :courseType or s.course = :course")
//    List<StudentRecords> findByStudentCourseType_courseTypeOrCourse(@Param(value="courseType") String courseType, @Param(value="course") String course);

    //@Query("select s from StudentRecords s where s.studentCourseType.courseType = :courseType or s.course = :courseType")
    List<StudentRecords> findByStudentCourseType_CourseTypeOrCourse(@Param(value="courseType") String courseType,
                                                                    @Param(value="course") String course);

    List<StudentRecords> findBycourse(@Param(value="course") String course);

    //%:username%
    @Query("select s.id, s.name, s.remarks,s.course,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, " +
            "s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.studentEmail " +
            "like %:studentEmail% or s.studentContact like %:studentContact%")
    List<StudentRecords> findByStudentEmailOrStudentContact(@Param(value="studentEmail") String studentEmail,
                                                             @Param(value="studentContact") String studentContact);

    //@Query("select s.id, s.name, s.remarks, s.course,s.firstName,s.lastName,s.studentEmail,s.studentContact, s.studentCourseType.courseType, s.studentStatus.studentStatus, s.studentBatch.studentBatch, s.studentYear.year, s.comments from StudentRecords s where s.name like '%name%' or where s.firstName like '%firstName%'")
    List<StudentRecords> findByFirstNameContainingOrNameContaining(@Param(value="firstName") String firstName,
                                               @Param(value="name") String name);








}
