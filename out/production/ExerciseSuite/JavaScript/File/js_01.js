/*
 * ����ע��
 */	
function SecondMethod()
	{
		//λ��js�ļ��еķ���
		alert("code in file");
	}
	function testDataType(){
		var i="100";//string
		var j=100;//number
		if(i==j)//�ã�����ֵ
				alert("equal");
		else
			alert("no")
		if(i===j)//��===������
			alert("same");
		else
			alert("no");
	}

	/*function testDataType(){
		var s="";//s��ֵ���ⲿ���룬�ǿ��ַ���ʱ������
		if(s != "")//
				alert("��������");
	}*/
	function calculate(){
		var d = document.getElementById("TestData").value;
		//�ж��û�¼����Ƿ�����ֵ
		var r = isNaN(d);
		if(r)
			alert("��¼����ֵ")
		else
		{
			//ת��Ϊ��ֵ
			var number = parseInt(d);
			var result=number*number;
			alert(result);
			
		}
}
	
	function testString()
	{
		/*var s = "abcdeffdadsgcddsf";
		var r = s.substring(1,3);;
		alert(r);*/
		//var s="aaaagcdbbgcdbb";//gcd
		//var r = s.replace("gcd", "*");//��gcd��*�����
//		var r = s.replace(/gcd/g, "*");
		/*var r = s.replace(/gcd/gi, "*");
		alert(r);*/
		
		var s="aaaaGCDcccGcdcgCD";//
		//�ж��Ƿ��������ַ���Ȼ���滻
		//search�����ҵ�����λ��
		var i=s.search(/gcd/i);
		alert(i);//4
		
		//��ʾ��������gcd�ģ����ܴ�Сд
	/*	var matchData=s.match(/gcd/gi);
		alert(matchData);*/
		
		if(i>-1){
				var r = s.replace(/gcd/gi, "*");
				alert(r);
		}
	}
		function testArray()
		{
			/*var r = new Array();
			r[0]=11;
			r[1]="aaa";
			r[2]=true;
			alert(r.length);*/
//		var r= new Array(11,"aa",true);
			
	/*	var r =[11,"aaa",true];//�����Ҹ�ֵ�����һ�ּ�д
		alert(r.length);
		alert(r[2]);*/
			
	/*		alert(r.toString());//11,aaa,true
			alert(r.join("*"));//11*aaa*true
*/			
			/*var r1 = [1,2,3];
			var r2 =[4,5];
			var result = r1.concat(r2);
			alert(result.toString());
			
			var large = [1,2,3,4,5,6];
			result = large.slice(1, 4);//2,3,4
			alert(result.toString());*/
			
			
			//����ķ�ת������
			var r = [12,34,123,11,234];
			alert(r.toString());//ԭ��˳��
			
			var newArray = r.reverse();//��ת
			alert(newArray.toString());
			
			var newArray = r.sort();//����String�Ƚ�����
			alert(newArray.toString());//String
			
			//number
			newArray = r.sort(Compare);//ʹ��ĳ������������бȽ�
			alert(newArray.toString());
			
		}
		
		function Compare(a,b)
		{
			return a-b;//����  0   ����
		}
		function testMath()
		{
			//����
//			alert(Math.PI);
			alert(Math.random());//0=< <1
			alert(Math.floor(32.21));//32
			//�����3��9֮�������������3��������9
			/*var r = Math.random();
			var n = Math.floor(r*(9-3))+3;
			alert(n);*/
			//���÷��������3��9֮�������������3��������9
			var data = RandomNumber(3,9);
			alert(data);
		}
		//������װһ�����������min��max��Ϊ������������
		function RandomNumber(min,max)
		{
			var r = Math.random();
			var n = Math.floor(r*(max-min))+min;
			return n;
		}
		//ʵ�鷽��������
/*		function M1()
		{
			alert("hello,no param");
		}*/
		//M1��Ӵ��룺���û�д������������hello;���򣬵�����
		function M2(x,y)
		{
			/*alert(arguments.length);
			alert(arguments[1]);
			alert(x+y);*/
			//arguments:������ʹ������������ʵ�ʲ���������
			if(arguments.length==0)
						alert("Hello");
			if(arguments.length==2)
				alert(arguments[0]+arguments[1]);
		}
		
		function testDOM()
		{
			//�ҵ�InputԪ�ؽڵ�
			var i = document.getElementById("txt1");
//			alert(typeof(i));//object
//			alert(i.value);
			i.value = "aaa";
			
			//img��ʾĳ���ڵ�
			var m = document.getElementById("myImage");
			m.src = "bang.gif";
			
			//����divԪ��
			var d = document.getElementById("div1");
			d.innerHTML="div text";
			
			
		}