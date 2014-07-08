package test;
import java.util.ArrayList;
import java.util.List;

import factory.*;
import vo.*;

public class test {
    public static void main(String[] args) throws Exception{
    	
    	//  登陆
    	/*LoginBean loginBean = new LoginBean();
    	loginBean.setLoginName("admin");
    	loginBean.setLoginPassword("0000");
    	
    	if(DAOFactory.getLoginDAOInstance().superUserLogin(loginBean)){
    		System.out.println("超级用户登陆成功");
    	}else if(DAOFactory.getLoginDAOInstance().adminLogin(loginBean)){
    		System.out.println("管理员登陆成");
    	}else{
    		System.out.println("用户名或密码错误");
    	}*/
    	
    	

    	//创建管理员
    	/*Admin admin = new Admin();
    	admin.setAdminName("admin");
    	admin.setAdminPassword("0000");
    	admin.setAdminPhone("10086");
    	admin.setAdminSex("男");
    	
    	if(DAOFactory.getAdminDAOInstance().doCreate(admin)){
    		System.out.println("创建管理员成员");
    	}else{
    		System.out.println("创建失败");
    	}*/
    	
    	/*根据ID查询
    	admin admin = new admin();
    	admin = DAOFactory.getAdminDAOInstance().findById(1);
    	System.out.println(admin.getAdminName());
        */
    	/*更新管理员
    	if(DAOFactory.getAdminDAOInstance().doUpdate("admin1","456789","男,"135465789")){
    		System.out.print("更新成功");
    	}else{
    		System.out.print("更新失败");
    	}
    	
    	*/
    	/*删除管理员
    	if(DAOFactory.getAdminDAOInstance().doDelete(1)){
    		System.out.print("删除成功");
    	}else{
    		System.out.print("删除失败");
    	}
    	*/
    	
    /*	List<Admin> all = new ArrayList<Admin>();
    	all = DAOFactory.getAdminDAOInstance().findAll("男");
    	System.out.println(all.size());
    	System.out.println(all.get(0).getAdminName());*/
    	
    	
    	//条件查询管理员
    	List<Admin> selectAdmin = new ArrayList<Admin>();
    	selectAdmin = DAOFactory.getAdminDAOInstance().queryAdmin("lin", "男", null);
    	System.out.println(selectAdmin.size());
    }
}
