package basic.day15;

import java.io.File;
import java.io.FileFilter;

public class ListFileDemo2 {
	public static void main(String[] args) {
		// ls /etc
		// ls /etc | grep pass
		File etc = new File("/etc");// new File("c:/window");
		// ����3,�������ı䣬ֻ�����ļ���
		File[] files = etc.listFiles(new FileFilter() {
			public boolean accept(File file) {
				System.out.println("���ڹ��ˣ�" + file.getName());
				boolean accept = file.getName().matches(".*pass.*")
						&& file.isFile();// �������ļ�
				if (accept)
					System.out.println("�������ļ�" + file.getName());
				else
					System.out.println("���˵���" + file.getName());
				return accept;
			}
		});
		//		
		// // ����2��������
		// File[] files = etc.listFiles(new FileFilter() {
		// public boolean accept(File file) {
		// System.out.println("���ڹ��ˣ�" + file.getName());
		// return file.getName().matches(".*pass.*");//�ĳ����£�
		//
		// }
		// });

		// listFiles(filter)�����ὫetcĿ¼�е�ÿ���ļ�(Ŀ¼)����filter.accept(file)���й��ˣ�
		// ��������������true������ļ��ͱ�������������Ϊ���ؽ����
		// filter.accept(file)�����Ǳ�listFiles(filter)�������õġ�accept(file)�����Ĳ���file
		// �ᶯ̬�󶨵�ÿ��etc�ļ����е��ļ���Ŀ¼��

		// ����1
		// FileFilter filter = new FileFilter(){
		// public boolean accept(File file) {
		// System.out.println("���ڹ��ˣ�"+file.getName());
		// return file.getName().matches(".*pass.*");
		// }};//�ڲ��࣬�����������˽��
		// File[] files = etc.listFiles(filter);

		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}
/**
 * 
 * boolean accept = file.getName().matches(".*pass.*")&&file.isFile();//�������ļ�
 * if(accept) System.out.println("�������ļ�"+file.getName()); else
 * System.out.println("���˵���"+file.getName());
 */
