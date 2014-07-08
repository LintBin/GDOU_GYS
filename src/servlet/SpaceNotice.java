package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;

public class SpaceNotice extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String noticeTittle = request.getParameter("ggbt");
		String notice = request.getParameter("ggzw");
		
		System.out.println(noticeTittle);
		System.out.println(notice);
		boolean flag = false;
		try{
			flag = DAOFactory.getAnnouncementDAOInstance().doCreateAnnouncement(noticeTittle, noticeTittle);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			System.out.println("发送公告成功");
		}else{
			System.out.println("发送公告失败");
		}
		response.sendRedirect("../jsp/site_notice.jsp");
	}

}
