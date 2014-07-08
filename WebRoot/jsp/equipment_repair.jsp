<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../style/right.css" rel="stylesheet" type="text/css" />
<link href="../style/right_form.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="../images/mail_leftbg.gif"><img src="../images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="../images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">报修设置</div></td>
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
        <td class="left_bt3"><b>当前位置：器材管理&gt;&gt;报修器材</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="20%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post" action="">  
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">请输入查询信息哦~</th>
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
        <td colspan="1">器材名称：</td>
         <td><input name="qcmc" type="text"></td>       
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">器材类别：</td>
         <td><input name="qclb" type="text"></td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
		<td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">器材编号：</td>
         <td><input name="qcbh" type="text"></td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
		<td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
	    <tr>
	        <td>&nbsp;</td>
	       	<td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td><input name="Save" type="submit" class="btn_an" value="提交">&nbsp;<input name="Reset" type="reset" class="btn_an" value="重置"></td>      
	        <td>&nbsp;</td>        
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
	        <td>&nbsp;</td>
        </tr>
     </tbody>
</table>
</form>
<form name="form2" method="post" action="">
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
        	<th scope="col" class="rounded">器材编号</th>
            <th scope="col" class="rounded">器材名称</th>
            <th scope="col" class="rounded">器材类别</th>
            <th scope="col" class="rounded">租用费用</th>
            <th scope="col" class="rounded">器材备注</th>
            <th scope="col" class="rounded-q4">创建者</th>
        </tr>
     </thead>
     <tfoot>
        <tr>
        	<td colspan="7" class="rounded-foot-left">
        	<input name="Save" type="submit" class="btn_red" value="报修器材">
            </td>
        </tr>
    	<tr>
        <td colspan="7"><div class="pagination"><span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next&gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	<tr>
        	<td><input type="checkbox" name="" /></td>
        	<td>001</td>
            <td>篮球-01</td>
            <td>篮球</td>
            <td>2rmb/h</td>
            <td>篮球很好玩</td>
            <td>2k</td>
        </tr>
        
    	<tr>
        	<td><input type="checkbox" name="" /></td>
        	<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr> 
        
    	<tr>
        	<td><input type="checkbox" name="" /></td>
        	<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
			<td>&nbsp;</td>
        </tr>
        
    	<tr>
        	<td><input type="checkbox" name="" /></td>
        	<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
			<td>&nbsp;</td>
        </tr>  
        
    	<tr>
        	<td><input type="checkbox" name="" /></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
			<td>&nbsp;</td>
        </tr>
        
    	<tr>
        	<td><input type="checkbox" name="" /></td>
        	<td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
			<td>&nbsp;</td>
        </tr>
        <tr>
        <td><input type="checkbox" name="" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td><input type="checkbox" name="" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td><input type="checkbox" name="" /></td>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
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
