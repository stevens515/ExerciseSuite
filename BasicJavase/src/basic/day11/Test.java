package basic.day11;

/**String�ģ�intern()����
	����ѭ���¹��򣺶������������ַ��� s �� t�����ҽ��� s.equals(t) Ϊ true ʱ��
	s.intern() == t.intern() ��Ϊ true�� 
	һ���ַ�������������ַ�����ͬ����һ��ȡ�Ծ���Ψһ�ַ����ĳء�
	���ֹ���С��ַ��������������ڼ�鵱ǰ�ַ����Ƿ�Ωһ��Ҳ��ʡ�ڴ档
*/
public class Test {
public static void main(String[] args) {
	String st = "Welcom to ";
	System.out.println(st.charAt(2));//����ָ��λ�õ��ַ���
	String st1 = "beijing";
	System.out.println(st.concat(st1));//���������ַ���
	System.out.println(st1.substring(4));//�ӵڼ���λ����ȡ�ַ���
	System.out.println(st1.substring(2,4));//�ӵڶ�����ȡ�����ĸ��ַ���
	String st2 = null ;//String����ֵ�Ļ��������������null����Ȼʹ��ʱ����
	if(st2==null){//�����������String�����Ƿ�ָ����ĳֵ
		System.out.println("st1 does not refer to anything!");
	}
	
	String string1 = "Too many ";
	String string2 = "cooks";
	String string3 = "Too many cooks";
	string1+=string2;
	string1=string1.intern();
	System.out.println(string1);//Too manycooks

	System.out.println(string1==string3);//true
}
}
