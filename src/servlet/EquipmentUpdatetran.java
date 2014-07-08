package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Equipment;

public class EquipmentUpdatetran extends HttpServlet {
	private HttpSession session = null;
	private String path = "../jsp/equipment_update_1.jsp";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String select[] = request.getParameterValues("EquipmentUpdate");
		List<Equipment> allEquipment = (List<Equipment>) session.getAttribute("AllEquipment");
		List<Equipment> findEquipment = (List<Equipment>) session.getAttribute("FindEquipment");
		
		Equipment equipment = new Equipment();
		int num = Integer.valueOf(select[0]);
		if(findEquipment == null){
			equipment = allEquipment.get(num);
		}else{
			equipment = findEquipment.get(num);
		}
		session.setAttribute("SelecEquipment", equipment);
		response.sendRedirect(path);
	}

}
