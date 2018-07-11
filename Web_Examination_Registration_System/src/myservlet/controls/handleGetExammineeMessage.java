package myservlet.controls;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import mybean.data.*;
import myclass.bll.*;
import myclass.bol.*;

public class handleGetExammineeMessage extends HttpServlet {
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
				getExamMessage(req,resp);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	public void getExamMessage(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		HttpSession session=req.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		String loginName=log.getLoginName();
		registerBean reg=new registerBean();
		req.setAttribute("register",reg);
		examineeBll exambll=new examineeBll();
		examinee exam=new examinee();
		exam=exambll.getExamineeByID(loginName);
		System.out.println("loginanem"+loginName);
		if(exam!=null) {
			reg.setBackMessage("您原来的报名信息：");
			reg.setSchool(exam.getSchool());
			reg.setExamName(exam.getExamName());
			reg.setExamType(exam.getExamType());
			reg.setMemo(exam.getMemo());
			reg.setSex(exam.getSex());
		}
		else {
			reg.setBackMessage("获取用户信息发生错误！");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("modifymessage.jsp");
		dispatcher.forward(req, resp);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		doPost(req,resp);
	}
}
