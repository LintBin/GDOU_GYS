package dao;
import vo.SetFines;

public interface SetFinesDAO {
	public boolean doCreateSetFines(String finesTittle,String finesDetail) throws Exception; //新建罚款条例
	public boolean doUpdateSetFines(int finesNo,
			String finesTittle,String finesDetail)throws Exception;  //更新罚款条例
	public SetFines doQuery(int finesNo) throws Exception; //查找罚款条例
}
