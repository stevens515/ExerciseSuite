package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection {
public static void main(String[] args) {
	Collection c = new ArrayList();
	//���Ԫ��
	c.add("�����");
	//���Զ�װ���ܸ����Ϸ��������������
	c.add(9);
	System.out.println("����C�е�Ԫ�ظ���Ϊ��"+c.size());//2
	//�жϼ������Ƿ����ĳ��Ԫ��
	System.out.println("����C���Ƿ��������գ�"+c.contains("�����"));//����C���Ƿ��������գ�true
	
	c.add("��˽�");
	
	Collection c1 = new HashSet();
	c1.add("��˽�");
	c1.add("ɳ����");
	//�ж�һ���������Ƿ������һ�����ϵ�ȫ��Ԫ��
	System.out.println("C�Ƿ����c1ȫ��Ԫ�أ�"+c.contains(c1));//C�Ƿ����c1ȫ��Ԫ�أ�false
	
	System.out.println("C��"+c);
	System.out.println("C1��"+c1);
	//��C���ϼ�ȥc1�������Ԫ��
	c.remove(c1);
	System.out.println("c��Ԫ��Ϊ��"+c);//c��Ԫ��Ϊ��[�����, 9, ��˽�]
	
	//ɾ��c�����ڵ�ȫ��Ԫ��
	c.clear();
	System.out.println("C��Ԫ��Ϊ��"+c);//C��Ԫ��Ϊ��[]
	c.add("ɳ����");
	System.out.println("c1���ϵ�Ԫ��Ϊ��"+c1);//c1���ϵ�Ԫ��Ϊ��[��˽�, ɳ����]
	//c1������ֻʣ��C������Ҳ������Ԫ��
	c1.retainAll(c);//������ͬ��
	System.out.println("c1���ϵ�Ԫ��Ϊ��"+c1);//c1���ϵ�Ԫ��Ϊ��[ɳ����]

	
	
}
}
