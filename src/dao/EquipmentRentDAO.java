package dao;
import java.util.List;

import vo.EquipmentRent;
public interface EquipmentRentDAO {
    public boolean doCreateEquipmentRent(EquipmentRent equipmentRent) 
    		throws Exception;  //创建场地租借
    public boolean doDeleteEquipmentRent(int eRentID) throws Exception;//删除场地租借记录
    public boolean doReEquipment(String eTypeName,int eNumber) throws Exception;  //回收器材
    public List<EquipmentRent> findEquipmentRent(String eTypeName,
    		String eRentPeople) throws Exception;  //查询器材租借记录
    public List<EquipmentRent> showAllEquipmentRent() throws Exception;  //得到所有器材租借记录
}
