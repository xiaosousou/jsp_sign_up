package myservlet.controls;

import java.io.*;
import javax.servlet.*;
import mybean.data.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandRegister extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	public String handleString(String s) {
		try {
			byte bb[]=s.getBytes("iso-8859-1");
			s=new String(bb,"utf-8");
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
		return s;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		registerBean reg=new registerBean();
		req.setAttribute("register", reg);
		String examID=req.getParameter("examID").trim(),
				examName=req.getParameter("examName").trim(),
				sex=req.getParameter("sex").trim(),
				password=req.getParameter("password").trim(),
				examType=req.getParameter("examType").trim(),
				school=req.getParameter("school").trim(),
				memo=req.getParameter("memo").trim(),
				backmessage="",
				pic="";

		examID=handleString(examID);
		examName=handleString(examName);
		sex=handleString(sex);
		password=handleString(password);
		examType=handleString(examType);
		school=handleString(school);
		memo=handleString(memo);
		pic=handleString(pic);
		
		System.out.println(examID+" "+examName+" "+sex+" "+password+" "+examType+" "+ school+" "+memo+ " "+backmessage+" "+pic);
		int result=0;
		try {
			examineeBll exambll=new examineeBll();
			result=exambll.CreateExaminee(examID, examName, sex, password, examType, school,memo,pic);
			if(result==0) {
				backmessage="身份证或密码不符合要求！请重新报考！";
				reg.setBackMessage(backmessage);
			}
			if(result==-1) {
				backmessage="数据库访问发生错误！";
				reg.setBackMessage(backmessage);
			}
			if(result==-2) {
				backmessage="身份证号码已存在";
				reg.setBackMessage(backmessage);
			}
			if(result==1) {
				backmessage="报名成功";
				reg.setBackMessage(backmessage);
				reg.setExamID(examID);
				reg.setExamName(examName);
				reg.setExamType(examType);
				reg.setPassword(password);
				reg.setSchool(school);
				reg.setMemo(memo);
				reg.setSex(sex);
				reg.setPic(pic);
			}
		}catch(Exception ex) {
			backmessage="发生错误！"+ex.toString();
			reg.setBackMessage(backmessage);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("showRegisterMess.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
