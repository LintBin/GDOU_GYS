<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="jscript">
function check(form1){
	if(form1.qcsl.value==""){
		alert("请输入器材数量!");form1.qcsl.focus();return false;
	}
	if(form1.shfy.value==""){
		alert("请输入损坏费用!");form1.shfy.focus();return false;
	}
	if(form1.qcfy.value==""){
		alert("请输入租用费用!");form1.qcfy.focus();return false;
	}
	else{
	   form1.action="../servlet/EquipmentAdd";
	}
}
</script>
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
        <td height="31"><div class="titlebt">添加界面</div></td>
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
        <td class="left_bt3"><b>当前位置：器材管理&gt;&gt;添加器材</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="10%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
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
            <th scope="col" class="rounded">请输入新器材信息</th>
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
        <td colspan="1">器材类别：</td>
         	    <td><select name="Item" id="type">
            <option value="1">乒乓球</option>
            <option value="2">羽毛球 </option>
            <option value="3">保龄球</option>
            <option value="4">哑铃 </option>
            <option value="5">毽球</option>
            <option value="6">篮球</option>
            </select>&nbsp;*</td> 
        <td>&nbsp;</td>        
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">器材数量：</td>
         <td><input name="qcsl" type="text">&nbsp;个*</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
		<td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td colspan="1">损坏费用：</td>
	    <td><input name="shfy" type="text">&nbsp;元/个*</td>       
	    <td>&nbsp;</td>        
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    </tr>
        <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td colspan="1">租借费用：</td>
	    <td><input name="qcfy" type="text">&nbsp;元/个*</td>       
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
<form name="form2" method="post" action="">
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
            <th scope="col" class="rounded">器材类别</th>
            <th scope="col" class="rounded">器材数量</th>
            <th scope="col" class="rounded">损坏费用</th>
            <th scope="col" class="rounded">租用费用</th>
            <th scope="col" class="rounded-q4">创建者</th>
        </tr>
     </thead>
     <tfoot>
    	<tr>
        <td colspan="7"><div class="pagination"><span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next&gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	<c:forEach var="item" items="${AllEquipment}">
            	<tr>
            		<td>&nbsp;</td>
   					<td> <c:out value="${item.eTypeName}"/></td>
   					<td> <c:out value="${item.eNumber}"/></td>
   					<td> <c:out value="${item.compensation}元/个"/></td>
   					<td> <c:out value="${item.eRentFees}元/个"></c:out></td>
   					<td> <c:out value="${item.adminID }"></c:out></td>
				</tr>
			 </c:forEach>
        
        
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
