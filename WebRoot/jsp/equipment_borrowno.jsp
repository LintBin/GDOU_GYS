<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="jscript">
function check(form2){
	var checked=true;
    var id= document.getElementsByName("equipmentDel");
    var checkCount = 0;
    for(var i=0;i<id.length;i++){
        if(id[i].checked){
            checkCount++;
        }
    }
    if(checkCount == 0) {  
        alert("请选择要收回的器材！");  
        return true;  
    }else{  
        if (confirm("您确定要收回这"+checkCount+"类器材吗？"))
	       form2.action="../servlet/EquipRentDel";
	       return false; 
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
        <td height="31"><div class="titlebt">收回界面</div></td>
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
        <td class="left_bt3"><b>当前位置：器材管理&gt;&gt;收回器材</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="10%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post" action="../servlet/EquipRentFind">

           
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
        <td colspan="1">器材类别：</td>
         	    <td><select name="Item" id="type">
            <option value="0">&nbsp;</option>
            <option value="1">乒乓球</option>
            <option value="2">羽毛球 </option>
            <option value="3">保龄球</option>
            <option value="4">哑铃 </option>
            <option value="5">毽球</option>
            <option value="6">篮球</option>
            </select></td> 
        <td>&nbsp;</td>        
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">申请人：</td>
         <td><input name="qcsqr" type="text"></td>
        <td>&nbsp;</td>        
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td>&nbsp;</td>
        <td><input name="Submit" type="submit" class="btn_an" value="提交" >&nbsp;<input name="Submit2" type="reset" class="btn_an" value="重置"></td>      
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>   
    </tbody>
</table>
</form>
 <form name="form2" method="post">
<table id="rounded-corner" style="width:850px">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
        	<th scope="col" class="rounded">器材类别</th>
        	<th scope="col" class="rounded">租用数量</th>
            <th scope="col" class="rounded">损坏收费</th>
            <th scope="col" class="rounded">租用收费</th>
            <th scope="col" class="rounded">开始时间</th>
            <th scope="col" class="rounded">结束时间</th>
			<th scope="col" class="rounded-q4">申请人</th>
        </tr>
    </thead>
    <tfoot>
    	<tr>
        	<td colspan="8" class="rounded-foot-left">
        	<input name="Save" type="submit" class="btn_red" value="收回器材" onClick="check(form2)">
            </td>
        </tr>
        <tr>
        <td colspan="8"><div class="pagination">
        <span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next &gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	
        
    		<c:forEach var="item" items="${FindEquipRent}"  varStatus="status">
            	<tr>
            		<td> <input type="checkbox" name="equipmentDel" value="${status.index}"/></td>
   					<td> <c:out value="${item.eTypeName}"/></td>
   					<td> <c:out value="${item.rentNumber}"/></td>
   					 <td>200元/个</td>
   					 <td>2元/个</td>
   					<td> <c:out value="${item.eStartTime }"></c:out></td>
   					<td> <c:out value="${item.eEndTime }"></c:out></td>
   					<td> <c:out value="${item.eRentPeople}"></c:out></td>
				</tr>
			</c:forEach>
    </tbody>
</table></form>

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
