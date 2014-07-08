<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	StringBuffer requestUrlBuffer = (StringBuffer)request.getRequestURL();
	System.out.println(requestUrlBuffer);
	String requestURL = requestUrlBuffer.toString();
	session.setAttribute("requestURL", requestURL);
 %>
<script language="jscript">
function check(form2){
	var checked=true;
    var id= document.getElementsByName("adminDel");
    var checkCount = 0;
    for(var i=0;i<id.length;i++){
        if(id[i].checked){
            checkCount++;
        }
    }
    if(checkCount == 0) {  
        alert("请选择要删除的管理员！");  
        return true;  
    }else{  
        if (confirm("您确定要删除这"+checkCount+"个管理员吗？"))
	       form2.action="../servlet/DelAdminServlet";
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
        <td height="31"><div class="titlebt">删除界面</div></td>
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
        <td class="left_bt3"><b>当前位置：人员管理&gt;&gt;删除人员</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="10%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post" action="../servlet/FindAdminServlet">  
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
        <td colspan="1">管理员名称：</td>
         <td><input name="glymc" type="text"></td>       
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
        
        <tr>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td colspan="1">性别：</td>
	    <td><select name="Item" id="type">
            <option value="0">男 </option>
            <option value="1">女</option>
            </select></td>       
	    <td>&nbsp;</td>        
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    </tr>
        
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">联系方式：</td>
         <td><input name="lxfs" type="text"></td>
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
            <th scope="col" class="rounded">管理员名称</th>
            <th scope="col" class="rounded">性别</th>
            <th scope="col" class="rounded-q4">联系方式</th>
        </tr>
     </thead>
     <tfoot>
    	<tr>
        	<td colspan="7" class="rounded-foot-left">
        	<input name="Save" type="submit" class="btn_red" value="删除管理员" onClick="check(form2)">
        	</td>
        </tr>
        <tr>
        <td colspan="7"><div class="pagination"><span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next&gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	<c:if test="${selectAdmin!=null}" var="flag" scope="page">
    		<c:forEach var="select" items="${selectAdmin}"  varStatus="status">
            	<tr>
            		<td> <input type="checkbox" name="adminDel" value="${status.index}" /></td>
   					<td> <c:out value="${select.adminName}"/></td>
   					<td> <c:out value="${select.adminSex}"/></td>
   					<td> <c:out value="${select.adminPhone }"></c:out></td>
				</tr>
			</c:forEach>
    	</c:if>
    	<c:if test="${selectAdmin==null}" var="flag" scope="page" >
             <c:forEach var="item" items="${AllAdmin}" varStatus="status">
            	<tr>
            		<td> <input type="checkbox" name="adminDel" value="${status.index}"/></td>
   					<td> <c:out value="${item.adminName}"/></td>
   					<td> <c:out value="${item.adminSex}"/></td>
   					<td> <c:out value="${item.adminPhone }"></c:out></td>
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
