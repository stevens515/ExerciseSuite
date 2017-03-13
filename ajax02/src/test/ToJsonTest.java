package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Option;

public class ToJsonTest {
	/*java���󣭣�JSON�ַ���*/
	public static void test2(){
		////{"cityName":"����","cityValue":"hd"}
		Option op = new Option("����","hd");
		JSONObject obj = JSONObject.fromObject(op);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/*�������->JSON�ַ���*/
	public static void test3(){
		////{"cityName":"����","cityValue":"hd"}
		Option op = new Option("����","hd");
		Option op2 = new Option("����","dc");
		Option op3 = new Option("����","xc");
		Option[] ops = {op,op2,op3};
		JSONArray obj = JSONArray.fromObject(ops);
		String str = obj.toString();
		System.out.println(str);
	}
	
	/*List����->JSON�ַ���*/
	public static void test4(){
		////{"cityName":"����","cityValue":"hd"}
		Option op = new Option("����","hd");
		Option op2 = new Option("����","dc");
		Option op3 = new Option("����","xc");
		List<Option> ops = new ArrayList<Option>();
		ops.add(op);
		ops.add(op2);
		ops.add(op3);
		JSONArray obj = JSONArray.fromObject(ops);
		String str = obj.toString();
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		test2();
		test3();
		test4();
	}
}
