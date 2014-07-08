package dao;
import vo.*;

public interface LoginDAO {
	
	 public boolean superUserLogin(LoginBean loginBean) throws Exception;  //验证超级用户登陆
	 public boolean adminLogin(LoginBean loginBean) throws Exception;  //验证管理员登陆

}
