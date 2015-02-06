<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib uri="/WEB-INF/conf/page.tld" prefix="p"%>
<%@	taglib uri="/WEB-INF/conf/webtype.tld"
	prefix="gettypename"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("path",path);
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP 1.0 
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
%>
  <head>
  <link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="<%=basePath%>/js/jquery/jquery-1.7.2.js"></script>
  <script>
  	$(document).ready(function() {
  			/**************删除信息***************/
		$('.deleteButton').click(function(){
			var choose = confirm('是否要删除所选信息');
				if(choose == true) {
					$.ajax({
					   type: "post",
					   dataType: "json",
					   url: "${pageContext.request.contextPath}/ftype/ftype_delete.action",
					   data: {id:this.name},
					   success: function(msg){	
					   		//	如果删除成功，重定向刷新list
					   		if(msg.msgname == "sccg") 
					   		{
					   			window.location = "${pageContext.request.contextPath}/ftype/ftype_listi.action?page=${page}";
					   		}			   		
					 }});
				}
		}); /*****结束****/
		
		
	});

  </script>
  </head>
	
  <body>
	<center>
  		<table width="100%"  border="0" cellspacing="0" cellpadding="0" >
    		<tr>
      			<td height="100%" align="center" valign="top">
      				<table width="100%"  border="0" cellspacing="0" cellpadding="0">
        				<tr>
          					<td align="center" valign="top" bgcolor="" height="495">
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
              								<table width="99%" height="455"  border="0" cellpadding="0" cellspacing="0" class="border0d">
                								<tr>
                  									<td height="419" align="center" valign="top" background="<%=basePath%>/images/2_11.jpg" style="background-repeat:repeat-x; ">
                  										<table width="95%"  border="0" cellspacing="0" cellpadding="0">
													         <tr>
													             <td height="77" align="center" valign="top" style="padding-top:10px; ">
													             	
													              </td>
													            </tr>
													            <tr>
													                <td height="5"></td>
													            </tr>
													            <tr>
													                <td height="183" align="center" valign="top">
													                	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
													                    	<tr>
													                        	<td align="center" valign="top">
													                        		
													                      		</td>
													                    	</tr>
													                    	<tr align="center" valign="top">
													                      	<td height="200">
													                      		<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="chart_list">
													                          		<tr align="right" background="images/001_57.jpg">
													                            		<td height="27" colspan="10" style="background-repeat:repeat-x;">
													                            			<a href="<%=basePath%>/ftype/ftype_createi.action" target="main" class="text4">增加</a>
													                            		</td>
													                          		</tr>
													                          		<tr align="center" valign="middle">
															                            <td width="8%" height="27"  style="background-color:#fff0f9 "><strong> 序 号 </strong></td>
															                            <td width="13%" height="27"  style="background-color:#fff0f9 "><strong> 二类名称 </strong></td>
															                             <td width="13%" height="27"  style="background-color:#fff0f9 "><strong> 所属大类 </strong></td>
															                            <td width="30%" height="27"  style="background-color:#fff0f9 "><strong> 操 作 </strong></td>
													                          		</tr>
													                          		<s:iterator id="firsttype" value="pagination.list" status="userList">
													                          			<tr align="center" valign="middle">
																                            <td height="27">${userList.count}</td>
																                            <td height="27">${firsttype.name}</td>
																                            <td height="27"><gettypename:gettypename areaId="${firsttype.parentId}" /></td>
																                            <td height="27">
																	                            <a class="deleteButton" name="${firsttype.id}" style="cursor:pointer" class="text4"><s:text name="删除" /></a>
																                            </td>
														                           		</tr>
													                          		</s:iterator>
													                          			<tr>
																							<td colspan="7">
																								<p:page pagination="${pagination}" location="0">
																									<!--<p:param name="xingming" value="${xingming}"></p:param>  -->
																								</p:page>
																							</td>
					</tr>
													                         	</table>
													                         </td>
													                    </tr>
													        		</table>
													        	</td>
													      	</tr>
													    </table>
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

