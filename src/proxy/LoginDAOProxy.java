package proxy;
import java.sql.*;
import dao.*;
import vo.*;
import daoImpl.*;
import dbc.DBConnection;

public class LoginDAOProxy implements LoginDAO{
	private DBConnection dbc = null;
	private LoginDAO dao = null;
	
	public LoginDAOProxy() throws Exception{
		this.dbc = new DBConnection();
        this.dao = new LoginDAOImpl(dbc.getConnection());	
	}
	
	public boolean superUserLogin(LoginBean loginBean) throws Exception{
		boolean flag = false;
		
		try {
			flag = this.dao.superUserLogin(loginBean);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	
	public boolean adminLogin(LoginBean loginBean) throws Exception{
		boolean flag = false;
		
		try {
			flag = this.dao.adminLogin(loginBean);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

}
