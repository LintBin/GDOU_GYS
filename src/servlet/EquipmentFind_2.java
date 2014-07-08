package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.assist.GetEquipmentName;
import vo.Equipment;
import factory.DAOFactory;

public class EquipmentFind_2 extends HttpServlet {
	private String path = null;
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();
		path = (String) session.getAttribute("requestURL");
		String equipmentNameNO = request.getParameter("Item");
		String equipmentName = new GetEquipmentName().getRquimentName(equipmentNameNO);
		List<Equipment> allEquipment = null;
		
		
		
		try{
			allEquipment = DAOFactory.getEquipmentDAOInstance().findEquipment(equipmentName);
		}catch(Exception e){
			e.printStackTrace();
		}
		session.setAttribute("FindEquipment", allEquipment);
		session.removeAttribute("requestURL");
		response.sendRedirect(path);
	}

}
