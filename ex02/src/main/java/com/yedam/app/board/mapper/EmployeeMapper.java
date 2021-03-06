package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.EmployeeVO;

public interface EmployeeMapper {
	   public List<EmployeeVO> getEmp(Criteria cri);
	   public int getCount(Criteria cri);
	   public EmployeeVO read(EmployeeVO emp);
	}