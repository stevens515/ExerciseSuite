function $(id){
	return document.getElementById(id);
}
function $F(id){
	return document.getElementById(id).value;
}
function getXhr() {
	var xhr = null;
	if (window.XMLHttpRequest) {
					//��ie�����
		xhr = new XMLHttpRequest();
	} else {
					//ie�����
		xhr = new ActiveXObject("Microsoft.XMLhttp");
	}
	return xhr;
}

