package basic.day18.IO;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File�� File���Դ�����ɾ��һ���ļ���Ҳ���Դ�����ɾ��һ����Ŀ¼
 * ע��File���ǲ����ܷ��ʵõ��ļ������ݵģ���
 * isDirectory()��isFile()���������ж���һ���ļ���Ŀ¼��
 * delete()��������ɾ��һ���ļ���Ŀ¼�����Ҫɾ��Ŀ¼��Ŀ¼����Ϊ�ղ���
 * deleteOnExit()�������˷�����������ɾ���ļ���Ŀ¼������Ҫ�ȵ��������н�����
 *					�Ż�ȥɾ���������ڿ�����ʱ�ļ�
 *list()�����������ɴ˳���·��������ʾ��Ŀ¼�е��ļ���Ŀ¼������������ַ�������.
 *		����˳���·��������ʾһ��Ŀ¼����˷���������null
 */
public class TestFileDemo {
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		String path = file.getAbsolutePath();
		System.out.println(path);// /home/soft01/work/JSD1202_2/��ǰ����Ŀ¼

		File f1 = new File("file1.txt");// ����һ��File���󣬴�ʱ�����ϻ�û��file.txt�ļ�
		f1.createNewFile();// ��ʱ�Ż��ڴ����ϴ���һ���ļ�����Ϊfile.txt
		File dir = new File("test/test2/test3");
		// �ڵ�ǰĿ¼�µ�test/test2��Ŀ¼�д���test3��Ŀ¼�����û��test/test2��Ŀ¼�򴴽����ɹ�
		dir.mkdir();
		// �ڵ�ǰĿ¼�£������Ŀ¼test/test2�����ڣ�����ȰѸ�Ŀ¼�����ã��ٽ���Ŀ¼�������Ŀ¼���ڣ���ֱ�Ӵ�����Ŀ¼
		dir.mkdirs();
		File home = new File("/etc");
		String[] list = home.list();
		for(int i=0;i<list.length;i++){
			//���Եõ���Ŀ¼�е����е�Ŀ¼�����ļ�������ʾ���ַ���
		}
	}
}
