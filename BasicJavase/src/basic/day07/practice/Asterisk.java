package basic.day07.practice;

public class Asterisk {

	/**
	 	9�����ó����������ͼ��:
			   *
			   * * *
			   * * * * *
			   * * * * * * *
			   * * * * *
			   * * *
			   *
	 */
	public static void main(String[] args) {
		for(int i=1;i<=13;i+=2){
			for(int j=1;j<=i&&i+j<=14;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
