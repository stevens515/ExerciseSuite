package basic.day17.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOUtils03 {
	public static void printHex(String fileName) throws IOException{
		// 1�������ļ�����������
		FileInputStream in = new FileInputStream(fileName);
		int b = 0;
		int i=1;
		// 2.ѭ����ȡbyte
			if (b <= 0xf) {// ��λ��ǰ�油0���磺8����08
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b) + "");
			if(i++%10==0){//��10�л���
				System.out.println();
		}
		in.close();
	}
}
