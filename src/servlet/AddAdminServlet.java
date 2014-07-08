package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;
import vo.Admin;

public class AddAdminServlet extends HttpServlet {
	private String path = "../jsp/manager_add.jsp";
	private String failuer_path = null;
	private String adminSex = null;
	private HttpSession session = null;
	private List<Admin> allAdmin = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		session = request.getSession();
		boolean flag = false;
		String permission = (String) session.getAttribute("permission");
		System.out.println("登录的权限为"+ permission);
		if(permission.equals("SUPER_USER")){
			Admin admin = new Admin();
			
			String adminName = (String)request.getParameter("glymc");
			String adminPassword = (String)request.getParameter("mm");
			String adminPassword_ag= (String)request.getParameter("qrmm");
			String sex_num = request.getParameter("Item");
			String adminPhone = (String)request.getParameter("lxfs");
			
			if(sex_num.equals("0")){
				adminSex = "男";
			}if(sex_num.equals("1")){
				adminSex = "女";
			}
			
			System.out.println(adminName);
			System.out.println(adminPassword);
			System.out.println(adminPassword_ag);
			System.out.println(adminSex);
			System.out.println(adminPhone);
			
			admin.setAdminName(adminName);
			admin.setAdminPassword(adminPassword);
			admin.setAdminPhone(adminPhone);
			admin.setAdminSex(adminSex);
			
			try{
				flag = DAOFactory.getAdminDAOInstance().doCreate(admin);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(flag == false){
		//	response.sendRedirect(success_path);
			System.out.println("新建管理员失败");
			response.sendRedirect(path);
		}else{
			response.sendRedirect(path);
			session.removeAttribute("AllAdmin");
			try{
				allAdmin = DAOFactory.getAdminDAOInstance().showAllAdmin();
			}catch(Exception e){
				e.printStackTrace();
			}
			session.setAttribute("AllAdmin", allAdmin);
			System.out.println("新建管理员成功");
		}
	}

}
