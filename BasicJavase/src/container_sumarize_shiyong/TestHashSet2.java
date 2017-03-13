package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.Iterator;

/**	���ʣ���
 	���⣺�����޷���ȷ�ķ��ʵ�countΪ5��Ԫ�ء�������Ϊ�տ�ʼ��
 		��HashSet��ʱ������hashCode��ֵΪ����λ�õģ�����count
 		ֵ�޸���֮��λ����Ȼ��ԭ����count
 */
public class TestHashSet2 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new D(3));
		hs.add(new D(5));
		hs.add(new D(9));
		hs.add(new D(-1));
		System.out.println(hs);//���ظ�
		
		Iterator it = hs.iterator();//[D:3, D:5, D:9, D:-1]
		D first = (D)it.next();
		//Ϊ��һ��Ԫ�ص�count���Ը�ֵ
		first.count = 5;
		System.out.println(hs);//���ظ�,[D:5, D:5, D:9, D:-1]
		
		hs.remove(new D(5));//ɾ��һ��countΪ5��D����Ԫ��
		System.out.println(hs);//ȷʵɾ����һ��,[D:5, D:9, D:-1]
		//��һ�䷵��false
		System.out.println("hs�Ƿ����һ��countΪ3��Ԫ�أ�"+hs.contains(new D(3)));//false
		//��һ��Ҳ����false,��ͳ������⣬�޷����ʵ���һ��Ԫ����
		System.out.println("hs�Ƿ����һ��countΪ5��Ԫ�أ�"+hs.contains(new D(5)));//false
	}

}
class D{
	int count;
	public D(int count){
		this.count = count;
	}
	public String toString(){
		return "D:"+count;
	}
	public boolean equals(Object o){
		if(o instanceof D){
			D d = (D)o;
			if(d.count == this.count){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return this.count;
	}
}