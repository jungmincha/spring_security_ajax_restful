package edu.bit.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@AllArgsConstructor
public class UserVO {
   private String username;
   private String password;
   
   private int enabled;
   
	/*
	 * private String job;// VARCHAR2(9) private int mgr;// NUMBER(4) private
	 * Timestamp hiredate;// DATE private int sal;// NUMBER(7,2) private int comm;//
	 * NUMBER(7,2) private int deptno;// NUMBER(2)
	 */   
   
   
   
   public UserVO(){
     
   }
   
}
