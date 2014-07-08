package daoImpl;
import java.sql.*;
import vo.*;
import dao.*;

public class LoginDAOImpl implements LoginDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    public LoginDAOImpl(Connection conn){
    	this.conn = conn;
    }
    
    //超级用户登陆验证
	public boolean superUserLogin(LoginBean loginBean) throws Exception {
		boolean flag = false;
    	String sql = "select * from superUser where superUserName" +
    			"=? and superUserPw =?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1,loginBean.getLoginName());
    	this.pstmt.setString(2,loginBean.getLoginPassword());
    	this.rs =  pstmt.executeQuery();
    	if(rs.next()){
    		flag = true;
    	}
    	this.pstmt.close();   	
    	return flag;
		
	}
	
    //管理员登陆验证
	public boolean adminLogin(LoginBean loginBean) throws Exception {
		boolean flag = false;
    	String sql = "select * from admin where adminName" +
    			"=? and adminPassword =?";
    	this.pstmt = this.conn.prepareStatement(sql);
    	this.pstmt.setString(1,loginBean.getLoginName());
    	this.pstmt.setString(2,loginBean.getLoginPassword());
    	this.rs =  pstmt.executeQuery();
    	if(rs.next()){
    		flag = true;
    	}
    	this.pstmt.close();  
    	return flag;
	}

}
