package container_sumarize_shiyong;

import java.util.TreeSet;
import java.util.Comparator;

//4,5�еķ�����Ҳ���Թ���TreeSetʱ��ʱ����һ�������ڲ��Ƚ���������
public class TestTreeSetDemo6 {
public static void main(String[] args) {
	//ʹ�������ڲ���ķ�ʽ������һ�������Ƚ���
	TreeSet ts = new TreeSet(new Comparator()
	{
		public int compare(Object o1,Object o2){
			Teacher t1 = (Teacher)o1;
			Teacher t2 = (Teacher)o2;
			if(t1.getHeight()>t2.getHeight()){
				return 1;
			}
			else if(t1.getHeight()<t2.getHeight()){
				return -1;
			}
			else{
				return 0;
			}
		}
	});
	Teacher s1 = new Teacher("�����",500,175);
	Teacher s2 = new Teacher("��˽�",200,180);
	Teacher s3 = new Teacher("ɳ����",150,185);
	Teacher s4 = new Teacher("��ɮ",40,176);
	ts.add(s1);
	ts.add(s2);
	ts.add(s3);
	ts.add(s4);
	System.out.println(ts);//�Զ������������
}
}
