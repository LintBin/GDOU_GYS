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

public class EquipmentAdd extends HttpServlet {
	private String path = "../jsp/equipment_add.jsp";
	private HttpSession session = null;
	private boolean flag = false;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		List<Equipment> allEquipment = null;
		int adminID = (Integer) session.getAttribute("AdminID");
		String equipmentNameNO = request.getParameter("Item");
		int num = Integer.valueOf(request.getParameter("qcsl"));
		int compensation = Integer.valueOf(request.getParameter("shfy"));
		int equipmentFee = Integer.valueOf(request.getParameter("qcfy"));
		String equipmentName = new GetEquipmentName().getRquimentName(equipmentNameNO);
		
		Equipment equipment = new Equipment();
		
		equipment.setAdminID(adminID);
		equipment.setCompensation(compensation);
		equipment.seteNumber(num);
		equipment.seteRentFees(equipmentFee);
		equipment.seteTypeName(equipmentName);
		
		try{
			flag = DAOFactory.getEquipmentDAOInstance().doAddEquipment(equipment);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			try {
				allEquipment = DAOFactory.getEquipmentDAOInstance().showAllEquipment();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("AllEquipment",allEquipment);
		}
		response.sendRedirect(path);
		
		
		
		
	}

}
