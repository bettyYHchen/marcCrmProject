package com.busyqa.crm.pojo.student;
/* 1:27 PM 
created by: ajaypalsingh , 2018-12-06
Project: crm 
*/

import javax.persistence.*;

@Entity
//@Table(name="RegistrationForm")
public class StudentRecords {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", unique = true, nullable = false, updatable = false)
    private long id;

    private String firstName;

    private String lastName;

    private String studentEmail;

    private String studentContact;


    private String name;
    //private String comments;
    // private String studentEmail;
    //private String phoneNumber;
    private String remarks;
    private String course;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="CourseType_fk_id")
    //@JoinColumn(name="coursetype", nullable=false)s
    //@JoinColumn(name = "coursetype_id", referencedColumnName = "id")

   // @JoinColumn(name = "course", referencedColumnName = "course")
//    @@JoinTable(name = "Student_Course_Type", joinColumns = {
//            @JoinColumn(name = "", nullable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID",
//                    nullable = false, updatable = false) })
//            // @Embedded
    private StudentCourseType studentCourseType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Status_fk_id")
    private StudentStatus studentStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Batch_fk_id")
    private StudentBatch studentBatch;

    //@Column(name="Year of Enrollment")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="year_fk_id")
    private StudentYear studentYear;

    @Lob
    private String comments;

    public StudentRecords(long id, String studentEmail,
                          String studentContact, String name, String remarks,
                          String course, String comments) {
        this.id = id;

        this.studentEmail = studentEmail;
        this.studentContact = studentContact;
        this.name = name;
        this.remarks = remarks;
        this.course = course;

        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public StudentRecords() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

//    public String getStudentContact() {
//        return studentContact;
//    }
//
//    public void setStudentContact(String studentContact) {
//        this.studentContact = studentContact;
//    }


    public StudentCourseType getStudentCourseType() {
        return studentCourseType;
    }

    public void setStudentCourseType(StudentCourseType studentCourseType) {
        this.studentCourseType = studentCourseType;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public StudentBatch getStudentBatch() {
        return studentBatch;
    }

    public void setStudentBatch(StudentBatch studentBatch) {
        this.studentBatch = studentBatch;
    }


    public StudentYear getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(StudentYear studentYear) {
        this.studentYear = studentYear;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getStudentEmail() {
//        return studentEmail;
//    }
//
//    public void setStudentEmail(String studentEmail) {
//        this.studentEmail = studentEmail;
//    }



    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    @Override
    public String toString() {
        return "StudentRecords{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", studentCourseType=" + studentCourseType +
                ", studentStatus=" + studentStatus +
                ", studentBatch=" + studentBatch +
                ", studentYear=" + studentYear +
                ", comments='" + comments + '\'' +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
