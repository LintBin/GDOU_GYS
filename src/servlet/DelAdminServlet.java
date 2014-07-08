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

import vo.Admin;

import factory.DAOFactory;

public class DelAdminServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		int adminId ;
		DAOFactory factory = new DAOFactory();
		
		HttpSession session =  request.getSession();
		List<Admin> allAdmin = (ArrayList<Admin>) session.getAttribute("AllAdmin");
		List<Admin> delAdmin = (ArrayList<Admin>)session.getAttribute("selectAdmin");
		String[] selectDel = request.getParameterValues("adminDel");
		
		if(delAdmin==null){
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Admin showAdmin =  allAdmin.get(j);
				System.out.println(showAdmin.getAdminName());
				System.out.println("delAdmin为空");
				try {
					adminId = factory.getAdminDAOInstance().doShowIDbyName(showAdmin.getAdminName());
					flag = factory.getAdminDAOInstance().doDelete(adminId);
					if(flag == true){
						System.out.println(showAdmin.getAdminName());
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}else{
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Admin showAdmin =  delAdmin.get(j);
				System.out.println(showAdmin.getAdminName());
				System.out.println("allAdmin为空");
				try {
					adminId = factory.getAdminDAOInstance().doShowIDbyName(showAdmin.getAdminName());
					flag = factory.getAdminDAOInstance().doDelete(adminId);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		}
		
		if(selectDel==null){
			System.out.println("selectDel为空");
		}
		
		
		/*for(int num=0;num < selectDel.length;num++){
			System.out.println(num);
		}*/
		
		
		try {
			allAdmin = DAOFactory.getAdminDAOInstance().showAllAdmin(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("AllAdmin");
		session.setAttribute("AllAdmin", allAdmin); //刷新全部用户信息的列表
		session.removeAttribute("selectAdmin");
		if(flag == true){
			System.out.println("删除成功");
			response.sendRedirect("../jsp/manager_delete.jsp");
		}else{
			System.out.println("删除失败");
			response.sendRedirect("../jsp/manager_delete.jsp");
		}
		
	


	}
}
