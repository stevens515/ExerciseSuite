function changeStyle() {
	var obj = $("myP");
	// �޸��ı�
	obj.innerHTML = "aaaaa";

	// �޸���ʽ
	obj.style.color = "red";
	obj.style.height = "100px";
	obj.style.backgroundColor = "yellow";
	obj.style.fontSize = "30pt";

	// �޸�div�ĸ��߿�
	var div = $("myDiv");
	div.className = "myStyle";

	// ����ҳ���϶���ĸ���
	var pArray = document.getElementsByTagName("p");
	alert(pArray.length);
	// ����ÿ����������ı�
	for ( var i = 0; i < pArray.length; i++) {
		alert(pArray[i].innerHTML);
	}

}
function showSubMenu(isShow, menuID) {
	var menu = $(menuID);
	if (isShow)
		menu.style.display = "block";// �������
	else
		menu.style.display = "none";
}

// ����ǰѡ�е�tab����ɫ��Ϊblue,����������tab����ɫ��Ϊsilver
function changeTab(divID) {
	// �����е�tab��ǩ�޸�Ϊ��ʼ��ʽ
	var parentDiv = $("allTabs");
	var divArray = parentDiv.getElementsByTagName("div");
	// document.getElementsByTagName("div");
	for ( var i = 0; i < divArray.length; i++) {
		// ����ǰѡ�е��޸�
		divArray[i].style.backgroundColor = "silver";
	}
	$(divID).style.backgroundColor = "blue";
}
// �ж��û�¼����û�����������Ϊ�գ�ֻ��Ϊ3λСд��ĸ
// ¼����ϣ�Ӧ���ж�����ʾ
// ����ύҳ�棬�����жϣ��Ѳ��ɹ���������֤���ɹ�
function judgeUserName() {
	var obj = $("txtUserName");
	var span = $("errorInfo");
	if (obj.value != "") {
		var reg = /^[a-z]{3}$/;
		if (reg.test(obj.value)) {
			span.innerHTML = "����֤";
			return true;
		} else {
			span.innerHTML = "�û����� ��Ϊ��λСд��ĸ ";
			return false;
		}
	} else
		span.innerHTML = "�û���������Ϊ��! ";
	return false;
}

	function addNew()
	{
		//����һ���ı����һ����ť
		var obj = document.createElement("input");
		var button=document.createElement("input");
		button.type="button";
		button.value="new button";
		
		//�����ĵ���
		$("form1").appendChild(obj);
		$("form1").appendChild(button);
		
		//����a   <a href="">ddd</a>
		var link = document.createElement("a");
		link.innerHTML = "click me";
		link.href = "a.html";
		
		var hobj =$("h1");
		$("form1").insertBefore(link,hobj);
	}
	function testSelect()
	{
		var obj = $("mySelect");
		//ÿ��ѡ����ı���ֵ
		for(var i=0;i<obj.options.length;i++)
		{
			var op = obj.options[i];
			alert(op.innerHTML);
			alert(op.value);
		}
		alert(obj.options.length);
	}
	
	//������ѡ�����ֵ���ı�7	7+\il
		function showSelect()
	{
		var obj = $("mySelect");
		var op = obj.options[obj.selectedIndex];
		alert(op.innerHTML);
		alert(op.value);
	}
		
		var dataArray = new Array();
		dataArray[0] = ["JSD1202","JSD1203","JSD1204"];
		dataArray[0] = ["JSD1202","JSD1203"];
		dataArray[0] = ["JSD1202","JSD1203","PHD1204"];
		//������ѡ��Ŀγ���ʾ��Ӧ�İ༶��Ϣ
		function showClasses()
		{
			var index = $("selSubjects").selectedIndex;
			
			//�����ԭ�еİ༶����
			$("selClasses").options.length=0;
			
			//�õ��༶��Ϣ
			//����0��["JSD1202","JSD1203","JSD1204"];
			var classArray = sdataArray[index]
			  for(var i=0;i<classArray.length;i++ )
			  {
				  //����������
				  var op = document.createElement("option");
				  op.innerHTML = classArray[i];
				  $("selClasses").appendChild();
			  }
		}