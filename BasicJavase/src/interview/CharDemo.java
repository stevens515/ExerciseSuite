package interview;

public class CharDemo {

	/**
	 * ȡС����֮ǰ����
	 */
	public static void main(String[] args) {
		/**
		String temp = String.valueOf("���ֻ��ַ���");//��������С�����String���͵�temp
		int index = temp.indexOf("   .   ");//���������ʼ�����ڼ�λ���ҵ�С���㣬�ڼ�λ
		temp = temp.substring(0,"(index)+��");//Ȼ��Ѵ�0λ����nλ������ֵ��temp
		 */
		String temp = String.valueOf("15145dfaf.15fvgdsag");//��������С�����String���͵�temp
		int index = temp.indexOf(".");//���������ʼ�����ڼ�λ���ҵ�С���㣬�ڼ�λ
		temp = temp.substring(0,index);//Ȼ��Ѵ�0λ����nλ������ֵ��temp
		System.out.println(temp);

	}

}
