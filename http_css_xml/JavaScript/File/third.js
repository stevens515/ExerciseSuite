function addDataToTable() {
	// ��������Ϊһ�м�����
	var row = document.createElement("tr");
	// ����td
	var td1 = document.createElement("td");
	td1.innerHTML = $("txtName").value;
	row.appendChild(td1);

	var td2 = document.createElement("td");
	td2.innerHTML = $("txtPrice").value;
	row.appendChild(td2);

	// ��tr���뵽table
	$("t1").appendChild(row);

}
// table.insertRow(index)deleteRow(index)
// row.insertCell(index)/deleteCell(index)
function addDataToTable1() {
	var t = $("t1");

	// �����з��������·�
	var row = t.insertRow(t.rows.length);// ���뵽�ڼ���

	var cell1 = row.insertCell(0);
	cell1.innerHTML = $("txtName").value;

	var cell2 = row.insertCell(0);
	cell2.innerHTML = $("txtPrice").value;
}

function openWin() {
	var newW = window.open("second.html", "aaa", "width=200");
	newW.focus();// �ٴε�ʱ��ʹ֮��Ϊ����ҳ��
}

function showTime() {
	var d = new Date();
	$("spanTime").innerHTML = d.toLocaleTimeString();
}

var timer;
function startTime() {
	timer = window.setInterval(showTime, 1000);// ��ϵͳ�Ķ�ʱ���ڵ���
	// window.setInterval(showTime,1000);//���󣬲��������Լ�����
}
function stopTime() {
	window.clearInterval(timer);
}
var timer1;
function waitClose() {
	timer1 = window.setTimeout(addButton, 3000)
}
function addButton() {
	var bu = document.createElement("input");
	bu.type = "button";
	$("form1").appendChild(bu);
}
function clearClose() {
	window.clearInterval(timer1);
}
function deleteDate() {
	// window.confirm("Are you really-----?");//û����ʵ�ύ,¼��һЩ��Ϣ���в���
	var r = window.confirm("Are you really-----?");// û����ʵ�ύ
	return r;// ����true��false
}
function inputData() {
	var r = window.prompt("��¼��ID��");
	alert(r);
}
function testLocation() {
	// alert(window.location.href);
	// alert(location.href);
	location.href = "second.html";
	// location.replace("second.html");
}
function testDocument() {
	document.write(history.length);
}
function calculate(event) {
	// ҳ��ʾnavigargt�������е����Ժ�
	/*
	 * for ( var p in navigator) { document.write(p + ":" + navigator[p] + "<br>"); }
	 */
	// �õ���IE�������Chrom
	// MSIE Firefox Chrome
	/*
	 * var index = navigator.userAgent.indexOf("Firefox"); if (index > -1)
	 * alert("Firefox�����") else alert("���������");
	 */
	// ��ȡ�������Ԫ��
	var obj = e.sreElement || e.target;
	if (obj.nodeName == "INPUT") {
		if (obj.type == "button")
			alert(obj.value);
	}
}
function addEvent() {
	var i = 12;
	if (i > 10)
		$("btn1").onclick = MMM;
	else
		$("btn1").onclick = function() {
			alert("��������");
		};
}
function MMM() {
	alert("aaa");
}
function testObject() {
	// ��װ ���ݣ�mary 18 true
	var p = new Object();
	p.name="mary";
	p.age=18;
	p.isG = true;
	//������Ϊ������
	p.sing = MMM;
	p.swim = function(){alert('bbbb')};
	//����
	alert(p.name);
	alert(p.address);//undefined
	p.sing();
	p.sweim();
}
//����һ���Զ���Ķ���Student
//ʹ�ùؼ���this
function Student(name,a,isGra)
{
	this.name = name;//this.���ԣ�������
	this.age = a;
	this.isG= isGra
	//����
	this.introduceSelf = intro;//func������������
}
function intro()
{
	//i am, i am years old ,t
	alert("i am "+this.name+",i am"+this.age+"years old"+this.isG);
}
//��ť����¼�����
function testStudent()
{
	var s = new Student("mary",18,true);
	var s1 = new Student("john",23,false);
	//test
	alert(s.name);
	alert(s1.age);
	s.introduceSelf();
	s1.introduceSelf();
}
function testJson()
{
	var p = {"name":"mary","age":18,"isG":true,"sing":MMM};
	alert(p.name);
	p.sing();
}

