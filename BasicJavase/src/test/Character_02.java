package test;

/**
 * �����ַ���indexOf()	lastIndexOf()
 */
public class Character_02 {
public static void main(String[] args) {
	String in = "jiadongpo";
	int index = 0;
	index = in.indexOf('a');
	System.out.println(index);//2
	index = in.lastIndexOf('o');
	System.out.println(index);//8
	index = in.indexOf('o',3);
	System.out.println(index);//4
	
	//�ҵ�ʱ��һ����a'����֮����׸�'b'��λ��
	int aIndex = -1;		//Position of first 'a'
	int bIndex = -1;		//Position of first 'o' after 'a'
	aIndex = in.indexOf('a');//Find first 'a'
	if(aIndex>=0){	//Make sure you found 'a'
		bIndex=in.indexOf('o', ++aIndex);//Find first 'o' after first 'a'.
	}
	
	//����ʹ��indexOf()��¼ĳ���ض��ַ���һ���ַ����г��ֵĴ���
	aIndex = -1;
	int count = 0;
	while((aIndex=in.indexOf('a',++aIndex))>-1){
		++count;
	}
	System.out.println(count);//1
	
}
}