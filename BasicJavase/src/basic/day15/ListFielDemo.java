package basic.day15;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ListFielDemo {
	public static void main(String[] args) {
		// File dir = new File(".");
		File dir = new File("/etc");
		File[] files = dir.listFiles();// ls -a .
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File o1, File o2) {
				// ���ͬʱ��Ŀ¼���ļ��������ļ����Ƚ�
				// File��Ĭ�ϵıȽϷ���compareTo�ǰ����ļ����Ƚϵ�
				if (o1.isDirectory() == o2.isDirectory()) {
					// return o1.compareTo(o2);//�൱�±���䣬���ļ�����
					return o1.getName().compareTo(o2.getName());
				}
				// �����Ŀ¼��һ�����ļ�С������-1
				return o1.isDirectory() ? -1 : 1;
			}
		});// ����,�ڲ���
		// ����2
		for (File file : files) {// java 5�ṩ�ļ򻯰�for������for ..each..
			if (file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");
			} else {
				System.out.println(file.getName());
			}
		}
		// ����1
		// for(int i = 0;i<files.length;i++){
		// File file = files[i];
		// if(file.isDirectory()){
		// System.out.println("["+file.getName()+"]");
		// }else{
		// System.out.println(file.getName());
		// }
		// }
	}
}
