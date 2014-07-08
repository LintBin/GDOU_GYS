package daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.SpaceRent;
import dao.SpaceRentDAO;

public class SpaceRentDAOImpl implements SpaceRentDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 =null;
    private PreparedStatement pstmt3 = null;
    private PreparedStatement pstmt4 = null;
    private ResultSet rs = null; 
    private ResultSet rs2 = null; 
    private ResultSet rs3 = null;
    private ResultSet rs4 = null;
    
	public SpaceRentDAOImpl(Connection conn){
		this.conn = conn;
	}

	//创建场地租借
	public boolean doCreateSpaceRent(SpaceRent spaceRent) throws Exception {
		boolean flag = false;
		String sql = "insert into spaceRent values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceRent.getspaceTypeName());
		this.pstmt.setString(2,spaceRent.getSpaceNo());
		this.pstmt.setString(3,spaceRent.getsStartTime());
		this.pstmt.setString(4,spaceRent.getsEndTime());
		this.pstmt.setString(5,spaceRent.getsRentPeople());
		
		if(this.pstmt.executeUpdate()>0){
			flag= true;
		}
	    this.pstmt.close();
		return flag;
	}

	//删除场地租借
	public boolean doDeleteSpaceRent(String spaceTypeName, String spaceNo,
			String sStartTime, String sEndTime) throws Exception {
		boolean flag = false;
		String sql = "delete from spaceRent where spaceTypeName=? and spaceNo=? and sStartTime=? and sEndTime=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,spaceTypeName);
		this.pstmt.setString(2,spaceNo);
		this.pstmt.setString(3,sStartTime);
		this.pstmt.setString(4,sEndTime);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//
	public boolean doCheckSpaceIsRent(String spaceTypeName, String spaceNo,
			String sStartTime, String sEndTime) throws Exception {
		boolean flag = false;
        String sql1 = "select sRentPeople from spaceRent where spaceTypeName=? and " +
        		"spaceNo=? and sStartTime <=? and sEndTime>=?";
        String sql2 = "select sRentPeople from spaceRent where spaceTypeName=? and " +
        		"spaceNo=? and sStartTime <=? and sEndTime>=?";
        String sql3 = "select sRentPeople from spaceRent where spaceTypeName=? and " +
        		"spaceNo=? and sStartTime >=? and sStartTime<=?";
        String sql4 = "select sRentPeople from spaceRent where spaceTypeName=? and " +
        		"spaceNo=? and sEndTime>=? and sEndTime<=?";
        
        this.pstmt = this.conn.prepareStatement(sql1);
        this.pstmt2 = this.conn.prepareStatement(sql2);
        this.pstmt3 = this.conn.prepareStatement(sql3);
        this.pstmt4 = this.conn.prepareStatement(sql4);
        
        this.pstmt.setString(1,spaceTypeName);
        this.pstmt.setString(2,spaceNo);
        this.pstmt.setString(3,sStartTime);
        this.pstmt.setString(4,sStartTime);
        
        this.pstmt2.setString(1,spaceTypeName);
        this.pstmt2.setString(2,spaceNo);
        this.pstmt2.setString(3,sEndTime);
        this.pstmt2.setString(4,sEndTime);
        
        this.pstmt3.setString(1,spaceTypeName);
        this.pstmt3.setString(2,spaceNo);
        this.pstmt3.setString(3,sStartTime);
        this.pstmt3.setString(4,sEndTime);
        
        this.pstmt4.setString(1,spaceTypeName);
        this.pstmt4.setString(2,spaceNo);
        this.pstmt4.setString(3,sStartTime);
        this.pstmt4.setString(4,sEndTime);

        this.rs = this.pstmt.executeQuery();
        this.rs2 = this.pstmt2.executeQuery();
        this.rs3 = this.pstmt3.executeQuery();
        this.rs4 = this.pstmt4.executeQuery();
        
        if(!rs.next()&&!rs2.next()&&!rs3.next()&&!rs4.next()){
        	flag = true;
        }
        this.pstmt.close();
        this.pstmt2.close();
        this.pstmt3.close();
        this.pstmt4.close();
		return flag;
	}

	//查找场地租借
	public List<SpaceRent> doQuerySpaceRent(String spaceTypeName, String spaceNo)
			throws Exception {
		List<SpaceRent> sr = new ArrayList<SpaceRent>();
		String sql = "select spaceTypeName,spaceNo,sStartTime,sEndTime,sRentPeople " +
				"from spaceRent where spaceTypeName like ? and spaceNo like ? " ;
		this.pstmt = this.conn.prepareStatement(sql);
		if(spaceNo==null){
			spaceNo = "";
		}
		if(spaceTypeName==null){
			spaceTypeName = "";
		}
		this.pstmt.setString(1,"%"+spaceTypeName+"%");
		this.pstmt.setString(2,"%"+spaceNo+"%");
		this.rs = this.pstmt.executeQuery();
		SpaceRent spaceRent = null;
		while(rs.next()){
			spaceRent = new SpaceRent();
			spaceRent.setspaceTypeName(rs.getString(1));
			spaceRent.setSpaceNo(rs.getString(2));
			spaceRent.setsStartTime(rs.getString(3).substring(0, 16));
			spaceRent.setsEndTime(rs.getString(4).substring(0, 16));
			spaceRent.setsRentPeople(rs.getString(5));	
			sr.add(spaceRent);
		}
		this.pstmt.close();
		return sr;
	}

	//返回所有场地租借信息
	public List<SpaceRent> showAllSpaceRent() throws Exception {
		List<SpaceRent> sr = new ArrayList<SpaceRent>();
		String sql = "select spaceTypeName,spaceNo,sStartTime,sEndTime,sRentPeople " +
				"from spaceRent" ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		SpaceRent spaceRent = null;
		while(rs.next()){
			spaceRent = new SpaceRent();
			spaceRent.setspaceTypeName(rs.getString(1));
			spaceRent.setSpaceNo(rs.getString(2));
			spaceRent.setsStartTime(rs.getString(3).substring(0, 16));
			spaceRent.setsEndTime(rs.getString(4).substring(0, 16));
			spaceRent.setsRentPeople(rs.getString(5));	
			sr.add(spaceRent);
		}
		this.pstmt.close();
		return sr;
	}
	
	

}
