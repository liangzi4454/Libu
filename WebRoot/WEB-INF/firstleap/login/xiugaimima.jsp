<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  	<script type="text/javascript" src="<%=basePath%>/js/jquery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
	
</head>	
 
  <body>
	<center>
  		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
    		<tr>
      			<td height="100%" align="center" valign="top">
      				<table width="100%"  border="0" cellspacing="0" cellpadding="0">
        				<tr>
          					<td align="center" valign="top" height="470">
          						<table width="100%"  border="0" cellspacing="0" cellpadding="0">
            						<tr>
              							<td height="32" align="center" valign="top" style="background-repeat:repeat-x; ">
              								<table width="98%"  border="0" cellspacing="0" cellpadding="0">
                								<tr>
                  									<td width="48%" height="25" align="left">
                  										
                  									</td>
                								</tr>
              								</table>
              							</td>
            						</tr>
            						<tr>
              							<td height="419" align="center" valign="top">
              								<table width="99%" height="419"  border="0" cellpadding="0" cellspacing="0" class="border0d">
                								<tr>
                  									<td height="455" align="center" valign="top" background="<%=basePath%>/images/2_11.jpg" bgcolor="#FFFFFF" style="background-repeat:repeat-x; ">
                  										 <s:form namespace="/login" action="login_updatemm" method="post" target="_top">
															 <table width="100%"  border="0" cellspacing="0" cellpadding="0" class="chart_list" >
															 <tr align="center" height="32" >
															 	<th colspan="4" style="background-color:#fff0f9;">修改密码</th>
															 </tr>
															 <tr>
															 	<td colspan="6" height="32" style="background-color:#fff0f9;">
															 		<strong>修改密码</strong>
																</td>
															 </tr>
															 <tr>
															 	<td>登录名</td>
															 	<td><s:textfield name="ltakLogin.loginName" disabled="true"></s:textfield></td>
															 	<input type="hidden" name="ltakLogin.loginId" value="${ltakLogin.loginId}"/>
															 	<input type="hidden" name="ltakLogin.loginName" value="${ltakLogin.loginName}"/>
															 	<input type="hidden" name="ltakLogin.isdelete" value="${ltakLogin.isdelete}"/>
															 	<input type="hidden" name="ltakLogin.loginType" value="${ltakLogin.loginType}"/>
															 	<input type="hidden" name="ltakLogin.yhId" value="${ltakLogin.yhId}"/>
															 	<input type="hidden" name="ltakLogin.createdDate" value="${ltakLogin.createdDate}"/>
															 </tr>
															  <tr>
															 	<td>密码</td>
															 	<td><s:password name="ltakLogin.password"/></td>
															 </tr>
															  <tr>
															 	<td colspan="6" align="center"><s:submit value="提交"></s:submit></td>
															 </tr>
															 </table>
														</s:form> 
                  									</td>
                								</tr>
              								</table>
              							</td>
            						</tr>
          						</table>
        				</tr>
      				</table>
      			</td>
   			 </tr>
 		 </table>
	</center>
  </body>
  </html>

