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
import vo.Space;

public class SpaceClassFeeFind extends HttpServlet {
	private String path = "../jsp/site_charge.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Space> findSpace = null;
		String spaceClassNo = request.getParameter("Item");
		String spaceClassName = new GetSpaceName().getSpaceName(spaceClassNo); 
		
		try{
			findSpace = DAOFactory.getSpaceDAOInstance().doQuerySpace(spaceClassName, null);
		}catch(Exception e){
			e.printStackTrace();
		}
		session.setAttribute("FindSpace", findSpace);
		response.sendRedirect(path);
	}

}
