package servlet.assist;
import java.io.FileOutputStream;  
import java.io.OutputStream;    
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import vo.EquipmentRent;
import vo.SpaceRent;

import factory.DAOFactory;
  
import jxl.Workbook;     
import jxl.write.*;  
import jxl.write.Number;

public class Excel {
    public static void main(String excelName) {
    	System.out.println("调用Excel2");
    	if (excelName == "器材") {
    		// 准备设置excel工作表的标题     
            String[] title = {"器材类型","器材租借开始时间","器材租借结束时间","租借数量","租借人"};            
            try {          
                // 输出的excel的路径     
                String filePath = "D://"+excelName+"reprot.xls";  
                System.out.println(filePath);
                // 创建Excel工作薄     
                WritableWorkbook wwb;
                // 新建立一个jxl文件,即在C盘下生成test.xls     
                OutputStream os = new FileOutputStream(filePath);     
                wwb=Workbook.createWorkbook(os);      
                // 添加第一个工作表并设置第一个Sheet的名字     
                WritableSheet sheet = wwb.createSheet("体育馆月收入报表", 0);     
                Label label;
                // 设置列的列长度 
                // 下面是填充数据     
                /*     
                 * Number用法(列, 行,内容)
                 * Label用法(列, 行, 内容)
                 * */ 
                sheet.setColumnView(1,18);
                sheet.setColumnView(2,18);
                for(int i=0;i<title.length;i++){             	
                    label = new Label(i,0,title[i]);       
                    sheet.addCell(label);     
                }     
                // 填充器材类型
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label eType = new Label(0, l, eRent().get(l-1).geteTypeName());
        			sheet.addCell(eType);
        		}
                // 填充器材租借开始时间
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label esTime = new Label(1, l, eRent().get(l-1).geteStartTime()); 
        			sheet.addCell(esTime);
        		}        
                // 填充器材租借结束时间
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label eeTime = new Label(2, l, eRent().get(l-1).geteEndTime());
        			sheet.addCell(eeTime);
        		}    
        		// 填充租借数量
        		for (int l = 1; l <= eRent().size(); l++) {
        			Number eNumber = new Number(3, l, eRent().get(l-1).getRentNumber()); 
        			sheet.addCell(eNumber);
        		}  
        		// 填充租借人
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label ePeoper = new Label(4, l, eRent().get(l-1).geteRentPeople());
        			sheet.addCell(ePeoper);
        		}  
                // 写入数据     
                wwb.write();     
                // 关闭文件     
                wwb.close(); 
                System.out.println("----器材租借报表完成该操作----"); 
                System.out.println(eRent().size());
            } catch (Exception e) {     
                System.out.println("---出现异常---");     
                e.printStackTrace();     
            }     
    	}
    	if (excelName == "场地") {
    		// 准备设置excel工作表的标题     
            String[] title = {"场地类型","场地编号","场地租借开始时间","场地租借结束时间","租借人"};             
            try {          
                // 输出的excel的路径     
                String filePath = "D://"+excelName+"reprot.xls";     
                // 创建Excel工作薄     
                WritableWorkbook wwb;
                // 新建立一个jxl文件,即在C盘下生成test.xls     
                OutputStream os = new FileOutputStream(filePath);     
                wwb=Workbook.createWorkbook(os);      
                // 添加第一个工作表并设置第一个Sheet的名字     
                WritableSheet sheet = wwb.createSheet("体育馆月收入报表", 0);     
                Label label;
                // 设置列的列长度 
                // 下面是填充数据     
                /*     
                 * Number用法(列, 行,内容)
                 * Label用法(列, 行, 内容)
                 * */ 
                sheet.setColumnView(2,18);
                sheet.setColumnView(3,18);
                for(int i=0;i<title.length;i++){             	
                    label = new Label(i,0,title[i]);       
                    sheet.addCell(label);     
                }     
                // 填充场地类型
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label eType = new Label(0, l, sRent().get(l-1).getspaceTypeName());
        			sheet.addCell(eType);
        		}
                // 填充场地编号
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label esTime = new Label(1, l, sRent().get(l-1).getSpaceNo()); 
        			sheet.addCell(esTime);
        		}        
                // 填充场地租借开始时间
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label eeTime = new Label(2, l, sRent().get(l-1).getsStartTime());
        			sheet.addCell(eeTime);
        		}    
        		// 填充场地租借结束时间
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label eNumber = new Label(3, l, sRent().get(l-1).getsEndTime()); 
        			sheet.addCell(eNumber);
        		}  
        		// 填充租借人
        		for (int l = 1; l <= eRent().size(); l++) {
        			Label ePeoper = new Label(4, l, sRent().get(l-1).getsRentPeople());
        			sheet.addCell(ePeoper);
        		}  
                // 写入数据     
                wwb.write();     
                // 关闭文件     
                wwb.close(); 
                System.out.println("----场地租借报表完成该操作----"); 
            } catch (Exception e) {     
                System.out.println("---出现异常---");     
                e.printStackTrace();     
            }     
    	}  
    }  
   
    
    // 获得所以器材租借信息
    public static List<EquipmentRent> eRent()  throws Exception {
    	List<EquipmentRent> all = new ArrayList<EquipmentRent>();
    	all = DAOFactory.getEquipmentRentDAOInstance().showAllEquipmentRent();
		return all;
    }
    
    // 获得所以场地租借信息
    public static List<SpaceRent> sRent() throws Exception {
    	List<SpaceRent> all = new ArrayList<SpaceRent>();
    	all = DAOFactory.getSpaceRentDAOInstance().showAllSpaceRent();
    	return all;
    }
}