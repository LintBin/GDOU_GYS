<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	StringBuffer requestUrlBuffer = (StringBuffer)request.getRequestURL();
	System.out.println(requestUrlBuffer);
	String requestURL = requestUrlBuffer.toString();
	session.setAttribute("requestURL", requestURL);
%>
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
        <td height="31"><div class="titlebt">查询界面</div></td>
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
        <td class="left_bt3"><b>当前位置：赛事管理&gt;&gt;查询赛事</b></td>
      </tr>
      <tr>
        <td colspan="3"><table width="100%" height="777px" border="0" cellpadding="0" cellspacing="0"> <!-- 设置 right 页面高度 -->
        <tr>
        <td height="5%">&nbsp;</td>   <!-- 设置right 内容 高度 -->
        </tr>
          <tr>
            <td align="center" valign="top">	
            <form name="form1" method="post" action="../servlet/GameFind">  
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">&nbsp;</th>
            <th scope="col" class="rounded">请输入需要查询的赛事信息哦~</th>
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
	        
	        </tr>
    	<tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">场地编号：</td>
         <td><input name="cdbh" type="text"></td>       
        <td>&nbsp;</td>        
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
        </tr>
        
  
        <tr>
        <td>&nbsp;</td>
       	<td>&nbsp;</td>
        <td colspan="1">赛事名称：</td>
         <td><input name="ssmc" type="text"></td>
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
        
        </tr>   
    </tbody>
</table>
</form>
<form name="form2" method="post" action="">
<table id="rounded-corner" style="width:850px">
    <thead>
    	<tr>
        	<th scope="col" class="rounded-company">&nbsp;</th>
        	<th scope="col" class="rounded">场地类别</th>
        	<th scope="col" class="rounded">场地编号</th>
            <th scope="col" class="rounded">赛事名称</th>
            <th scope="col" class="rounded">主办方</th>
            <th scope="col" class="rounded">申请人</th>
            <th scope="col" class="rounded">开始时间</th>
            <th scope="col" class="rounded">结束时间</th>
            
            <th scope="col" class="rounded-q4">联系电话</th>            
            
        </tr>
     </thead>
     <tfoot>
    	<tr>
        <td colspan="9"><div class="pagination"><span class="disabled">&lt;&lt;prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>...<a href="">10</a><a href="">next&gt;&gt;</a>
        </div></td>
        </tr>
    </tfoot>
    <tbody>
    	
      <c:if test="${FindGame!=null}" var="flag" scope="page">
        	<c:forEach var="item" items="${FindGame}" varStatus="status">
            	<tr>
            		<td>&nbsp;</td>
   					<td> <c:out value="${item.spaceTypeName}"/></td>
   					<td> <c:out value="${item.spaceNo}"/></td>
   					<td> <c:out value="${item.gameName}"></c:out></td>
   					<td> <c:out value="${item.gameHost}"></c:out></td>
   					<td> <c:out value="${item.gameHead}"></c:out></td>
   					<td> <c:out value="${item.gStartTime}"></c:out></td>
   					<td> <c:out value="${item.gEndTime}"></c:out></td>
   					<td> <c:out value="${item.headPhone}"></c:out></td>
				</tr>
			 </c:forEach>
        </c:if>
         <c:if test="${FindGame==null}" var="flag" scope="page">
        	<c:forEach var="item" items="${AllGame}" varStatus="status">
            	<tr>
            		<td>&nbsp;</td>
   					<td> <c:out value="${item.spaceTypeName}"/></td>
   					<td> <c:out value="${item.spaceNo}"/></td>
   					<td> <c:out value="${item.gameName}"></c:out></td>
   					<td> <c:out value="${item.gameHost}"></c:out></td>
   					<td> <c:out value="${item.gameHead}"></c:out></td>
   					<td> <c:out value="${item.gStartTime}"></c:out></td>
   					<td> <c:out value="${item.gEndTime}"></c:out></td>
   					<td> <c:out value="${item.headPhone}"></c:out></td>
				</tr>
			 </c:forEach>
        </c:if>
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
