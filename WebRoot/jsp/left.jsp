<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>

<script src="../js/prototype.lite.js" type="text/javascript"></script>
<script src="../js/moo.fx.js" type="text/javascript"></script>
<script src="../js/moo.fx.pack.js" type="text/javascript"></script>
<link rel="stylesheet" href="../style/left.css" type="text/css"></link>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="title"><a href="javascript:void(0)">人员管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="manager_add.jsp" target="main">添加管理员</a></li>
          <li><a href="manager_delete.jsp" target="main">删除管理员</a></li>
          <li><a href="manager_update.jsp" target="main">更新管理员</a></li>
          <li><a href="manager_check.jsp" target="main">查询管理员</a></li>
        </ul>
      </div>
      <h1 class="title"><a href="javascript:void(0)">场地管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="site_add.jsp" target="main">添加场地</a></li>
          <li><a href="site_delete.jsp" target="main">删除场地</a></li>
          <li><a href="site_update.jsp" target="main">更新场地</a></li>
          <li><a href="site_check.jsp" target="main">查询场地</a></li>
          <li><a href="site_book.jsp" target="main">预约场地</a></li>
          <li><a href="site_bookno.jsp" target="main">管理预约</a></li>
          <li><a href="site_charge.jsp" target="main">场地收费标准设置</a></li>
          <li><a href="site_notice.jsp" target="main">场地公告</a></li>
          <li><a href="site_information.jsp" target="main">场地一周信息查询</a></li>
        </ul>
      </div>
      <h1 class="title"><a href="javascript:void(0)">器材管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="equipment_add.jsp" target="main">添加器材</a></li>
          <li><a href="equipment_delete.jsp" target="main">删除器材</a></li>
          <li><a href="equipment_update.jsp" target="main">更新器材</a></li>
          <li><a href="equipment_check.jsp" target="main">查询器材</a></li>
          <li><a href="equipment_borrow.jsp" target="main">外借器材</a></li>
          <li><a href="equipment_borrowno.jsp" target="main">收回器材</a></li>
        </ul>
      </div>
      <h1 class="title"><a href="javascript:void(0)">赛事管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="game_apply.jsp" target="main">添加赛事</a></li>
          <li><a href="game_cancel.jsp" target="main">删除赛事</a></li>
          <li><a href="game_update.jsp" target="main">更新赛事</a></li>
          <li><a href="game_check.jsp" target="main">查询赛事</a></li>
        </ul>
      </div>
            <h1 class="title"><a href="javascript:void(0)">报表管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="gys_report.jsp" target="main">运营报表</a></li>
        </ul>
      </div>
    </div>
      
      <script type="text/javascript">
		  var toggles = document.getElementsByClassName('title');//定义contents 组数为所有标题，也是可点击展开的按钮
	      var contents = document.getElementsByClassName('content');//定义contents 组数为所有将要显示的内容
		  var myAccordion = new fx.Accordion(//调用moofx JS库
			  toggles, contents, {opacity: true, duration: 400}//opacity确定是否有alpha透明变化,duration确定动作所有时间
		  );
		  myAccordion.showThisHideOpen(contents[0]);//默认打开第一个内容
	  </script>
    </td>
  </tr>
</table>
</body>
</html>
