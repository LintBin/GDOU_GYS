<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="jscript">
function check(form1){
	if(form1.cdbh.value==""){
		alert("请输入场地编号!");form1.cdbh.focus();return false;
	}
	if(form1.cdbh.value.length !== 3){
		alert("请输入正确场地编号!");form1.cdbh.focus();return false;
	}
	if(form1.ssmc.value==""){
		alert("请输入赛事名称!");form1.ssmc.focus();return false;
	}
	if(form1.sszbf.value==""){
		alert("请输入主办方!");form1.sszbf.focus();return false;
	}
	if(form1.sssqr.value==""){
		alert("请输入申请人!");form1.sssqr.focus();return false;
	}
	if(form1.timestart.value==""){
		alert("请输入开始时间!");form1.timestart.focus();return false;
	}
	if(form1.timeup.value==""){
		alert("请输入结束时间!");form1.timeup.focus();return false;
	}
	if(form1.lxdh.value==""){
		alert("请输入联系电话!");form1.lxdh.focus();return false;
	}
	if(form1.lxdh.value.length !== 11){
		alert("请输入正确联系电话!");form1.lxdh.focus();return false;
	}
	else{
	   form1.action="../servlet/GameUpdate";
	}
}
</script>
<link href="../style/right.css" rel="stylesheet" type="text/css" />
<link href="../style/right_form.css" rel="stylesheet" type="text/css" />
<script src="../js/timepicker.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="../images/mail_leftbg.gif"><img src="../images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="../images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">更新界面</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="../images/mail_rightbg.gif"><img src="../images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="main" >
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" id="row_1" >
      <tr>
        <td class="left_bt3"><b>当前位置：赛事管理&gt;&gt;赛事更新</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="20%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post">

           
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">请更新赛事信息</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded-q4">&nbsp;</th>
        </tr>
     </thead>
    
     <tbody>
     <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">场地类别：</td>
	        <td><select name="Item" id="type">
            <option value="0">&nbsp;</option>
            <option value="1">乒乓球场</option>
            <option value="2">羽毛球场 </option>
            <option value="3">保龄球场</option>
            <option value="4">健身室 </option>
            <option value="5">毽球场</option>
            <option value="6">篮球场</option>
            </select>&nbsp;*</td>      
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
     
    	<tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">场地编号：</td>
         <td><input name="cdbh" type="text" value="${SelecGame.spaceNo }">&nbsp;*</td>       
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">赛事名称：</td>
         <td><input name="ssmc" type="text" value="${SelecGame.gameName}">&nbsp;*</td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">主办方：</td>
         <td><input name="sszbf" type="text" value="${SelecGame.gameHost}">&nbsp;*</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
		<td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td colspan="1">申请人</td> 
	    <td><input name="sssqr" type="text" value="${SelecGame.gameHead }">&nbsp;*</td>       
	    <td>&nbsp;</td>        
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    </tr>
	    
	    <tr>
	        <td>&nbsp;</td>
	       	<td>&nbsp;</td>
	        <td colspan="1">开始时间：</td>
	         <td><input name="timestart" type="text" value="${SelecGame.gStartTime}" onClick="setDayHM(this);">&nbsp;*</td>       
	        <td>&nbsp;</td>        
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	    </tr>
	    <tr>
	        <td>&nbsp;</td>
	       	<td>&nbsp;</td>
	        <td colspan="1">结束时间：</td>
	         <td><input name="timeup" type="text" value="${SelecGame.gEndTime}" onClick="setDayHM(this);">&nbsp;*</td>       
	        <td>&nbsp;</td>        
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	    </tr>
	     
	    <tr>
	        <td>&nbsp;</td>
	       	<td>&nbsp;</td>
	        <td colspan="1">联系电话</td>
	        <td><input name="lxdh" type="text" value="${SelecGame.headPhone}">&nbsp;*</td>      
	        <td>&nbsp;</td>        
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
        </tr>
        <tr>
	        <td>&nbsp;</td>
	       	<td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td><input name="Save" type="submit" class="btn_an" value="保存" onClick="return check(form1)">&nbsp;<input name="Reset" type="reset" class="btn_an" value="重置"></td>      
	        <td>&nbsp;</td>        
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
        </tr>
     </tbody>
</table>

</form>
</td>
</tr>
</table></td>
<td>&nbsp;</td>
</table></td>
</tr>
</table>
    </td>
    <td background="../images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="../images/mail_leftbg.gif"><img src="../images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="../images/buttom_bgs.gif"><img src="../images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="../images/mail_rightbg.gif"><img src="../images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
