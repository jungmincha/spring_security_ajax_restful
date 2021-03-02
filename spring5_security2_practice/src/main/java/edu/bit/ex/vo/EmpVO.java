package edu.bit.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmpVO {
	   private String ename;
	   private String empno;
	   
	   private String enabled;
	   
	  
		private String job;// VARCHAR2(9)
		private int mgr;// NUMBER(4)
		private Timestamp hiredate;// DATE
		private int sal;// NUMBER(7,2)
		private int comm;// NUMBER(7,2)
		private int deptno;// NUMBER(2)
		private int admin;
	   
	   private List<AuthVO> authList;
	   
	   
	}


/*public class MemberVO {
   private String username;
   private String password;
   private String enabled;
   
   private List<AuthVO> authList;
}*/