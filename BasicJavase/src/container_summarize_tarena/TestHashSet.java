package container_summarize_tarena;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**ע
 *	"abc"����֮���Բ��ܴ������������ΪString���Ѿ���д��hashCode()
 *	������equals()����
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("abc");
		set.add("bdef");
		set.add("abc");//ע���������Ḳ��֮ǰ��"abc"
		//.....
		print(set);
	}
	public static void print(Set set){
		Iterator it=set.iterator();
		while(it.hasNext()){
			Object o=it.next();
			System.out.println(o);
		}
	}
}
