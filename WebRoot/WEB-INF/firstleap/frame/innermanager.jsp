<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>励步成长计划系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%
String path=request.getContextPath();
System.gc();
 %>

<frameset rows="90,*,28" cols="*" framespacing="0" frameborder="no" style="background-image: url('${path }/firstleap/images/1_05.gif')" border="0" id="topframe">
  <frame src="<%=path %>/login/login_topi.action" name="top" scrolling="no">
  <frameset cols="180,*" framespacing="3" frameborder="yes" border="0" id="leftframe" >
    <frame src="<%=path %>/login/login_lefti.action" name="leftf"  id="myEditer1" border="0" frameborder="no" scrolling="no" marginwidth="0" marginheight="0" id="leftf" style="overflow-x:hidden">
    <frame src="<%=path %>/login/login_righti.action"  name="main" frameborder="no" scrolling="auto" id="main" border="0" border="0" frameborder="no" scrolling="no" marginwidth="0" marginheight="0" style="overflow-x:hidden">
  </frameset>
  <frame src="<%=path %>/login/login_bottomi.action" name="bottom" scrolling="no">
</frameset>
<noframes><body>
</body></noframes>
</html>