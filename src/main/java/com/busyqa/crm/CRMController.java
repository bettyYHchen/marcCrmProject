package com.busyqa.crm;

import com.busyqa.crm.pojo.student.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CRMController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CRMService crmService;



//===================== code added by Ajaypal Singh===============
    //create
    @RequestMapping(method = RequestMethod.POST, value="/registerstudent",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentRecords registerStudentRecord(@RequestBody StudentRecords studentRecords) throws Exception {

        this.crmService.registerStudentRecord(studentRecords);
        return studentRecords;
    }

    //read
    @RequestMapping(method = RequestMethod.GET, value="/audit")
    @PreAuthorize("hasRole('ROLE_AUDIT')")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentRecords> auditPage(){

        return this.crmService.listofRegisteredStudentRecords();

    }

    //read
    @RequestMapping(method = RequestMethod.GET, value="/adminpage")
    @PreAuthorize("hasRole('ROLE_AUDIT') OR ('ROLE_SYSTEM_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentRecords> adminPage(){

        return this.crmService.listofRegisteredStudentRecords();

    }

    //read
    @RequestMapping(method=RequestMethod.GET, value = "/student/id/{id}")
    public Optional<StudentRecords> getStudentRecordbyId(@PathVariable long id) {

        return this.crmService.
                getbyId(id);

    }


    //update
    @RequestMapping(method = RequestMethod.PUT, value="/update/student")
    public StudentRecords updateRecord(@RequestBody StudentRecords studentRecords) {

        return this.crmService.updateStudentRecord(studentRecords);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/update/student/{id}")
    public StudentRecords updateRecordbyId(@PathVariable long id, @RequestBody StudentRecords studentRecord) throws Exception {

       // Optional<StudentRecords> records = this.crmService.getbyId(id);


        return this.crmService.updateStudentRecordbyId(id, studentRecord);


    }

    //delete
    @RequestMapping(method=RequestMethod.DELETE, value="/student/id/{id}")
    public void deleteStudentRecord(@PathVariable long id) {

       System.out.println("delete method called");
       this.crmService.deleteStudentRecordById(id);
        //return ResponseEntity.ok("resource deleted");
    }


    //== get courseTypes
    //http://localhost:8080/courseType
    @RequestMapping(method = RequestMethod.GET, value = "/courseType")
    public List<StudentCourseType> getCourseType() {

        return this.crmService.getCourseType();
    }

    //== get Student_Status
    //==http://localhost:8080/studentstatus
    @RequestMapping(method = RequestMethod.GET, value = "/studentstatus")
    public List<StudentStatus> getStudentStatus() {

        return this.crmService.getStudentStatus();
    }

    //== get Student_Batch
    //== http://localhost:8080/studentbatch
    @RequestMapping(method = RequestMethod.GET, value = "/studentbatch")
    public List<StudentBatch> getStudentBatch() {

        return this.crmService.getStudentBatch();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list_years")
    public List<StudentYear> getStudentYear() {

        return this.crmService.getStudentYear();
    }

//    @RequestMapping(method = RequestMethod.GET , value = "/search/student")
//    public List<StudentRecords> SearchStudents(@RequestParam String terms) {
//        List<StudentRecords> students = this.crmService.searchStudents(terms);
//        System.out.println(students);
//        return students;
//
//    }

    @RequestMapping(method = RequestMethod.GET , value = "/student/firstname")
    public List<StudentRecords> SearchStudentsbyFirstName(@RequestParam String firstName) {
        List<StudentRecords> students = this.crmService.searchStudentRecordsbyfirstName(firstName);
        System.out.println(students);
        return students;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/csvData")
    public void StudentRecordsCSV(@RequestBody ArrayList<StudentRecords> csvData) {

       crmService.saveStudentRecordsCSV(csvData);
       System.out.println("CSV data has been saved");

    }

//    @RequestMapping(method=RequestMethod.GET, value="/csvData")
//    public List<CSVData> SearchCSVDatabyName(@RequestParam String name) {
//
//        System.out.println("**Search by name controller called");
//       List<CSVData> csv = this.crmService.SearchCSVData(name);
//       return csv;
//    }
//     @RequestMapping(method=RequestMethod.GET, value="/csvData")
//    public List<StudentRecords> SearchCSVDatabyName(@RequestParam String name) {
//
//        System.out.println("**Search by name controller called");
//       List<StudentRecords> csv = this.crmService.SearchCSVData(name);
//       return csv;
//    }

    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byEmail")
    public List<StudentRecords> SearchStudentRecordbyEmail(@RequestParam String studentEmail) {

        List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyEmailAddress(studentEmail);
        return csv;
    }

    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byPhone")
    public List<StudentRecords> SearchStudentRecordbyPhoneNumber(@RequestParam String studentContact) {

        List<StudentRecords> csv = this.crmService.SearchStudentReocrdsbyPhoneNumber(studentContact);
        return csv;
    }

    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byEmailOrPhone")
    public List<StudentRecords> SearchStudentRecordbyPhoneNumber(@RequestParam String studentEmail,
                                                                 @RequestParam String studentContact) {

        List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyEmailAndPhoneNumber(studentEmail, studentContact);
        return csv;
    }

    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byfirstNameOrname")
    public List<StudentRecords> SearchStudentRecordbyfirstNameOrName(@RequestParam String firstName,
                                                                      @RequestParam String name) {

        List<StudentRecords> csv = this.crmService.SearchStudentRecordbyfirstNameOrName(firstName, name);
        return csv;
    }




//    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byCourseType")
//    public List<StudentRecords> SearchStudentRecordbyCourseType(@RequestParam(value="courseType", required = false) String courseType,
//                                                                @RequestParam(value = "course", required = false) String course) {
//
//        if(courseType==null){
//            List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyCourse(course);
//            return csv;
//        }
//
//        else{
//            List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyCourseType(courseType);
//            return csv;
//
//        }
////        List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyCourseType(courseType);
////        return csv;
//
//    }

    @RequestMapping(method=RequestMethod.GET, value="/studentRecord/byCourseTypeOrCourse")
    public List<StudentRecords> SearchStudentRecordbyCourseType(@RequestParam(value="courseType") String courseType,
                                                                @RequestParam(value="course") String course){



            List<StudentRecords> csv = this.crmService.SearchStudentRecordsbyCourseTypeOrCourse(courseType, course);
            return csv;


    }




    //=====================================================

    //http://127.0.0.1:8080/sub2?terms=
    @RequestMapping(method = RequestMethod.POST, value = "/sub")
    public List<StudentProfile> createByStudentsByCSV(@RequestBody ArrayList<StudentProfile> studentProfiles) {

//                for (StudentProfile sp:
//        studentProfiles) {
//            System.out.print(sp.getStudentEmail());
//        }

        crmService.createStudentProfilesByCSV(studentProfiles);
        return studentProfiles;

    }
    //========
    @RequestMapping(method = RequestMethod.GET, value = "/studentprofiles")
    public List<StudentProfile> listAllAndSort() {
        return this.crmService.getStudentProfileList();
    }


    @RequestMapping(method = RequestMethod.GET , value = "/sub2")
    public List<StudentProfile> SearchStudentsByTerm(@RequestParam String  terms) {
        List<StudentProfile>  students = this.crmService.searchStudentsByTerm(terms);
        System.out.println(students);
        return students;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/submitcsv")
//    @ResponseStatus(HttpStatus.OK)
//    public void createByStudentsByCSV(@RequestBody List<StudentProfile> studentProfiles) {
//        System.out.print("step1");
//        //        for (StudentProfile sp:
////        studentProfiles) {
////            System.out.print(sp);
////        }
////         this.crmService.createStudentProfilesByCSV(studentProfiles);
////        System.out.print(job);s
////        return this.jobbankService.getJobList();
//    }
//
//    //========
//    @RequestMapping(method = RequestMethod.GET, value = "/companies")
//    public List<JobCompany> getCompanyList() {
//        return this.jobbankService.getCompanyList();
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/jobtypes")
//    public List<JobType> getJobTypeList() {
//        return this.jobbankService.getJobTypeList();
//    }
//
//    //========
////    @Autowired
////    private JobLoginStatus jobLoginStatus;
//
//    @RequestMapping(method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE, value = "/login")
//    public JobLoginStatus login(@RequestBody JobPostUser jobPostUser, HttpSession session) {
//
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
//
//        if (session.getAttribute("id") != null) {
//            System.out.println("SUCCESS: " + session.getAttribute("id") + " \n");
//        } else {
//            session.setAttribute("id", sessionId);
//            System.out.println("F");
//
//        }
//
//
//        JobLoginStatus jobLoginStatus = new JobLoginStatus();
//
////        if (jobLoginStatus.isLogin()) {
////            this.jobLoginStatus.setLogin(true);
////        } else {
////            this.jobLoginStatus.setLogin(false);
////        }
////
////        System.out.println("\n " + this.jobLoginStatus.isLogin() + " \n");
//
//
//        return jobLoginStatus;
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET,
//            value = "/checklogin")
//    public JobLoginStatus checkLogin(HttpSession session) {
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
////        System.out.println("\n SERVICE: checkLogin \n");
//
////        System.out.println("\n " + request.getSession() + " \n");
////        System.out.println("\n " + request.getSession().getAttribute("login") + " \n");
////
////
////        boolean login = Boolean.valueOf(request.getSession().getAttribute("login").toString());
////        System.out.println("\n " + session.getAttribute("login") + " \n");
////        System.out.println("\n " + login + " \n");
//        JobLoginStatus js = new JobLoginStatus();
//
//        return js;
////        return this.jobbankService.checkLogin(session);
//    }
//
//    @GetMapping("/checkCount")
//    // it will handle all request for /welcome
//    public java.util.Map<String, Integer> start(HttpSession session) {
//        String sessionId = session.getId();
//        System.out.println("\n " + sessionId + " \n");
//
//        Integer integer = (Integer) session.getAttribute("hitCounter"); // it will read data from database tables
//        if (integer == null) {
//            integer = new Integer(0);
//            integer++;
//            session.setAttribute("hitCounter", integer);  // it will write data to tables
//        } else {
//            integer++;
//            session.setAttribute("hitCounter", integer);  // it will write data to tables
//        }
//        java.util.Map<String, Integer> hitCounter = new HashMap<>();
//        hitCounter.put("Hit Counter", integer);
//        return hitCounter;
//    }

}

