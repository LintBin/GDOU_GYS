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

import servlet.assist.GetSpaceName;
import vo.SpaceRent;

public class FindSpaceRent extends HttpServlet {
	private String path = ".../jsp/bookno.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String spaceClassNo = request.getParameter("Item");
		String applyer = request.getParameter("cdsqr");
		
		String spaceClass = new GetSpaceName().getSpaceName(spaceClassNo);
		
		List<SpaceRent> findSpace = null;
		try{
			findSpace = DAOFactory.getSpaceRentDAOInstance().doQuerySpaceRent(spaceClass,applyer);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(findSpace.get(0).getspaceTypeName());
		session.setAttribute("FindSpaceRent",findSpace);
		response.sendRedirect(path);
		
	}

}
