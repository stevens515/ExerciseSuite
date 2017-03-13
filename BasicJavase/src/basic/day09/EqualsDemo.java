package basic.day09;
/**�ص㡣ģ��*/
public class EqualsDemo {
public static void main(String[] args) {
	Ipad p1 = new Ipad(8);
	Ipad p2 = new Ipad(8);
	//������ȣ�ʹ�ã����Ƚϱ�����ֵ
	//������ȣ�����Ҫ�Ƚ϶���Ĺؼ������Ƿ�һ�����磺ID
	System.out.println(p1==p2);//flase ������ֵ�������õĵ�ֵַ��
	//����ʹ��Object���ṩ��equals�����Ƚ϶����Ƿ����
	System.out.println(p1.equals(p2));
	//Object���ṩ��equalsĬ��ʵ�֣��ǱȽ����ñ�����ֵ��
	//java���鸲��equals�������ṩ����Ķ���ȽϹ���
	
	p2 = null;
	System.out.println(p1.equals(p2));
	p1 = p2;
//	System.out.println(p1.equals(p2));//��ָ���쳣
	
	String s1 = new String("ABC");
	String s2 = new String("ABC");
	String s3 = new String("ABD");
	System.out.println(s1==s2);//false
	System.out.println(s1.equals(s2));//true
	System.out.println(s1.hashCode());//true
	System.out.println(s2.hashCode());//true
	System.out.println(s3.hashCode());//false
}
}
class Ipad{
	int id;//��Ʒ���
	public Ipad(int id){
		this.id=id;
	}
	public boolean equals(Object obj){
		
//		return this.id == obj.id;////java��������ʱ���ȼ������,���Բ�����ôд
		
		/*Ipad pad =(Ipad)obj;
		return this.id == pad.id;//Ҳ������ôд�����������쳣
*/		
		
//		return this.id == ((Ipad)obj).id;//������ôд,����ȷ�������� �����쳣
		
		//ģ��ʽд�����£�
		if(obj==null){//����
			return false;
		}
		if(obj==null){//�����ֵַ���
			return true;
		}
		if(this ==obj){
			return true;
		}
		if(obj instanceof Ipad){//�ȼ���ǲ���Ipad���͵�,�ٽ��бȽ�
			Ipad other = (Ipad)obj;
			return this.id==other.id;
		}
		return false;
		
	}
	//����equals()ͬʱ���븲��hashCode()����
	public int hashCode(){
		return id;
	}
}