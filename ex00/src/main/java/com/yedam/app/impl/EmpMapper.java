package com.yedam.app.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yedam.app.Departments;

//dao라는 것을 알려주기위한 어노테이션
@Repository
public interface EmpMapper {
	List<Map> getEmp(String deptid);
	List<Departments> getDept();
	@Select("select sysdate from dual")
	public String getTime();
}
