package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {
	/**
	 * 		�����%E5%B0%8F%E5%BC%A0

	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "С��";
		String str2 = URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
	}
}
