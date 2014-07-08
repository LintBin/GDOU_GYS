package proxy;

import java.util.List;
import dao.*;
import vo.*;
import daoImpl.*;
import dbc.DBConnection;

public class EquipmentRentDAOProxy implements EquipmentRentDAO{

	private DBConnection dbc = null;
	private EquipmentRentDAO dao = null;
	
	public EquipmentRentDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		this.dao = new EquipmentRentDAOImpl(this.dbc.getConnection());
	}

	//创建场地租借
	public boolean doCreateEquipmentRent(EquipmentRent equipmentRent)
			throws Exception {
		boolean flag = false;
		try{
        	flag = this.dao.doCreateEquipmentRent(equipmentRent);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//删除场地租借记录
	public boolean doDeleteEquipmentRent(int eRentID) throws Exception {
		boolean flag = false;
		try{
        	flag = this.dao.doDeleteEquipmentRent(eRentID);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//回收器材
	public boolean doReEquipment(String eTypeName, int eNumber) throws Exception {
		boolean flag = false;
		try{
        	flag = this.dao.doReEquipment(eTypeName, eNumber);
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//查询场地租借记录
	public List<EquipmentRent> findEquipmentRent(String eTypeName,
			String eRentPeople) throws Exception {
		List<EquipmentRent> er = null;
		try{
        	er = this.dao.findEquipmentRent(eTypeName, eRentPeople);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return er;
	}

	//得到所有场地租借记录
	public List<EquipmentRent> showAllEquipmentRent() throws Exception {
		List<EquipmentRent> er = null;
		try{
        	er = this.dao.showAllEquipmentRent();
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
				return er;
	}

	
}
