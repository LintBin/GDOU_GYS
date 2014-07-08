package dao;
import java.util.List;
import vo.Admin;;

public interface AdminDAO {
    public boolean doCreate(Admin admin) throws Exception;  //创建管理员
    public List<Admin> queryAdmin(String adminName,String adminSex,String adminPhone) throws Exception;  //关键字查询
	public Admin findById(int string) throws Exception;  //根据ID查询
	public boolean doDelete(int adminId) throws Exception;  //删除管理员
	public boolean doUpdate(String adminName, String adminPassword, 
			String adminSex, String adminPhone) throws Exception;  //更新管理员
	public int doShowIDbyName(String adminName) throws Exception; //根据管理员名字查询ID
	public List<Admin> showAllAdmin() throws Exception; //显示所有管理员信息
}
