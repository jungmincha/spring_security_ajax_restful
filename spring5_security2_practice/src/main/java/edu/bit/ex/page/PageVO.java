package edu.bit.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;



@Getter
@ToString
public class PageVO {
	   private int startPage; //시작번호
	   private int endPage; //끝번호
	   private boolean prev; //이전
	   private boolean next; //다음
	   private int total; // 전체 글 개수
	   private Criteria cri;
	   
	   public PageVO(Criteria cri, int total) {
	      this.cri = cri;
	      this.total = total; //전체 데이터 수
	      
	      //ex) 현재 페이지가 13이면 13/10 = 1.3 올림 ->2 끝페이지는 2*10 = 20
	      this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
	      //endPage 계산 공식      
	      this.startPage = this.endPage-9;
	      
	      //Total을 통한 endPage의 재계산
	      //10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝번호는 10이 아닌 8이 된다.
	      int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
	      if(realEnd <=this.endPage) {
	         this.endPage = realEnd;
	      }
	      
	      //시작번호가 1보다 큰경우 
	      this.prev = this.startPage >1;
	      
	      //realEnd가 끝번호(endPage)보다 큰 경우에만
	      this.next = this.endPage <realEnd;
	   }
	   
	    public String makeQuery(int page) {
	         UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
	               .queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
	               .build(); // ?pageNum=3&amount=10
	         return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴 
	      }
	   

	   public int getStartPage() {
	      return startPage;
	   }

	   public void setStartPage(int startPage) {
	      this.startPage = startPage;
	   }

	   public int getEndPage() {
	      return endPage;
	   }

	   public void setEndPage(int endPage) {
	      this.endPage = endPage;
	   }

	   public boolean isPrev() {
	      return prev;
	   }

	   public void setPrev(boolean prev) {
	      this.prev = prev;
	   }

	   public boolean isNext() {
	      return next;
	   }

	   public void setNext(boolean next) {
	      this.next = next;
	   }

	   public int getTotal() {
	      return total;
	   }

	   public void setTotal(int total) {
	      this.total = total;
	   }

	   public Criteria getCri() {
	      return cri;
	   }

	   public void setCri(Criteria cri) {
	      this.cri = cri;
	   }   

	}