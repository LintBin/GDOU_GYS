package proxy;

import java.util.ArrayList;
import java.util.List;

import dbc.DBConnection;
import dao.GameDAO;
import daoImpl.GameDAOImpl;
import vo.Game;

public class GameDAOProxy implements GameDAO{
	private DBConnection dbc = null;
	private GameDAOImpl dao = null;
	
	public GameDAOProxy() throws Exception {
		this.dbc = new DBConnection();
		this.dao = new GameDAOImpl(this.dbc.getConnection());
	}
	/*
	// 新建赛事
	public boolean doCreate(Game game) throws Exception {
		boolean flag = false;
		try {
				flag = this.dao.doCreate(game);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	
	// 查找全部赛事
	public List<Game> findAll() throws Exception {
		List<Game> all = new ArrayList<Game>();
		try {			
			all = this.dao.findAll();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return all;
	}
	
	// 赛事关键字查询
	public List<Game> findByKey(String keyWord) throws Exception {
		List<Game> all = new ArrayList<Game>();
		try {			
			all = this.dao.findByKey(keyWord);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return all;
	}
	
	// 更改赛事
	public boolean doUpdate(int gameNo, String spaceNo, String gameName, String gameHost, String gStartTime, String gEndTime, int gSpaceFees, String gameHead, String headPhone) throws Exception {
		boolean flag = false;
		try {			
			flag = this.dao.doUpdate(gameNo, spaceNo, gameName, gameHost, gStartTime, gEndTime, gSpaceFees, gameHead, headPhone);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	
	// 删除赛事
	public boolean doDelete(int gameNo) throws Exception {
		boolean flag = false;
		try {			
			flag = this.dao.doDelete(gameNo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	
	// 通过赛事名称查找赛事编号
	public Game findNoByName(String gameName) throws Exception {
		Game game = new Game();
		try {			
			game = this.dao.findNoByName(gameName);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return game;
	}

	//检查场地冲突
	public boolean doCheckSpaceIsRent(String spaceNo, String gStartTime,
			String gEndTime) throws Exception {
		boolean flag = false;
		try {			
			flag = this.dao.doCheckSpaceIsRent(spaceNo, gStartTime, gEndTime);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	*/

	//创建赛事
	public boolean doCreate(Game game) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(game);
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
		return flag;
	}

	//得到所有赛事信息
	public List<Game> findAll() throws Exception {
		List<Game> g = null;
		try {
			g = this.dao.findAll();
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
		return g;
	}

	//查找赛事
	public List<Game> queryGame(String spaceTypeName, String spaceNo,
			String gameName) throws Exception {
		List<Game> g = null;
		try {
			g = this.dao.queryGame(spaceTypeName, spaceNo, gameName);
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
				return g;
	}

	//删除赛事
	public boolean doDelete(int gameNo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doDelete(gameNo);
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
		return flag;
	}

	//更新赛事
	public boolean doUpdate(Game game) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(game);
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
		return flag;
	}

	//检查赛事场地冲突
	public boolean doCheckSpaceIsRent(String spaceTypeName, String spaceNo,
			String gStartTime, String gEndTime) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCheckSpaceIsRent(spaceTypeName, spaceNo, gStartTime, gEndTime);
	}catch(Exception e) {
		throw e;
	}finally {
		this.dbc.close();
	}
		return flag;
	}
}
