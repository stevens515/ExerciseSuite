package annotation;
/**
 *	@SuppressWarningsע�͵���Ҫ����������ѹ�ƾ��档
 *	�磺֮ǰ���ⷺ��ʱ�����һ����ʱû��ָ�����ͣ���϶��ڱ���ʱ��������ô�Ϳ���ѹ�ơ�
 *	@SuppressWarnings�е�unchecked����ʾ���ǲ���飬�����Ҫѹ�Ƹ���ľ�����Ϣ��
 *	������ں�����������ַ�����ֻ��������ʱ��Ҫ��������ĸ�ʽ���ӡ�
 *	�ؼ��֣�deprecationʹ���˲���ʹ�õ���򷽷�ʱ�ľ���
 *		  uncheckedִ����δ����ת��ʱ���棬���磬���Ͳ�����û��ָ����������
 *		fallthrough��ʹ��switch����ʱcase��δ����break�����������µġ�
 *		path��������һ���������·����Դ�ļ�·��ʱ����
 *		serial���ڿ����л�������ȱ��serialVersionUID����ʱ�ľ���
 *		all�����������е�����ľ���
 */
public class DeprecatedAnnotationDemo3 {
	@SuppressWarnings("unchecked")		//ѹ���������ľ�����Ϣ
	public static void main(String[] args) {
		Demo3 d = new Demo3();	//����ʱ�������־�����Ϣ������ʱ���汻ѹ��
		d.setVar("�ֶ���");
		System.out.println("���ݣ�"+d.getVar());//���
	}
}
class Demo3<T>{		//����Demo�࣬ʹ�÷��� 
	private T var;	//���巺�ͱ���
	public T getVar(){//ȡ�÷��ͱ���������
		return var;
	}
	public void setVar(T var){
		this.var = var;
	}
}