package annotation;

/**ע��
 *		������ע����Ϣʱ������key->value����ʽ���ֵģ�����Ҳ����ֱ��ʹ��
 *	"value={"unchecked","deprecation"}"�ķ�ʽ����
 */
public class DeprecatedAnnotationDemo4 {
//	@SuppressWarnings (value={"unchecked","deprecation"});//��ʱѹ����������
	public static void main(String[] args) {
		Demo4 d = new  Demo4();
		d.setVar("�ֶ���");
		System.out.println("���ݣ�"+d.getVar());
	}
}
@Deprecated
class Demo4<T>{
	public T var;
	public T getVar(){
		return var;
	}
	public void setVar(T var){
		this.var=var;
	}
}