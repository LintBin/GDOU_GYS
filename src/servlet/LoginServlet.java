package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.SpaceShow;

import vo.Admin;
import vo.Equipment;
import vo.EquipmentRent;
import vo.Game;
import vo.LoginBean;
import vo.Space;
import vo.SpaceRent;
import factory.DAOFactory;


public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Admin> allAdmin = new ArrayList<Admin>();
		List<Space> allSpace = new ArrayList<Space>();
		List<SpaceRent> allSpaceRent = null;
		List<Game> allGame = null;
		List<Equipment> allEquipment = null;
		List<EquipmentRent> allEquimentRent = null;
		int adminID = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		LoginBean loginBean = new LoginBean();
    	loginBean.setLoginName(username);
    	loginBean.setLoginPassword(password);
    	boolean user_flag = false;
    	boolean super_flag = false;
    	try{
    		super_flag = DAOFactory.getLoginDAOInstance().superUserLogin(loginBean);//超级用户登录
    		user_flag = DAOFactory.getLoginDAOInstance().adminLogin(loginBean);//普通管理员登录
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	try{
    		adminID = DAOFactory.getAdminDAOInstance().doShowIDbyName(username);
    		allAdmin = DAOFactory.getAdminDAOInstance().showAllAdmin();//取到所有所有普通用户的信息
    		allSpace = DAOFactory.getSpaceDAOInstance().doQuerySpace(null, null);//取得所有场地的信息
    		allSpaceRent = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();//取得所有场地租借的信息
    		allEquipment = DAOFactory.getEquipmentDAOInstance().showAllEquipment();//取得所有的器材信息
    		allEquimentRent = DAOFactory.getEquipmentRentDAOInstance().showAllEquipmentRent();//取得所有器材的信息
    		allGame = DAOFactory.getGameDAOInstance().findAll();
    	}catch(Exception e){
    		e.printStackTrace();
    	}if(super_flag == true && user_flag == true){
    		response.sendRedirect("../login.jsp"); 
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
    	
    	if(super_flag){
    		session.setAttribute("permission", "SUPER_USER");
    		session.setAttribute("AllAdmin", allAdmin);//超级用户登录
    	}if(user_flag){
    		session.setAttribute("permission", "COMMON_USER");
    		session.setAttribute("AllAdmin", allAdmin);//普通管理员登录
    	}
    	
    	session.setAttribute("ShowSpace", showSpace);
		session.setAttribute("AdminID", adminID);
    	session.setAttribute("AllAdmin", allAdmin);//将所有的用户信息存到session
		session.setAttribute("AllSpace", allSpace);//将所有场地信息存到session
		session.setAttribute("AllSpaceRent", allSpaceRent);
		session.setAttribute("AllEquipment", allEquipment);
		session.setAttribute("AllEquimentRent", allEquimentRent);
		session.setAttribute("AllGame",allGame);
		
	//	System.out.println(allSpace.get(0).getSpaceTypeName());
		
		if(super_flag == true || user_flag == true){
			response.sendRedirect("../jsp/index.jsp");
			session.removeAttribute("msg");
			session.setAttribute("username", username);//将用户名存到session
			session.setAttribute("password", password);
		}else{
			session.setAttribute("msg", "账号或密码错误");
			response.sendRedirect("../login.jsp");
		}
		
	}

}
