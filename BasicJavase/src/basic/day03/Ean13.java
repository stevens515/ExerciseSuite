package basic.day03;

public class Ean13 {

	/**
	 * ǰʮ��λ��������c1=6+2+5+7+0+9��
	 * ǰʮ��λ��ż����c2=9+5+1+2+1+1.
	 * ���������͡��롱ż���͵���������ӡ�
	 */
	public static void main(String[] args) {
//		String code = "9787561143896";
		String code = "6921168509256";
//		char c = code.charAt(3);
		int c1 = 0;
		int c2 = 0;
		for(int i=0;i<12;i+=2){
			//i=0 2 4 6 8 10
			char c = code.charAt(i);//����λ�õ��ַ�
			int n = c - '0';//'6'-'0'=6
			c1+=n;//�ۼ�ż��λ�����ֺ�
//			c2+=code.charAt(i+1)-'0';//�ۼ�ż��λ�����ֺ�
		}
		int cc = c1+c2*3;
		int check = (10-cc%10)%10;
		System.out.println(check);//4
		System.out.println(check==code.charAt(12)-'0');
		
		
		}
	
	public static String gen(String code12){
		return null;
	}
	public static boolean check(String ean13){
		return false;
	}

}
