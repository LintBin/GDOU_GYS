package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.SetFines;
import dao.SetFinesDAO;

public class SetFinesDAOImpl implements SetFinesDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SetFinesDAOImpl(Connection conn){
    	this.conn = conn;
    }

	//创建罚款条例
	public boolean doCreateSetFines(String finesTittle,String finesDetail)
			throws Exception {
		boolean flag = false;
		String sql = "insert into setFines(finesTittle,finesDetail) values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, finesTittle);
		this.pstmt.setString(2,finesDetail);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	//更新罚款条例
	public boolean doUpdateSetFines(int finesNo,
			String finesTittle,String finesDetail) throws Exception {
		boolean flag = false;
		String sql = "update setFines set finesTittle=?,finesDetail=? where finesNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, finesTittle);
		this.pstmt.setString(2,finesDetail);
		this.pstmt.setInt(3,finesNo);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	//查找罚款条例
	public SetFines doQuery(int finestNo) throws Exception {
		SetFines sf = new SetFines();
		String sql = "select finesTittle,finesDetail from setFines where finesNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,finestNo);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			sf.setFinesTittle(rs.getString(1));
			sf.setFinesDetail(rs.getString(2));
		}
		return sf;
	}
	
    
}
