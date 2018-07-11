<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="mybean.data.registerBean" %>
<jsp:useBean id="register" type="mybean.data.registerBean" scope="request"/>
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
           <%@ include file="txtfile/header.txt" %>
         </div>
        <div id="sidebar1">
            <%@ include file="txtfile/left.txt"%>
        </div>
        <div id="mainContent">
            <center><p><font size=4 color=red>欢迎您来到修改报考信息！ </font></p></center>
        <blockquote>
            <center>
                <form action="helpModifyMessage" name=form method="post" onsubmit="return check() ">
                    <jsp:getProperty name="register" property="backMessage" />
                    <p>
                    <table bgcolor="#CCFFCC">
                    <tr><td>考生姓名:</td><td><input name="examName" type=text id="examName" value=<jsp:getProperty property="examName" name="register"/>></td></tr>
                    <tr><td>考生性别: </td><td>
                    <% if("男".equals(register.getSex())){%>
                        <input name="sex" type=radio id="sex" value="男" checked="default">男
                        <input type=radio name="sex" value="女" id="sex" >女
                    <%}else{%>
                        <input name="sex" type=radio id="sex" value="男" >男
                        <input type=radio name="sex" value="女" id="sex" checked="default">女
                    <% } %>
                    </td></tr>
                    <tr>
                    <td>学校</td><td><Input name="school" type=text id="school" value=<jsp:getProperty name="register" property="school" />></td></tr>
                    <tr>
                    <td>报考类别：</td><td>
                    
                    <select name="examType" size=2>
                    <% if("高级".equals(register.getExamType())){ %>
                           <option Selected value="高级">高级</option>
                           <option value="中级">中级</option>
                    <%}
                    else{ %>
                           <option value="高级">高级</option>
                           <option Selected value="中级">中级</option>
                    <%} %>
                    </select>
                    </td>
                    </tr>
                    <tr><td>备注：</td><td> <TextArea name="memo" Rows="6" Cols="30"><jsp:getProperty name="register" property="memo"/></TextArea>
                    </td></tr>

                     <tr><td></td><td align="center" >
                        <input type="submit" value="提交" name="submit" >
                        <input type="reset" value="重置" name="submit" ></td></tr>
                     </table>
         </form>
         </center>
         </blockquote>
     </div>
     <br class="clearfloat" />
     <%@ include file="txtfile/footer.txt" %>   
     </div>
</body>
</html>