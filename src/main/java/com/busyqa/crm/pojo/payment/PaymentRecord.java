package com.busyqa.crm.pojo.payment;

import com.busyqa.crm.pojo.student.LearningProfile;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "PaymentRecord")
public class PaymentRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "paymentPlanType")
	private PaymentPlanType paymentPlanType;

	private int paymentTotalAomount;

	@OneToMany//(mappedBy = "paymentRecord", cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment_record_id", referencedColumnName = "id")
	private List<PaymentPlanWeek> paymentPlanWeeks;

	@Enumerated(EnumType.STRING)
	@Column(name = "paymentStatus")
	private PaymentStatus paymentStatus;

	// ========ref
	@OneToOne//(mappedBy = "paymentRecord")
	private LearningProfile learningProfile;




}
