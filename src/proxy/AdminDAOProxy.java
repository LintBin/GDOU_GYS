package proxy;

import java.util.List;
import dao.*;
import vo.*;
import daoImpl.*;
import dbc.DBConnection;

public class AdminDAOProxy implements AdminDAO{
	
	private DBConnection dbc = null;
	private AdminDAO dao = null;

	
	public AdminDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		this.dao = new AdminDAOImpl(this.dbc.getConnection());
	}

    //创建管理员
	public boolean doCreate(Admin admin) throws Exception {
        boolean flag = false;
        try{
        	flag = this.dao.doCreate(admin);
        	
        }
        catch(Exception e){
        	throw e;
        }finally{
        	this.dbc.close();
        }
        return flag;
	}
	
	//关键字查询
	public List<Admin> queryAdmin(String adminName,String adminSex,String adminPhone) throws Exception {
		List<Admin> all = null;
		try {
			all = this.dao.queryAdmin(adminName,adminSex,adminPhone);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return all;
	}

	//通过ID查询
	public Admin findById(int adminId) throws Exception {
		Admin admin = null;
		try {
			admin = this.dao.findById(adminId);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return admin;
	}
	
	//删除管理员
	public boolean doDelete(int adminId) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doDelete(adminId);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	
	//更新管理员信息
	public boolean doUpdate(String adminName, String adminPassword, String adminSex, String adminPhone) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(adminName, adminPassword, adminSex, adminPhone);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

	//根据管理员名字查找ID
	public int doShowIDbyName(String adminName) throws Exception {
		int adminID = 0;
		try{
			adminID = this.dao.doShowIDbyName(adminName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return adminID;
	}

	//显示所有管理员
	public List<Admin> showAllAdmin() throws Exception {
		List<Admin> all = null;
		try {
			all = this.dao.showAllAdmin();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return all;
	}


}
