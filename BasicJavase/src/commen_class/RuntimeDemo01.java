package commen_class;
/**
 *�õ�JVM���ڴ�ռ���Ϣ��
 *��������ڴ�ռ䣬�����ڴ�ռ䡣
 *gc()�����󣬿��ÿռ�ͱ����
 */
public class RuntimeDemo01 {
	public static void main(String[] args) {
		Runtime run=Runtime.getRuntime();//ͨ��Runtime��ľ�̬����Ϊ�����ʵ��������
		System.out.println("JVM����ڴ�����"+run.maxMemory());//�۲�����ڴ��������ݻ���������������ͬ
		System.out.println("JVM�����ڴ�����"+run.freeMemory());//ȡ�ó�������֮ǰ���ڴ������
		
		String str = "Hello"+"World"+"!!!"+
				"\t"+"Welocome"+"To"+"MLDN"+"!~";
		System.out.println(str);
		for(int x=0;x<1000;x++){//ѭ���޸�String�����������������ռ���ڴ�
			str += x;
		}
		System.out.println("����String֮��ģ�JVM�����ڴ�����"+run.freeMemory());//�۲��ж�������ռ����֮����ڴ������
		run.gc();//���������ռ����ͷſռ�
		System.out.println("��������֮��ģ�JVM�����ڴ�����"+run.freeMemory());//�����ռ�֮����ڴ��������
	}
}
