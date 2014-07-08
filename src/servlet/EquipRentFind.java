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

public class EquipRentFind extends HttpServlet {
	private String path = "../jsp/equipment_borrowno.jsp";
	private HttpSession session = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String eClassName = new GetEquipmentName().getRquimentName(request.getParameter("Item"));
		String equipAppler = request.getParameter("qcsqr");
		List<EquipmentRent> findEquipment = null;
		try{
			findEquipment = DAOFactory.getEquipmentRentDAOInstance().findEquipmentRent(eClassName, equipAppler);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("FindEquipRent.size()"+findEquipment.size());
		session.setAttribute("FindEquipRent", findEquipment);
		response.sendRedirect(path);
		
	}

}
