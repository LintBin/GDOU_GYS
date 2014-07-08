<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>广东海洋大学体育馆管理系统主界面</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="admin_top.jsp" noresize="noresize" frameborder="0" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" >
  <frameset cols="190,*" frameborder="NO" border="0" framespacing="0">
	<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no">
	<frame src="right.jsp" name="main" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto">
  </frameset>
</frameset>
<noframes>
  <body></body>
</noframes>
</html>
