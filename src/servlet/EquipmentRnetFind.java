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
import vo.Equipment;
import vo.EquipmentRent;

public class EquipmentRnetFind extends HttpServlet {
	private String path = "../jsp/equipment_borrow.jsp";
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String eClassName = new GetEquipmentName().getRquimentName(request.getParameter("Item"));
		int eNum = Integer.valueOf(request.getParameter("qcsl"));
		String startTime = request.getParameter("Timestart");
		String endTime = request.getParameter("Timeup");
		List<Equipment> findEquip = null;
		EquipmentRent temp_equip_rent = new EquipmentRent();
		temp_equip_rent.seteTypeName(eClassName);
		temp_equip_rent.seteStartTime(startTime);
		temp_equip_rent.seteEndTime(endTime);
		temp_equip_rent.setRentNumber(eNum);
		session.setAttribute("tem", temp_equip_rent);
		
		try{
			findEquip = DAOFactory.getEquipmentDAOInstance().findEquipment(eClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect(path);
		
		
	}

}
