package daoImpl;
import dao.*;
import vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	//创建管理员
	public boolean doCreate(Admin admin) throws Exception {
        
		boolean flag = false;
		String sql = "insert into admin(adminName," +
				"adminPassword,adminSex,adminPhone) values(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setString(1,admin.getAdminName());
		this.pstmt.setString(2,admin.getAdminPassword());
		this.pstmt.setString(3,admin.getAdminSex());
		this.pstmt.setString(4,admin.getAdminPhone());
		
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;		
	}
	
//	关键字查询
	public List<Admin> queryAdmin(String adminName,String adminSex,String adminPhone) throws Exception {
		List<Admin> all = new ArrayList<Admin>();
		String sql = "SELECT adminId,adminName,adminPassword," +
				"adminSex,adminPhone FROM admin WHERE adminName LIKE ? and" +
				" adminSex like ? and adminPhone like ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		if(adminName==null){
			adminName = "";
		}
		if(adminSex==null){
			adminSex = "";
		}
		if(adminPhone==null){
			adminPhone = "";
		}
		this.pstmt.setString(1,"%"+adminName+"%");
		this.pstmt.setString(2,"%"+adminSex+"%");
		this.pstmt.setString(3,"%"+adminPhone+"%");
		ResultSet rs = this.pstmt.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin();
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminPassword(rs.getString(3));
			admin.setAdminSex(rs.getString(4));
			admin.setAdminPhone(rs.getString(5));
			all.add(admin);
		}
		this.pstmt.close();
		return all;
	}

//	管理员ID查询
	public Admin findById(int adminId) throws Exception {
		Admin admin = null;
		String sql = "SELECT adminID,adminName,adminPassword,adminSex,adminPhone FROM admin WHERE adminID = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, adminId);
		ResultSet rs = this.pstmt.executeQuery();		
		if(rs.next()) {
			admin = new Admin();
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminPassword(rs.getString(3));
			admin.setAdminSex(rs.getString(4));
			admin.setAdminPhone(rs.getString(5));
		}
		this.pstmt.close();
		return admin;
	}
	
	//	管理员用户删除
	public boolean doDelete(int adminId) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM admin WHERE adminID = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, adminId);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	//	管理员用户信息更改
	public boolean doUpdate(String adminName, String adminPassword, String adminSex, String adminPhone) throws Exception {
		boolean flag = false;
		String sql = "UPDATE admin SET adminName = ?,adminPassword = ?,adminSex = ?,adminPhone = ? WHERE adminName = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, adminName);
		this.pstmt.setString(2, adminPassword);
		this.pstmt.setString(3, adminSex);
		this.pstmt.setString(4, adminPhone);
		this.pstmt.setString(5,adminName);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//根据名字查ID
	public int doShowIDbyName(String adminName) throws Exception {
		int adminID = 0;
		String sql = "select adminID from admin where adminName = ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,adminName);
		this.rs = this.pstmt.executeQuery();
		if(rs.next()){
			adminID = rs.getInt(1);
		}
		
		return adminID;
	}

	//显示所有管理员
	public List<Admin> showAllAdmin() throws Exception {
		List<Admin> all = new ArrayList<Admin>();
		String sql = "SELECT adminId,adminName,adminPassword," +
				"adminSex,adminPhone FROM admin";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin();
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminPassword(rs.getString(3));
			admin.setAdminSex(rs.getString(4));
			admin.setAdminPhone(rs.getString(5));
			all.add(admin);
		}
		this.pstmt.close();
		return all;
	}


}
