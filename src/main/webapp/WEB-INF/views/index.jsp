<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/ui-lightness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script><title>Home</title>
</head>
<body>
<script type="text/javascript">
	function searchAjax() {
		
		var url = $("#url").val();
		var type = $("#type").val();
		var line = $("#line").val();
		
		if(url == ''){
			alert("url을 입력해주세요.")
			return;
		}
		else if(line == ''){
			alert("line을 입력해주세요.")
			return;
		}
		
		$.ajax({
			type : "post",
			url : "/indexAjax.do",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data : { "url": url, "type": type, "line": line },
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				$("#quotientSpan").text(data.quotient);
				$("#remainderSpan").text(data.remainder);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			}
		});
	}
	
	</script>
	
	<form id="form" method="POST">
	<P>
		<h1>url</h1>
		<input type="text" name="url" id="url" value="" />
			
		<br /> 

		<h1>type</h1>

		<select name="type" id="type">
			<option value="0" selected>TEXT</option>
			<option value="1">HTML</option>
		</select> <br /> 
		
		<h1>출력묶음단위(자연수)</h1>
		<input type="text" name="line" id="line" value="" /> 
		
		<br/><br/><br/>
		
		<input type="button" value="확인" onclick="searchAjax()" />
		<br />
		<br />
		<h1>몫  : </h1> <span id="quotientSpan"></span> <br>
		<h1>나머지 : </h1> <span id="remainderSpan"></span>	
	</p>
	</form>
	

</body>
</html>
