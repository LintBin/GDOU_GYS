package dbc;

import java.sql.*;

public class DBConnection {
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=GMS";
	private static final String DBUSER = "gms";
	private static final String DBPASSWORD = "gms";
	private Connection conn = null;
	
	public DBConnection() throws Exception{
		Class.forName(DBDRIVER);
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);		
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn!=null){
		    try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
