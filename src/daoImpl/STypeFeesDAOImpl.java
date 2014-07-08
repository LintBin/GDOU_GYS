package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.SpaceTypeFees;
import dao.STypeFeesDAO;

public class STypeFeesDAOImpl implements STypeFeesDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public STypeFeesDAOImpl(Connection conn){
		this.conn = conn;
	}

	//创建场地类型费用
	public boolean doCreateSTypeFees(String spaceTypeName, int spaceFees)
			throws Exception {
		boolean flag = false;
		String sql = "insert into spaceTypeFees values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		this.pstmt.setInt(2,spaceFees);
		
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//删除场地类型费用
	public boolean doDeleteSTypeFees(String spaceTypeName) throws Exception {
		boolean flag = false;
		String sql = "delete from spaceTypeFees where spaceTypeName = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	
	

	//根据场地类型名查询费用
	public int doQuerySpaceFees(String spaceTypeName) throws Exception {
		int spaceFees = 0;
		String sql = "select spaceFees from spaceTypeFees where spaceTypeName=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			spaceFees = rs.getInt(1);
		}
		return spaceFees; 
	}

	//更新场地类型费用
	public boolean doUpdateSTypeFees(String spaceTypeName, int spaceFees)
			throws Exception {
		boolean flag = false;
		String sql = "update spaceTypeFees set spaceFees=? where spaceTypeName = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,spaceFees);
		this.pstmt.setString(2,spaceTypeName);
		if(this.pstmt.executeUpdate()>0){
			flag  = true;
		}
        this.pstmt.close();
		return flag;
	}
	
	
}
