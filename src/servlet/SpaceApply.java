package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.assist.GetSpaceName;
import vo.SpaceRent;

import factory.DAOFactory;

public class SpaceApply extends HttpServlet {
	private boolean flag = false;
	private String path = "../jsp/site_bookno.jsp";
	private List<SpaceRent> allSpaceRent = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		boolean conflict = false;
		SpaceRent spaceRent = new SpaceRent();
		String spaceClassId = request.getParameter("Item");
		String spaceNo_Or = request.getParameter("spaceNo");
		String applyer = request.getParameter("cdsqr");
		String startTime = request.getParameter("Timestart");
		String endTime = request.getParameter("Timeup");
		
		String spaceTypeName = new GetSpaceName().getSpaceName(spaceClassId);
		String spaceNo = "00" + spaceNo_Or ;
		System.out.println("spaceNo:" + spaceNo);
		System.out.println(applyer);
		
		
		spaceRent.setsEndTime(endTime);
		spaceRent.setSpaceNo(spaceNo);
		spaceRent.setspaceTypeName(spaceTypeName);
		spaceRent.setsRentPeople(applyer);
		spaceRent.setsStartTime(startTime);
		
		try{
			conflict = DAOFactory.getSpaceRentDAOInstance().doCheckSpaceIsRent(spaceTypeName, spaceNo, startTime, endTime);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conflict){
			try{
				flag = DAOFactory.getSpaceRentDAOInstance().doCreateSpaceRent(spaceRent);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(flag == true){
				try {
					allSpaceRent = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("AllSpaceRent", allSpaceRent);
				System.out.println("申请成功");
			}else{
				System.out.println("申请失败");
			}
		}
		response.sendRedirect(path);
	}

}
