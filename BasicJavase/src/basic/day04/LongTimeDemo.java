package basic.day04;

public class LongTimeDemo {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();//��1970�����ڵĺ�����
		long year = now/1000/60/60/24/365+1970;
		System.out.println(year);//��������
		long max = 0x7fffffffffffffffL;
		long y = max/1000/60/60/24/366+1970;//�þ�����һ�����ݡ�
		System.out.println(y);

	}

}
