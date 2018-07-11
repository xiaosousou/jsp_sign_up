package myservlet.controls;

import mybean.data.*;
import java.io.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleExit extends HttpServlet {
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
				logoutExam(req,resp);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	public void logoutExam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session=req.getSession(true);
		session.invalidate();
		resp.sendRedirect("index.jsp");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
