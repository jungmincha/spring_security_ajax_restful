package edu.bit.ex.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@Setter@Getter@ToString 이 3가지는 무조건 들어가주어야 한다.
public class EmpUser extends User {
	
	   
	private EmpVO emp; //emp를 호출할 수 있다는 것은 메모리에 올렸다는 것(session!!) jsp에서 (ex : principal.emp.ename)
	 
	   
	   //기본적으로 부모의 생성자를 호출해야만 정상적으로 작동
	   
		/*
		 * private String job;// VARCHAR2(9) private int mgr;// NUMBER(4) private
		 * Timestamp hiredate;// DATE private int sal;// NUMBER(7,2) private int comm;//
		 * NUMBER(7,2) private int deptno;// NUMBER(2)
		 */
	   public EmpUser(String ename, String empno, Collection<? extends GrantedAuthority> authorities) {
	      super(ename, empno, authorities);
	   }
	   
	   public EmpUser(EmpVO emp) {//username, password, auth 이 3가지는 무조건 넘겨야 한다.
	            
	      super(emp.getEname(), emp.getEmpno(),getAuth(emp) );
	      
	      this.emp = emp;

			/* this.member = MemberVO; */
	   }
	   
	   //유저가 갖고 있는 권한 목록
	   public static Collection<? extends GrantedAuthority> getAuth(EmpVO emp) { 

	      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	      
	      for (AuthVO auth: emp.getAuthList()) {
	         authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
	      }
	      
	      return authorities;
	   }   

}
