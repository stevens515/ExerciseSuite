package commen_class;

import java.io.IOException;

/**
 *	Runtime�����б����Ŀ�ִ�г��� 
 *���³�����ñ����ļ��±����򣬼��±������ִ�������ǡ�notepad.exe"
 */
public class RuntimeDemo02 {
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("notepad.exe");//���ñ������򣬱�������쳣����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
