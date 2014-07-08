package dao;

public interface STypeFeesDAO {
    public boolean doCreateSTypeFees(String spaceTypeName, int spaceFees) throws Exception; //创建场地收费表
    public boolean doDeleteSTypeFees(String spaceTypeName) throws Exception;  //删除场地收费表
    public boolean doUpdateSTypeFees(String spaceTypeName, int spaceFees) throws Exception; //更新场地收费
    public int doQuerySpaceFees(String spaceTypeName) throws Exception;  //根据场地类型名查询场地收费
}
