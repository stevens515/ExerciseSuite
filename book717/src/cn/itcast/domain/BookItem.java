package cn.itcast.domain;
/**
 * Ҫ�����ͼ����ϸĿ¼
 *  ���ﳵ���ͼ�����ϸ��Ŀ
 */
public class BookItem {
	private Book book;
	private int quantity;//����
	private double totalprice;//�ܼ۸�
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
