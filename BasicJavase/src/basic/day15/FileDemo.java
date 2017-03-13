package basic.day15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		//new File(".")���ڴ��д���һ�����󣬲��������ļ�ϵͳ�ϴ���Ŀ¼���ļ�
		File dir = new File(".");
		//getCanonicalPath()��ȡ��׼�ľ���·����
		String pathname = dir.getCanonicalPath();
		// ��eclipse�У���ǰĿ¼�ǡ���Ŀ�ļ��С�
		System.out.println(pathname);//pwd
		
		//���ڴ��д���һ��File���󣬲��������ļ�ϵͳ�ϴ���Ŀ¼���ļ�
		File demo = new File(dir,"demo");//��һ��parameter�Ǹ�Ŀ¼���ڶ���parameter����Ŀ¼
		File file = new File(demo,"file.dat");//demo���и���Ŀ¼file.dat
		//��������File API����������ļ���Ŀ¼�Ƿ���� 
		System.out.println(demo.exists());//exists�൱��ls .|grep demo����
		if(!demo.exists()){
			demo.mkdir();//���ļ�ϵͳ�����ļ���,�൱������mkdir demo
		}
		System.out.println(demo.exists());//true
		if(!file.exists()){
			file.createNewFile();//���ļ�ϵͳ�����µĿհ��ļ���
		}
		long create = demo.lastModified();//���༭ʱ��
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(demo.isFile());//false
		System.out.println(demo.isDirectory());//true
		System.out.println(demo.canRead());//true
		System.out.println(demo.canWrite());//true
		System.out.println(demo.isHidden());//false
		System.out.println(demo.length());//�ļ�����long,4k
		System.out.println(demo.getName());//�ļ���
		System.out.println(demo.getParent());//..��Ŀ¼
		System.out.println(demo.getCanonicalPath());//.������·�����淶·������������"."
		file.delete();//rm,deleteֻ��ɾ���ļ��У����Բ��ܺ�����ķ�����д
		demo.delete();//rm
	}
}
