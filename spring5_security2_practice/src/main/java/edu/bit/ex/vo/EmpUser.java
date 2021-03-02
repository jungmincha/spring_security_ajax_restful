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
//@Setter@Getter@ToString �� 3������ ������ ���־�� �Ѵ�.
public class EmpUser extends User {
	
	   
	private EmpVO emp; //emp�� ȣ���� �� �ִٴ� ���� �޸𸮿� �÷ȴٴ� ��(session!!) jsp���� (ex : principal.emp.ename)
	 
	   
	   //�⺻������ �θ��� �����ڸ� ȣ���ؾ߸� ���������� �۵�
	   
		/*
		 * private String job;// VARCHAR2(9) private int mgr;// NUMBER(4) private
		 * Timestamp hiredate;// DATE private int sal;// NUMBER(7,2) private int comm;//
		 * NUMBER(7,2) private int deptno;// NUMBER(2)
		 */
	   public EmpUser(String ename, String empno, Collection<? extends GrantedAuthority> authorities) {
	      super(ename, empno, authorities);
	   }
	   
	   public EmpUser(EmpVO emp) {//username, password, auth �� 3������ ������ �Ѱܾ� �Ѵ�.
	            
	      super(emp.getEname(), emp.getEmpno(),getAuth(emp) );
	      
	      this.emp = emp;

			/* this.member = MemberVO; */
	   }
	   
	   //������ ���� �ִ� ���� ���
	   public static Collection<? extends GrantedAuthority> getAuth(EmpVO emp) { 

	      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	      
	      for (AuthVO auth: emp.getAuthList()) {
	         authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
	      }
	      
	      return authorities;
	   }   

}
