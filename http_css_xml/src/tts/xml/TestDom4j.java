package tts.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
		//��DOM4j��APIȥ����books.xml
		
		//����������װ�˶�XML���ݵĽ���
		SAXReader reader = new SAXReader();
		
		//��������ȡ����
		//reader.read(InputStream is);
		FileInputStream fis = new FileInputStream("tts"+File.separator+"xml"+File.separator+"books.xml");
		//��������ȡ����,��ɽ�������
		//����Document���󣬸ö����д�
		//���������XML��������
		Document doc = reader.read(fis);
		
		//����Document��API����Ҫ������
		
		//��ȡ��Ԫ��
		Element root = doc.getRootElement();
		System.out.println(root.getName());
		
		//Element��elements����
		//���ڸ�Ԫ�ص�������Ԫ��
		//����ֵ��Element���͵�List
		List<Element> list = root.elements();
		for(Element e: list){
			System.out.println(e.getName());
			List<Element> list1 = e.elements();
			for(Element e1:list){
				System.out.println(e1.getName());
				System.out.println(e1.getData());//����Ԫ�ص��ļ������������ı�ʱ��
			}
		}
	}
}
