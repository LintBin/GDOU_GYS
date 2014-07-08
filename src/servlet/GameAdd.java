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
import vo.Game;

public class GameAdd extends HttpServlet {
	private String path = "../jsp/game_apply.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int adminId = (Integer) session.getAttribute("AdminID");
		String spaceClassNo = request.getParameter("Item");
		String spaceNo = request.getParameter("cdbh");
		String startTime = request.getParameter("timestart");
		String endTime = request.getParameter("timeup");
		String matchName = request.getParameter("ssmc");
		String matchHost = request.getParameter("sszbf");
		String macthApplyer = request.getParameter("sssqr");
		String phoneNum = request.getParameter("lxdh");
		boolean flag = false;
		boolean rentConflict = false; 
		boolean gameConflict = false;
		String spaceClassName = new GetSpaceName().getSpaceName(spaceClassNo);
		Game game = new Game();
		game.setSpaceTypeName(spaceClassName);
		game.setSpaceNo(spaceNo);
		game.setAdminID(adminId);
		game.setGameName(matchName);
		game.setgStartTime(startTime);
		game.setgEndTime(endTime);
		game.setGameHost(matchHost);
		game.setHeadPhone(phoneNum);
		game.setGameHead(macthApplyer);
		
		
		System.out.println("spaceClassName" + spaceClassName);
		System.out.println("spaceNo" + spaceNo);
		System.out.println("adminId" + adminId);
		System.out.println("matchName"+matchName);
		System.out.println("startTime"+startTime);
		System.out.println("endTime"+endTime);
		System.out.println("matchHost"+matchHost);
		System.out.println("phoneNum"+phoneNum);
		System.out.println("macthApplyer"+macthApplyer);
		
		try{
			gameConflict = DAOFactory.getGameDAOInstance().doCheckSpaceIsRent(spaceClassName, spaceNo, startTime, endTime);
			rentConflict = DAOFactory.getSpaceRentDAOInstance().doCheckSpaceIsRent(spaceClassName, spaceNo, startTime, endTime);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(gameConflict==true && rentConflict==true){
			try{
				flag = DAOFactory.getGameDAOInstance().doCreate(game);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			List<Game> allGame = null;
			
			if(flag){
				try {
					allGame = DAOFactory.getGameDAOInstance().findAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
				session.setAttribute("AllGame", allGame);
			}
		}
		response.sendRedirect(path);
	}
}
