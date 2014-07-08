package proxy;

import vo.SetFines;
import daoImpl.SetFinesDAOImpl;
import dao.*;
import dbc.DBConnection;

public class SetFinesDAOProxy implements SetFinesDAO{
	private DBConnection dbc = null;
	private SetFinesDAO dao = null;
	
	public SetFinesDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		this.dao = new SetFinesDAOImpl(this.dbc.getConnection());
	}

	//创建公告
	public boolean doCreateSetFines(String finesTittle, String finesDetail)
			throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreateSetFines(finesTittle, finesDetail);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//更新公告
	public boolean doUpdateSetFines(int finesNo, String finesTittle, 
			String finesDetail) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdateSetFines(finesNo, finesTittle, finesDetail);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//查询公告
	public SetFines doQuery(int finesNo) throws Exception {
		SetFines sf = new SetFines();
		try {
			sf = this.dao.doQuery(finesNo);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return sf;
	}

}
