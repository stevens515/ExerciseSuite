package container_sumarize_shiyong;

import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
		TreeMap tm = new TreeMap();
		tm.put(new R(3), "java");
		tm.put(new R(-5), "C++");
		tm.put(new R(9), "VB");
		System.out.println(tm);//�Ѿ�����key�Ĵ�С��������
		//���ظ�TreeMap�ĵ�һ��Entry����
		System.out.println(tm.firstEntry());//R����Ϊ��-5=C++
		//����TreeMap�����һ��keyֵ
		System.out.println(tm.lastKey());//R����Ϊ��9
		//���ظ�TreeMap��new R(3)�����Сkeyֵ
		System.out.println(tm.higherKey(new R(3)));//R����Ϊ��9
		//�����컨��
		System.out.println(tm.ceilingKey(new R(3)));//R����Ϊ��3.ע������һ�������
	}
}
class R implements Comparable{
	int count;
	public R(int count){
		this.count=count;
	}
	public String toString(){
		return "R����Ϊ��"+count;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(this!=null && o.getClass()==R.class){
			R r = (R)o;
			if(this.count==r.count){
				return true;
			}
		}
		return false;
	}
	public int compareTo(Object o){
		R r =(R)o;
		if(this.count>r.count){
			return 1;
		}
		else if(this.count<r.count){
			return -1;
		}
		else{
			return 0;
		}
	}
}
