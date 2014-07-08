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

public class EquipmentUpdate extends HttpServlet {
	private HttpSession session = null;
	private String path = "../jsp/equipment_update.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		String equipmentClass = new GetEquipmentName().getRquimentName(request.getParameter("Item"));
		int equipmentNum = Integer.valueOf(request.getParameter("qcsl"));
		int equipmentFee = Integer.valueOf(request.getParameter("shfy"));
		int equipmentCom = Integer.valueOf(request.getParameter("qcfy"));
		boolean flag = false;
		Equipment equipment = new Equipment();
		List<Equipment> allEquipment = null;
		
		equipment.setCompensation(equipmentCom);
		equipment.seteNumber(equipmentNum);
		equipment.seteRentFees(equipmentFee);
		equipment.seteTypeName(equipmentClass);
		
		try{
			flag = DAOFactory.getEquipmentDAOInstance().doUpdateEquipment(equipment);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag){
			try {
				allEquipment = DAOFactory.getEquipmentDAOInstance().showAllEquipment();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.removeAttribute("FindEquipment");
			session.setAttribute("AllEquipment",allEquipment);
		}
		response.sendRedirect(path);
	
	}

}
