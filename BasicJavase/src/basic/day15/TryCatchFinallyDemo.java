package basic.day15;

import java.text.ParseException;

public class TryCatchFinallyDemo {
	public static void main(String[] args) {
		System.out.println(test("5") + "," + test(null)+","+test("")+","+test("A"));
	}

	public static int test(String str) {
		try {
			char ch = str.charAt(0);
			if(ch<'0'||ch>'9'){
				throw new NotNumberException();
			}
			int n = ch - '0';
			return n;
		} catch (NullPointerException e) {
			return 0;
		} catch (RuntimeException e1) {
			return 1;
		}	catch(Exception e) {
			return 2;
		}	finally{//�����Ƿ�����쳣������ִ�еĴ����
			return 8;//����ȡ��ǰ��ķ��ؽ��
		}
	}
}
class NotNumberException extends Exception{
	
}