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

import vo.Game;

public class GameUpdateTran extends HttpServlet {
	private String path = "../jsp/game_update_1.jsp";
	private HttpSession session = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String selectGame[] = request.getParameterValues("GameUpate");
		List<Game> findGame = (List<Game>) session.getAttribute("FindGame");
		List<Game> allGame = (List<Game>) session.getAttribute("AllGame");
		int num = Integer.valueOf(selectGame[0]);
		Game game = null;
		if(findGame == null){
			game = allGame.get(num);
		}else{
			game = findGame.get(num);
		}
		System.out.println(game.getGameHead());
		session.setAttribute("SelecGame", game);
		response.sendRedirect(path);
	}

}
