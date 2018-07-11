package myservlet.controls;

import mybean.data.*;
import java.io.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleModifPwd extends HttpServlet {
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
				modifyPassword(req,resp);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	public void modifyPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		String loginName=log.getLoginName();
		passwordBean pwd=new passwordBean();
		req.setAttribute("password", pwd);
		String oldPassword=req.getParameter("oldPassword");
		String newPassword=req.getParameter("newPassword");
		examineeBll exambll=new examineeBll();
		int result=exambll.setExamineePwd(loginName, newPassword, oldPassword);
		if(result==0) {
			pwd.setBackMessage("密码不符合要求,未更新");
		}else if(result==-1) {
			pwd.setBackMessage("旧密码不正确，密码更新失败");
		}else {
			pwd.setBackMessage("更新成功");
			pwd.setNewPassword(newPassword);
			pwd.setOldPassword(oldPassword);
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("showModifyPassword.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
