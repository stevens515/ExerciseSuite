package container_sumarize_shiyong;

import java.util.Hashtable;

/*
 	��֤map�ж�key��Ⱥ�value��ȵı�׼
 */
public class TestHashMapDemo1 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new Count(200), "Java");
		ht.put(new Count(300), "C++");
		ht.put(new Count(100), new L());
		ht.put(new Count(200), "Delphi");
		//��ʾ˳����hashCodeֵ�йأ�������ʾ�������������μ���new Count(200),��
		//����ֻ�ܱ���һ������Ϊ������key�ظ�
		//����ht���Ƿ�����ַ�����VB��
		System.out.print(ht);
	//�������true����ΪL�������κζ���Ƚ϶�����true,����new L()�͡�VB����hashCodeȴ�ǲ�һ����
		System.out.println(ht.containsValue("VB"));//���true
		//ɾ��һ��key-value��
		ht.remove(new Count(300));
		System.out.println(ht);
		//ʹ��key����ht
		for(Object key:ht.keySet()){
			System.out.println(ht.get(key));
		}
	}
}
class Count {
	int count;
	public Count(int count){
		this.count = count;
	}
	public boolean equals(Object o){
		if(o==this){
			return true;
		}
		if(o != this&&o.getClass()==Count.class){
			Count c =(Count)o;
			if(this.count==c.count){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return this.count;
	}
}
class L{
	public boolean equals(Object o){
		return true;
	}
}