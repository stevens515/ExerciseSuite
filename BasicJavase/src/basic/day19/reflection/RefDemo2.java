package basic.day19.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/** ����API ���� 
 * 1 ����API��Java���Ժ��Ĺ���API, ��java�ĵײ㹤������
 *   ��Object���Ͼʹ���֧�ַ���API�ķ���(getClass())
 * ����API�Ĺ���: 
 *  A ���ֶ��������
 *  B �������͵�����, ����, ��������
 *  C ���ʶ��������, ���ö���ķ���, �������͵�ʵ����
 **/
public class RefDemo2 {
  public static void main(String[] args) {
//    discovery(1);
//    discovery("1");
    Scanner s = new Scanner(System.in);
    System.out.print("��������:");
    String name = s.nextLine();
    Object obj = create(name);
    discovery(obj);
    System.out.println(get(obj, "n")); //null
    //һ�нԶ���
    //�κ�����(��������)����Class��ʵ��
    // int.class, double.class String.class Integer.class ...
    // Card.class
    //Class ��ʵ����3�ֻ�÷���
    // A String.class 
    // B "abc".getClass()
    // C Class.forName("java.lang.String")
    // 3�ַ�ʽ��õĶ���ͬһ������. ����Class��ʵ��
    //  String.class == "abc".getClass()
    Class c = int.class;
    System.out.println(c.getName());//int
    obj = create("basic.day19.Foo", 
        new Class[]{int.class, String.class},
        new Object[]{5, "��"});
    discovery(obj);
    System.out.println(get(obj, "n")); 
    System.out.println(call(obj, "add", 
        new Class[]{int.class, int.class, String.class}, 
        new Object[]{5,5,"55"}));
  }
  
  /** 
   * ����ĳ���������
   * @param obj ĳ����
   * @param fieldName ĳ������
   * @return ���Ե�ֵ
   **/
  public static Object get(Object obj, String fieldName){
    try {
      Class cls = obj.getClass();
      Field field = cls.getDeclaredField(fieldName);
      Object val = field.get(obj);
      return val;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  /** 
   * ����ĳ����ķ���
   * @param obj �����÷����Ķ���
   * @param method ������
   * @param paramTypes �������������б�
   * @param params ���������б�
   * @return ��������ֵ
   */
  public static Object call(Object obj, 
      String method, 
      Class[] paramTypes, 
      Object[] params){
    try {
      Class cls = obj.getClass();
      Method m = cls.getDeclaredMethod(method, paramTypes);
      //invoke: ����
      Object value = m.invoke(obj, params); //obj -> this  
      return value;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  
  /**
   * ����ĳ���͵�ʵ��(���ù�����)
   * @param className ����
   * @param paramTypes ���������б�: 
   *  ��: new Class[]{int.class, String.class} ��ʾ: int,String
   * @param params �����б�
   *  ��: new Object[]{5, "50"} ��ʾ: 5,"50"
   */
  public static Object create(String className, 
      Class[] paramTypes, Object[] params){
    try{
      //�ҵ�����
      Class cls = Class.forName(className);
      //�ҵ�������
      Constructor c = 
        cls.getDeclaredConstructor(paramTypes);
      //���ù�����, ����ʵ��
      Object obj = c.newInstance(params);
      return obj;
    }catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e); 
    }
  }
  
  
  /**
   * ��������
   * ��һ��, �����ʹ��Ĭ�Ϲ���������ʵ��
   //����API, ����ڶ��Ǵ�Classʵ����ʼ
    //Class.forName()�Ǿ�̬����, ȥ�����ڴ��Ƿ���className
    //��Ӧ�����ʵ��, ���û�оͼ��������, ��CLASSPATH�ϼ���
    //���CLASSPATH��û���ҵ���Ķ����׳�: ClassNotFoundException

   * @param className ����
   * @return ��������޲�������������������ʵ��
   */
  public static Object create(String className){
    try{
      Class cls = Class.forName(className);
      //newInstance() �����cls���޲����������������ʵ�� 
      Object obj = cls.newInstance();
      return obj;
    }catch(Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  


  /**
   * A ���ֶ��������
   * B �������͵�����, ����, ��������
   */
  public static void discovery(Object obj){
    System.out.println("����:"+obj);
    //"�±�����" �� �±������� 
    // �±����� ����Ҳ�Ƕ���, ��"����"��ʵ��
    //obj.getClass()�������Ի�ȡ��ǰ���������
    //���������Object�϶���, ��java�ĺ��ķ���֮һ
    System.out.println("��������:");
    Class cls = obj.getClass();
    //cls ����Ӳ���� .class�ļ�װ��(class load)���ڴ�Ľ��
    System.out.println(cls.getName());//����!
    //������cls�ϻ������������, Field: �ֶ�,����
    System.out.println("��������:");
    Field[] fields = cls.getDeclaredFields();
    for(Field field:fields){
      System.out.println(
          field.getType()+" "+field.getName());
    }
    //Method: ����, getDeclaredMethods()�������Ϸ��������ķ���.
    //Declared: ������ 
    System.out.println("���ַ���:");
    Method[] methods = cls.getDeclaredMethods();
    for(Method method:methods){
      System.out.print(method.getReturnType()+" ");
      System.out.print(method.getName());
      System.out.println(
          Arrays.toString(method.getParameterTypes())); 
    }
    System.out.println("���ֹ�����:");
    //Constructor:������ 
    Constructor[] constructors = 
      cls.getDeclaredConstructors();
    for (Constructor c : constructors) {
      System.out.print(c.getName());
      System.out.println(
          Arrays.toString(c.getParameterTypes()));
    }
  }
}
class Foo2{
  int a;
  String n;
  public Foo2() {
  }
  public Foo2(int a, String s) {
    this.a = a;
    this.n=s;
  }
  
  public int add(int b, int c, String s){
    return b+c+s.charAt(0)-'0';
  }
  
}




