package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Announcement;
import dao.AnnouncementDAO;

public class AnnouncementDAOImpl implements AnnouncementDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AnnouncementDAOImpl(Connection conn){
    	this.conn = conn;
    }

	//创建公告
	public boolean doCreateAnnouncement(String aTittle, String aDetail)
			throws Exception {
		boolean flag = false;
		String sql = "insert into announcement(aTittle,aDetail) values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, aTittle);
		this.pstmt.setString(2,aDetail);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	//更新公告
	public boolean doUpdateAnnouncement(int announcementNo, String aTittle,
			String aDetail) throws Exception {
		boolean flag = false;
		String sql = "update announcement set aTittle=?,aDetail=? where announcementNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, aTittle);
		this.pstmt.setString(2,aDetail);
		this.pstmt.setInt(3,announcementNo);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	//查找公告
	public Announcement doQuery(int announcementNo) throws Exception {
		Announcement an = new Announcement();
		String sql = "select aTittle,aDetail from announcement where announcementNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,announcementNo);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			an.setaTittle(rs.getString(1));
			an.setaDetail(rs.getString(2));
		}
		return an;
	}
	
}
