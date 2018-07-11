package myservlet.controls;
import java.io.*;
import mybean.data.loginBean;
import mybean.data.showExamineeByPage;
import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleShowExamineeByPage extends HttpServlet {
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request ,HttpServletResponse
			response) throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		if(log!=null) {
			boolean ok=log.isSuccess();
			if(ok==false) {
				response.sendRedirect("login.jsp");
			}
			else {
				showExamineeByPage(request,response);
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	public void showExamineeByPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		StringBuffer presentPageResult=new StringBuffer();
		showExamineeByPage showBean=null;
		try{
			showBean=(showExamineeByPage)session.getAttribute("examineebypage");
			if(showBean==null) {
				showBean=new showExamineeByPage();
				session.setAttribute("examineebypage", showBean);
			}
		}
		catch(Exception exp) {
			showBean=new showExamineeByPage();
			session.setAttribute("examineebypage", showBean);
		}
		showBean.setPageSize(3);
		String strShowPage=request.getParameter("showPage");
		System.out.println("上下页页码"+strShowPage);
		for(int i=0;i<strShowPage.length();i++) {
			char c=strShowPage.charAt(i);
			if(!(c>='0' && c<='9'))
			{
				strShowPage="1";
				break;
			}
		}
		if(strShowPage=="") {
			strShowPage="1";
		}
		int showPage=Integer.parseInt(strShowPage);
		int pageSize=showBean.getPageSize();
		
		try {
			examineeBll examBll=new examineeBll();
			showBean.setList(examBll.getExamineeAll());
			int m=showBean.getList().size();
			int n=pageSize;
			int pageAllCount=((m%n)==0)?(m/n):(m/n+1);
			System.out.println("总共考生数m="+m+"最大页码"+pageAllCount);
			showBean.setPageAllCount(pageAllCount);
			if(showPage>showBean.getPageAllCount()) {
				showPage=1;
			}
			if(showPage<=0) {
				showPage=showBean.getPageAllCount();
			}
			showBean.setShowPage(showPage);
			presentPageResult=show(showPage,pageSize,showBean);
			showBean.setPresentPageResult(presentPageResult);
		}
		catch(Exception exp) {
			System.out.println(exp.toString());
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("showExamineeAll.jsp");
		dispatcher.forward(request, response);
	}
	public StringBuffer show(int page,int pageSize,showExamineeByPage showBean) {
		StringBuffer str=new StringBuffer();
		try {
			for(int i=(page-1)*pageSize;i<=page*pageSize-1;i++) {
				
				String examName=showBean.getList().get(i).getExamName();
				String examType=showBean.getList().get(i).getExamType();
				String sex=showBean.getList().get(i).getSex();
				String School=showBean.getList().get(i).getSchool();
				System.out.println(examName+" "+examType+" "+sex+" "+School);
				str.append("<tr>");
				str.append("<td>"+examName+"</td>");
				str.append("<td>"+examType+"</td>");
				str.append("<td>"+sex+"</td>");
				str.append("<td>"+School+"</td>");
				str.append("</tr>");
			}
		}
		catch(Exception exp) {
			return str;
		}
		return str;
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
}
