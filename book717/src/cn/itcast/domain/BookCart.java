package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.exception.ServiceException;

/*
 ���ﳵ
 */
public class BookCart {
	private Map<String, BookItem> map = new HashMap<String, BookItem>();

	public Map<String, BookItem> getMap() {
		return map;
	}

	public void setMap(Map<String, BookItem> map) {
		this.map = map;
	}

	/**
	 * �ڹ��ﳵ�������µ��鼮
	 * 
	 * @param bookItem
	 */
	public void addBookItem2BookCart(BookItem bookItem) {
		if (bookItem == null) {
			throw new ServiceException("����Ʒ�����ڣ����ܼ��뵽���ﳵ");
		}
		if (bookItem.getBook() == null) {
			throw new ServiceException("����Ʒ�����ڣ����ܼ��뵽���ﳵ");
		}
		BookItem oldBookItem = map.get(bookItem.getBook().getId());

		// ��map���ϲ����ڸ��鼮
		if (oldBookItem == null) {
			bookItem.setQuantity(1);
			bookItem.setTotalprice(bookItem.getBook().getPrice()*bookItem.getQuantity());
			map.put(bookItem.getBook().getId(), bookItem);
		}else{
			//���ڸ��鼮
			oldBookItem.setQuantity(oldBookItem.getQuantity()+1);
			oldBookItem.setTotalprice(oldBookItem.getBook().getPrice()*oldBookItem.getQuantity());
		}
	}
	/**
	 * �����ܵļ۸�
	 * @return
	 */
	public double getSumprice(){
		if(map!=null&&!map.isEmpty()){
			double sum = 0;
			for(Map.Entry<String, BookItem> em:map.entrySet()){
				BookItem bookItem = em.getValue();
				if(bookItem!=null){
					sum=sum+bookItem.getTotalprice();
				}
			}
			return sum;
		}
		return 0d;
	}
}
