package tarena.employment;

//��������������Ҳ�ʾ�����Ӧ���漰����λ�����������в�������
//Using the bitwise operators.
import java.util.Random;

public class BitManipulation {
	// static Test monitor = new Test();
	public static void main(String[] args) {
		
		/**
		 * �ַ��������Ż��������������Ż�
		 */
		String s1 = "ab";
		String s2 = "cd";
		String s3 = s1+"cd";
		String s4 = "abcd";
		String tt1 = "ab"+"cd";
		String tt = s1+s2;
		System.out.println(tt==s4);//false
		System.out.println(tt1==s4);//true
		System.out.println(s3==s4);//false
		s3 = "ab"+"cd";
		System.out.println(s3 ==s4);//true
		
		//new�����Ķ����ڶ��￪��һ���ռ䣬ͬʱ�ַ����Ǿ�̬�ģ�����Ҫ�ڳ��￪��һ���ռ䡣
		String s5 = new String("java");
		String s6 = "java";
		System.out.println(s5==s6);//false
		
		String s7 = new String("java");
		String s8 = new String("java");
		System.out.println(s7==s8);//false
		
		Random rand = new Random();
		int i = rand.nextInt();
		int j = rand.nextInt();
		printBinaryInt("-1", -1);
		printBinaryInt("+1", +1);
		int maxpos = 2147483647;
		printBinaryInt("maxpos", maxpos);
		int maxneg = -2147483648;
		printBinaryInt("maxneg", maxneg);
		printBinaryInt("i", i);
		printBinaryInt("~i", ~i);
		printBinaryInt("-i", -i);
		printBinaryInt("j", j);
		printBinaryInt("i & j", i & j);
		printBinaryInt("i | j", i | j);
		printBinaryInt("i ^ j", i ^ j);
		printBinaryInt("i << 5", i << 5);
		printBinaryInt("i >> 5", i >> 5);
		printBinaryInt("(~i) >> 5", (~i) >> 5);
		printBinaryInt("i >>> 5", i >>> 5);
		printBinaryInt("(~i) >>> 5", (~i) >>> 5);
		long l = rand.nextLong();
		long m = rand.nextLong();
		printBinaryLong("-1L", -1L);
		printBinaryLong("+1L", +1L);
		long ll = 9223372036854775807L;
		printBinaryLong("maxpos", ll);
		long lln = -9223372036854775808L;
		printBinaryLong("maxneg", lln);
		printBinaryLong("l", l);
		printBinaryLong("~l", ~l);
		printBinaryLong("-l", -l);
		printBinaryLong("m", m);
		printBinaryLong("l & m", l & m);
		printBinaryLong("l | m", l | m);
		printBinaryLong("l ^ m", l ^ m);
		printBinaryLong("l << 5", l << 5);
		printBinaryLong("l >> 5", l >> 5);
		printBinaryLong("(~l) >> 5", (~l) >> 5);
		printBinaryLong("l >>> 5", l >>> 5);
		printBinaryLong("(~l) >>> 5", (~l) >>> 5);
		// monitor.expect("BitManipulation.out");
		System.out.println("BitManipulation.out");
	}

