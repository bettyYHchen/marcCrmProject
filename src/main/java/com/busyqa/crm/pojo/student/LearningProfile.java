package com.busyqa.crm.pojo.student;

import com.busyqa.crm.pojo.course.Course;
import com.busyqa.crm.pojo.payment.PaymentRecord;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "LearningProfile")
public class LearningProfile {
    public LearningProfile() {
    }

    public LearningProfile(Course course, LearningStatus learningStatus, String studentCourseInterestNote) {
        this.course = course;
        this.learningStatus = learningStatus;
        this.studentCourseInterestNote = studentCourseInterestNote;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @OneToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "course_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Course course;

    // LEAD
    @Enumerated(EnumType.STRING)
    @Column(name = "learningStatus")
    private LearningStatus learningStatus;


    private String studentCourseInterestNote;

    // REGISTERED STUDENT
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "payment_record_id")
    private PaymentRecord paymentRecord;

//	private CourseRecord courseRecord;

    // ========ref

    @ManyToOne
//    @JsonManagedReference
    private StudentProfile studentProfile;

    //========getter&setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LearningStatus getLearningStatus() {
        return learningStatus;
    }

    public void setLearningStatus(LearningStatus learningStatus) {
        this.learningStatus = learningStatus;
    }

    public String getStudentCourseInterestNote() {
        return studentCourseInterestNote;
    }

    public void setStudentCourseInterestNote(String studentCourseInterestNote) {
        this.studentCourseInterestNote = studentCourseInterestNote;
    }

    public PaymentRecord getPaymentRecord() {
        return paymentRecord;
    }

    public void setPaymentRecord(PaymentRecord paymentRecord) {
        this.paymentRecord = paymentRecord;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
