package tarena.employment;
/**
 * ��λ����Ⱥţ�<<=��>>=��>>>=�����ʹ�á���ʱ����������ߵ�ֵ���ƶ����ұߵ�ֵָ
 * ����λ�����ٽ��õ��Ľ��������ߵı��������ڽ��С��޷��š����ƽ�ϸ�ֵ����ʱ������ ������һ�����⣺ ����� byte �� short
 * ֵ������������λ���㣬�õ��Ŀ��ܲ�����ȷ�Ľ���� ���ǻ��ȱ�ת���� int ���ͣ��ٽ������Ʋ�����Ȼ�󱻽ضϣ���ֵ��ԭ�������ͣ��������� ���¿��ܵõ�-1
 * �Ľ�����������������ʾ�����������
 */
public class URShift {
	public static void main(String[] args) {
		int i = -1;
		System.out.println(i >>>=10	);//4194303
		int  z1 = 4194303;
		int  z = 4194303;
		System.out.println(Integer.toBinaryString(z));
		
		long l =-1;
		System.out.println(i >>>=10);	//4095
		short s =-1;
		System.out.println(s >>>=10);//-1
		byte b = -1;
		System.out.println(b >>>10 );//4194303
		b = -1;
		System.out.println(b>>>10);//4194303
	}
}
