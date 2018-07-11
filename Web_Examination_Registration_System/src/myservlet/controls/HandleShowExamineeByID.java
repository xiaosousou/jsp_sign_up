package myservlet.controls;

import mybean.data.*;
import java.io.*;
import myclass.bll.*;
import myclass.bol.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class HandleShowExamineeByID extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
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
				showExamineeByID(req,resp);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	public void showExamineeByID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("showExamineeByid");
		showExamineeByIDBean examineeinfo=new showExamineeByIDBean();
		req.setAttribute("examineeinfo", examineeinfo);
		
		HttpSession session=req.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		String loginName=log.getLoginName();
		
		//String examID=req.getParameter("examID");
		examineeBll exambll=new examineeBll();
		examinee exam=new examinee();
		exam=exambll.getExamineeByID(loginName);
			if(exam!=null) {
				System.out.println("查询的考生信息"+exam. getExamName()+exam. getExamID()+exam.getExamType()+exam.getSex()+exam.getSchool()+exam.getMemo());
				examineeinfo.setBackmessage("查询到的考生如下:");
				examineeinfo.setExamName(exam. getExamName());
				examineeinfo.setExamID(exam.getExamID());
				examineeinfo.setSex(exam.getSex());
				examineeinfo.setExamType(exam.getExamType());
				examineeinfo.setMemo(exam.getMemo());
				examineeinfo.setSchool(exam.getSchool());
				examineeinfo.setPic(exam.getPic());
			}else {
				examineeinfo.setBackmessage("未查询到该考生！");
			}
			RequestDispatcher dispatcher=req.getRequestDispatcher("showExamineeByID.jsp");
			dispatcher.forward(req, resp);
	}
}
