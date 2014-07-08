package dao;
import vo.SpaceRent;
import java.util.List;

public interface SpaceRentDAO {
	public boolean doCreateSpaceRent(SpaceRent spaceRent) throws Exception; //创建场地租借
	public boolean doDeleteSpaceRent(String spaceTypeName, String spaceNo,String sStartTime, String sEndTime)
	    throws Exception; //删除场地租借
	public boolean doCheckSpaceIsRent(String spaceTypeName, String spaceNo,String sStartTime, String sEndTime)
	    throws Exception;  //租借场地的时候检查场地在某个时间段是否被人使用
	public List<SpaceRent> doQuerySpaceRent(String spaceTypeName, String spaceNo) throws Exception; //模糊查询场地租借表
	public List<SpaceRent> showAllSpaceRent() throws Exception; //显示所有场地租借
}
