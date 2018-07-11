<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<center>
					<P><font size=4 color=red>欢迎使用浏览功能！</font></P>
					<P><p><font size=4 color=red>请选择浏览方式</font>
				</center>
			<blockquote>
				<center><p></p>
					<form action="helpShowExamineeByPage" name=form method="post">
						<table>
							<tr><td>分页显示全体考生信息:</td><td><input name="showPage" type="hidden"><input type="submit" value="显示" name="submit"></td></tr>
						</table>
					</form>
					<form action="helpShowExaminee" name=form method="post">
						<table>
							
							<tr><td>输入考生身份证号：</td><td><input name="examID" type=text id="examID"><input type="submit" value="显示" name="submit"></td></tr>
						</table>
					</form>
				</center>
			</blockquote>
			</div>
			<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
</div>
</body>
</html>