package dao;
import java.util.*;
import vo.Space;

public interface SpaceDAO {
	public boolean doCreateSpace(String spaceTypeName,String spaceNo,
			int adminID,int spaceFees,String remarks) throws Exception;	 //创建场地
	
	public boolean doDeleteSpace(String spaceTypeName,String spaceNo) throws Exception; //删除场地
	
	public boolean doUpdateSpace(String spaceTypeName,String spaceNo,
			int spaceFees,String remarks) throws Exception; //更新场地
	
	public List<Space> doQuerySpace(String spaceTypeName,String spaceNo) throws Exception; //查找场地
	
	public int doCountSpace(String spaceTypeName) throws Exception; //计算该类型场地的数量
	
	
}
