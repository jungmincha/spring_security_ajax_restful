package edu.bit.ex;




import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.EmpUser;
import edu.bit.ex.vo.EmpVO;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class UserController {

	  private UserService userService;

	   @PostMapping("/user/addUser")
	   public String addUser(UserVO userVO) {
	      log.info("post resister");      

	      userService.addUser(userVO);
	      
	      return "redirect:/";   
	   }   

	   @GetMapping("/user/userForm")
	   public void userForm() {
	      log.info("Welcome userFForm!");      
	   }   
	   
	   @GetMapping("/loginInfo")
	   public String loginInfo(Principal principal) {
		 //Principal = userdetails다 user 이자 empVO이다
		   
		   //1
		   String ename = principal.getName();
		   System.out.println("유저 아이디" + ename);
		   
		 
		   
		   //2
		   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   ename = auth.getName();
		   
		   
		   
		   //3
		   UserDetails userDetails = (UserDetails)auth.getPrincipal();
		   System.out.println(userDetails.getUsername());
		   
		   //4
		   EmpUser empUser = (EmpUser)auth.getPrincipal();
		   System.out.println(empUser.getPassword());
		   
		   
		   //5
		   User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   ename = user.getUsername();
		  
		   System.out.println("유저 아이디 : " + ename);
		   
	        
	      return "home";
	   }   


	}