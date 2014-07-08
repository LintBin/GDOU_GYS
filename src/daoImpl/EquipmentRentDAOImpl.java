package daoImpl;
import java.util.ArrayList;
import java.util.List;
import vo.EquipmentRent;
import dao.EquipmentRentDAO;
import factory.DAOFactory;

import java.sql.*;

public class EquipmentRentDAOImpl implements EquipmentRentDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
    private ResultSet rs = null; 
    
    public EquipmentRentDAOImpl(Connection conn){
    	this.conn = conn;
    }
    
	//创建器材租借
	public boolean doCreateEquipmentRent(EquipmentRent equipmentRent) throws Exception {
		boolean flag = false;
		int eNowNumber = DAOFactory.getEquipmentDAOInstance().findEquipment(equipmentRent.geteTypeName()).get(0).geteNumber();
		if(equipmentRent.getRentNumber()>eNowNumber){
			return false;
		}
		String sql = "insert into EquipmentRent(eTypeName,eStartTime,eEndTime,rentNumber,eRentPeople) values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);		
		this.pstmt.setString(1,equipmentRent.geteTypeName());
		this.pstmt.setString(2,equipmentRent.geteStartTime());
		this.pstmt.setString(3,equipmentRent.geteEndTime());
		this.pstmt.setInt(4,equipmentRent.getRentNumber());
		this.pstmt.setString(5,equipmentRent.geteRentPeople());
		
		if(this.pstmt.executeUpdate()>0){
			flag = true;
			int n = eNowNumber - equipmentRent.getRentNumber();
			DAOFactory.getEquipmentDAOInstance().doUpdateENumber(equipmentRent.geteTypeName(),n);
		}
		this.pstmt.close();
		return flag;
	}

	//删除器材租借记录
	public boolean doDeleteEquipmentRent(int eRentID) throws Exception {
		boolean flag = false;
		String sql = "delete from EquipmentRent where eRentID = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,eRentID);	
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		
		return flag;
	}

	//查询器材租借记录
	public List<EquipmentRent> findEquipmentRent(String eTypeName,String eRentPeople)
			throws Exception {
		List<EquipmentRent> er = new ArrayList<EquipmentRent>();
		String sql = "select * from equipmentRent where eTypeName like ? or eRentPeople like ?";
		if(eTypeName==null){
			eTypeName = "";
		}
		if(eRentPeople==null){
			eRentPeople="";
		}
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+eTypeName+"%");
		this.pstmt.setString(2,"%"+eRentPeople+"%");
		rs = this.pstmt.executeQuery();
		EquipmentRent equipmentRent = null;
		while(rs.next()){
			equipmentRent = new EquipmentRent();
			equipmentRent.seteRentID(rs.getInt(1));
			equipmentRent.seteTypeName(rs.getString(2));
			equipmentRent.seteStartTime(rs.getString(3).substring(0, 16));
			equipmentRent.seteEndTime(rs.getString(4).substring(0, 16));
			equipmentRent.setRentNumber(rs.getInt(5));
			equipmentRent.seteRentPeople(rs.getString(6));
			er.add(equipmentRent);
		}
		this.pstmt.close();
		return er;
	}

	//显示所有器材租借
	public List<EquipmentRent> showAllEquipmentRent() throws Exception {
		List<EquipmentRent> er = new ArrayList<EquipmentRent>();
		String sql = "select * from equipmentRent";
		this.pstmt = this.conn.prepareStatement(sql);
		rs = this.pstmt.executeQuery();
		EquipmentRent equipmentRent = null;
		while(rs.next()){
			equipmentRent = new EquipmentRent();
			equipmentRent.seteRentID(rs.getInt(1));
			equipmentRent.seteTypeName(rs.getString(2));
			equipmentRent.seteStartTime(rs.getString(3).substring(0, 16));
			equipmentRent.seteEndTime(rs.getString(4).substring(0, 16));
			equipmentRent.setRentNumber(rs.getInt(5));
			equipmentRent.seteRentPeople(rs.getString(6));
			er.add(equipmentRent);
		}
		this.pstmt.close();
		return er;
	}

	//器材回收
	public boolean doReEquipment(String eTypeName, int eNumber) throws Exception {
		boolean flag = false;
		int eNowNumber = DAOFactory.getEquipmentDAOInstance().findEquipment(eTypeName).get(0).geteNumber();
		int n = eNowNumber + eNumber;
		if(DAOFactory.getEquipmentDAOInstance().doUpdateENumber(eTypeName,n)){
			flag = true;
		}
		return flag;
	}
}
