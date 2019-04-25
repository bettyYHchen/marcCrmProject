package com.busyqa.crm.pojo.payment;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "PaymentPlanWeek")
public class PaymentPlanWeek {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int weekNumber;
	private int weekAmount;

	private int studentPaidStatus;
	private String studentPaymentNote;

	private int staffCheckedStatus;
	private String staffCheckNote;

	private int staffAuditedStatus;
	private String staffAuditNote;


	// ========ref
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "payment_record_id", referencedColumnName = "id")
//	@JsonManagedReference
	private PaymentRecord paymentRecord;


}
