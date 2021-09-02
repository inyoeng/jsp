package com.yedam.app;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Employees {
	private String lastName;
	private String employeeId;
	private String jobId;
}
