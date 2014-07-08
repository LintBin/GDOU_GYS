package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;

import servlet.assist.GetEquipmentName;

public class EquipmentFeeUpdate extends HttpServlet {
	private String path = "../jsp/equipment_charge.jsp";
	private HttpSession session = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String equipClassName = new GetEquipmentName().getRquimentName(request.getParameter("Item"));
		int equipCom = Integer.valueOf(request.getParameter("shfy"));
		int equipFee = Integer.valueOf(request.getParameter("qcfy"));
		
		try{
//			DAOFactory.getEquipmentDAOInstance().);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
