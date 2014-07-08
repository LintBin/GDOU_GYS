package proxy;
import vo.Announcement;
import dao.AnnouncementDAO;
import dbc.DBConnection;
import daoImpl.AnnouncementDAOImpl;
public class AnnouncementDAOProxy implements AnnouncementDAO{
	private DBConnection dbc = null;
	private AnnouncementDAO dao = null;
	
	public AnnouncementDAOProxy() throws Exception{
		this.dbc = new DBConnection();
		this.dao = new AnnouncementDAOImpl(this.dbc.getConnection());
	}

	//创建公告
	public boolean doCreateAnnouncement(String aTittle, String aDetail)
			throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreateAnnouncement(aTittle, aDetail);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//更新公告
	public boolean doUpdateAnnouncement(int announcementNo, String aTittle,
			String aDetail) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdateAnnouncement(announcementNo, aTittle, aDetail);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	//查询公告
	public Announcement doQuery(int announcementNo) throws Exception {
		Announcement an = new Announcement();
		try {
			an = this.dao.doQuery(announcementNo);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return an;
	}

}
