package dao;

import java.util.*;

import vo.Game;

public interface GameDAO {
	public boolean doCreate(Game game) throws Exception; //创建赛事
	public List<Game> findAll() throws Exception;  //得到所有赛事列表
	public List<Game> queryGame(String spaceTypeName,
			String spaceNo,String gameName) throws Exception;  //查询赛事
	public boolean doDelete(int gameNo) throws Exception;  //删除赛事
	public boolean doUpdate(Game game) throws Exception;  //更新赛事
	public boolean doCheckSpaceIsRent(String spaceTypeName,String spaceNo,
			String gStartTime,String gEndTime) throws Exception;  //检查场地占用冲突
}
