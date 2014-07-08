package factory;
import dao.*;
import proxy.*;

public class DAOFactory {
	
	//管理员DAO
	public static AdminDAO getAdminDAOInstance() throws Exception{
		return new AdminDAOProxy();
	}
	
	//登陆DAO
	public static LoginDAO getLoginDAOInstance() throws Exception{
		return new LoginDAOProxy();
	}
	
	//场地DAO
	public static SpaceDAO getSpaceDAOInstance() throws Exception{
		return new SpaceDAOProxy();
	}
	
    //场地租借DAO
	public static SpaceRentDAO getSpaceRentDAOInstance() throws Exception{
		return new SpaceRentDAOProxy();
	}
	
	//场地类型收费DAO
	public static STypeFeesDAO getSTypeFeesDAOInstance() throws Exception{
		return new STypeFeesDAOProxy();
	}
	
	//器材DAO
	public static EquipmentDAO getEquipmentDAOInstance() throws Exception{
		return new  EquipmentDAOProxy();
		
	}
	
	//器材租借DAO
	public static EquipmentRentDAO getEquipmentRentDAOInstance() throws Exception{
		return new EquipmentRentDAOProxy();	
	}
	
	//赛事DAO
	public static GameDAO getGameDAOInstance() throws Exception{
		return new GameDAOProxy();
	}
	
	//公告DAO
	public static AnnouncementDAO getAnnouncementDAOInstance() throws Exception{
		return new AnnouncementDAOProxy();
	}
	
	//条例DAO
	public static SetFinesDAO getSetFinesDAOInstance() throws Exception{
		return new SetFinesDAOProxy();
	}
}
