package basic.day16;

import java.io.File;
import java.io.FileFilter;

//FileFilter���ǶԲ����ļ��Ĺ��ˣ��൱�����ls|grep pattern
//API������File[] listFile(File Filter)
//�ص�ģʽ��FilerFilter
/**
 * public interface FileFilter���ڳ���·�����Ĺ������� 
 * 
 * �˽ӿڵ�ʵ���ɴ��ݸ� File ��� listFiles(FileFilter) ������
 * 
 * �ӿ� boolean accept(File pathname)
 * 
 * ����ָ������·�����Ƿ�Ӧ�ð�����ĳ��·�����б��С�
 * 
 * ������ pathname - Ҫ���Եĳ���·����
 * 
 * ���أ����ҽ���Ӧ�ð��� pathname ʱ���� true
 * 
 *   �ص�ģʽ    accept()�����ĵ������ڻص�ģʽ
 *   
 * �������г�Ŀ¼/home/soft01/work/JSD1202_2/test�е�.java�ļ�
 */
public class FileFilterDemo {
	public static void main(String[] args) {
		File dir = new File("/home/soft01/work/JSD1202_2/test");
		//����1
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File afile) {
				System.out.println(afile.getName());
				return afile.getName().endsWith(".java") && afile.isFile();
			}
		});

		
	}
}
