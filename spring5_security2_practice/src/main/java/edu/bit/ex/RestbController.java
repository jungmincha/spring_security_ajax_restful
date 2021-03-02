package edu.bit.ex;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/restful/*")
public class RestbController {
	
	private BoardService service;
	
	@GetMapping("/board")
	public ModelAndView getList(ModelAndView mv , Criteria criteria ){
		
		log.info("getList...");
		
		mv.setViewName("rest_list");
		mv.addObject("list", service.getList(criteria));
		
		int total = service.getTotal(criteria);
		log.info("total" + total);
		
		mv.addObject("pageMaker",  new PageVO(criteria, total));
		
		return mv;
		
	}
	
	
	@GetMapping("/board/{bId}")
	public ModelAndView rest_content_view(ModelAndView mv, BoardVO boardVO) {
		
		log.info("rest_content_view...");
		
		mv.setViewName("rest_content_view");
		mv.addObject("content_view", service.rest_content_view(boardVO.getbId()));
		
		return mv;
		
	}
	
	

	  @GetMapping("/board/rest_write_view")
	  public ModelAndView rest_write_view(ModelAndView mv) {
	  
	  log.info("rest_write_view...");
	  
	  mv.setViewName("rest_write_view");
	  
	 
	  return mv;
	 }
	
	
	
	@GetMapping("/rest/board/{bId}")
	public ModelAndView rest_reply_view(ModelAndView mv, BoardVO boardVO) {
		
		log.info("rest_reply_view...");
		
		mv.setViewName("rest/rest_reply_view");
		mv.addObject("reply_view", service.rest_reply_view(boardVO.getbId()));
		
		return mv;
		
	}
	
	// Reply
	   @PostMapping("/board/{bId}")
	   public ResponseEntity<String> rest_reply(@RequestBody BoardVO boardVO, ModelAndView modelAndView) {

	      ResponseEntity<String> entity = null;

	      log.info("rest_reply..");
	      try {
	         
	         int rn = service.rest_reply(boardVO);
	         log.info("insert 넘어온 숫자:::::" + rn);
	         entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }
	      
	      return entity;
	   
	   }  
	   
	 //write
	
		
		  @PostMapping("/rest_write_view") public
		  ResponseEntity<String>rest_write(@RequestBody BoardVO boardVO, ModelAndView
		  modelAndView) {
		  
		  ResponseEntity<String> entity = null;
		  
		  log.info("rest_write.."); try {
		  
		  int rn = service.rest_write(boardVO); log.info("insert 넘어온 숫자:::::" + rn);
		  entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		  
		  } catch (Exception e) { e.printStackTrace(); entity = new
		  ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); }
		  
		  return entity;
		  
		  }
		 
	 	
	
	
	
	
	
	
	//4.delete 하게 해주는 거
	   @DeleteMapping("/board/{bId}")
	   public ResponseEntity<String> remove(BoardVO boardVO,Model model) {
	      ResponseEntity<String> entity = null;
	      log.info("rest_delete..");
	      try {
	         service.remove(boardVO.getbId());
	            // 삭제가 성공하면 성공 상태메시지 저장
	            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // 댓글 삭제가 실패하면 실패 상태메시지 저장
	            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	        // 삭제 처리 HTTP 상태 메시지 리턴
	        return entity;

	   }  
	   
	 //put 구현 , 수현
	   @PutMapping("/board/{bId}")
	   public ResponseEntity<String> rest_Modify(@RequestBody BoardVO boardVO, ModelAndView modelAndView) {

	      ResponseEntity<String> entity = null;

	      log.info("rest_update..");
	      try {
	         
	         int rn = service.rest_Modify(boardVO);
	         log.info("update 넘어온 숫자:::::" + rn);
	         entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }
	      
	      return entity;
	   
	   }  
	
	

}
