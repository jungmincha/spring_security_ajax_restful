package edu.bit.ex.page;

import lombok.ToString;

@ToString
public class Criteria {
   
   //����¡ ó���� ���ؼ��� ��ȣ�� �� �������� �� ���� �����͸� �������� �����ؾ��Ѵ�.
   private int pageNum; //������ ��ȣ
   private int amount; //�� �������� �� ���� �����͸� ������ ���ΰ�?
   
   public Criteria() {
      this(1,10); //�Ķ���Ͱ� 2���� �ڱ��ڽ� ������ ȣ��
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
