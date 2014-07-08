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

import bo.SpaceShow;

import factory.DAOFactory;

import servlet.assist.GetSpaceName;
import vo.Space;

public class SpaceUpdateServ extends HttpServlet {
	private String path = "../jsp/site_update.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到场地修改");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		List<Space> allSpace = null;
		boolean flag = false;
		String spaceClassId = request.getParameter("Item");
		String spaceNo = request.getParameter("cdbh");
		String spaceCharge_Str = request.getParameter("cdsf");
		String spaceDesp = request.getParameter("cdms");
		
		int spaceCharge_int = Integer.valueOf(spaceCharge_Str);
		String spaceClass = new GetSpaceName().getSpaceName(spaceClassId);
		
		System.out.println("spaceNo" + spaceNo);
		System.out.println("spaceClass" + spaceClass);
		System.out.println("spaceCharge_int" + spaceCharge_int);
		System.out.println("spaceDesp" + spaceDesp);
		try{
			flag =DAOFactory.getSpaceDAOInstance().doUpdateSpace(spaceClass,spaceNo, spaceCharge_int,spaceDesp);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag == true){
			System.out.println("修改成功");
			try {
				allSpace = DAOFactory.getSpaceDAOInstance().doQuerySpace(null, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<SpaceShow> showSpace =  new ArrayList<SpaceShow>();
			for(int i=0;i<allSpace.size();i++){
	    		SpaceShow spaceShow = new SpaceShow();
	    		spaceShow.setSpace(allSpace.get(i));
	    		int spaceFee = 0 ;
	    		try{
	    			spaceFee = DAOFactory.getSTypeFeesDAOInstance().doQuerySpaceFees(allSpace.get(i).getSpaceTypeName());
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    		spaceShow.setSpaceTypeFee(spaceFee);
	    		showSpace.add(spaceShow);
	    	}
			System.out.println("ShowSpace=" + showSpace.size());
			session.setAttribute("ShowSpace", showSpace);
			session.setAttribute("AllSpace",allSpace);
		}
		session.removeAttribute("selectUpdateSpace");
		response.sendRedirect(path);
		
		
		
	}

}
