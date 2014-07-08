package daoImpl;
import dao.EquipmentDAO;
import vo.Equipment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAOImpl implements EquipmentDAO{
    	private Connection conn = null;
    	private PreparedStatement pstmt = null;
    	private ResultSet rs = null;
    	
    	public EquipmentDAOImpl(Connection conn){
    		this.conn = conn;
    	}

		//增加器材
		public boolean doAddEquipment(Equipment equipment) throws Exception {
			boolean flag = false;
			String sql = "insert into equipment values(?,?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setString(1,equipment.geteTypeName());
			this.pstmt.setInt(2,equipment.getAdminID());
			this.pstmt.setInt(3,equipment.geteNumber());
			this.pstmt.setInt(4,equipment.getCompensation());
			this.pstmt.setInt(5,equipment.geteRentFees());

			
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
            this.pstmt.close();
			return flag;
		}

		//删除器材
		public boolean doDeleteEquipment(String eTypeName) throws Exception {
			boolean flag = false;
			 String sql = "delete from equipment where eTypeName = ? ";
			 this.pstmt = this.conn.prepareStatement(sql);
			 
			 this.pstmt.setString(1,eTypeName);
			 
			 if(this.pstmt.executeUpdate()>0){
				 flag = true;
			 }
			 this.pstmt.close();
			return flag;
		}

		//更新器材
		public boolean doUpdateEquipment(Equipment equipment) throws Exception {
			boolean flag = false;
			String sql = "update equipment set eNumber=? , compensation=? ,eRentFees=?  where  eTypeName = ? ";
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setInt(1,equipment.geteNumber());
			this.pstmt.setInt(2,equipment.getCompensation());
			this.pstmt.setInt(3,equipment.geteRentFees());
			this.pstmt.setString(4,equipment.geteTypeName());
			
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
			this.pstmt.close();
			
			return flag;
		}

		//查找器材
		public List<Equipment> findEquipment(String eTypeName) throws Exception {
			List<Equipment> ep = new ArrayList<Equipment>();
			String sql = "select eTypeName,adminID,eNumber,compensation,eRentFees" +
					" from equipment where eTypeName like ? ";
			this.pstmt = this.conn.prepareStatement(sql);
			if(eTypeName==null){
				eTypeName = "";
			}
			this.pstmt.setString(1,"%"+eTypeName+"%");
			ResultSet rs = this.pstmt.executeQuery();
			Equipment equipment = null;
			while(rs.next()){
				equipment = new Equipment();
				equipment.seteTypeName(rs.getString(1));
				equipment.setAdminID(rs.getInt(2));
				equipment.seteNumber(rs.getInt(3));
				equipment.seteRentFees(rs.getInt(4));
				equipment.setCompensation(rs.getInt(5));
				ep.add(equipment);
			}
			return ep;
		}

		//显示所有器材
		public List<Equipment> showAllEquipment() throws Exception {
			List<Equipment> ep = new ArrayList<Equipment>();
			String sql = "select eTypeName,adminID,eNumber,compensation,eRentFees" +
					" from equipment";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			Equipment equipment = null;
			while(rs.next()){
				equipment = new Equipment();
				equipment.seteTypeName(rs.getString(1));
				equipment.setAdminID(rs.getInt(2));
				equipment.seteNumber(rs.getInt(3));
				equipment.seteRentFees(rs.getInt(4));
				equipment.setCompensation(rs.getInt(5));
				ep.add(equipment);
			}
			
			return ep;
		}
		//更新器材数量
				public boolean doUpdateENumber(String eTypeName ,int eNumber) throws Exception {
					boolean flag = false;
					String sql = "update equipment set eNumber=? where eTypeName = ? ";
					this.pstmt = this.conn.prepareStatement(sql);
					
					this.pstmt.setInt(1,eNumber);
					this.pstmt.setString(2,eTypeName);
					
					if(this.pstmt.executeUpdate()>0){
						flag = true;
					}
					this.pstmt.close();
					
					return flag;
				}
        
}
