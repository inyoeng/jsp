package com.yedam.app.board.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.EmployeeVO;

@Repository
public interface EmployeeService {
	   public List<EmployeeVO> getEmp(Criteria cri);
	   public int getCount(Criteria cri);
	   public EmployeeVO read(EmployeeVO emp);
	}