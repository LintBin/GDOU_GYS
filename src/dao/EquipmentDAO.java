package dao;

import java.util.List;
import vo.Equipment;

public interface EquipmentDAO {
    public boolean doAddEquipment(Equipment equipment) throws Exception;  //增加器材
    public boolean doDeleteEquipment(String eTypeName) throws Exception; //删除器材
    public boolean doUpdateEquipment(Equipment equipment) throws Exception;  //更新器材
    public List<Equipment> findEquipment(String eTypeName) throws Exception;  //查找器材
    public List<Equipment> showAllEquipment() throws Exception; //显示所有器材
    public boolean doUpdateENumber(String eTypeName ,int eNumber) throws Exception; //更新器材数量
}
