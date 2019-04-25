package com.busyqa.crm.pojo.student;
/* 1:49 PM
created by: ajaypalsingh , 2018-12-06
Project: crm
*/

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="student_batch")

public class StudentBatch {

    //Autumn, Winter, Spring, Summer

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long Id;

    private String studentBatch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentBatch", orphanRemoval = true)
    @JsonBackReference
    private List<StudentRecords> studentRecordsList;

    public StudentBatch() {
    }

    public StudentBatch(String studentBatch) {
        this.studentBatch = studentBatch;
    }

    public StudentBatch(long id, String studentBatch) {
        this.Id = id;
        this.studentBatch = studentBatch;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

//    public List<StudentRecords> getStudentRecordsList() {
//        return studentRecordsList;
//    }
//
//    public void setStudentRecordsList(List<StudentRecords> studentRecordsList) {
//        this.studentRecordsList = studentRecordsList;
//    }

    public String getStudentBatch() {
        return studentBatch;
    }

    public void setStudentBatch(String studentBatch) {
        this.studentBatch = studentBatch;
    }

}
