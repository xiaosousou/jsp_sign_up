<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
	String path=request.getContextPath();
	//getContextPath获取相对路径
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/*getScheme返回当前链接使用的协议，如：http
	*getServerName返回当前页面所在服务器名字
	*getServerPort返回当前页面的端口
	*path返回当前页面应用名字
	*/
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mystylesheet.css" rel="stylesheet" type="text/css" />
<title>职称计算机考试报名</title>
</head>
<body class="twoColHybLtHdr">
	<div id="container">
		<div id="header">
			<%@ include file="txtfile/header.txt" %>
		</div>
		<div id="sidebar1">
			<%@ include file="txtfile/left.txt" %>
		</div>
		<div id="mainContent">
			<center>
				<p><font size=4 color=red>欢迎你来报名</font></p>
				<br>
				<img src="image/welcome.jpg" width=700 height=394/>
			</center>
		</div>
		<br class="clearfloat"/>
		<%@ include file="txtfile/footer.txt" %>
	</div>
</body>
</html>