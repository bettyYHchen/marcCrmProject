package com.busyqa.crm.pojo.employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EmployeeProfile")
public class EmployeeProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private String email;
	private String phone1;
	private String phone2;
	private boolean active;



	private boolean login;
	private Date lastLoginTime;
	private Date lastActionTime;
	private Date expectExpireTime;
	private String sessionID;


	public EmployeeProfile() {
	}


}
