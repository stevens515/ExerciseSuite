package tarena.interview;
/**
 * ��֮������Ҫ��ȷ�𰸵ĵط���Ҫ����ʹ��float��double;���ڻ��Ҽ���Ҫʹ��int
 * long��BigDecimal��
 */
import java.math.BigDecimal;

public class Chage {

	public static void main(String[] args) {
//		System.out.println(2.00-1.10);//0.8999999999999999
		/*
		 * ʹ��BigDecimal������ʮ����������Ϊjava��û��Ϊ���ṩ�κ������ϵ�֧�֡�
		 * Ҫ��ԭʼ���͵ļ���Ҫ��һЩ��BigDecimal(String)������
		 */

		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));

	}

}
