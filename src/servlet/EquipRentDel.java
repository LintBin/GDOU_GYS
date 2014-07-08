package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.EquipmentRent;
import factory.DAOFactory;

public class EquipRentDel extends HttpServlet {
	private HttpSession session = null;
	private String path = "../jsp/equipment_borrowno.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		List<EquipmentRent> findquipRent = (List<EquipmentRent>) session.getAttribute("FindEquipRent");
		String[]  equipRentDel= request.getParameterValues("equipmentDel");
		boolean flag = false;
		for(int i=0;i<equipRentDel.length;i++){
			int j = Integer.valueOf(equipRentDel[i]);
			EquipmentRent equipmentRent =  findquipRent.get(j);
			try {
				flag = DAOFactory.getEquipmentRentDAOInstance().doReEquipment(equipmentRent.geteTypeName(), equipmentRent.getRentNumber());
				DAOFactory.getEquipmentRentDAOInstance().doDeleteEquipmentRent(equipmentRent.geteRentID());
				if(flag == true){
					findquipRent = DAOFactory.getEquipmentRentDAOInstance().showAllEquipmentRent();
					session.setAttribute("FindEquipRent",findquipRent);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect(path);
		}
	}
	

}
