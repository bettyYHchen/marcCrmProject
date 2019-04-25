package com.busyqa.crm.repo;

import com.busyqa.crm.pojo.payment.PaymentPlanWeek;
import com.busyqa.crm.pojo.payment.PaymentRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PaymentPlanWeekRepo extends PagingAndSortingRepository<PaymentPlanWeek, Long> {

}

