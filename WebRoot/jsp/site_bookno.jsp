<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="jscript">
function check(form2){
	var checked=true;
    var id= document.getElementsByName("SpaceBookDel");
    var checkCount = 0;
    for(var i=0;i<id.length;i++){
        if(id[i].checked){
            checkCount++;
        }
    }
    if(checkCount == 0) {  
        alert("请选择要取消场地预约！");  
        return true;  
    }else{  
        if (confirm("您确定要取消这"+checkCount+"个场地预约吗？"))
	       form2.action="../servlet/SpaceRentDel";
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
        <td height="31"><div class="titlebt">管理预约</div></td>
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
        <td class="left_bt3"><b>当前位置：场地管理&gt;&gt;场地预约管理</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="10%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post" action="../servlet/SpaceRentFind">

<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">请输入查询信息</th>
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
        <td colspan="1">申请人：</td>
         <td><input name="cdsqr" type="text"></td>
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
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company"></th>
        	<th scope="col" class="rounded">场地类型</th>
            <th scope="col" class="rounded">场地编号</th>
            <th scope="col" class="rounded">收费标准</th>
            <th scope="col" class="rounded">开始时间</th>
            <th scope="col" class="rounded">结束时间</th>
			<th scope="col" class="rounded-q4">申请人</th>
        </tr>
    </thead>
    <tfoot>
    	<tr>
        	<td colspan="7" class="rounded-foot-left">
        	<input name="Save" type="submit" class="btn_red" value="取消预约" onClick="check(form2)">
            </td>
        </tr>
        <tr>
        <td colspan="7"><div class="pagination">
        <span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next &gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	
        <c:if test="${FindSpaceRent!=null}" var="flag" scope="page">
    		<c:forEach var="spaceRent" items="${FindSpaceRent}"  varStatus="status">
            	<tr>
            		<td> <input type="checkbox" name="SpaceBookDel" value="${status.index}" /></td>
   					<td> <c:out value="${spaceRent.spaceTypeName}"/></td>
   					<td> <c:out value="${spaceRent.spaceNo}"/></td>
   					<td> <c:out value="11rmb"></c:out></td>
   					<td> <c:out value="${spaceRent.sStartTime}"></c:out></td>
   					<td> <c:out value="${spaceRent.sEndTime}"></c:out></td>
   					<td> <c:out value="${spaceRent.sRentPeople}"></c:out></td>
				</tr>
			</c:forEach>
    	</c:if>
    	<c:if test="${FindSpaceRent==null}" var="flag" scope="page" >
             <c:forEach var="spaceRent" items="${AllSpaceRent}" varStatus="status">
            	<tr>
            		<td> <input type="checkbox" name="SpaceBookDel" value="${status.index}"/></td>
   					<td> <c:out value="${spaceRent.spaceTypeName}"/></td>
   					<td> <c:out value="${spaceRent.spaceNo}"/></td>
   					<td> <c:out value="11rmb"></c:out></td>
   					<td> <c:out value="${spaceRent.sStartTime}"></c:out></td>
   					<td> <c:out value="${spaceRent.sEndTime}"></c:out></td>
   					<td> <c:out value="${spaceRent.sRentPeople}"></c:out></td>
				</tr>
			 </c:forEach>
		</c:if>
        
    	
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
