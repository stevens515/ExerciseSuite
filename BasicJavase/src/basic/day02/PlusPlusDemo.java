package basic.day02;

/**��������++ Plus Plus C++/C Plus Plus CPP*/
public class PlusPlusDemo {

	public static void main(String[] args) {
		
		int a = 1;
		a++;
		System.out.println(a);//2
		++a;
		System.out.println(a);//3
		a = 1;
		int b = a++;
		/*
		 * ��++ 
		 * 		1)ȡa��ֵ1��Ϊ��ǰ���ʽa++��ֵ1
		 * 		2����a��ֵ����1��aΪ2
		 * 		3)ִ�и�ֵ���佫���ʽa++��ֵ1 ��ֵ��b ,b Ϊ 1
		 */
		System.out.println("a="+a+",b="+b);//a=2,b=1
		
		a = 1;
		b = ++a;
		/*
		 * ǰ++ 
		 * 		1)�Ƚ�a��ֵ����1��aΪ2
		 * 		2����aֵ2��Ϊ���ʽ++a��ֵ2
		 * 		3)ִ�и�ֵ���㣬��++a��ֵ2����ֵ��b,bΪ2
		 */
		System.out.println("a="+a+",b="+b);//a=2,b=2
		
		a = 1;
		a = a++;
		/*
		 * ��++ 
		 * 		1)ȡa��ֵ1��Ϊ��ǰ���ʽa++��ֵ1
		 * 		2����a��ֵ����1��aΪ2
		 * 		3)ִ�и�ֵ���佫���ʽa++��ֵ1 ��ֵ��b ,b Ϊ 1
		 */
		System.out.println("a="+a);//a=1
		
		
		a = 1;
		a = ++a;
		/*
		 * ǰ++ 
		 * 		1)�Ƚ�a��ֵ����1��aΪ2
		 * 		2����aֵ2��Ϊ���ʽ++a��ֵ2
		 * 		3)ִ�и�ֵ���㣬��++a��ֵ2����ֵ��b,bΪ2
		 */
		System.out.println("a="+a);//a=2
		
		int i = 0;
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2
		System.out.println(i++%3);//0
		System.out.println(i++%3);//1
		System.out.println(i++%3);//2

		String[] names = {"����","����","���ү"};
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//���ү
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//���ү
		System.out.println(names[i++%3]);//���ү
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//����
		System.out.println(names[i++%3]);//���ү

		
	}

}
