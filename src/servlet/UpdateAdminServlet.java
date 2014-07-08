package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Admin;

import factory.DAOFactory;

public class UpdateAdminServlet extends HttpServlet {
	private String path = "../jsp/manager_update.jsp";
	private List<Admin> allAdmin = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		boolean flag = false;
		String username  = request.getParameter("glymc");
		String password = request.getParameter("mm");
		String passwordAg = request.getParameter("qrmm");
		String admin_sex_Str = request.getParameter("Item");
		String admin_phone = request.getParameter("lxfs");
		String admin_sex = null;
		
		
		
		if(admin_sex_Str.equals("1")){
			admin_sex = "女";
		}else{
			admin_sex = "男";
		}
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(passwordAg);
		System.out.println(admin_sex);
		System.out.println(admin_phone);
		
		
		
		try{
			flag = DAOFactory.getAdminDAOInstance().doUpdate(username,password,admin_sex,admin_phone);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag == false){
			System.out.println("修改失败");
		}else{
			System.out.println("修改成功");
		}
		
		session.removeAttribute("AllAdmin");
		
		try {
			allAdmin = DAOFactory.getAdminDAOInstance().showAllAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("request_admin");
		session.removeAttribute("AllAdmin");
		session.setAttribute("AllAdmin",allAdmin);//刷新session里面的所有用户信息
		response.sendRedirect(path);
	}

}
