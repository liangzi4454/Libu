<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("path",path);
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP 1.0 
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
%>
  <head></head>
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
  
<body>
<center>
<table width="100%"  border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr align="center">
	    <td>
	    	<img src="<%=basePath%>/images/desk.gif"></img>
	    </td>
	  </tr>
</table>
</center>
</body>

