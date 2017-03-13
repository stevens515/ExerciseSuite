package basic.day15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExceptionDemo2 {
public static void main(String[] args) {
	SimpleDateFormat fmt = new SimpleDateFormat();
	Scanner in = new Scanner(System.in);
	while(true){
		try{
			System.out.print("��������yyyy-MM-dd:");
			String str = in.nextLine();
			Date date = fmt.parse(str);
			System.out.println("��Ҫ��������"+date.getTime());
			break;
		}catch(ParseException e){
//			e.printStackTrace();
			System.out.println(e.getMessage());
			continue;
		}
	}
}
}
