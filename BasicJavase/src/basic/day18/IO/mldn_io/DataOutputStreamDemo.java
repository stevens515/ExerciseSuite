package basic.day18.IO.mldn_io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *	������д�뵽�ļ�order.txt�У�
 *���³���ÿ������֮��ʹ�á�\n'�ָ���ÿ��������ÿ������֮��ʹ�á�\t'�ָ���
 *���Դ�DataOutputStreamDemo2.java�ж�ȡorder.txt������
 */
public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = null;	//�����������������
		File f =new File("test"+File.separator+"xiya.txt");//ָ���ļ��ı���·��
		dos = new DataOutputStream(new FileOutputStream(f));//ʵ�����������������
		String names[] = {"����","����","Χ��"};//��Ʒ����
		float prices[] = {98.3f,30.3f,50.5f	};//��Ʒ�۸�
		int nums[] ={3,2,1};//��Ʒ����
		for(int i=0;i<names.length;i++){//ѭ��д��
			dos.writeChars(names[i]);	//д���ַ���
			dos.writeChar('\t');//����ָ���
			dos.writeFloat(prices[i]);//д��С��
			dos.writeChar('\t');//д��ָ���
			dos.writeInt(nums[i]);//д������
			dos.writeChar('\n');//����
		}
		dos.close();//�ر������
	}
}
