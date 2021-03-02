package edu.bit.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;



@Getter
@ToString
public class PageVO {
	   private int startPage; //���۹�ȣ
	   private int endPage; //����ȣ
	   private boolean prev; //����
	   private boolean next; //����
	   private int total; // ��ü �� ����
	   private Criteria cri;
	   
	   public PageVO(Criteria cri, int total) {
	      this.cri = cri;
	      this.total = total; //��ü ������ ��
	      
	      //ex) ���� �������� 13�̸� 13/10 = 1.3 �ø� ->2 ���������� 2*10 = 20
	      this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
	      //endPage ��� ����      
	      this.startPage = this.endPage-9;
	      
	      //Total�� ���� endPage�� ����
	      //10���� �����ִ� ��� ��ü ������ ���� 80����� �����ϸ� ����ȣ�� 10�� �ƴ� 8�� �ȴ�.
	      int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
	      if(realEnd <=this.endPage) {
	         this.endPage = realEnd;
	      }
	      
	      //���۹�ȣ�� 1���� ū��� 
	      this.prev = this.startPage >1;
	      
	      //realEnd�� ����ȣ(endPage)���� ū ��쿡��
	      this.next = this.endPage <realEnd;
	   }
	   
	    public String makeQuery(int page) {
	         UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
	               .queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
	               .build(); // ?pageNum=3&amount=10
	         return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 ���� 
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