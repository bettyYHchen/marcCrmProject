package com.busyqa.crm.pojo.student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudentProfile")
public class StudentProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private String userName;
//    private String password;

    private String firstName;
    private String lastName;

    private String address;

    private String email;
    private String phone;
    private String phone2;
    private String comments;
    private String status;
//    private String course;
//    private String batch;
//    private String year;
    //@OneToMany(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})//(mappedBy = "studentProfile", fetch = FetchType.EAGER)
//    @OneToMany( cascade = CascadeType.ALL)//mappedBy = "studentProfile",
//    @JoinColumn(name = "student_profile_id", referencedColumnName = "id")
//    private List<LearningProfile> learningProfiles;


    public StudentProfile() {
    }

    public StudentProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public StudentProfile(String firstName, String lastName, List<LearningProfile> learningProfiles) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.learningProfiles = learningProfiles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getUserName() {
//        return userName;
//    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getComments() { return comments;    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//    public String getBatch() {
//        return batch;
//    }
//
//    public void setBatch(String batch) {
//        this.batch = batch;
//    }
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }

  // public List<LearningProfile> getLearningProfiles() {
  //    return learningProfiles;
  //  }

  // public void setLearningProfiles(List<LearningProfile> learningProfiles) {
  //     this.learningProfiles = learningProfiles;
   // }
}
