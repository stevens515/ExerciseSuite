package basic.day07.practice;

public class PrintStar {

	/**
	15������Ļ�ϴ�ӡ��n�еĽ�����ͼ�����磬��n=5,��ͼ�����£�
		        *
		       ***
		      *****
		     *******
		    *********
	 */
	//��ӡ������ͼ��
	public static void main(String[] args) {
		for(int i=1;i<=5;i++){//i��ʾ����
			//��ӡ�ո�
			for(int k=0;k<5-i;k++){
				System.out.print("");
			}
			//��ӡ����
			for(int j=0;j<2*i-1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
