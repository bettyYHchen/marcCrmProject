package com.busyqa.crm.repo;

import com.busyqa.crm.pojo.student.LearningProfile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentCourseProfileRepo extends PagingAndSortingRepository<LearningProfile, Long> {

}

