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
import vo.Space;
import vo.SpaceRent;

public class SpaceRentDel extends HttpServlet {
	private String path = "../jsp/site_bookno.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean flag = false;
		String[] selectDel = request.getParameterValues("SpaceBookDel");
		List<SpaceRent> allSpaceRent = (ArrayList<SpaceRent>) session.getAttribute("AllSpaceRent");
		List<SpaceRent> findSpaceRent = (ArrayList<SpaceRent>)session.getAttribute("FindSpaceRent");
		
		if(findSpaceRent == null){
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				SpaceRent spaceRent = allSpaceRent.get(j);
				try {
					flag = DAOFactory.getSpaceRentDAOInstance().doDeleteSpaceRent(spaceRent.getspaceTypeName(), spaceRent.getSpaceNo(),spaceRent.getsStartTime(), spaceRent.getsEndTime());
					if(flag == true){
						System.out.println("预约删除成功");
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}else{
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				SpaceRent spaceRent = findSpaceRent.get(j);
				try {
					flag = DAOFactory.getSpaceRentDAOInstance().doDeleteSpaceRent(spaceRent.getspaceTypeName(), spaceRent.getSpaceNo(),spaceRent.getsStartTime(), spaceRent.getsEndTime());
					if(flag == true){
						System.out.println(spaceRent.getSpaceNo() + "预约删除成功");
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(flag){
			try {
				allSpaceRent = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.removeAttribute("AllSpaceRent");
			session.removeAttribute("FindSpaceRent");
			session.setAttribute("AllSpaceRent", allSpaceRent);
		}
		
		response.sendRedirect(path);
	}
}
