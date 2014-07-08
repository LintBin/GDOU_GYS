package proxy;

import java.util.ArrayList;
import java.util.List;

import vo.Space;
import dbc.*;
import dao.SpaceDAO;
import daoImpl.SpaceDAOImpl;

public class SpaceDAOProxy implements SpaceDAO {
	private DBConnection dbc = null;
	private SpaceDAO dao = null;
	
	public SpaceDAOProxy() throws Exception {
		this.dbc = new DBConnection();
		this.dao = new SpaceDAOImpl(this.dbc.getConnection());
	}

	//创建场地
	public boolean doCreateSpace(String spaceTypeName, String spaceNo,
			int adminID, int spaceFees, String remarks) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doCreateSpace(spaceTypeName, spaceNo, adminID, spaceFees, remarks);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
		return flag;
	}
	
    //删除场地
	public boolean doDeleteSpace(String spaceTypeName, String spaceNo)
			throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doDeleteSpace(spaceTypeName, spaceNo);		
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
		return flag;
	}

	//更新场地
	public boolean doUpdateSpace(String spaceTypeName, String spaceNo,
			int spaceFees, String remarks) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doUpdateSpace(spaceTypeName, spaceNo, spaceFees, remarks);		
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
		return flag;
	}


	//查询场地
	public List<Space> doQuerySpace(String spaceTypeName, String spaceNo)
			throws Exception {
		List<Space> sp = null;
		try{
			sp = this.dao.doQuerySpace(spaceTypeName, spaceNo);		
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
		return sp;
	}

	//计算某类型场地的数量
	public int doCountSpace(String spaceTypeName) throws Exception {
		int i = 0;
		try{
			i = this.dao.doCountSpace(spaceTypeName);	
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
		return i;
	}

}
