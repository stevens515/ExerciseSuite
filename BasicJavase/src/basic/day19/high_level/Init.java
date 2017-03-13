package basic.day19.high_level;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**��������ļ��Ĺ���ģʽ
 * ͨ�������ļ�����ʽ������Ҫ��������Ϣ
 * ������Ҫ������ȡ�������ļ���������Ϣ����������ļ������ڣ��򴴽�һ���µģ�������Ĭ��ֵ
 */
class Init {		//�����ʼ��������
	public static Properties getPro(){
		Properties pro = new Properties();//ʵ����������
		File f = new File("basic.day19.high_level.fruit.properties");
		try{
			if(f.exists()){//�����ļ� ���Ѵ���
				pro.load(new FileInputStream(f));//��ȡ����
			}else{//����һ���µ������ļ���ͬʱ���ú�Ĭ������
				pro.setProperty("apple", "basic.day19.high_level.factorydemo02.Apple");
				pro.setProperty("orange", "basic.day19.high_level.factorydemo02.Orange");
				pro.store(new FileOutputStream(f), "FRUIT CLASS");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pro;
	}
}
