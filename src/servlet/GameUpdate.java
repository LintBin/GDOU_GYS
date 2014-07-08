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

public class GameUpdate extends HttpServlet {
	private String path = "../jsp/game_update.jsp";
	private HttpSession session = null;
	private boolean flag = false;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		session = request.getSession();
		Game oldGame = (Game) session.getAttribute("SelecGame");
		List<Game> allGame = null;
		Game game = new Game();
		String spaceClassName = new GetSpaceName().getSpaceName(request.getParameter("Item"));
		String spaceNo = request.getParameter("cdbh");
		String gameName = request.getParameter("ssmc");
		String gameApplyer = request.getParameter("sssqr");
		String gameHost = request.getParameter("sszbf");
		String startTime = request.getParameter("timestart");
		String endTiem = request.getParameter("timeup");
		String phoneNum = request.getParameter("lxdh");
		
		System.out.println("gameApplyer=" + gameApplyer);
		System.out.println("gameHost=" + gameHost);
		System.out.println("gameName=" + gameName);
		System.out.println("getGameNo=" + oldGame.getGameNo());
		System.out.println("endTiem=" + endTiem);
		System.out.println("startTime=" + startTime);
		System.out.println("phoneNum=" + phoneNum);
		System.out.println("spaceNo=" + spaceNo);
		System.out.println("spaceClassName=" + spaceClassName);
		
		game.setGameHead(gameApplyer);
		game.setGameHost(gameHost);
		game.setGameName(gameName);
		game.setGameNo(oldGame.getGameNo());
		game.setgEndTime(endTiem);
		game.setgStartTime(startTime);
		game.setHeadPhone(phoneNum);
		game.setSpaceNo(spaceNo);
		game.setSpaceTypeName(spaceClassName);
		
		try{
			flag = DAOFactory.getGameDAOInstance().doUpdate(game);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			try {
				allGame = DAOFactory.getGameDAOInstance().findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("AllGame", allGame);
			session.removeAttribute("SelecGame");
		}
		response.sendRedirect(path);
		
	}

}
