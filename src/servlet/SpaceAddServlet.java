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
import servlet.assist.*;
public class SpaceAddServlet extends HttpServlet {
	
	private boolean flag = false;
	private String failPath = null;
	private String succPath = "../jsp/site_add.jsp";
	private Space space = new Space();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		List<Space> allSpace = null;
		int adminID = (Integer) session.getAttribute("AdminID"); //取得用户ID
		String spaceClassNo = request.getParameter("Item");
		System.out.println("选中项为" + spaceClassNo);
		String spaceNo = request.getParameter("cdbh"); //取得场地编号
		String spaceCharge_str = request.getParameter("cdsf");
		String spaceDes = request.getParameter("cdms");//取得场地描述
		
		System.out.println("successfully-!->"+spaceDes);
		
		
		
		
		String StringClass = new GetSpaceName().getSpaceName(spaceClassNo);//取得场地类型
		
		
		int spaceCharge_int = Integer.valueOf(spaceCharge_str); //取得场地收费
	
		System.out.println("场地类型" + StringClass);
		System.out.println("用户名ID:" + adminID);
		System.out.println("场地编号:" + spaceNo);
		System.out.println("场地费用:" +spaceCharge_int);
		System.out.println("场地描述---:" +spaceDes);
		
		try {
			flag = DAOFactory.getSpaceDAOInstance().doCreateSpace(StringClass, spaceNo,adminID, spaceCharge_int, spaceDes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag==true){
			try{
				allSpace = DAOFactory.getSpaceDAOInstance().doQuerySpace(null, null);
			}catch(Exception e){
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
			session.setAttribute("ShowSpace", showSpace);
			session.setAttribute("AllSpace", allSpace);
			response.sendRedirect(succPath);
			System.out.println("创建场地成功");
		}else{
			System.out.println("创建场地失败");
		}
	}

}
