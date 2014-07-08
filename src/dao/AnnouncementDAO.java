package dao;
import vo.Announcement;
public interface AnnouncementDAO {
    public boolean doCreateAnnouncement(String aTittle,String aDetail) throws Exception; //新建公告
    public boolean doUpdateAnnouncement(int announcementNo,
    		String aTittle,String aDetail)throws Exception;  //更新公告
    public Announcement doQuery(int announcementNo) throws Exception; //查找公告
}
