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

public class AdminUpdateTran extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] selectAdmin = request.getParameterValues("adminUpdate");
		String adminNum = selectAdmin[0];
		boolean flag = false;
		List<Admin> allAdmin = (List<Admin>) session.getAttribute("AllAdmin");
		List<Admin> selectList = (List<Admin>) session.getAttribute("selectAdmin");
		Admin admin = null;
		int num = Integer.valueOf(selectAdmin[0]);
		if(selectList == null){
			admin = allAdmin.get(num);
		}else{
			admin = selectList.get(num);
		}
		String adminName = admin.getAdminName();
		System.out.println(adminName);
		session.setAttribute("request_admin",adminName);//将选中的用户名存入request域中
		
		response.sendRedirect("../jsp/manager_update_1.jsp");
	}

}
