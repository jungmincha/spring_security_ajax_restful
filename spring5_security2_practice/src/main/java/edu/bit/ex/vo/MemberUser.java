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
public class MemberUser extends User {
	
	   private MemberVO member;
	 
	   
	   //�⺻������ �θ��� �����ڸ� ȣ���ؾ߸� ���������� �۵�
	   
		/*
		 * private String job;// VARCHAR2(9) private int mgr;// NUMBER(4) private
		 * Timestamp hiredate;// DATE private int sal;// NUMBER(7,2) private int comm;//
		 * NUMBER(7,2) private int deptno;// NUMBER(2)
		 */
	   public MemberUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
	      super(username, password, authorities);
	   }
	   
	   public MemberUser(MemberVO memberVO) {
	            
	      super(memberVO.getUsername(), memberVO.getPassword(),getAuth(memberVO) );

	      this.member = memberVO;
	   }
	   
	   //������ ���� �ִ� ���� ���
	   public static Collection<? extends GrantedAuthority> getAuth(MemberVO memberVO) { 

	      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	      
	      for (AuthVO auth: memberVO.getAuthList()) {
	         authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
	      }
	      
	      return authorities;
	   }   

}