package com.busyqa.crm.pojo.student;
/* 1:48 PM
created by: ajaypalsingh , 2018-12-06
Project: crm
*/

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="StudentStatus")
public class StudentStatus {

    //Lead, Register, Alumni

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long Id;


    private String studentStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentStatus", orphanRemoval = true)
    @JsonBackReference
    private List<StudentRecords> studentsRecords;

    public StudentStatus() {
    }

    public StudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public StudentStatus(long Id, String studentStatus) {
        this.Id = Id;
        this.studentStatus = studentStatus;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public List<StudentRecords> getStudentsRecords() {
        return studentsRecords;
    }

    public void setStudentsRecords(List<StudentRecords> studentsRecords) {
        this.studentsRecords = studentsRecords;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
}
