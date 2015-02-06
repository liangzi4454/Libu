<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>励步宝宝计划登录系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body style="background-color:#0885BD;" background="<%=basePath%>/images/dl_01.jpg">
  <s:form namespace="/login" action="login_listLogin" method="post" name="form1" id="form1">
  	<table width="1022" height="230" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="<%=basePath%>/images/dl_03.jpg">&nbsp;</td>
  </tr>
</table>
<table width="1022" height="282" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="231" background="<%=basePath%>/images/dl_05.jpg">&nbsp;</td>
    <td width="600" align="left" valign="top" background="<%=basePath%>/images/BD_06.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right"><table width="50%" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td height="51">&nbsp;</td>
          </tr>
          <tr>
            <td align="left" class="biaoti"><img src="<%=basePath%>/images/lz_17.jpg" width="25" height="31" hspace="10" align="absmiddle" />励步成长计划管理系统</td>
          </tr>
          <tr>
            <td align="center" class="zhengwen"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td colspan="2">用户名：
                    <s:textfield name="ltakLogin.loginName" id="name" size="16"/></td>
                  <td rowspan="3">
                  
                  	<s:submit type="image" src="http://127.0.0.1:8086/Libu/images/lz_21.jpg" width="78" height="59" border="0" align="absmiddle"></s:submit>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">密&nbsp; &nbsp;&nbsp;码：
                     <s:password name="ltakLogin.password" id="name" size="17"/></td>
                </tr>
                
            </table></td>
          </tr>
          <tr>
            <td height="50" align="center" class="zhengwen">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="center" class="banquan">版权所有：励步成长计划管理系统 电话：0311-87654321<br />
          Release Version Build 2015.1.30 </td>
        </tr>
      </table></td>
    <td width="191" background="<%=basePath%>/images/lz_07.jpg">&nbsp;</td>
  </tr>
</table>
<table width="1022" height="50" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="<%=basePath%>/images/dl_08.jpg">&nbsp;</td>
  </tr>
</table>
</s:form>
  </body>
</html>
