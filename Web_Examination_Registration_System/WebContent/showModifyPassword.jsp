<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="mybean.data.*"%>
<jsp:useBean id="password" type="mybean.data.passwordBean"
	scope="request" />
<%
String path = request.getContextPath();
String basePath = 
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath %>">
<title>职称计算机考试报名</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-content" content="no-cache">
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
			<center>
				<p>
					<font size=4 color=red>欢迎您使用密码修改功能</font>
				</p>
			</center>
			<blockquote>
				<center>
					<p><p>
					<table bgcolor="#CCFFCC">
						<tr><th colspan="2"><jsp:getProperty name="password" property="backMessage" /></th></tr>
						<tr><td>您的旧密码：</td><td><jsp:getProperty name="password" property="oldPassword" /></td></tr>
						<tr><td>您的新密码：</td><td><jsp:getProperty name="password" property="newPassword" /></td></tr>
					</table>
				</center>
			</blockquote>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>
</body>
</html>