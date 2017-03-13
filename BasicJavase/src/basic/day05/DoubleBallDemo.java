package basic.day05;

import java.util.Arrays;
import java.util.Random;

/**�ص���ҵ����
 * ˫ɫ��,ȡ��ͬ�����������㷨����Ҫ
 */
public class DoubleBallDemo {
	
	public static void main(String[] args) {
		String[] balls = gen();
		System.out.println(Arrays.toString(balls));
	}
	/** ����һ��˫ɫ���Ʊ����*/
	public static String[] gen(){
		String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17",
				"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"};
		boolean[] used =  new boolean[pool.length];//ʹ�ñ�ǣ�ÿһ������false
		Random random = new Random();
		String[] balls = new String[6];
		int i = 0;//�������ɵĽ��������
		while(true){
			int index  = random.nextInt(pool.length);
			if(used[index]){		//���ʹ����������
				continue;			//�����´�ѭ��
			}
			balls[i++]=pool[index];//ȡ��һ����ŵ�balls�У���һ�η���0λ�ã��Ժ󲻶ϼ�һ
			used[index]=true;
			if(i==balls.length){
				break;
			}
		}
		Arrays.sort(balls);
		balls=(String[]) Arrays.copyOf(balls, balls.length+1);
		balls[i++]=pool[random.nextInt(16)];
		return balls;
	}

}
