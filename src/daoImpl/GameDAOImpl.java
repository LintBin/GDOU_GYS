package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dao.GameDAO;

import vo.Game;

public class GameDAOImpl implements GameDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private  PreparedStatement pstmt2 = null;
	private  PreparedStatement pstmt3 = null;
	private  PreparedStatement pstmt4 = null;
	
	public GameDAOImpl(Connection conn) {
		this.conn = conn;
	}
	/*
	// 新建赛事
	public boolean doCreate(Game game) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO game(adminID, spaceNo, gameName, gameHost, gStartTime, gEndTime, gSpaceFees, gameHead, headPhone) VALUES (?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, game.getAdminID());
		this.pstmt.setString(2, game.getSpaceNo());
		this.pstmt.setString(3, game.getGameName());
		this.pstmt.setString(4, game.getGameHost());
		this.pstmt.setString(5, game.getgStartTime());
		this.pstmt.setString(6, game.getgEndTime());
		this.pstmt.setInt(7, game.getgSpaceFees());
		this.pstmt.setString(8, game.getGameHead());
		this.pstmt.setString(9, game.getHeadPhone());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	// 查询全部赛事
	public List<Game> findAll() throws Exception {
		List<Game> all = new ArrayList<Game>();
		String sql = "SELECT * FROM game";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Game game = null;
		while(rs.next()) {
			game = new Game();
			game.setGameNo(rs.getInt(1));
			game.setAdminID(rs.getInt(2));
			game.setGameNo(rs.getInt(3));
			game.setGameName(rs.getString(4));
			game.setGameHost(rs.getString(5));
			game.setgStartTime(rs.getString(6));
			game.setgEndTime(rs.getString(7));
			game.setgSpaceFees(rs.getInt(8));
			game.setGameHead(rs.getString(9));
			game.setHeadPhone(rs.getString(10));
			all.add(game);
		}
		this.pstmt.close();
		return all;
	}
	
	// 赛事关键字查询
	public List<Game> findByKey(String keyWord) throws Exception {
		List<Game> all = new ArrayList<Game>();
		String sql = "SELECT * FROM game WHERE gameNo LIKE ? OR adminID LIKE ?  OR spaceNo LIKE ? OR gameName LIKE ? OR gameHost LIKE ? OR gStartTime LIKE ? OR gEndTime LIKE ? OR gSpaceFees LIKE ? OR gameHead LIKE ? OR headPhone LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyWord+"%");
		this.pstmt.setString(2, "%"+keyWord+"%");
		this.pstmt.setString(3, "%"+keyWord+"%");
		this.pstmt.setString(4, "%"+keyWord+"%");
		this.pstmt.setString(5, "%"+keyWord+"%");
		this.pstmt.setString(6, "%"+keyWord+"%");
		this.pstmt.setString(7, "%"+keyWord+"%");
		this.pstmt.setString(8, "%"+keyWord+"%");
		this.pstmt.setString(9, "%"+keyWord+"%");
		this.pstmt.setString(10, "%"+keyWord+"%");
		ResultSet rs = this.pstmt.executeQuery();
		Game game = null;
		while (rs.next()) {
			game = new Game();
			game.setGameNo(rs.getInt(1));
			game.setAdminID(rs.getInt(2));
			game.setGameNo(rs.getInt(3));
			game.setGameName(rs.getString(4));
			game.setGameHost(rs.getString(5));
			game.setgStartTime(rs.getString(6));
			game.setgEndTime(rs.getString(7));
			game.setgSpaceFees(rs.getInt(8));
			game.setGameHead(rs.getString(9));
			game.setHeadPhone(rs.getString(10));
			all.add(game);
		}
		this.pstmt.close();
		return all;
	}
	
	// 更改赛事
	public boolean doUpdate(int gameNo, String spaceNo, String gameName, String gameHost, String gStartTime, String gEndTime, int gSpaceFees, String gameHead, String headPhone) throws Exception {
		boolean flag = false;
		String sql = "UPDATE game SET spaceNo = ?,gameName = ?,gameHost = ?,gStartTime = ?,gEndTime = ?,gSpaceFees = ?,gameHead = ?,headPhone = ? WHERE gameNo = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, spaceNo);
		this.pstmt.setString(2, gameName);
		this.pstmt.setString(3, gameHost);
		this.pstmt.setString(4, gStartTime);
		this.pstmt.setString(5, gEndTime);
		this.pstmt.setInt(6, gSpaceFees);
		this.pstmt.setString(7, gameHead);
		this.pstmt.setString(8, headPhone);
		this.pstmt.setInt(9, gameNo);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	// 删除赛事
	public boolean doDelete(int gameNo) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM game WHERE gameNo = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, gameNo);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}
	
	// 通过赛事名称查找赛事编号
	public Game findNoByName(String gameName) throws Exception {
		Game game = null;
		String sql = "SELECT gameNo FROM game WHERE gameName = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, gameName);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			game = new Game();
			game.setGameNo(rs.getInt(1));
		}
		this.pstmt.close();
		return game;
	}

	//检查场地冲突
	public boolean doCheckSpaceIsRent(String spaceNo, String gStartTime,
			String gEndTime) throws Exception {
		boolean flag = false;
		String sql1 = "select adminID from game where spaceNo=? and gStartTime<=? and gEndTime >=? ";
		String sql2 = "select adminID from game where spaceNo=? and gStartTime<=? and gEndTime >=? ";
		String sql3 = "select adminID from game where spaceNo=? and gStartTime>=? and gStartTime<=? ";
		String sql4 = "select adminID from game where spaceNo=? and gEndTime>=? and gEndTime <=? ";
		this.pstmt = this.conn.prepareStatement(sql1);
		this.pstmt2 = this.conn.prepareStatement(sql2);
		this.pstmt3 = this.conn.prepareStatement(sql3);
		this.pstmt4 = this.conn.prepareStatement(sql4);
		
		this.pstmt.setString(1,spaceNo);
		this.pstmt.setString(2,gStartTime);
		this.pstmt.setString(3,gStartTime);
		
		this.pstmt2.setString(1,spaceNo);
		this.pstmt2.setString(2,gEndTime);
		this.pstmt2.setString(3,gEndTime);
		
		this.pstmt3.setString(1,spaceNo);
		this.pstmt3.setString(2,gStartTime);
		this.pstmt3.setString(3,gEndTime);
		
		this.pstmt4.setString(1,spaceNo);
		this.pstmt4.setString(2,gStartTime);
		this.pstmt4.setString(3,gEndTime);
		
		ResultSet rs = this.pstmt.executeQuery();
		ResultSet rs2 = this.pstmt2.executeQuery();
		ResultSet rs3 = this.pstmt3.executeQuery();
		ResultSet rs4 = this.pstmt4.executeQuery();
		
		if(!rs.next()&&!rs2.next()&&!rs3.next()&&!rs4.next()){
			flag = true;
		}
		this.pstmt.close();
		this.pstmt2.close();
		this.pstmt3.close();
		this.pstmt4.close();
		return flag;
		
	}
	*/

	//创建赛事
	public boolean doCreate(Game game) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO game(spaceTypeName,spaceNo,adminID, gameName, gameHost, gStartTime, gEndTime,gameHead, headPhone) VALUES (?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,game.getSpaceTypeName());
		this.pstmt.setString(2, game.getSpaceNo());
		this.pstmt.setInt(3, game.getAdminID());
		this.pstmt.setString(4, game.getGameName());
		this.pstmt.setString(5, game.getGameHost());
		this.pstmt.setString(6, game.getgStartTime());
		this.pstmt.setString(7, game.getgEndTime());
		this.pstmt.setString(8, game.getGameHead());
		this.pstmt.setString(9, game.getHeadPhone());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//得到所有赛事列表
	public List<Game> findAll() throws Exception {
		List<Game> all = new ArrayList<Game>();
		String sql = "SELECT * FROM game";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Game game = null;
		while(rs.next()) {
			game = new Game();
			game.setGameNo(rs.getInt(1));
			game.setSpaceTypeName(rs.getString(2));
			game.setSpaceNo(rs.getString(3));
			game.setAdminID(rs.getInt(4));
			game.setGameName(rs.getString(5));
			game.setGameHost(rs.getString(6));
			game.setgEndTime(rs.getString(7).substring(0, 16));
			game.setgStartTime(rs.getString(8).substring(0, 16));
			game.setGameHead(rs.getString(9));
			game.setHeadPhone(rs.getString(10));
			all.add(game);
		}
		this.pstmt.close();
		return all;
	}

	//查询赛事
	public List<Game> queryGame(String spaceTypeName, String spaceNo,
			String gameName) throws Exception {
		List<Game> all = new ArrayList<Game>();
		if(spaceTypeName==null){
			spaceTypeName = "";
		}
		if(spaceNo==null){
			spaceNo = "";
		}
		if(gameName==null){
			gameName = "";
		}
		String sql = "SELECT * FROM game where spaceTypeName like ? and spaceNo like ? and gameName like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+spaceTypeName+"%");
		this.pstmt.setString(2,"%"+spaceNo+"%");
		this.pstmt.setString(3,"%"+gameName+"%");
		ResultSet rs = this.pstmt.executeQuery();
		Game game = null;
		while(rs.next()) {
			game = new Game();
			game.setGameNo(rs.getInt(1));
			game.setSpaceTypeName(rs.getString(2));
			game.setSpaceNo(rs.getString(3));
			game.setAdminID(rs.getInt(4));
			game.setGameName(rs.getString(5));
			game.setGameHost(rs.getString(6));
			game.setgEndTime(rs.getString(7).substring(0, 16));
			game.setgStartTime(rs.getString(8).substring(0, 16));
			game.setGameHead(rs.getString(9));
			game.setHeadPhone(rs.getString(10));
			all.add(game);
		}
		this.pstmt.close();
		return all;
	}

	//删除赛事
	public boolean doDelete(int gameNo) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM game WHERE gameNo = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, gameNo);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	//更新赛事
	public boolean doUpdate(Game game) throws Exception {
		boolean flag = false;
		String sql = "update game set spaceTypeName=?,spaceNo=?,adminID=?, gameName=?, gameHost=?, gStartTime=?, gEndTime=?,gameHead=?,headPhone=? where gameNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,game.getSpaceTypeName());
		this.pstmt.setString(2, game.getSpaceNo());
		this.pstmt.setInt(3, game.getAdminID());
		this.pstmt.setString(4,game.getGameName());
		this.pstmt.setString(5,game.getGameHost());
		this.pstmt.setString(6,game.getgStartTime());
		this.pstmt.setString(7,game.getgEndTime());
		this.pstmt.setString(8,game.getGameHead());
		this.pstmt.setString(9,game.getHeadPhone());
		this.pstmt.setInt(10,game.getGameNo());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

    //检查赛事场地冲突
	public boolean doCheckSpaceIsRent(String spaceTypeName, String spaceNo,
			String gStartTime, String gEndTime) throws Exception {
		boolean flag = false;
		String sql1 = "select adminID from game where spaceTypeName=? and spaceNo=? and gStartTime<=? and gEndTime >=? ";
		String sql2 = "select adminID from game where spaceTypeName=? and spaceNo=? and gStartTime<=? and gEndTime >=? ";
		String sql3 = "select adminID from game where spaceTypeName=? and spaceNo=? and gStartTime>=? and gStartTime<=? ";
		String sql4 = "select adminID from game where spaceTypeName=? and spaceNo=? and gEndTime>=? and gEndTime <=? ";
		this.pstmt = this.conn.prepareStatement(sql1);
		this.pstmt2 = this.conn.prepareStatement(sql2);
		this.pstmt3 = this.conn.prepareStatement(sql3);
		this.pstmt4 = this.conn.prepareStatement(sql4);
		
		this.pstmt.setString(1,spaceTypeName);
		this.pstmt.setString(2,spaceNo);
		this.pstmt.setString(3,gStartTime);
		this.pstmt.setString(4,gStartTime);
		
		this.pstmt2.setString(1,spaceTypeName);
		this.pstmt2.setString(2,spaceNo);
		this.pstmt2.setString(3,gEndTime);
		this.pstmt2.setString(4,gEndTime);
		
		this.pstmt3.setString(1,spaceTypeName);
		this.pstmt3.setString(2,spaceNo);
		this.pstmt3.setString(3,gStartTime);
		this.pstmt3.setString(4,gEndTime);
		
		this.pstmt4.setString(1,spaceTypeName);
		this.pstmt4.setString(2,spaceNo);
		this.pstmt4.setString(3,gStartTime);
		this.pstmt4.setString(4,gEndTime);
		
		ResultSet rs = this.pstmt.executeQuery();
		ResultSet rs2 = this.pstmt2.executeQuery();
		ResultSet rs3 = this.pstmt3.executeQuery();
		ResultSet rs4 = this.pstmt4.executeQuery();
		
		if(!rs.next()&&!rs2.next()&&!rs3.next()&&!rs4.next()){
			flag = true;
		}
		this.pstmt.close();
		this.pstmt2.close();
		this.pstmt3.close();
		this.pstmt4.close();
		return flag;
		
	}
}
