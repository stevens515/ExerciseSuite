package container_sumarize_shiyong;

import java.util.Stack;

/**Stack��
 	Vector�����࣬ģ��ջ
 	�ڼ������������һ�����˰�ť��ÿ�ε�����˶���ص���һ��������ʵ���Ͼ���һ��ջ��Ӧ�ã�
 	���ƵĻ���Office���ߵĳ��������ȣ����ǲ���һ���Ƚ�����Ĳ�����
 */
public class TestStackDemo {
public static void main(String[] args) {
	Stack s = new Stack();
	s.push("java");//����ѹ���ջ����,�״δ�����ջʱ������������
	s.push("C++");
	s.push("VB");
	System.out.println(s);//[java, C++, VB]�����˳��Ϊ��ջ��˳��
	
	//���ʵ�һ��Ԫ�أ����ǲ��õ�һ��Ԫ�س�ջ��pop��
	System.out.println(s.peek());//VB,�鿴��ջ�����Ķ��󣬵����Ӷ�ջ���Ƴ�����
	System.out.println(s);//[java, C++, VB]
	
	//����һ��Ԫ��ѹ��ջ
	System.out.println(s.pop());//VB,�Ƴ���ջ�����Ķ��󣬲���Ϊ�˺�����ֵ���ظö���
	System.out.println(s);//[java, C++]
	
	//���ض����ڶ�ջ�е�λ��
	System.out.println(s.search("java"));//2
	System.out.println(s.search("C++"));//1
}
}
