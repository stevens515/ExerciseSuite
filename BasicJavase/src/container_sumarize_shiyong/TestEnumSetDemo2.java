package container_sumarize_shiyong;
import java.util.Collection;
import java.util.HashSet;
import java.util.EnumSet;

/*
 	ö�١����⡣�ַ�����ö�١�
 */
public class TestEnumSetDemo2 {
	public static void main(String[] args) {
	Collection c = new HashSet();
	c.clear();
	c.add(Season.SPRING);
	c.add(Season.SUMMER);
	//��ֵc�е�Ԫ�ص��µ�EnumSet��
	EnumSet es = EnumSet.copyOf(c);//û������
	System.out.println(es);//[SPRING, SUMMER]
	
	c.add("abce");
	EnumSet es1 = EnumSet.copyOf(c);//�׳��쳣����Ϊc�в�ȫΪö��ֵ��
	}
}
