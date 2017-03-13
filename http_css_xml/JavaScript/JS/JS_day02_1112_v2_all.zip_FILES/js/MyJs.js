function fileFunction()
{
	//alert("function in file!");
	//var s = "111";//string
	//var s = 111;//number
	var s = true;//boolean
	alert(typeof(s));
}

function testDataType()
{
	var str1 = "hello";
	var n1 = 12;
	var b1 = true;

	var r1 = str1 + n1;
	alert(r1);//hello12
	var r2 = n1 + b1;
	alert(r2);//13
	var r3 = str1 + b1;
	alert(r3);//hellotrue
}

function add()
{
	var s1 = document.getElementById("txt1").value;//string
	var s2 = document.getElementById("txt2").value;
	var n1 = parseInt(s1);
	var n2 = parseInt(s2);
	alert(n1 + n2);
}

//��������������ֵ,������ֵ��;������string��
function addMethod(n1,n2)
{
	if(typeof(n1) == "number" && typeof(n2) == "number")
	{
		alert(n1 + n2);
	}
	else
	{
		alert(n1.toString() + n2.toString());
	}	
}

function testEqual()
{
	var s1 = "11";
	var s2 = 11;

	if(s1 == s2)
		alert("equal");

	if(s1 === s2)
		alert("same");

	if( "" == 0)// "" true/false
		alert("aaaaa");//aaaaa
}

//����ı���ֵ,�ж�,���������ֵ,��ʾ;�������ƽ��
function calculateSq()
{
	var s = document.getElementById("txt3").value;
	if( isNaN(s))//is not a number
		alert("��¼����ֵ����");
	else
	{
		var n = parseFloat(s);
		alert(n*n);
	}
}

function testString()
{
	var s = "abcdefg";
	var r = s.charAt(3);//λ�õ��ַ�
	alert(r);
	var r1 = s.indexOf("k");//�ַ���λ��
	alert(r1);//-1
/*	
//alert(s.length);
	var result = s.substring(1,4);
	alert(result);//bcd
	var result1 = s.substr(4,2);//ef
	alert(result1);

	var s1 = "12,sd,56";
	var arr = s1.split(",");
	alert(arr.length);*/
}

function verifyString()
{
	//
	var s = document.getElementById("txt4").value;

	//�ж�¼������ֵ�λ�ú�����
	/*var result = s.search(/[0-9]/);
	alert(result);

	//g:global  i:ignour
	var result1 = s.match(/[0-9]+/g);	
	alert(result1);*/

	//��¼���е�gcd���滻Ϊ*
	//������¼���д��ĸ /[A-Z]/
	var r = s.replace(/gcd/ig,"*");
	document.getElementById("txt4").value = r;
}

function testArray()
{
	//��ʽһ:
	/*var arr = new Array();
	arr[0] = 1;
	arr[1] = "aaa";
	arr[2] = true;*/
	//��ʽ��:
	/*var arr = [1,"aaa",true];

	alert(arr.length);
	alert(arr[1]);

	arr[3] = 234;
	alert(arr.length);*/
	
	var arr = [1,12,45,78,34];
	//alert(arr.toString());

	var arr1 = [9,8];
	var r = arr.concat(arr1);
	alert(r.join("-"));//1-12-45-78-34-9-8
}

function operateArray(t)
{
	var s = document.getElementById("txt5").value;
	var arr = s.split(",");
	var r1;
	switch(t)
	{
		case 1:
			r1 = arr.reverse();
			break;
		case 2:
			r1 = arr.sort();
			break;
		case 3:
			r1 = arr.sort(sortFunc);
			break;
	}
	alert(r1);
}
function sortFunc(a,b)
{
	return b-a;
}

//�����һ��1��7֮�������(����1,������7)
//Math.round/random(0=< <1)/floor/ceil
function testMath()
{	
	alert(randomInt(1,40));
}

//���������
function randomInt(min,max)
{
	var r = Math.random();
	var result = Math.floor(r * (max-min) + min);
	return result;
}

function same1()
{
	alert("no param");
}

function same1(a,b)
{	
	alert(a+b);
}
//����:���������,alert;����������,�������в����ĺ�
function useArguments()
{
	var info = "";
	if(arguments.length == 0)
		info = "no param";
	else
	{
		var sum = 0;
		for(var i=0;i<arguments.length;i++)
		{
			sum += arguments[i];
		}
		info = sum.toString();
	}

	document.getElementById("spanInfo").innerHTML = info;
}


