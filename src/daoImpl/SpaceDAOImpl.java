package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.DAOFactory;

import vo.Space;

import dao.*;

public class SpaceDAOImpl implements SpaceDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public SpaceDAOImpl(Connection conn) {
		this.conn = conn;
	}

	//创建场地
	public boolean doCreateSpace(String spaceTypeName, String spaceNo,
			int adminID, int spaceFees, String remarks) throws Exception {
		boolean flag = false;
		if(DAOFactory.getSTypeFeesDAOInstance().doQuerySpaceFees(spaceTypeName)==0){
			DAOFactory.getSTypeFeesDAOInstance().doCreateSTypeFees(spaceTypeName, spaceFees);
		}
		String sql = "insert into space values(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		this.pstmt.setString(2,spaceNo);
		this.pstmt.setInt(3,adminID);
		this.pstmt.setString(4,remarks);
		
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//删除场地
	public boolean doDeleteSpace(String spaceTypeName, String spaceNo)
			throws Exception {
		boolean flag = false;
		if(DAOFactory.getSpaceDAOInstance().doCountSpace(spaceTypeName)==1){
			DAOFactory.getSTypeFeesDAOInstance().doDeleteSTypeFees(spaceTypeName);
		}
		String sql = "delete from space where spaceTypeName=? and spaceNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		this.pstmt.setString(2,spaceNo);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//更新场地
	public boolean doUpdateSpace(String spaceTypeName, String spaceNo,
			int spaceFees, String remarks) throws Exception {
		boolean flag = false;
		DAOFactory.getSTypeFeesDAOInstance().doUpdateSTypeFees(spaceTypeName, spaceFees);
		String sql = "update space set remarks=? where spaceTypeName=? and spaceNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,remarks);
		this.pstmt.setString(2,spaceTypeName);
		this.pstmt.setString(3,spaceNo);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//查询场地
	public List<Space> doQuerySpace(String spaceTypeName, String spaceNo)
			throws Exception {
		List<Space> sp = new ArrayList<Space>();
		String sql = "select * from space where spaceTypeName like ? and spaceNo like ? ";
		if(spaceTypeName==null){
			spaceTypeName = "";
		}
		if(spaceNo==null){
			spaceNo = "";
		}
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+spaceTypeName+"%");
		this.pstmt.setString(2,"%"+spaceNo+"%");
		ResultSet rs = this.pstmt.executeQuery();
		
		Space space = null ;
		while(rs.next()){
			space = new Space();
			space.setSpaceTypeName(rs.getString(1));
			space.setSpaceNo(rs.getString(2));
			space.setAdminID(rs.getInt(3));
			space.setRemarks(rs.getString(4));
			sp.add(space);
		}
		this.pstmt.close();
		return sp;
	}

	//计算该类型场地的数量
	public int doCountSpace(String spaceTypeName) throws Exception {
		int s = 0;
		String sql = "select count(*) from spaceTypeFees where spaceTypeName=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			s = rs.getInt(1);
		}
		this.pstmt.close();
		return s;
	}

	
}
