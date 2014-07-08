package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.assist.GetSpaceName;
import vo.SpaceRent;

import factory.DAOFactory;

public class SpaceRentFind extends HttpServlet {
	private String path = "../jsp/site_bookno.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String spaceClassNo = request.getParameter("Item");
		String spaceApplyer = request.getParameter("cdsqr");
		
		
		String spaceClass = new GetSpaceName().getSpaceName(spaceClassNo);
		List<SpaceRent> spaceRentSelect = null;
		
		try{
			spaceRentSelect = DAOFactory.getSpaceRentDAOInstance().doQuerySpaceRent(spaceClass,spaceApplyer);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("查询到的场地租借有" + spaceRentSelect.size());
		
		session.setAttribute("FindSpaceRent",spaceRentSelect);
		response.sendRedirect(path);
		
		
	
	}

}
