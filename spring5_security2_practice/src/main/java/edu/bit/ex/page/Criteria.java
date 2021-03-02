package edu.bit.ex.page;

import lombok.ToString;

@ToString
public class Criteria {
   
   //페이징 처리를 위해서는 번호와 한 페이지당 며 개의 데이터를 보여줄지 결정해야한다.
   private int pageNum; //페이지 번호
   private int amount; //한 페이지당 몇 개의 데이터를 보여줄 것인가?
   
   public Criteria() {
      this(1,10); //파라미터가 2개인 자기자신 생성자 호출
   }
   
   public Criteria(int pageNum, int amount) {
      this.pageNum = pageNum;
      this.amount = amount;
   }

public int getPageNum() {
	return pageNum;
}

public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}
   
  
   
   
}
