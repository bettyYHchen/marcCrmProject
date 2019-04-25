package com.busyqa.crm;

import com.busyqa.crm.pojo.student.*;
import com.busyqa.crm.repo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

//@EnableBatchProcessing
public class CRMService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentProfileRep studentProfileRep;
    @Autowired
    private StudentCourseProfileRepo studentCourseProfileRepo;

    @Autowired
    private PaymentRecordRepo paymentRecordRepo;
    @Autowired
    private PaymentPlanWeekRepo paymentPlanWeekRepo;

//=====================
    @Autowired
    private StudentRecordRepo studentRecordRepo;
    @Autowired
    private StudentStatusRepo studentStatusRepo;
    @Autowired
    private StudentCourseTypeRepo studentCourseTypeRepo;
    @Autowired
    private StudentBatchRepo studentBatchRepo;
    @Autowired
    private StudentYearRepo studentYearRepo;
    @Autowired
    private StudentRecordsCSVRepo studentRecordsCSVRepo;

//    @Autowired
//    private CSVDataRepo csvDataRepo;



//    public CRMService() {
//
//        System.out.println("Default Construtor called");
//    }



    public CRMService(StudentRecordRepo studentRecordRepo,
                      StudentCourseTypeRepo studentCourseTypeRepo, StudentStatusRepo studentStatusRepo,
                      StudentBatchRepo studentBatchRepo, StudentYearRepo studentYearRepo

                      ) {
        this.studentRecordRepo = studentRecordRepo;
        this.studentStatusRepo = studentStatusRepo;
        this.studentCourseTypeRepo = studentCourseTypeRepo;
        this.studentBatchRepo = studentBatchRepo;
        this.studentYearRepo = studentYearRepo;




        if(!this.studentCourseTypeRepo.findAll().iterator().hasNext()) {

            this.studentCourseTypeRepo.saveAll(new ArrayList<StudentCourseType>() {
                {
                    add(new StudentCourseType(1, "Software Testing"));
                    add(new StudentCourseType(2, "Full Stack Java Developer"));
                    add(new StudentCourseType(3, "Business Analyst"));
                    add(new StudentCourseType(4, "Project Management"));

                }
            });
        }

        if(!this.studentStatusRepo.findAll().iterator().hasNext()) {

            this.studentStatusRepo.saveAll(new ArrayList<StudentStatus>() {
                {
                    add(new StudentStatus(1, "Lead"));
                    add(new StudentStatus(2, "Register"));
                    add(new StudentStatus(3, "Alumni"));

                }
            });
        }

        if(!this.studentBatchRepo.findAll().iterator().hasNext()) {

            this.studentBatchRepo.saveAll(new ArrayList<StudentBatch>() {
                {
                    add(new StudentBatch(1, "Autumn"));
                    add(new StudentBatch(2, "Winter"));
                    add(new StudentBatch(3, "Spring"));
                    add(new StudentBatch(4, "Summer"));
                }
            });
        }

        if(!this.studentYearRepo.findAll().iterator().hasNext()) {

            this.studentYearRepo.saveAll(new ArrayList<StudentYear>() {
                {

                    add(new StudentYear(1, 2019));
                    add(new StudentYear(2, 2018));
                    add(new StudentYear(3, 2017));
                    add(new StudentYear(4, 2016));
                    add(new StudentYear(5, 2015));
                    add(new StudentYear(6, 2014));
                    add(new StudentYear(7, 2013));
                    add(new StudentYear(8, 2012));
                    add(new StudentYear(9, 2011));
                    add(new StudentYear(10, 2010));
                    add(new StudentYear(11, 2009));
                    add(new StudentYear(12, 2008));
                    add(new StudentYear(13, 2007));
                    add(new StudentYear(14, 2006));
                    add(new StudentYear(15, 2005));
                    add(new StudentYear(16, 2004));
                    add(new StudentYear(17, 2003));
                    add(new StudentYear(18, 2002));
                    add(new StudentYear(19, 2001));
                    add(new StudentYear(20, 2000));


                }
            });
        }


    }


