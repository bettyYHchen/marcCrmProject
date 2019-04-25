package com.busyqa.crm;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


//@EnableTransactionManagement

public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);

		ObjectMapper om = new ObjectMapper();
		Version version = om.version();
		System.out.println(version);
	}
}
