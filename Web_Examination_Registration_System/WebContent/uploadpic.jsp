<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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

<script type="text/javascript">
				function check()
				{
					if(myform.uploadFileName.value==""){
						alert("文件名不正确");
						myform.uploadFileName.focus();
						return false;
					}
				}
			</script>
			
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

				<form action="helpUpload" method="post" name="myform"
					ENCTYPE="multipart/form-data" onsubmit="return check()">
					<p>选择要上传的文件，文件必须是jpg\bmp\gif文件格式！ </p>
					<br>
					<table>
						<tr>
							<td><input type=file name="uploadFileName" size="40"
								id="uploadFileName"></td>
						</tr>
						<tr>
							<td align="center"><input type=submit name="g" value="提交"></td>
						</tr>
					</table>
				</form>
				<p>
					<% out.println(basePath); %><br>
					<% out.println(path); %>
				
			</center>
		</div>
		<br class="clearfloat" />
		<%@ include file="txtfile/footer.txt"%>
	</div>
</body>
</html>