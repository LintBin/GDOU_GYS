package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;

import vo.EquipmentRent;

public class EquipmentRentUpdate extends HttpServlet {
	private String path = "";
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		EquipmentRent temp_equip_rent = (EquipmentRent) session.getAttribute("tem");
		String eRentPeople = request.getParameter("qcsqr");
		temp_equip_rent.seteRentPeople(eRentPeople);
		try{
			DAOFactory.getEquipmentRentDAOInstance().doCreateEquipmentRent(temp_equip_rent);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
