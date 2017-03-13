package basic.day08.snake;

public class WormPane {
	private Worm worm;

	private int rows = 10;// ����

	private int cols = 32;// ����

	public Worm getWorm() {
		return worm;
	}

	public void setWorm(Worm worm) {
		this.worm = worm;
	}
	// �������
	public WormPane(){
		worm = new Worm();//����һ��Ĭ�ϵ���
	}
	//������ǰ���
	public void print(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(i==0||i==rows-1){
					System.out.print("-");//��������س�
				}else if(j==0||j==cols-1){
					System.out.print("|");
				}else if(worm.contain(i, j)){
					System.out.print("#");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();//һ�н����Ժ󻭻س�
		}
	}
}
