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
import vo.Equipment;

public class EquipmentDel extends HttpServlet {
	private String path = "../jsp/equipment_delete.jsp";
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String num_Str = request.getParameter("sssl");
		int num = Integer.valueOf(num_Str);
		session = request.getSession();
		
		String select[] = request.getParameterValues("EquipmentDel");
		boolean flag = false;
		
		List<Equipment> allEquiment = (List<Equipment>) session.getAttribute("AllEquipment");
		List<Equipment> findEquipment = (List<Equipment>) session.getAttribute("FindEquipment");
		
		System.out.println("运行EquipmentDel");
		
		if(findEquipment == null){
			int j = Integer.valueOf(select[0]);
			Equipment equipment =  allEquiment.get(j);
			String type = equipment.geteTypeName();
			try {
					DAOFactory.getEquipmentDAOInstance().doUpdateENumber(type, equipment.geteNumber() - num);
				} catch (Exception e) {
					e.printStackTrace();
			}
		}else{
			int j = Integer.valueOf(select[0]);
			Equipment equipment =  allEquiment.get(j);
			String type = equipment.geteTypeName();
			try {
				DAOFactory.getEquipmentDAOInstance().doUpdateENumber(type, equipment.geteNumber() - num);
			} catch (Exception e) {
					e.printStackTrace();
			}
		}
			if(flag == true){
				try {
					allEquiment = DAOFactory.getEquipmentDAOInstance().findEquipment(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				session.setAttribute("AllEquipment", allEquiment);
				session.removeAttribute("FindEquipment");
			}
			response.sendRedirect(path);
	}

}
