import java.util.ArrayList;
import java.util.List;

import factory.*;
import vo.*;

public class test {
    public static void main(String[] args) throws Exception{
        /*创建场地收费
    	if(DAOFactory.getSTypeFeesDAOInstance().doCreateSTypeFees("保龄球场",15)){
    		System.out.println("创建成功");
    	}else{
    		System.out.println("创建失败");
    	}*/
    	/*删除场地收费
    	if(DAOFactory.getSTypeFeesDAOInstance().doDeleteSTypeFees("篮球场")){
    		System.out.println("删除成功");
    	}*/
    	/*根据场地类型名称查询场地收费
    	int fee = DAOFactory.getSTypeFeesDAOInstance().doQuerySpaceFees("羽毛球场");
    	System.out.println(fee);*/
    	
    	/*创建场地,如果场地收费表里没有该场地类型，则新建
        if(DAOFactory.getSpaceDAOInstance().doCreateSpace("保龄球场", "002",1, 15, "请不要将保龄球拿回宿舍！")){
        	System.out.println("创建成功");
        }    	
    	/*若是该类型最后一个，则连同收费表一起删除
    	if(DAOFactory.getSpaceDAOInstance().doDeleteSpace("保龄球场","001")){
    		System.out.println("删除成功");
    	}*/
    	/* 更新场地
    	if(DAOFactory.getSpaceDAOInstance().doUpdateSpace("保龄球场", "002", 20,"保龄球涨价了！")){
    		System.out.println("更新成功");
    	}*/
    	/*查询场地
    	List<Space> sp = new ArrayList<Space>();
    	sp = DAOFactory.getSpaceDAOInstance().doQuerySpace(null,null);
    	
    	for(int i=0;i<sp.size();i++){
    		System.out.println(sp.get(i).getSpaceTypeName()
    				+" "+sp.get(i).getSpaceNo()+" "+sp.get(i).getRemarks());
    	}
    	*/
    	/*新建租借场地
    	SpaceRent spaceRent = new SpaceRent();
    	spaceRent.setspaceTypeName("羽毛球场");
    	spaceRent.setSpaceNo("001");
    	spaceRent.setsStartTime("2013-12-11 12:00");
    	spaceRent.setsEndTime("2013-12-11 15:00");
    	spaceRent.setsRentPeople("南瓜");
    	if(DAOFactory.getSpaceRentDAOInstance().doCreateSpaceRent(spaceRent)){
    		System.out.println("添加场地预约成功");
    	}*/
    	/*检查场地冲突
    	if(DAOFactory.getSpaceRentDAOInstance().doCheckSpaceIsRent("羽毛球场","001","2013-12-11 12:00","2013-12-11 13:00")){
    		System.out.println("该场地无人租借");
    	}else{
    		System.out.println("该场地有人租借");
    	}*/
    	/*删除场地预约
    	if(DAOFactory.getSpaceRentDAOInstance().doDeleteSpaceRent("羽毛球场","001","2013-12-11 12:00","2013-12-11 15:00")){
    		System.out.println("该场地预约删除成功");
    	}*/
    	/*查询场地租借
    	List<SpaceRent> sr = new ArrayList<SpaceRent>();
    	sr = DAOFactory.getSpaceRentDAOInstance().doQuerySpaceRent("篮球场",null);
    	System.out.println(sr.get(0).getsEndTime());
    	*/
    	/*返回所有场地租借
    	List<SpaceRent> sr = new ArrayList<SpaceRent>();
    	sr = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();
    	System.out.println(sr.get(0).getsEndTime());
    	*/
    	/*添加器材
    	Equipment ep = new Equipment();
    	ep.seteTypeName("哑铃");
    	ep.setAdminID(1);
    	ep.seteNumber(20);
    	ep.setCompensation(200);
    	ep.seteRentFees(10);
    	if(DAOFactory.getEquipmentDAOInstance().doAddEquipment(ep)){
    		System.out.println("添加器材陈宫");
    	}*/
    	/*删除器材
    	if(DAOFactory.getEquipmentDAOInstance().doDeleteEquipment("篮球")){
    		System.out.println("删除器材陈宫");
    	}*/
    	/*更新
    	Equipment ep = new Equipment();
    	ep.seteTypeName("羽毛球");
    	ep.setAdminID(1);
    	ep.seteNumber(20);
    	ep.setCompensation(100);
    	ep.seteRentFees(50);
    	if(DAOFactory.getEquipmentDAOInstance().doUpdateEquipment(ep)){
    		System.out.println("更新器材陈宫");
    	}*/
    	/*查询场地
    	List<Equipment> ep = new ArrayList<Equipment>();
    	ep = DAOFactory.getEquipmentDAOInstance().findEquipment("羽毛球");
    	System.out.println(ep.get(0).geteNumber());
    	*/
    	/*返回所有场地
    	List<Equipment> ep = new ArrayList<Equipment>();
    	ep = DAOFactory.getEquipmentDAOInstance().showAllEquipment();
    	System.out.println(ep.get(0).geteNumber());
    	*/
    	/*创建器材租借
    	EquipmentRent er = new EquipmentRent();
    	er.seteTypeName("羽毛球");
    	er.seteStartTime("2013-12-20");
    	er.seteEndTime("2013-12-30");
    	er.setRentNumber(3);
    	er.seteRentPeople("南瓜");
    	if(DAOFactory.getEquipmentRentDAOInstance().doCreateEquipmentRent(er)){
    		System.out.println("创建器材租借成功");
    	}*/
    	/*
    	DAOFactory.getEquipmentRentDAOInstance().doReEquipment("羽毛球", 3);
    	*/
    	/*删除器材租借记录
    	if(DAOFactory.getEquipmentRentDAOInstance().doDeleteEquipmentRent("羽毛球", "2013-12-20", "2013-12-30")){
    		System.out.println("删除器材租借记录成功");
    	}*/
    	/*查询器材租借记录
    	List<EquipmentRent> er = new ArrayList<EquipmentRent>();
    	er = DAOFactory.getEquipmentRentDAOInstance().findEquipmentRent("羽毛球", null);
    	System.out.println(er.get(0).geteRentPeople());
    	*/
    	/*得到所有器材租借记录
    	List<EquipmentRent> er = new ArrayList<EquipmentRent>();
    	er = DAOFactory.getEquipmentRentDAOInstance().showAllEquipmentRent();
    	System.out.println(er.get(0).geteRentPeople());
    	*/
    	/*创建赛事
    	Game g = new Game();
    	g.setSpaceTypeName("篮球场");
    	g.setSpaceNo("001");
    	g.setAdminID(1);
    	g.setGameName("海大杯篮球赛");
    	g.setgStartTime("2013-12-01 12:00");
    	g.setgEndTime("2013-12-01 19:00");
    	g.setGameHost("校学生会体育部");
    	g.setHeadPhone("10086");
    	g.setGameHead("南瓜");
    	if(DAOFactory.getGameDAOInstance().doCreate(g)){
    		System.out.println("创建赛事成功");
    	}
    	*/
    	/*更新赛事
    	Game g = new Game();
    	g.setGameNo(2);
    	g.setSpaceTypeName("篮球场");
    	g.setSpaceNo("002");
    	g.setAdminID(1);
    	g.setGameName("海大杯篮球赛");
    	g.setgStartTime("2013-12-02 12:00");
    	g.setgEndTime("2013-12-02 19:00");
    	g.setGameHost("校学生会体育部");
    	g.setHeadPhone("10086");
    	g.setGameHead("南瓜");
    	DAOFactory.getGameDAOInstance().doUpdate(g);
    	*/
    	//查询赛事
    	/*List<Game> g = new ArrayList<Game>();
    	g = DAOFactory.getGameDAOInstance().queryGame(null,null,null);
    	System.out.println(g.get(0).getGameHead());
    	*/
    	/*得到所有赛事
    	List<Game> g = new ArrayList<Game>();
    	g = DAOFactory.getGameDAOInstance().findAll();
    	System.out.println(g.get(0).getGameHost());
    	*/
    	/*检查赛事场地冲突
    	if(DAOFactory.getGameDAOInstance().doCheckSpaceIsRent("篮球场", "002","2013-12-02 11:00","2013-12-02 11:30")){
    		System.out.println("改时间段场地无人租借");
    	}else{
    		System.out.println("改时间段场地被人租借");
    	}*/
    	/*删除赛事
    	if(DAOFactory.getGameDAOInstance().doDelete(1)){
    		System.out.println("赛事删除成功");
    	}*/
    	/*创建公告
    	if(DAOFactory.getAnnouncementDAOInstance().doCreateAnnouncement("置顶公告","今天我今天不错")){
    		System.out.println("创建公告成功");
    	}*/
    	/*更新公告
    	if(DAOFactory.getAnnouncementDAOInstance().doUpdateAnnouncement(1,"公告","今天心情不错")){
    		System.out.println("更新公告成功");
    	}*/
    	/*查询公告
    	Announcement an = new Announcement();
    	an = DAOFactory.getAnnouncementDAOInstance().doQuery(1);
    	System.out.println(an.getaDetail());
    	*/
    	/*创建条例
    	if(DAOFactory.getSetFinesDAOInstance().doCreateSetFines("。。。。", "损一罚十")){
    		System.out.println("创建条例成功");
    	}*/
    	/*更新条例
    	if(DAOFactory.getSetFinesDAOInstance().doUpdateSetFines(1, "呵呵呵", "哈哈啊哈")){
    		System.out.println("更新条例成功");
    	}*/
    	/*
    	SetFines sf = new SetFines();
    	sf = DAOFactory.getSetFinesDAOInstance().doQuery(1);
    	System.out.println(sf.getFinesDetail());
    	*/
    }
}
