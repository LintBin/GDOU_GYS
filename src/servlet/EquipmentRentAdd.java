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

import servlet.assist.GetEquipmentName;
import vo.EquipmentRent;

public class EquipmentRentAdd extends HttpServlet {
	private String path = "../jsp/equipment_borrowno.jsp";
	private HttpSession session = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		EquipmentRent applyequipRent = (EquipmentRent) session.getAttribute("tem");
		request.setCharacterEncoding("utf-8");
		String eClassName = applyequipRent.geteTypeName();
		int eNum = applyequipRent.getRentNumber();
		String startTime = applyequipRent.geteStartTime();
		String endTime = applyequipRent.geteEndTime();
		String rentApplyer = request.getParameter("qcsqr");
		List<EquipmentRent> allEquimentRent = null;
		boolean flag = false;
		
		EquipmentRent equipRent = new EquipmentRent();
		
		equipRent.seteEndTime(endTime);
		equipRent.seteRentPeople(rentApplyer);
		equipRent.seteStartTime(startTime);
		equipRent.seteTypeName(eClassName);
		equipRent.setRentNumber(eNum);
		try{
			flag = DAOFactory.getEquipmentRentDAOInstance().doCreateEquipmentRent(equipRent);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			try {
				allEquimentRent = DAOFactory.getEquipmentRentDAOInstance().showAllEquipmentRent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("AllEquipmentRent", allEquimentRent);
		}
		response.sendRedirect(path);
	}

}
