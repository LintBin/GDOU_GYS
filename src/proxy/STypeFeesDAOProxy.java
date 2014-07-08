package proxy;

import java.sql.Connection;
import dao.STypeFeesDAO;
import daoImpl.STypeFeesDAOImpl;
import dbc.DBConnection;

public class STypeFeesDAOProxy implements STypeFeesDAO{

	private DBConnection dbc = null;
	private STypeFeesDAO dao = null;
	
	public STypeFeesDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		dao = new STypeFeesDAOImpl(this.dbc.getConnection());
	}
	//创建场地收费
	public boolean doCreateSTypeFees(String spaceTypeName, int spaceFees)
			throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doCreateSTypeFees(spaceTypeName, spaceFees);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//删除场地收费
	public boolean doDeleteSTypeFees(String spaceTypeName) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doDeleteSTypeFees(spaceTypeName);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//根据场地类型名字查询场地收费
	public int doQuerySpaceFees(String spaceTypeName) throws Exception {
		int spaceFees = 0;
		try{
			spaceFees = this.dao.doQuerySpaceFees(spaceTypeName);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return spaceFees;
	}
	//更新场地收费
	public boolean doUpdateSTypeFees(String spaceTypeName, int spaceFees)
			throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.doUpdateSTypeFees(spaceTypeName, spaceFees);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	

}
