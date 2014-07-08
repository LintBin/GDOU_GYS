package proxy;

import java.util.List;
import dao.*;
import vo.*;
import daoImpl.*;
import dbc.DBConnection;

public class EquipmentDAOProxy implements EquipmentDAO{

	private DBConnection dbc = null;
	private EquipmentDAO dao = null;
	
	public EquipmentDAOProxy() throws Exception{
		this.dbc  = new DBConnection();
		this.dao  = new EquipmentDAOImpl(this.dbc.getConnection());
	}
	
	//添加器材
	public boolean doAddEquipment(Equipment equipment) throws Exception {
		boolean flag = true;
		try{
        	flag = this.dao.doAddEquipment(equipment);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//删除器材
	public boolean doDeleteEquipment(String equipmentNo) throws Exception {
		boolean flag = true;
		try{
        	flag = this.dao.doDeleteEquipment(equipmentNo);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//更新器材
	public boolean doUpdateEquipment(Equipment equipment) throws Exception {
		boolean flag = true;
		try{
        	flag = this.dao.doUpdateEquipment(equipment);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

	//查找器材
	public List<Equipment> findEquipment(String keyWord) throws Exception {
		List<Equipment> ep = null;
		try{
        	ep = this.dao.findEquipment(keyWord);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return ep;
	}

	//显示所有器材
	public List<Equipment> showAllEquipment() throws Exception {
		List<Equipment> ep = null;
		try{
        	ep = this.dao.showAllEquipment();
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return ep;
	}

	//更新器材数量
	public boolean doUpdateENumber(String eTypeName, int eNumber)
			throws Exception {
		boolean flag = false;
		try{
        	flag = this.dao.doUpdateENumber(eTypeName, eNumber);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
		return flag;
	}

}
