package test;
/**ѡ����*/
public class Question {
	
		int id ;//���
		String text;//���
		String[] options={};//ѡ��

		public boolean check(String[] answers){
		return false;
	}
	public void print(){
		System.out.println(id+"."+text);
		for(int i=0;i<options.length;i++){
			System.out.println(""+options[i]);
		}
		System.out.println();
	}
}
