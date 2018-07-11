<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*" %>
<jsp:useBean id="register" type="mybean.data.registerBean" scope="request"/>
<% String path =request.getContextPath();
String basePath=request.getScheme() +"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
	<title>职称计算机考试报名</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="网上报名，职称考试，计算机">
	<meta http-equiv="description" content="网上报名首页">
	<link href="css/mystylesheet.css" rel="stylesheet" type="text/css"/>
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
				<p><font size=4 color=red>欢迎您来报名！</font></p>
			</center>
			<blockquote>
			<center>
			<p><jsp:getProperty name="register" property="backMessage"/></p>
			<table bgcolor="#CCFFCC">
			<tr>
			<td>身份证号：</td><td><jsp:getProperty name="register" property="examID"/>*</td></tr>
			<tr>
			<td>考生姓名：</td><td><jsp:getProperty name="register" property="examName"/>*</td></tr>
			<tr>
			<td>考生性别：</td><td><jsp:getProperty name="register" property="sex"/></td></tr>
			<tr>
			<td>所在学校：</td><td><jsp:getProperty name="register" property="school"/></td></tr>
			<tr>
			<td>报考类别：</td><td><jsp:getProperty name="register" property="examType"/></td></tr>
			<tr>
			<td>备注：</td><td><TextArea name="memo" Rows="6" Cols="30"><jsp:getProperty name="register" property="memo"/></TextArea></td></tr>
			<tr><td></td><td></td></tr>
			</table>
			</center>
			</blockquote>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt" %>
</div>
</body>
</html>