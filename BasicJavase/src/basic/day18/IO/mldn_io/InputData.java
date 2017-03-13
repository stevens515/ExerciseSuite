package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**(2) ������к���Ļ���
 * 	�����������ݣ�����Ŀ��� ��������С�������ڣ��ַ��������Դ�ʱ��ý������
 *  һ��ר�ŵ����������࣬����������ݵĹ��ܡ�
 *  �������£����һ��ר�Ŵ����������ݵ��ֻ࣬�ܵõ��������ַ�����
 *  �Ժ�ֻҪ����õ��������ݣ���ֱ�ӿ��ԴӴ����еõ���
 */
public class InputData {
	private BufferedReader buf = null;
	public InputData(){				//����Ĺ��췽����ʵ����BufferedReader��
		this.buf=new BufferedReader(new InputStreamReader(System.in));
		
	}
	public String getString(String info){//�Ӵ˷����еõ��ַ�������Ϣ
		String temp = null;
		System.out.println(info);       //��ӡ��ʾ��Ϣ
		try{
			temp = this.buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return temp;
	}
	public int getInt(String info,String err){//�õ�һ����������������
		int temp = 0;
		String str = null;
		boolean flag = true;				//����һ��ѭ���Ĵ����־
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+$")){		//�ж�������Ƿ�������\d��ʾ[0-9]��+��ʾ����1��n��
				temp = Integer.parseInt(str);//���ַ��ڱ�Ϊ����
				flag = false;				//���ı�־λ֮�󣬽��˳�ѭ��
			}else{
				System.out.println(err);   //���ִ������ӡ���ݽ��Ĵ�����Ϣ
			}
		}
		return temp;
	}
}
