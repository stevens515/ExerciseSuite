package basic.day11;

public class StringBuilderAPIDemo {
public static void main(String[] args) {
	
	/*append API
	 * if (newcount > value.length)
	    expandCapacity(newcount);
	    
	    int newCapacity = (value.length+1)*2;
	    	if(newCapacity<0){
	    		newCapacity = Integer.MAX_VALUE;
	    	}else if(minimumCapacity>0){
	    		
	    	}
	 */
	StringBuilder buf = new StringBuilder();
	buf.append("�����").append("��ǰ��").append("������")
	.append("����˵��ʮ��Ư��!").delete(2, 4).insert(0, "��ʦ")
	.replace(17, 19, "����");
	System.out.println(buf);//buf.toString()
	
	String str = buf.toString();
	System.out.println(str);
	//���õĴ��룬ÿ���Զ�����һ��StringBuiler����
	//java�У�String������ʹ��StringBuilder()ʵ��
	String s = "a";
	String ss = s+"1"+2+3+4;//java��ʹ�����¼���ʵ��
//	String ss1 = new StringBuilder(s).append("1").append(2)
//				.append(3).append(4).toString();
	//����java�ַ����ļ��������Ż�
	s = "a";
	s+="a";
	s+="a";
	s+="a";
	s+="a";
	///�����Ż�Ϊ��һ��StringBuilder����
	buf	= new StringBuilder(s);
	buf.append("a");
	buf.append("a");
	buf.append("a");
	buf.append("a");
	s = buf.toString();
	System.out.println(s);//aaaaa
	
}
}
