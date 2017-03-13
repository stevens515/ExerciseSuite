package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �������������һ������ ����InputData ����������͵�����
 * �˳���ʵ��������С�����ַ����������������ݵ����롣
 */

public class InputData2 {
	private BufferedReader buf = null;

	public InputData2() {
		this.buf = new BufferedReader(new InputStreamReader(System.in));// ����Ĺ��췽����ʵ����InputStreamReader����
	}

	public String getString(String info) { // �Ӵ˷����еõ��ַ�������Ϣ
		String temp = null;
		System.out.println(info); // ��ӡ��ʾ��Ϣ
		try {
			temp = this.buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public int getInt(String info,String err){	//�õ�һ����������������
		int temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+$")){//�ж�������Ƿ�������
				temp = Integer.parseInt(str);//���ַ�����Ϊ����
				flag = false;			//���ı�־λ֮�󣬽��˳�ѭ��
			}else{
				System.out.println(err);	//����ʱ�����ӡ�������ĳ�����Ϣ
			}
		}
		return temp;
	}
	
	public float getFloat(String info,String err){//�õ�һ��С������������
		float temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+.?\\d+$")){//�ж��Ƿ���С��
				temp = Float.parseFloat(str);
				flag = false;				//���ı�־λ֮�󣬽��˳�ѭ��
			}else{
				System.out.println(err);
			}
		}
		return temp;
	}
	
	public Date getDate(String info,String err){	//�õ�һ����������
		Date d = null;
		String str = null;
		boolean flag = true;			//����һ��ѭ�������־
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try{
					d = sdf.parse(str);
				}catch(ParseException e){
					e.printStackTrace();
				}
				flag = false;
			}else{
				System.out.println(err);
			}
		}
		return d;
	}
}
