<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.onload = function(){
		var ajax = document.getElementById("ajax");
		var disp = document.getElementById("disp");
		
		ajax.addEventListener("click",function(e){
			$.ajax({
				url:'controller.json',
				data:{},
				dataType:'json',
				success:function(data){
					$.each(data.data,function(){
						disp.innerHTML += this
					})
				}
			})
		})
	}
	

</script>

</head>
<body>
	<p><a href="filelist.do">파일 목록 보기</a></p>
	<p><a href="excel.xlsx">엑셀 만들기</a></p>
	<p><a href="data.pdf">PDF 만들기</a></p>
	<p><a href="view.json">View를 이용한 JSON 만들기</a></p>
	<p><a href="data.csv">csv 출력</a></p>
	<p><a href="controller.json">Controller 를 이용한 JSON 만들기1</a></p>
	<p><a href="#" id="ajax">Controller 를 이용한 JSON 만들기</a></p>
	
	<div id="disp"></div>
	
	<p><a href="data.xml">xml 출력</a></p>
	
	
</body>
</html>