package util;

/**
 * ������
 * @author tarena
 *
 */
public class DAOFactory {
	//type��һ���ӿ���
	public static Object getInstance(String type){
		Object obj = null;
		//���ݽӿ���(Ҳ����type)����ѯdao.properties�ļ���
		//�ҵ���Ӧ��ʵ���������
		String className = ConfigUtil.getValue(type);
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	
}
