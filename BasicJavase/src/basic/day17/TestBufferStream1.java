package basic.day17;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//������Ҫ���׽ӡ�����Ӧ�Ľڵ���֮�ϣ��Զ�д�������ṩ�˻���Ĺ��ܣ�����˶�д��Ч�ʣ�ͬʱ������һЩ�µķ���
//����������֧���丸���mark��reset����

//BufferedReader(Reader in)
//BufferedReader(Reader in,int sz)//szΪ�Զ��建�����Ĵ�С 
//BufferedWriter(Writer out)
//BuffereWriter(Writer out,int sz)
//BufferedInputStream(InputStream in)
//BufferedInputStrame(InputStream in,int size)
//BufferedOutputStream(OutputStream out)
//BufferedOutputStream(OutputStream out,int size)

//BufferedReader�ṩ��readLine�������ڶ�ȡһ���ַ�������\r��\n�ָ���
//BufferedWriter�ṩ��newLine����д��һ���зָ���
//��������Ļ�������д�������ݻ��ȷ����ڴ��л��棬ʹ��flush��������ʹ�ڴ��е���������д��
public class TestBufferStream1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test/xiya.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(100);//�ڴ��������б�ǵ�ǰ��λ�á�
			for(int i=0;i<=10&&(c=bis.read())!=-1;i++){
				System.out.println(c+" ");
			}
			System.out.println();
			bis.reset();//���������¶�λ�����һ�ζԴ����������� mark ����ʱ��λ��
			for(int i=0;i<=10&&(c=bis.read())!=-1;i++){
				System.out.println(c+"");
			}
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
