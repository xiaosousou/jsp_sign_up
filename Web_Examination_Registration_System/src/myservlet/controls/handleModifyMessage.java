package myservlet.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.data.loginBean;
import mybean.data.modifyMessageBean;
import myclass.bll.examineeBll;

public class handleModifyMessage extends HttpServlet {
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
		HttpSession session=req.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		if(log!=null) {
			boolean ok=log.isSuccess();
			if(ok==false) {
				resp.sendRedirect("login.jsp");
			}else {
				modifyExamMessage(req,resp);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	private void modifyExamMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		
		String loginName=log.getLoginName();
		modifyMessageBean modify=new modifyMessageBean();
		req.setAttribute("modify", modify);
		String examName=req.getParameter("examName").trim();
		String sex=req.getParameter("sex").trim();
		String examType=req.getParameter("examType").trim();
		String school=req.getParameter("school").trim();
		String memo=req.getParameter("memo").trim();
		
		
		loginName=handleString(loginName);
		examName=handleString(examName);
		sex=handleString(sex);
		examType=handleString(examType);
		school=handleString(school);
		memo=handleString(memo);
		System.out.println(loginName+examName+sex+examType+school+memo);
		examineeBll exambll=new examineeBll();
		
		int result=exambll.updateExaminByID(loginName, examName, sex, examType, school, memo);
		if(result==1) {
			modify.setBackMessage("修改报名信息成功");
			modify.setExamID(loginName);
			modify.setSex(sex);
			modify.setExamName(examName);
			modify.setExamType(examType);
			modify.setMemo(memo);
			modify.setSchool(school);
		}else if(result==-1) {
			modify.setBackMessage("考生姓名有错误！信息未修改");
		}else {
			modify.setBackMessage("修改信息失败！");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("showModifyMessage.jsp");
		dispatcher.forward(req, resp);
	}
}
