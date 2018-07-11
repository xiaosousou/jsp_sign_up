package myservlet.controls;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mybean.data.loginBean;
import mybean.data.uploadFileBean;
import myclass.bll.*;

public class HandleUploadFile extends HttpServlet {
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
				System.out.println("没登录");
				resp.sendRedirect("login.jsp");
			}else {
				System.out.println("登录了");
				String loginName=log.getLoginName();
				uploadFileMethod(req,resp,loginName);
			}
		}else {
			resp.sendRedirect("login.jsp");
		}
	}
	private void uploadFileMethod(HttpServletRequest req, HttpServletResponse resp,String loginName) throws ServletException, IOException{
		System.out.println("图片上传方法");
		uploadFileBean upFile=new uploadFileBean();
		String backMessage="";
		try {
			HttpSession session=req.getSession(true);
			req.setAttribute("upFile", upFile);
			System.out.println("将upFile添加到网页");
			String tempFileName=(String)session.getId();
			InputStream in=req.getInputStream();
			String saveFileName=loginName,driverPath="H:\\javaee\\Web_Examination_Registration_System\\WebContent\\image";
					//driverPath = req.getRealPath("image");
			System.out.println("文件名字savaFileName="+saveFileName+"文件路径driver"+driverPath);
			
			uploadFileBll upbll=new uploadFileBll();
			boolean flag=upbll.uploadFileMethod(driverPath, tempFileName, saveFileName, in);
			
			if(flag) {
				examineeBll exambll=new examineeBll();
				int n=exambll.setExamineePic(loginName, upbll.getSaveFileName());
				if(n==1) {
					backMessage="文件上传成功";
					upFile.setbackMessage(backMessage);
					upFile.setFileName(upbll.getUploadFileName());
					upFile.setsavedFileName(upbll.getSaveFileName());
				}else {
					backMessage="文件上传失败";
				}
			}else {
				backMessage="文件上传失败";
				upFile.setbackMessage(backMessage);
			}
		}catch(Exception exp){
			backMessage=""+exp;
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("showUploadMess.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
