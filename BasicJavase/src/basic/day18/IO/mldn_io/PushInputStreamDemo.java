package basic.day18.IO.mldn_io;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**������ 
 *	�ڴ�����һ��"www.mldnjava.cn"�ַ�����ֻҪ�����������"."��ִ�л��˲�����������ȡ"."
 */
public class PushInputStreamDemo {
	public static void main(String[] args) throws Exception {
		String str = "www.mldnjava.cn";//�����ַ���
		PushbackInputStream push =null;//�������������
		ByteArrayInputStream bai = null;//�����ڴ�������
		bai = new ByteArrayInputStream(str.getBytes());//ʵ�����ڴ�������
		push = new PushbackInputStream(bai);//ʵ������������
		System.out.println("��ȡ֮�������Ϊ��");
		int temp = 0;//��������
		while((temp=push.read())!=-1){//��ȡ����
			if(temp=='.'){
				push.unread(temp);//���˵�������ǰ��
				temp=push.read();//�ճ�������
				System.out.println("(�˻�"+(char)temp+")");
			}else{
				System.out.println((char)temp);//�������
			}
		}
	}
}
