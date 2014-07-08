package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Admin;

import factory.DAOFactory;

public class ShowAllAdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Admin> allAdmin = new ArrayList<Admin>();
		HttpSession session =  request.getSession();
		try {
			allAdmin = DAOFactory.getAdminDAOInstance().showAllAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("AllAdmin", allAdmin);
	}

}
