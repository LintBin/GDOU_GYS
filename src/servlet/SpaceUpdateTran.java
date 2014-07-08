package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Space;

public class SpaceUpdateTran extends HttpServlet {
	private String path = "../jsp/site_update_1.jsp";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] selectAdmin = request.getParameterValues("ChangeSpace");
		List<Space> findSpace = (List<Space>)session.getAttribute("FindSpace");
		List<Space> allSpace = (List<Space>)session.getAttribute("AllSpace");
		Space space = null;
		int num = Integer.valueOf(selectAdmin[0]);
		
		if(findSpace == null){
			space = allSpace.get(num);
		}else{
			space = findSpace.get(num);
		}
		
		session.setAttribute("selectUpdateSpace", space);
		response.sendRedirect(path);
		
	}

}