	static void printBinaryInt(String s, int i) {
		System.out.println(s + ", int: " + i + ", binary: ");
		System.out.print(" ");
		for (int j = 31; j >= 0; j--)
			if (((1 << j) & i) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}

	static void printBinaryLong(String s, long l) {
		System.out.println(s + ", long: " + l + ", binary: ");
		System.out.print(" ");
		for (int i = 63; i >= 0; i--)
			if (((1L << i) & l) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}
}

/**
 * 
 * ����ĩβ�������������������Ƿֱ����printBinaryInt()�� printBinaryLong()�� һ�� int �� long
 * ֵ�Ĳ��������ö����Ƹ�ʽ�����ͬʱ���м�Ҫ��˵�����֡��������ʱ�������Ǿ��������ʵ�ֵġ�
 * 
 * ��ע���������� System.out.print()�������� System.out.println()��print()�������Զ����У���
 * ����������ͬһ������������Ϣ�� ����������У�expect() ��һ���ļ��������������������ļ��ж�ȡԤ�ڵ��У����� �����У�Ҳ����û��������ʽ��
 * ��������Щ̫������������������������������������
 * �á�����ļ�����չ���ǡ�.out�������������Ĵ����һ���֣����Դ�www.BruceEckel.com��
 * �ء��������Ȥ�Ļ������Դ�����ļ���������ȷ�����Ӧ����ʲô���������Լ�ֱ���� ��һ��ǰ��������� �� ���������չʾ�˶� int �� long
 * �����а�λ�����Ч������չʾ�� int �� long ����Сֵ���� ��ֵ��+1 ��-1
 * ֵ���Լ����ǵĶ�������ʽ����ʹ����˽������ڻ����еľ�����ʽ��ע�⣬ ���λ��ʾ���ţ�0 Ϊ����1 Ϊ���������г������й��� int ���ֵ������ -1,
 * int: -1, binary: 11111111111111111111111111111111 +1, int: 1, binary:
 * 00000000000000000000000000000001 maxpos, int: 2147483647, binary:
 * 01111111111111111111111111111111 maxneg, int: -2147483648, binary:
 * 10000000000000000000000000000000 i, int: 59081716, binary:
 * 00000011100001011000001111110100 ~i, int: -59081717, binary:
 * 11111100011110100111110000001011 -i, int: -59081716, binary:
 * 11111100011110100111110000001100 j, int: 198850956, binary:
 * 00001011110110100011100110001100 i & j, int: 58720644, binary:
 * 00000011100000000000000110000100 i | j, int: 199212028, binary:
 * 00001011110111111011101111111100 i ^ j, int: 140491384, binary:
 * 00001000010111111011101001111000 i << 5, int: 1890614912, binary:
 * 01110000101100000111111010000000 i >> 5, int: 1846303, binary:
 * 00000000000111000010110000011111 (~i) >> 5, int: -1846304, binary:
 * 11111111111000111101001111100000 i >>> 5, int: 1846303, binary:
 * 00000000000111000010110000011111 (~i) >>> 5, int: 132371424, binary:
 * 00000111111000111101001111100000 ���ֵĶ����Ʊ�ʾ��ʽ����Ϊ���з��ŵ� 2 �Ĳ��롱��
 * 
 * 
 */

/*
 * 
 * ��λ��������shift operator�� ��λ�������������������Ҳ�Ƕ����Ƶġ�λ������������ֻ���Ա����������������ͣ����� ���͵�һ�֣�
 * ������λ��������<<���ܽ���������ߵ�������������ƶ��������Ҳ�ָ���� λ�����ڵ�λ��
 * 0�������з��š�����λ��������>>���򽫲�������ߵ�������������ƶ���
 * �����Ҳ�ָ����λ�������з��š�����λ������ʹ���ˡ�������չ����������Ϊ�������ڸ�λ�� �� 0��������Ϊ�������ڸ�λ���� 1��Java
 * ��������һ�֡��޷��š�����λ��������>>>�� ���� ʹ���ˡ�����չ�����������������ڸ�λ���� 0����һ�������� C �� C++û�еġ�
 * 
 * ����� char��byte ���� short ���͵���ֵ������λ������ô����λ����֮ǰ�����ǻ��Զ� ת��Ϊ int�����ҵõ��Ľ��Ҳ��һ�� int
 * ���͵�ֵ�����Ҳ����������Ϊ������λ��λ���� ֻ��������Ʊ�ʾ�еĵ� 5 λ�����á������ɷ�ֹ������λ���� int ��ֵ�����е�λ���� ���� ע����Ϊ 2
 * �� 5 �η�Ϊ 32���� int ��ֵֻ�� 32 λ��������һ�� long ���͵���ֵ���д��� ���õ��Ľ��Ҳ�� long����ʱֻ���õ��Ҳ�������ĵ�
 * 6 λ���Է�ֹ��λ���� long ���� ֵ���е�λ����
 * 
 * ��λ����Ⱥţ�<<=��>>=��>>>=�����ʹ�á���ʱ����������ߵ�ֵ���ƶ����ұߵ�ֵָ
 * ����λ�����ٽ��õ��Ľ��������ߵı��������ڽ��С��޷��š����ƽ�ϸ�ֵ����ʱ������ ������һ�����⣺ ����� byte �� short
 * ֵ������������λ���㣬�õ��Ŀ��ܲ�����ȷ�Ľ���� ���ǻ��ȱ�ת���� int ���ͣ��ٽ������Ʋ�����Ȼ�󱻽ضϣ���ֵ��ԭ�������ͣ��������� ���¿��ܵõ�-1
 * �Ľ�����������������ʾ�����������
 * 
 */

