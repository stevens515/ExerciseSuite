package json;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**��ajax�����ڵĴ���json
 * step1,��дһ������ת�����࣬����ʵ��JsonValueProcessor�ӿ�
 * @author soft01
 *
 */
public class DateProcessor implements JsonValueProcessor{
	
	private String pattern = "yyyy-MM-dd";
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
		
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		Date date = (Date)arg0;//�õ����Ƕ���ת��������
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);//���Լ����ĸ�ʽ���ʹ����� 
		return sdf.format(date);
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		Date date = (Date)arg1;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
}
