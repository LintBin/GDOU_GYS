<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>广东海洋大学体育馆管理系统登陆界面</title>
<link href="style/nav.css" rel="stylesheet" type="text/css">
<script language="jscript">
function check(form){
	if(form.username.value==""){
		alert("请输入用户名!");document.form.username.focus();return false;
	}
	if(form.password.value==""){
		alert("请输入密码!");document.form.password.focus();return false;
	}
	else{
	   form.action="servlet/LoginServlet";
	}
}
</script>
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="60" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="138" valign="top"><table width="98%" height="477" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="150">&nbsp;</td>
                </tr>
                <tr>
                  <td height="70" align="center" valign="top"><img src="images/logo.png" width="300" height="70"></td>
                </tr>
                <tr>
                  <td height="200" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2"><p>1- 该馆共投入4000余万元。</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2"><p>2- 主校区体育馆位于校园中心区域</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2"><p>3- 中西风格相统一、自然与人文相协调</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="images/icon-demo.gif" width="16" height="16">&nbsp;使用说明</td>
                      <td width="35%"><img src="images/icon-login-seaver.gif" width="16" height="16">&nbsp;在线客服</td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" class="name">广东海洋大学体育馆管理系统登陆</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2">
                       <form name="form" action="servlet/LoginServlet" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38">用&nbsp;&nbsp;户：</td>
                            <td height="38" colspan="2"><input name="username"value="" size="20">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35">密&nbsp;&nbsp;码：</td>
                            <td height="35" colspan="2"><input type="password" size="20" name="password">
                              <img src="images/luck.gif" width="19" height="18"> </td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td width="20%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 陆" onClick="check(form)"> </td>
                            <td width="67%"><input name="cs" type="button" class="button" id="cs" value="取 消"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center">Copyright &copy; 2013</td>
      </tr>
    </table></td>
  </tr>
</table>
