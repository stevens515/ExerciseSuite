package container_sumarize_shiyong;

import java.util.HashSet;

/**
 	ע�⣺�����ͬһ���������η���һ��HashSet�У����۸ö�������������ζ���equals������
 		hashCode��������HashSet�ж���ֻ��һ�����󣬶������������
 */
public class TestHashSet {

	/**
	 	HashSet�����д��룬���Է��֣�����A�����Ѿ��ӽ�HashSet,����B����Ҳ���Լӽ�HashSet
	 	��C������һ����û�У�������ΪC�����hashCodeֵ��A������ȣ�����C������κζ���Ƚ϶�����true,
	 	���Ը����Ӳ���ȥ�������C���е�hashCode����ֵ��Ϊ2����ᷢ�ֿ��Լ���һ��C����
	 */
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new A());
		hs.add(new A());
		hs.add(new B());
		hs.add(new B());
		hs.add(new C());
		hs.add(new C());
		System.out.println(hs);
	}

}
class A{			//ֻ��дhashCode����
	public int hashCode(){
		return 1;
	}
}
class B{			//ֻ��дequals����
	public boolean equals(Object o){
		return true;
	}
}
class C{			//��дequals������hashCode����
	public boolean equals(Object o){
		return true;
	}
	public int hashCode(){
		return 1;
	}
}
