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

public class SpaceFind extends HttpServlet {
	private String path = null;
	private List<Space> findSelect = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String spaceClassNo = request.getParameter("Item");
		String spaceNo = request.getParameter("cdbh");
		
		String spaceClass = new GetSpaceName().getSpaceName(spaceClassNo);
		System.out.println(spaceClass);
		path = (String) session.getAttribute("requestURL");
		
		System.out.println(path);
		
		if(spaceNo.equals("")){
			spaceNo = null;
		}
		
		try{
			findSelect = DAOFactory.getSpaceDAOInstance().doQuerySpace(spaceClass,spaceNo); 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<SpaceShow> showSpace =  new ArrayList<SpaceShow>();
		for(int i=0;i<findSelect.size();i++){
    		SpaceShow spaceShow = new SpaceShow();
    		spaceShow.setSpace(findSelect.get(i));
    		int spaceFee = 0 ;
    		try{
    			spaceFee = DAOFactory.getSTypeFeesDAOInstance().doQuerySpaceFees(findSelect.get(i).getSpaceTypeName());
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		spaceShow.setSpaceTypeFee(spaceFee);
    		showSpace.add(spaceShow);
    	}
		System.out.println("FindShowSpace=" + showSpace.size());
		session.setAttribute("FindShowSpace", showSpace);
		
		
		
		session.removeAttribute("FindSpace");
		System.out.println("findSpace.size=" + findSelect.size());
		session.setAttribute("FindSpace",findSelect);
		session.removeAttribute("requestURL");
		response.sendRedirect(path);
		
		
	}

}
