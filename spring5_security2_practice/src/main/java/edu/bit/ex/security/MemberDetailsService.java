package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.MemberMapper;
import edu.bit.ex.vo.EmpUser;
import edu.bit.ex.vo.EmpVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberDetailsService implements UserDetailsService  {
   
   @Setter(onMethod_ = @Autowired)
   private MemberMapper memberMapper;
   
   
   
   
   @Override
   public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
     //UserDetails�� ������ session���·� �־�� �Ѵ�.
	   //�α����� �ϰԵǸ� �ݵ�� ȣ��
	  //userdetails ������(--> new MemberUser(vo) )
	   
	   
      log.warn("Load User By EmpVO number: " + ename);      
      EmpVO vo = memberMapper.getMember(ename);      
      
      log.warn("queried by EmpVO mapper: " + vo);
      
      return vo == null ? null : new EmpUser(vo);
   }
   
}