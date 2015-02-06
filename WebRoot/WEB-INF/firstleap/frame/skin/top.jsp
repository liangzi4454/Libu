<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base href="<%=basePath%>">
    <title>My JSP 'bar.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style type="text/css">
.topbj {
	background: url(<%=basePath%>/images/topbj1.jpg) no-repeat left;
}
</style>
</head>

<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" background="<%=basePath%>/images/topbj2.jpg">
   		<tr>
    		<td height="90" align="right" valign="bottom" background="topbj" class="topbj">
    			<table width="250" height="25" border="0" cellpadding="0" cellspacing="0">
      			<tr>
			        <td width="88"></td>
			        <td width="50">&nbsp;</td>
			        <td width="88"><a href="<%=basePath%>/login/login_logout.action" target="_top"><img src="<%=basePath%>/images/anliu2.jpg" width="88" height="25" border="0"></a></td>
			        <td width="88">&nbsp;</td>
     			</tr>
    			</table>
    		</td>
  		</tr>
	</table>
</body>
</html>

