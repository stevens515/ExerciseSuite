package basic.day18.IO.mldn_io;
/**�˵���ʾ��
 *	��Ϊ�˵�������Ҫ���ϵ���ʾ������ʹ��ѭ����ӡ�ķ�ʽ��ÿһ�β�����ɺ󶼻�
 *������ʾ�����еĲ˵������Թ��û�ѡ�� 
 */
public class Menu {
	public Menu(){
		while(true){		
			this.show();		//�����Ƶ��ò˵�����ʾ
		}
	}
	public void show(){
		System.out.println("====Xxxxϵͳ====");
		System.out.println(" [1] �������� ");
		System.out.println(" [2] ɾ������ ");
		System.out.println(" [3] �޸����� ");
		System.out.println(" [4] �鿴���� ");
		System.out.println(" [0] ϵͳ�˳�\n");
		InputData2 input = new InputData2();
		int i = input.getInt("��ѡ��", "��������ȷ��ѡ�");
		switch(i){
		case 1:{
			Operate.add();		//���ò���������Ӳ���
			break;
		}
		case 2:{
			Operate.delete();	//���ò������ɾ������
			break;
		}
		case 3:{
			Operate.update();	//���ò�����ĸ��²���'
			break;
		}
		case 4:{
			Operate.find();	//���ò�����Ĳ鿴����
			break;
		}
		case 0:{
			System.exit(1);	//ϵͳ�˳�
			break;
		}
		default:{
			System.out.println("��ѡ����ȷ�Ĳ�����");
		}
		
		}
	}
}
