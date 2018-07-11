package myclass.bll;

import java.util.ArrayList;

import myclass.bol.examinee;
import myclass.dal.examineeDal;

public class examineeBll {
	//添加考生数据的方法
	public int CreateExaminee(String examID,String examName,String sex,String password,String examType,String school,String memo,String pic) {
		examineeDal examDal=new examineeDal();
		int result=0;
		if((examID.length()==15)||examID.length()==18&&password.length()>0) {
			boolean isLD=true;
			for(int i=0;i<examID.length();i++) {
				char c=examID.charAt(i);
				if(!((c<='z'&&c>='a')||(c<='Z')&&(c>='A')||(c<='9')&&(c>='0'))) {
					isLD=false;
				}
			}
			if(isLD==true&&examDal.getExamineeByID(examID)!=null) {
				return result=-2;
			}
			if(isLD=true) {
				result=examDal.CreateExaminee(examID, examName, sex, password, examType, school, memo,pic);
			}
		}else {
			System.out.println("身份证号或密码不符合要求！");
			System.out.println("函数返回值"+result);
		}
		return result;
	}
	//考生登录的方法
	public int examineeLogin(String examID,String password) {
		examineeDal examDal=new examineeDal();
		int result=0;
		if((examID.length()==15||examID.length()==18)&&password.length()>0) {
			examinee exam=null;
			exam=examDal.getExamineeByIdpwd(examID, password);
			if(exam!=null) {
				result=1;
			}else {
				result=-1;
			}
		}
		return result;
	}
	//储存照片文件名
	public int setExamineePic(String examID,String picStr) {
		examineeDal examDal=new examineeDal();
		return examDal.setExamineePic(examID,picStr);
	}
	//返回examinee对象
	public examinee getExamineeByID(String examID) {
		examinee exam = null;
		examineeDal examdal=new examineeDal();
		exam=examdal.getExamineeByID(examID);
		return exam;
	}
	//返回examinee数组
	public ArrayList<examinee> getExamineeAll(){
		examineeDal examdal=new examineeDal();
		return examdal.getExamineeAll();
	}
	//设置用户名密码
	public int setExamineePwd(String examID,String newPassword,String oldPassword) {
		int result=0;
		examineeDal examdal=new examineeDal();
		if(newPassword==""||newPassword.equals(oldPassword)) {
			return result;
		}
		if(examdal.getExamineeByIdpwd(examID, oldPassword)!=null) {
			result=examdal.setExaminePwd(examID, newPassword);
		}else {
			result=-1;
		}
		return result;
	}
	//更新考生信息
	public int updateExaminByID(String examID,String examName,String sex,String examType,String school,String memo) {
		System.out.println("更新考生数据");
		examineeDal examdal=new examineeDal();
		int result=0;
		if(examName.length()>0) {
			result=examdal.updateExamineeByID(examID, examName, sex, examType, school, memo);
		}else {
			return result=-1;
		}
		return result;
	}
	//删除考生信息
	public int deleteExamineeByID(String examID) {
		examineeDal examdal=new examineeDal();
		int result=0;
		if(examID==null) {
			result=-2;
		}
		if(examID.length()>0) {
			result=examdal.deleteExmineeByID(examID);
		}
		return result;
	}
}
