
package com.yedam.app.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeeVO {
   private int Employee_id;
   private String last_name;
   private String email;
   private String phone_number;
   private Date hire_date;
}