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

import vo.Space;

import factory.DAOFactory;

public class SpaceDelServlet extends HttpServlet {

	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SpaceShow> showSpace =  new ArrayList<SpaceShow>();
		boolean flag = false;
		DAOFactory factory = new DAOFactory();
		HttpSession session =  request.getSession();
		String[] selectDel = request.getParameterValues("DelSpace");
		
		List<Space> allSpace = (List<Space>) session.getAttribute("AllSpace");
		List<Space> findSpace = (List<Space>) session.getAttribute("findSpace");
		
		if(findSpace == null){
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Space space = allSpace.get(j);
				String spaceNo = space.getSpaceNo(); 
				String spaceClass = space.getSpaceTypeName();
				try{
					flag = DAOFactory.getSpaceDAOInstance().doDeleteSpace(spaceClass, spaceNo);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}else{
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Space space = findSpace.get(j);
				String spaceNo = space.getSpaceNo();
				String spaceClass = space.getSpaceTypeName();
				try{
					flag = DAOFactory.getSpaceDAOInstance().doDeleteSpace(spaceClass, spaceNo);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		if(flag == true){
			session.removeAttribute("AllSpace");
			try {
				allSpace = DAOFactory.getSpaceDAOInstance().doQuerySpace(null,null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(allSpace.size());
			
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
		}
		session.setAttribute("ShowSpace", showSpace);
		session.removeAttribute("findSpace");
		session.setAttribute("AllSpace", allSpace);
		session.removeAttribute("requestURL");
		response.sendRedirect("../jsp/site_delete.jsp");
		
	}

}
