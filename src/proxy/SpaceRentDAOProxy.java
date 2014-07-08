package proxy;
import java.util.ArrayList;
import java.util.List;

import dao.SpaceRentDAO;
import vo.SpaceRent;
import daoImpl.SpaceRentDAOImpl;
import dbc.DBConnection;

public class SpaceRentDAOProxy implements SpaceRentDAO{

	private DBConnection dbc = null;
	private SpaceRentDAO dao = null;
	
	public SpaceRentDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		this.dao = new SpaceRentDAOImpl(dbc.getConnection());
	}

	//创建场地租借
	public boolean doCreateSpaceRent(SpaceRent spaceRent) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doCreateSpaceRent(spaceRent);	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//删除场地租借
	public boolean doDeleteSpaceRent(String spaceTypeName, String spaceNo,
			String sStartTime, String sEndTime) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doDeleteSpaceRent(spaceTypeName, spaceNo, sStartTime, sEndTime);	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//检查场地是否冲突
	public boolean doCheckSpaceIsRent(String spaceTypeName, String spaceNo,
			String sStartTime, String sEndTime) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doCheckSpaceIsRent(spaceTypeName, spaceNo, sStartTime, sEndTime);	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//查找场地租借
	public List<SpaceRent> doQuerySpaceRent(String spaceTypeName, String spaceNo)
			throws Exception {
		List<SpaceRent> sr = new ArrayList<SpaceRent>();
		try{
			sr = this.dao.doQuerySpaceRent(spaceTypeName, spaceNo);	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return sr;
	}

	//返回所有场地租借
	public List<SpaceRent> showAllSpaceRent() throws Exception {
		List<SpaceRent> sr = new ArrayList<SpaceRent>();
		try{
			sr = this.dao.showAllSpaceRent();	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return sr;
	}
    
}
