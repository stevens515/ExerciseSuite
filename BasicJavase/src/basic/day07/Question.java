package basic.day07;

/**ѡ���⣬�����Ǽ̳еĸ����ͣ�Ҫ�����������ͣ���ѡ��Ͷ�ѡ��
 *	A. �̳���������Ȼ�߼�ϵͳ�еķ����ϵ 
 *	B.������������������Ĺ������������ԣ�����Ϊ������������
 *	C.������Լ̳и����͵Ŀ��Լ̳е����Ժͷ�����
 *	D.�̳п���ʵ�ִ���ĸ��ã�����),������Բ����ٶ�����
 *	E.��������������е����Ժͷ���������������ػ������廯�����⻯��
 *	F.������Ը��ǣ���д�������͵Ĺ��ܣ�ʵ�ֶ�̬��Ϊ
 *		�磺��������죩�����޸��˸����ͣ����ࣩ�������Ϊ����̬��
 */
public class Question {
	String title;//���
	String[] options;//ѡ��
	public void print(/*Question this*/){//��ӡ��
		System.out.println(title);//this.title
		for(int i=0;i<options.length;i++){//this.options.length
			String option = options[i];
			System.out.println("\t"+option);
		}
		System.out.println();
	}
	public boolean check(char[] answers){//����û���
		return false;
	}
}
