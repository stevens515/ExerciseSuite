package tarena.employment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
  ����Ƚ���������equals��ȵĻ����������ǵ�hascode��ȡ���������ͬһ���ط���
��һ�����󱻴����hashSet�������Ժ󣬾Ͳ����޸���������е���Щ��������ϣ����ֶ��ˣ����򣬶����޸ĺ�Ĺ�ϣֵ��
����洢��hashSet�����ǵĹ�ϣֵ�Ͳ�ͬ�ˣ�����������£���ʹ��contains����ʹ�øö���ĵ�ǰ������Ϊ�Ĳ���ȥHashSet�м�������
Ҳ�������Ҳ�������Ľ������Ҳ�ᵼ���޷���HashSet�����е���ɾ����ǰ���󣬴Ӷ�����ڴ�й¶��
 */
public class ReflectTest {
	//�����arraylist����Ϊarrarylist����������ã�����˳��ļ��ϣ�����˳�򣩣�һ�����������м������õ�ַ�ڼ�����
	//arraylist�Ⱥ�����Դη��룬����˵�Ƚ�˳�����С���ߵ�ʲô�ģ�����ָλ��˳����˳��ķš�
	public static void main(String[] args) throws Exception{
		
		/**
		 	pt1��pt3��equals����ȵģ�==�ǲ��ȵģ�hashCodeҲ�ǲ��ȵģ�ֻ����д��hashCode()����
			(�������д������Ͳ�һ���ˣ�hascode�Ǹ��������ģ�
			ͬ���ض��������ڲ�һ�����еĻ����Ŀ�����ͬ�����ܲ�ͬ)��size()����2����
			����д���size()Ϊ3.
		*/
//		Collection collections = new ArrayList();
		Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3,3);
		ReflectPoint pt2 = new ReflectPoint(5,5);
		ReflectPoint pt3 = new ReflectPoint(3,3);	

		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);	
		
//		pt1.y = 7;		
		collections.remove(pt1);
		
		System.out.println(collections.size());
	}

}
/**���������
 	1.ReflectPointû����дhashCode():
 		a.�ڣ�
 		Collection collections = new HashSet();
 		//pt1.y = 7;		
		//collections.remove(pt1);
		���ʱ���collections.size()Ϊ��3
		b.��
		Collection collections = new HashSet();
		pt1.y = 7;		
		collections.remove(pt1);
		���ʱ���collections.size()Ϊ��2
	1.ReflectPoint��дhashCode():
		a.��:
		Collection collections = new HashSet();
 		//pt1.y = 7;		
		//collections.remove(pt1);
		���ʱ���collections.size()Ϊ��2
		b.��:
		Collection collections = new HashSet();
 		pt1.y = 7;		
		collections.remove(pt1);
	 	���ʱ���collections.size()Ϊ��2
	 	c.��:
		Collection collections = new HashSet();
 		//pt1.y = 7;		
		collections.remove(pt1);
	 	���ʱ���collections.size()Ϊ��1
	 �ۺ����ϣ���b������ı�pty1.y=7�Ļ���remove(pt1)֮���sizeֵΪ2
	 		�����ı�pty1.y=7�Ļ���remove(pt1)֮���size��ֵΪ1.���
	 		˵���ı�pt1.yֵ�󣬸�����û������ɾ����pt1�����ı���hashCode
	 		ֵ���洢�ڲ�ͬ�ĵط��ˡ�
 */

/**hashSet
	1.�ȱȽ���û������������û�оͷţ�����оͲ��ţ������滻����
	2.���hashCode���У���������ţ��Ǿ�Ҫ��ɾ��hashCode��ģ��ٷ��µġ�
*/

/**
	Ĭ��hashCode�Ƚϵ��ǹ�ϣֵ��hashCodeֵͨ������Ĭ�����ڴ��ַ��������ġ�
	�������ڴ��ַ�Ƿ���ȣ����ͬһ����Ķ�������������ȵĻ�������Ҫ��дhashCode()�ˡ�
*/

/**
  
	import java.util.Date;

public class ReflectPoint {
	private int x;
	public int y;
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ReflectPoint other = (ReflectPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
		public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}

 */
