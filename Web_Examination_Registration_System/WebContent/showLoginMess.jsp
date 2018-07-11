<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.data.loginBean" %>
<jsp:useBean id="login" type="mybean.data.loginBean" scope="session"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>职称计算机考试报名</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="网上报名，职称考试，计算机">
<meta http-equiv="description" content="网上报名首页">
<link href="css/mystylesheet.css" rel="stylesheet" type="text/css" />
</head>

<body class="twoColHybLtHdr">
	<div id="container">
		<div id="header">
			<%@ include file="txtfile/header.txt"%>
		</div>
		<div id="sidebar1">
			<%@ include file="txtfile/left.txt"%>
		</div>
		<div id="mainContent">
			<center><p><font size=4 color=red>欢迎您使用登录功能！</font></p></center>
			<br>
			<center><font size=4 color=blue><jsp:getProperty name="login" property="backMessage" /></font>
			</center>
			<% if (login.isSuccess() == true) { %>
			<center><br>登录考生身份证号：<jsp:getProperty property="loginName" name="login" /></center>
			<% } else { %>
			<br>
			<center>登录考生身份证号：<jsp:getProperty property="loginName" name="login" /></center>
			<br>
			<center>登录使用的密码为：<jsp:getProperty property="password" name="login" /></center>
			<% } %>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>
</body>
</html>