//=====  added by Ajaypal Singh  ==================


    //add new student
    public StudentRecords registerStudentRecord(StudentRecords studentRecords) throws Exception {



//        StudentCourseType courseType = studentRecords.getStudentCourseType();
//        StudentStatus studentStatus = studentRecords.getStudentStatus();
//        StudentBatch studentBatch = studentRecords.getStudentBatch();
//        StudentYear studentYear = studentRecords.getStudentYear();
//
////        System.out.println("Course Id; " + courseType.getid());
////        System.out.println("Status Id; " + studentStatus.getid());
//
//
//        if(courseType != null  && courseType.getId() == 0) {
//            studentRecords.setStudentCourseType(studentCourseTypeRepo.save(courseType));
//        }
//
//        if(studentStatus !=null && studentStatus.getId() == 0) {
//            studentRecords.setStudentStatus(studentStatusRepo.save(studentStatus));
//        }
//
//        if(studentBatch !=null && studentBatch.getId() == 0){
//            studentRecords.setStudentBatch(studentBatchRepo.save(studentBatch));
//        }
//
//        if(studentYear !=null && studentYear.getId() == 0) {
//            studentRecords.setStudentYear(studentYearRepo.save(studentYear));
//        }

//        System.out.println("Student Records");
//        System.out.println(studentRecords);
        StudentCourseType courseType = studentRecords.getStudentCourseType();
        StudentStatus studentStatus = studentRecords.getStudentStatus();
        StudentBatch studentBatch = studentRecords.getStudentBatch();
        StudentYear studentYear = studentRecords.getStudentYear();
        String email = studentRecords.getStudentEmail();
        //System.out.println("Email: "+ email);

        //System.out.println(emailRecord);



        if(email == "") {
            studentRecords.setStudentEmail(null);
        }
        if(courseType !=null && courseType.getId() != 0) {
            studentRecords.setStudentCourseType(studentCourseTypeRepo.findById(courseType.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentCourseType(null);
        }

        if(studentStatus !=null && studentStatus.getId() != 0) {
            studentRecords.setStudentStatus(studentStatusRepo.findById(studentStatus.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentStatus(null);
        }
        if(studentBatch !=null && studentBatch.getId() != 0) {
            studentRecords.setStudentBatch(studentBatchRepo.findById(studentBatch.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentBatch(null);
        }
        if(studentYear !=null && studentYear.getId() != 0) {
            studentRecords.setStudentYear(studentYearRepo.findById(studentYear.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentYear(null);
        }

      //duplicate email validate check
        List<StudentRecords> emailRecord =  this.studentRecordRepo.findByStudentEmail(email);
//        System.out.println("Student Records");
//        System.out.println(emailRecord);

        if(emailRecord.isEmpty()) {
            this.studentRecordRepo.save(studentRecords);
        }
        else {
            System.out.println("Email address already exists");
        }

            return studentRecords;

       // if(studentRecordRepo.findBystudentEmail(studentRecords.getStudentEmail()) == null)
//            this.studentRecordRepo.save(studentRecords);
//            return studentRecords;
    }


    //return list of students
    public List<StudentRecords> listofRegisteredStudentRecords() {

        List<StudentRecords> listofStudents = new ArrayList<>();
        this.studentRecordRepo.findAll().forEach(listofStudents::add);

        return listofStudents;
    }

    //get Student Record by Id
    public Optional<StudentRecords> getbyId(long id) {

        Optional<StudentRecords> record = this.studentRecordRepo.findById(id);
        return record;

    }

    //update StudentRecord
    public StudentRecords updateStudentRecord(StudentRecords studentRecords) {

       // Optional<StudentRecords> record = studentRecordRepo.findById(studentRecords.getId());

       return this.studentRecordRepo.save(studentRecords);

    }

    public StudentRecords updateStudentRecordbyId(long id, StudentRecords studentRecords) throws Exception{

       // System.out.println("Id-1: " + id);


        Optional<StudentRecords> record = this.studentRecordRepo.findById(id);

        StudentCourseType courseType = studentRecords.getStudentCourseType();
        StudentStatus studentStatus = studentRecords.getStudentStatus();
        StudentBatch studentBatch = studentRecords.getStudentBatch();
        StudentYear studentYear = studentRecords.getStudentYear();
        String email = studentRecords.getStudentEmail();



        if(email == "") {
            studentRecords.setStudentEmail(null);
        }
        if(courseType !=null && courseType.getId() != 0) {
            studentRecords.setStudentCourseType(studentCourseTypeRepo.findById(courseType.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentCourseType(null);
        }

        if(studentStatus !=null && studentStatus.getId() != 0) {
            studentRecords.setStudentStatus(studentStatusRepo.findById(studentStatus.getId()).orElseThrow(() -> new Exception("StudentCourseType not found for this id")));
        }else{
            studentRecords.setStudentStatus(null);
        }

        if(studentBatch !=null && studentBatch.getId() != 0) {
            studentRecords.setStudentBatch(studentBatchRepo.findById(studentBatch.getId()).orElseThrow(() -> new Exception("StudentBatchType not found for this id")));
        }else{
            studentRecords.setStudentBatch(null);
        }

        if(studentYear !=null && studentYear.getId() != 0) {
            studentRecords.setStudentYear(studentYearRepo.findById(studentYear.getId()).orElseThrow(() -> new Exception("StudentYear not found for this id")));
        }else{
            studentRecords.setStudentYear(null);
        }

        //System.out.println("Id-2: " + record.get().getId());
         //System.out.println(record.get().getStudentStatus());
        if(record.get().getId() == id) {
            studentRecords.setId(id);
            return this.studentRecordRepo.save(studentRecords);
        }
        else
            return null;

    }

    //delete StudentRecord
    public void deleteStudentRecordById(long id) {

        System.out.println("Delete ID: " + id);

        this.studentRecordRepo.deleteById(id);
    }

    //get Student_Course_Type
    public List<StudentCourseType> getCourseType() {

        return this.studentCourseTypeRepo.findAll();
    }

    //==get Student Status
    public List<StudentStatus> getStudentStatus() {

        return this.studentStatusRepo.findAll();
    }

    //get Student_Batch
    public List<StudentBatch> getStudentBatch() {

        return this.studentBatchRepo.findAll();
    }

    //get years list
    public List<StudentYear> getStudentYear() {

        return this.studentYearRepo.findAll();
    }

//    public List<StudentRecords> searchStudentRecords(String terms) {
//        List<StudentRecords> students  = studentRecordRepo.searchStudents(terms);
//        return students;
//    }

    public List<StudentRecords> searchStudentRecordsbyfirstName(String firstName) {
        List<StudentRecords> students = studentRecordRepo.findByFirstName(firstName);
        return students;
    }
//
//    public List<StudentRecords> searchStudentRecordsbyEmailAddress(String studentEmail) {
//        List<StudentRecords> students = studentRecordRepo.findBystudentEmail(studentEmail);
//        return students;
//    }



//    public List<CSVData> saveStudentRecordsCSV(ArrayList<CSVData> csvData) {
//
//        return this.csvDataRepo.saveAll(csvData);
//
//    }
    public void saveStudentRecordsCSV(ArrayList<StudentRecords> csvData) {

        this.studentRecordRepo.saveAll(csvData);

    }

//    public List<CSVData> SearchCSVData(String firstName) {
//        List<CSVData> students  = csvDataRepo.findByName(firstName);
//        return students;
//    }
//

//    public List<CSVData> csvDatabyEmailAddress(String email){
//        List<CSVData> students = csvDataRepo.findByEmail(email);
//        return students;
//    }
        public List<StudentRecords> SearchStudentRecordsbyEmailAddress(String studentEmail){
        List<StudentRecords> students = studentRecordRepo.findByStudentEmail(studentEmail);
        return students;
    }

    public List<StudentRecords> SearchStudentReocrdsbyPhoneNumber(String phoneNumber){
        List<StudentRecords> students = studentRecordRepo.findBystudentContact(phoneNumber);
        return students;
    }

    public List<StudentRecords> SearchStudentRecordsbyCourseTypeOrCourse(String courseType,String course){

        List<StudentRecords> students = studentRecordRepo.findByStudentCourseType_CourseTypeOrCourse(courseType, course);

        return students;
    }

    public List<StudentRecords> SearchStudentRecordsbyCourse(String course){

        List<StudentRecords> students = studentRecordRepo.findBycourse(course);

        return students;
    }

    public List<StudentRecords> SearchStudentRecordsbyEmailAndPhoneNumber(String studentEmail, String studentContact) {

        List<StudentRecords> students = studentRecordRepo.findByStudentEmailOrStudentContact(studentEmail, studentContact);
        return students;
    }

    public List<StudentRecords> SearchStudentRecordbyfirstNameOrName(String firstName, String name){

        List<StudentRecords> students = studentRecordRepo.findByFirstNameContainingOrNameContaining(firstName, name);
        return students;
    }





    // ================================


    public void createStudentProfilesByCSV(ArrayList<StudentProfile> studentProfiles) {
    studentProfileRep.saveAll(studentProfiles);
    }

   //----------------------------------
   public List<StudentProfile> searchStudentsByTerm(String terms){
       List<StudentProfile> students  = studentProfileRep.SearchStudentsByTerm(terms);
       return students;
   }




  //----------------------------------------------
//  public void updateStudent(StudentProfile studentup){
//      this.studentProfileRep.updateStudent(studentup.getId());
//  }

//    public CRMService(PaymentPlanWeekRepo paymentPlanWeekRepo, PaymentRecordRepo paymentRecordRepo, StudentCourseProfileRepo studentCourseProfileRepo, StudentProfileRep studentProfileRep) {
//        this.studentProfileRep = studentProfileRep;
//        this.studentCourseProfileRepo = studentCourseProfileRepo;
//
//        this.paymentRecordRepo = paymentRecordRepo;
//        this.paymentPlanWeekRepo = paymentPlanWeekRepo;
//
//        //Mock-Course
//        Course course1 = new Course("FSJ-2018S", "Full Stak Java", "2018 Summer");
//        Course course2 = new Course("AT-2018S", "Auto Testing", "2018 Summer");
//        Course course3 = new Course("SM-2018S", "Scrum Master", "2018 Summer");
//
//
//
//        //Mock-LearningProfile
//        LearningProfile scp11 = new LearningProfile(course1, LearningStatus.LEAD, "Contact on Monday");
//        LearningProfile scp12 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
//        LearningProfile scp13 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");
//
//        LearningProfile scp21 = new LearningProfile(course1, LearningStatus.LEAD, "Contact on Monday");
//        LearningProfile scp22 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
//        LearningProfile scp23 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");
//
//        LearningProfile scp31 = new LearningProfile(course2, LearningStatus.LEAD, "Contact on Monday");
//        LearningProfile scp32 = new LearningProfile(course3, LearningStatus.LEAD, "Contact on Monday");
//
//
//
//
//    }


    

    //    //create
//    public Job createJob(Job job) {
//        JobCompany jobCompany = job.getJobCompany();
//        JobType jobType = job.getJobType();
//
//        if (jobCompany != null && jobCompany.getId() == 0) {
//            job.setJobCompany(jbCompanyRepository.save(jobCompany));
//        }
////        if (jobType != null && jobType.getId() == 0) {
////            job.setJobType(jobTypeRepository.save(jobType));
////        }
//
////        System.out.println(jobCompany.getCompanyName());
////        System.out.println(jobType.getJobTypeName());
//
//        this.jobRepository.save(job);
//        return job;
//    }
//
//    //Read
    public List<StudentProfile> getStudentProfileList() {
        List<StudentProfile> list = new ArrayList<>();
        studentProfileRep.findAll().forEach(list::add);

        return list;
    }


//
//
//    public List<JobCompany> getCompanyList() {
//        List<JobCompany> list = new ArrayList<>();
//        jbCompanyRepository.findAll().forEach(list::add);
//
//        return list;
//    }
//
//    public List<JobType> getJobTypeList() {
//        List<JobType> list = new ArrayList<>();
//        jobTypeRepository.findAll().forEach(list::add);
//
//        return list;
//    }
//
////    @Autowired
////    private JobLoginStatus jobLoginStatus;
//
//
//    public JobLoginStatus login(JobPostUser jobPostUser, HttpSession session) {
//
//         JobLoginStatus jobLoginStatus =  new JobLoginStatus();
//
//
//        if (jobPostUserRepository.findByUserNameAndPassword(jobPostUser.getUserName(), jobPostUser.getPassword()) != null) {
//            System.out.println("\n LOGIN \n");
//            jobLoginStatus.setLogin(true);
//            session.setAttribute("login", true);
//
////            this.jobLoginStatus.setLogin(true);
//        } else {
//            System.out.println("\n NOT LOGIN \n");
//            jobLoginStatus.setLogin(false);
//            session.setAttribute("login", false);
//
////            this.jobLoginStatus.setLogin(false);
//
//        }
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//        return jobLoginStatus;
//    }

//    public JobLoginStatus checkLogin(HttpSession session) {
////        JobLoginStatus loginStatus = new JobLoginStatus();
////        loginStatus.setLogin(loginStatus.isLogin());
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//        return jobLoginStatus;
//
//    }
}
