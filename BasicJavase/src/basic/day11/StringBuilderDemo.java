package basic.day11;

import java.util.Arrays;

/**
 	StringBuilder�˹���ԭ��
 * */
public class StringBuilderDemo {
public static void main(String[] args) {
	//new StringBuilder()
	char[] chs = new char[5];
	int length=0;//����chs�����е���Ч�ַ�����
	//׷�ӡ���������StringBuilder().append()
	chs[length++]='��';
	chs[length++]='��';
	//׷�ӡ����ڿƼ�",���������������Ҫ�ɱ�����StringBuilder().append()
	chs = Arrays.copyOf(chs, chs.length*2);
	chs[length++]='��';
	chs[length++]='��';
	chs[length++]='��';
	chs[length++]='��';
	//���롰�й����ڱ���֮ǰ,�ƶ����������ڿƼ�insert()
	chs[7] = chs[5];//�ƶ�������
	chs[6] = chs[4];
	chs[5] = chs[3];
	chs[4] = chs[2];
	chs[3] = chs[1];
	chs[2] = chs[0];
	chs[0]='��';
	chs[1]='��';
	length+=2;
	//�����(StringBuilder toString())
	System.out.println(Arrays.copyOf(chs, length));
	
	//String  char[] + ����
	//String �ǲ�����ַ�����char[]�������ݲ��ɱ䣬�κβ���
	//һ�������ԭ�ַ������ݲ�ͬ���͸���char[]�����µ��ַ�������
	//ԭString���󲻱�(char[]����������Զ���䣡)
	//StringӦ�ã����������ݽ������������
	
	//StringBuilder=char[]+���������ݵĲ���
	//StringBuilder�ǲ������㷨ά����char����,��Ҫʱ������
	//StringBuilder�Ƕ�ͬһ��char�������ݽ���ά���������ݿɱ���ַ���
	//StringBuilderӦ���ڣ��ַ������ݵļ��㣨��ɾ�Ĳ飩
	
	//��˵��StringBuilder�ģ��������������ܺ���String
	
	//�����У�Ϊ�ˡ�׷���¡����ַ�����������ʹ�ã�char[]+�㷨
	//			���ġ��ַ������㡰ʹ��:StringBuilder
	//			Stringʹ���ڴ�����ĳ���
	StringBuilder buf = new StringBuilder();
	buf.append("����");
	buf.append("���ڿƼ�");
	buf.insert(0, "�й�");
	System.out.println(buf.toString());
	}
}
