package container_sumarize_shiyong;

import java.util.HashMap;
import java.util.Hashtable;

/**HashMapo���Hashtable��
 	��null����map,���ԡ�Hashtable���ܼӿ�Ԫ��
 */
public class TestHashMap {
public static void main(String[] args) {
	HashMap hm = new HashMap();
	//��ͼ������keyΪnull�ļ�ֵ�Է��뼯��
	hm.put(null, null);
	hm.put(null, null);//û�з���ɹ�
	System.out.println(hm.size());//1
	hm.put("a", null);
	System.out.print(hm);//{null=null, a=null}
	
	Hashtable ht = new Hashtable();
	ht.put(null, null);//������ָ���쳣
	System.out.println(ht);
}
}
