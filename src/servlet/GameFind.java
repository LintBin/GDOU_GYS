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

public class GameFind extends HttpServlet {
	private String path = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		path = (String) session.getAttribute("requestURL");
		String spaceClassName = new GetSpaceName().getSpaceName(request.getParameter("Item"));
		String spaceNo = request.getParameter("cdbh");
		String gameName = request.getParameter("ssmc");
		List<Game> findGame = null;
		if(spaceNo.equals("")){
			spaceNo = null;
		}if(gameName.equals("")){
			gameName = null;
		}
		
		try{
			findGame = DAOFactory.getGameDAOInstance().queryGame(spaceClassName, spaceNo, gameName);
		}catch(Exception e){
			e.printStackTrace();
		}
		session.removeAttribute("requestURL");
		session.setAttribute("FindGame",findGame);
		response.sendRedirect(path);
		
	}

}
