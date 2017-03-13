package basic.day10;

/**
 	String = char[] + ����Ĳ���������indexOf,concat..)
 	String API�ص㣺
 		1.String�����ǲ��ɸı�ģ��������ԣ�����ı�char[]����
 			��String�ǲ��ɸı��,String�����ɸı�
 		2.String Ϊ�����Ż���API�������Ż�
 */
public class StringAPIDemo {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 =s1;
		s1  = s1+s2;
		System.out.println(s1);//abcabc
		
		//API������ؽ����ԭ�ַ�����ͬ�����һ�������ַ�������
		//������ؽ����ԭ�ַ�����ͬ��һ����ԭ�ַ��������ܺã�
		String s3 = s1.toUpperCase();
		System.out.println(s3==s1);//false
		String s4 = s1.toLowerCase();
		System.out.println(s4==s1);//true
		
		String name = "tom";
		String login = name.trim();//ȥ���ַ������˵Ŀհ�()
		name = " \t 	\r 	\n Jerry	 \n 	\t ";
		login = name.trim();
		System.out.println(login);//Jerry
		//		    012345678901234567890123456789
		String url="http://www.tarena.com.cn/index.html";
		int index = url.lastIndexOf('/');//24,������һ��������
		System.out.println(index);//24
		index = url.indexOf('/',7);//�ӵ�7��λ�ÿ�ʼ�ң����ڼ�����'/'
		System.out.println(index);//24
		//				01234567890123345
		String email = "295445156@qq.com";
		name = email.substring(0,email.indexOf("@"));//����ǰ�������󣬣�0��11��,ȡ����0����11
		System.out.println(name);//295445156
		String host = email.substring(email.indexOf("@")+1);//�����λ�ÿ�ʼ��������е�
		System.out.println(host);//qq.com
		
		String filename = "tom.png";
		if( filename.endsWith(".png")){
			System.out.println("����PNG��ʽ��Ƭ�ļ���");
		}
//		boolean isPhoto = filename.endsWith(".png");//���飺��..ʲô��β��
//		System.out.println(isPhoto);//true
		
		String filename1 = "jiadongpo";
		if(filename1.startsWith("jia")){
			System.out.println("���ϣ�");
		}
	}

}
