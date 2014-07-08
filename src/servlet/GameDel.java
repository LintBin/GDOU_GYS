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

import vo.Admin;
import vo.Game;

public class GameDel extends HttpServlet {
	private String path = "../jsp/game_cancel.jsp";
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String[] selectDel = request.getParameterValues("delGame");
		List<Game> findGame = (List<Game>) session.getAttribute("FindGame");
		List<Game> allGame = (List<Game>) session.getAttribute("AllGame");
		boolean flag = false;
		
		if(findGame==null){
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Game game =  allGame.get(j);
				try {
					flag =DAOFactory.getGameDAOInstance().doDelete(game.getGameNo());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			for(int i=0;i<selectDel.length;i++){
				int j = Integer.valueOf(selectDel[i]);
				Game game =  findGame.get(j);
				try {
					flag =DAOFactory.getGameDAOInstance().doDelete(game.getGameNo());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(flag){
			try {
				allGame = DAOFactory.getGameDAOInstance().findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("AllGame",allGame);
		}
		session.removeAttribute("FindGame");
		response.sendRedirect(path);

	}
}
