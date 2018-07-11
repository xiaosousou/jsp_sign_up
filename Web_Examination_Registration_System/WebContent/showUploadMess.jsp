<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="mybean.data.*"%>
<jsp:useBean id="upFile" type="mybean.data.uploadFileBean"
	scope="request" />
<%
String path=request.getContextPath();
String basePath = 
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath %>>">
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
					<font size=4 color=red>欢迎您使用图片上传功能！</font>
				</p>
			</center>
			<center>
				
				<font size=2 color=blue> 
					<br><jsp:getProperty name="upFile" property="backMessage" /> 
						上传的文件名：<jsp:getProperty name="upFile" property="fileName" /> 
					<br>保存后的文件名：<jsp:getProperty name="upFile" property="savedFileName" /> 
					<br>
				</font> 
				<img src="image/<jsp:getProperty name="upFile" property="savedFileName" />" width=150 height=120>图像效果
			</center>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>
</body>
</html>