function createWin()
{
	/*var arr = new Array(7);

	for(var i=0;i<7;i++)
	{
		var n = randomInt(1,37);
		//�ж�n�Ƿ��ظ�:break,continue
		for()
		arr[i] = n;
	}
	arr.sort(sortFunc);
	document.. = arr.toString();
*/
}

function modifyElement()
{
	var p = document.getElementById("firstP");
	p.innerHTML = "new text";//�ı�
	p.style.color = "green";//������ɫ
	p.style.backgroundColor = "gray";//����ɫ
	p.style.fontSize = "30";//�����С

	//�޸���ʽ��
	var d = document.getElementById("firstDiv");
	d.className = "s1";
}

//�����ж����������ɫ�޸�Ϊ��ɫ
function findElements()
{
	var els = document.getElementsByTagName("p");
	for(var i=0;i<els.length;i++)
	{
		//�õ������е�ĳ��Ԫ��
		els[i].style.color = "green";
	}
}

function changeTabs(index)
{	
	//���ҵ����е�ҳǩ:ѭ��:����ǵ�ǰ���е�ҳǩ,on;����,off
	var parentDiv = document.getElementById("allTabs");
	var tabs = parentDiv.getElementsByTagName("div");

	for(var i=0;i<tabs.length;i++)
	{
		if(index == i)
			tabs[i].className = "tab_on";
		else
			tabs[i].className = "tab_off";
	}
}

function showMenu(liObject,isShow)
{
	var menuArray = liObject.getElementsByTagName("ul");
	var menu = menuArray[0];

	//��ʾ������ʧ
	if(isShow)
		menu.style.display = "block";
	else
		menu.style.display = "none";
}

function verifyName()
{
	var name = $("txtName").value;
	//������Ϊ��
	if(name == "")	
		document.getElementById("nameInfo").innerHTML = "��¼���û���";
	else
	{
		//��֤���ݸ�ʽ
		var reg = /^\d{3}$/;
		var tag = reg.test(name);
		if(!tag)
			document.getElementById("nameInfo").innerHTML = "�û�����ʽ����";
		else
		{
			document.getElementById("nameInfo").innerHTML = "";
			return true;
		}
	}
	return false;
}

//3��6λ�Ĵ�Сд��ĸ/���ֵ����
function verifyPwd(){
	var pwd = $("txtPwd").value;
	var reg = /^[A-Za-z0-9]{3,6}$/;
	if(reg.test(pwd)){
		$("pwdInfo").innerHTML = "";
		return true;
	}
	else{
		$("pwdInfo").innerHTML = "�����ʽ����";
		return false;
	}
}
//����һ�������滻document.getElementById
function $(id)
{
	return document.getElementById(id);
}
function verifyAll(){
	//���ø�����֤����
	var r1 = verifyName();
	var r2 = verifyPwd();

	if(r1 && r2)
		return true;
	else
		return false;	
}


function addNewElement()
{
	//��ť�ĺ������һ����������,�ı�ΪClick me,�����ȥ��a.html  <a href="a.html">Click Me</a>
	var newEle = document.createElement("a");
	newEle.innerHTML = "Click Me";
	newEle.href = "a.html";

	$("parentDiv").appendChild(newEle);

	//����һ����ť,������login��ť֮ǰ
	var txt = document.createElement("input");
	txt.type = "button";
	txt.value = "new button";
	
	var pNode = $("form1");
	var refNode = $("btnLogin");
	pNode.insertBefore(txt,refNode);
}

function createClasses()
{
	var sub = $("selSubjects");
	//���������
	$("selClasses").options.length = 0;

	var dataArray = new Array();
	dataArray[0] = ["--ѡ��༶--"];
	dataArray[1] = ["jsd1111","jsd1112","jsd1201"];
	dataArray[2] = ["tsd1111","tsd1112"];

	//��Ҫ������
	var showDatas = dataArray[sub.selectedIndex];
	//ѭ������,����option
	for(var i=0;i<showDatas.length;i++)
	{
		var op = document.createElement("option");
		op.innerHTML = showDatas[i];

		$("selClasses").appendChild(op);
	}
}


























