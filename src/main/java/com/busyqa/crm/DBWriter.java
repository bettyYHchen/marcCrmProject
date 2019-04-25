//package com.busyqa.crm;
///* 5:20 PM
//created by: ajaypalsingh , 2019-01-06
//Project: crm
//*/
//
//import com.busyqa.crm.pojo.student.StudentRecordsCSV;
//import com.busyqa.crm.repo.StudentRecordsCSVRepo;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManagerFactory;
//import java.util.List;
//
//@Component
//public class DBWriter implements ItemWriter<StudentRecordsCSV> {
//
//    @Autowired
//    EntityManagerFactory emf;
//
//    @Autowired
//    private StudentRecordsCSVRepo studentRecordsCSVRepo;
//
//
//    @Override
//    public void write(List<? extends StudentRecordsCSV> studentRecordsCSVList) throws Exception {
//
//        System.out.println("Data Saved for Users: " + studentRecordsCSVList);
//        studentRecordsCSVRepo.saveAll(studentRecordsCSVList);
//
//    }
//
//}
//
//
//
