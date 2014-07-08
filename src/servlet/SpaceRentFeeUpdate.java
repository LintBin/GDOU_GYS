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

import servlet.assist.GetSpaceName;
import vo.SpaceRent;

public class SpaceRentFeeUpdate extends HttpServlet {
	private String path = "../jsp/site_charge.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<SpaceRent> allSpaceRent = null;
		boolean flag = false;
		String spaceClassId = request.getParameter("Item");
		String spaceFee_Str = request.getParameter("cdsf");
		
		String spaceClass = new GetSpaceName().getSpaceName(spaceClassId);
		int spaceFee = Integer.valueOf(spaceFee_Str);
		System.out.println("spaceFee =" + spaceFee);
		try{
			flag = DAOFactory.getSTypeFeesDAOInstance().doUpdateSTypeFees(spaceClass, spaceFee);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag == true){
			try{
				allSpaceRent = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();
			}catch(Exception e){
				e.printStackTrace();
			}
			session.removeAttribute("AllSpaceRent");
			session.setAttribute("AllSpaceRent",allSpaceRent);//刷新更新后的全部租借信息
			
		}
		
		response.sendRedirect(path);
		
		
		
	}

}
