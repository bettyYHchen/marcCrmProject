package com.busyqa.crm.pojo.student;
/* 5:02 PM
created by: ajaypalsingh , 2018-12-07
Project: crm
*/


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
//@Table
public class StudentYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long Id;


   // @Column(insertable=false, updatable=false)
    private long year;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentYear", orphanRemoval = true)
    @JsonBackReference
    private List<StudentRecords> studentRecordsList;

    public StudentYear() {
    }

    public StudentYear(long year) {
        this.year = year;
    }

    public StudentYear(long Id, long year) {
        this.Id = Id;
        this.year = year;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public List<StudentRecords> getStudentRecordsList() {
        return studentRecordsList;
    }

    public void setStudentRecordsList(List<StudentRecords> studentRecordsList) {
        this.studentRecordsList = studentRecordsList;
    }
}
