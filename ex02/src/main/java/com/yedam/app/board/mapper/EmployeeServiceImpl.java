package com.yedam.app.board.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.EmployeeVO;
import com.yedam.app.board.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	   @Autowired EmployeeMapper employeeMapper;
	   @Override
	   public List<EmployeeVO> getEmp(Criteria cri) {
	      // TODO Auto-generated method stub
	      return employeeMapper.getEmp(cri);
	   }

	   @Override
	   public int getCount(Criteria cri) {
	      // TODO Auto-generated method stub
	      return employeeMapper.getCount(cri);
	   }

	   @Override
	   public EmployeeVO read(EmployeeVO emp) {
	      // TODO Auto-generated method stub
	      return employeeMapper.read(emp);
	   }

	}