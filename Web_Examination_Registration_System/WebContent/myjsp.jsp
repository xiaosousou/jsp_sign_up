<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="java.sql.*"%>
<%@ page import="myclass.bol.*"%>
<%@ page import="myclass.dal.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1234
<%
	DBAccess dba=new DBAccess();
	examineeDal examd=new examineeDal();
	ArrayList<examinee> list=new ArrayList<examinee>();
	try{
		int rsult=examd.CreateExaminee("1234567891234567891", "小刘", "男", "123456","计算机类", "长江之夜学院", "sdfsdf","pic");
		out.println(rsult);
		dba.getConnection();
		if(dba.getConn()!=null){
			out.println("已经获得DataSource!");
			out.println("<br>");
			String str="select * from examinee";
			ResultSet rst=dba.query(str);
			out.println("以下是从数据库读出的数据:<br>");
			while(rst.next()){
				out.println("<br>");
				out.println(rst.getString(1));
				out.println(rst.getString(2));
				out.println(rst.getString(3));
				out.println(rst.getString(4));
				out.println(rst.getString(5));
				out.println(rst.getString(6));
				out.println(rst.getString(7));
				out.println(rst.getString(8));
			}
			out.println("<br>系统时间"+DBAccess.getSysDate());
			examinee exambean=null;
			exambean=examd.getExamineeByID("1234567891234567891");
			out.println("<br><br>"+exambean.getExamID());
			list=examd.getExamineeAll();
			for(examinee e:list){
				out.println("<br>这是通过ArraryList得到的值"+e.getExamID());
			}
		}
	}catch(Exception ne){
		out.println("出现如下错误<br>");
		out.println(ne);
	}finally{
		dba.closeConnection();
		out.println("<br>已经关闭dateSource");
	}
%>
</body>
</html>