<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*" %>
<jsp:useBean id="examineeinfo" type="mybean.data.showExamineeByIDBean" scope="request"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
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
			<center><p><font size=4 color=red>欢迎您使用浏览功能！</font></p></center>
			<p>
			<center>
				<p><font size=5 color=blue> <jsp:getProperty property="backmessage" name="examineeinfo" /></font></p>
				<table width="318" border="1">
					<tr><th width="19" scope="row">身份证号</th>
						<td colspan="3"><jsp:getProperty property="examID" name="examineeinfo" /></td>
						<td colspan="2" rowspan="2">照片
						<img src=image/<jsp:getProperty property="pic" name="examineeinfo"/>
						width=90 height=100>
						</td>
					<tr>
						<th width="19" height="15" scope="row">考生姓名</th>
						<td width="18"><jsp:getProperty property="examName" name="examineeinfo" /></td>
						<td>性别</td><td><jsp:getProperty property="sex" name="examineeinfo" /></td>
					</tr>
					<tr>
						<th scope="row">学校</th>
						<td colspan="5"><jsp:getProperty property="school" name="examineeinfo" /></td>
					</tr>
					<tr>
						<th scope="row">考试类别</th>
						<td colspan="5"><jsp:getProperty property="examType" name="examineeinfo" /></td>
					</tr>
					<tr>
						<th scope="row">备注</th>
						<td colspan="5"><jsp:getProperty property="memo" name="examineeinfo" /></td>
					</tr>
				</table>
				<p>&nbsp;</p>
			</center>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>

</body>
</html>