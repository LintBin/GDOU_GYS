package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;

import vo.Admin;

public class FindAdminServlet extends HttpServlet {
	private String path = null;
	private List<Admin> selectAdmin = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		path = (String)session.getAttribute("requestURL");
		String adminName = request.getParameter("glymc");
		String adminSex = request.getParameter("Item");
		String admin_phone = request.getParameter("lxfs");
		
		if(adminSex.equals("0")){
			adminSex = "男";
		}else{
			adminSex = "女";
		}
		
		
		
		if("".equals(adminName)){
			adminName = null;
		}if("".equals(admin_phone)){
			admin_phone = null;
		}if("".equals(adminSex)){
			adminSex = null;
		}
		
		System.out.println("path:" + path);
		System.out.println("adminName:" + adminName);
		System.out.println(adminSex);
		System.out.println(admin_phone);
		
		
		
		try{
			selectAdmin = DAOFactory.getAdminDAOInstance().queryAdmin(adminName, adminSex, admin_phone);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("选中的数量"+selectAdmin.size());
		session.setAttribute("selectAdmin", selectAdmin);
		session.removeAttribute("requestURL");
		response.sendRedirect(path);
		
	}
}
