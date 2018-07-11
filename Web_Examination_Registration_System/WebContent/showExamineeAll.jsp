<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*" %>
<jsp:useBean id="examineebypage" type="mybean.data.showExamineeByPage" scope="session"/>
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
			<center>
				<p>
					<font size=4 color=red>欢迎您使用登录功能！</font>
				</p>
			</center>
			<center>
			<p>显示考生信息。每页最多显示
			<jsp:getProperty property="pageSize" name="examineebypage" />
			当前显示第
			<jsp:getProperty property="showPage" name="examineebypage" />
			页，共有
			<jsp:getProperty property="pageAllCount" name="examineebypage" />
			页。当前显的示内容是：	
			</center>
			<center>
				<table width="318" border="1">
					<tr>
						<th>姓名</th>
						<th>类别</th>
						<th>性别</th>
						<th>学校</th>
					</tr>
					<jsp:getProperty property="presentPageResult" name="examineebypage" />
				</table>
				<p>单击"前一页"或"后一页"按钮查看信息
				<table>
					<tr>
						<td>
							<form action="helpShowExamineeByPage" method="post">
								<input type=hidden name="showPage" value="<%=examineebypage.getShowPage() - 1%>">
								<input type="submit" name="g" value="前一页">
							</form>
						</td>
						<td>
							<form action="helpShowExamineeByPage" method="post">
								<input type=hidden name="showPage" value="<%=examineebypage.getShowPage() + 1%>">
								<input type="submit" name="g" value="后一页">
							</form>
						</td>
						<td>
						<form action="helpShowExamineeByPage" method="post">
							输入页码：<input type=text name="showPage" size=5> 
							<input type="submit" name="g" value="提交">
						</form>
						</td>
					</tr>
				</table>
			</center>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>
</body>
</html>