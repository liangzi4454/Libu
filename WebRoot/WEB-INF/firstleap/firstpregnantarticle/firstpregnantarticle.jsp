<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib uri="/WEB-INF/conf/page.tld" prefix="p"%>
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
					   url: "${pageContext.request.contextPath}/pregnantart/pregnantart_delete.action",
					   data: {id:this.name},
					   success: function(msg){	
					   		//	如果删除成功，重定向刷新list
					   		
					   		if(msg.msgname == "sccg") 
					   		{
					   			window.location = "${pageContext.request.contextPath}/pregnantart/pregnantart_list.action?page=${page}";
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
													             		<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="chart_list">
																	                    <tr>
																	                    	<td width="12%" height="33" align="center" style="background-color:#fff0f9;">
																	                    		<strong> 文章标题 </strong>
																	                    	</td>
																	                    	<td width="15%" height="33" align="left" style="background-color:#fff0f9;">
																	                        	<input name="textfield" type="text" class="input8">
																	                     	</td>
																	                    </tr>
																	                    <tr align="center" valign="middle">
																		                     <td height="33" colspan="6">
																		                      	<a href="#">查询</a>
																		                     </td>
																	                    </tr>
																	                </table>
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
													                            			<a href="<%=basePath%>/pregnantart/pregnantart_create.action" target="main" class="text4">增加</a>
													                            		</td>
													                          		</tr>
													                          		<tr align="center" valign="middle">
															                            <td width="8%" height="27"  style="background-color:#fff0f9 "><strong> 序 号 </strong></td>
															                            <td width="13%" height="27"  style="background-color:#fff0f9 "><strong> 文章标题 </strong></td>
															                            <td width="13%" height="27"  style="background-color:#fff0f9 "><strong> 文章内容 </strong></td>
															                            <td width="13%" height="27"  style="background-color:#fff0f9 "><strong> 所属类别 </strong></td>
															                            <td width="30%" height="27"  style="background-color:#fff0f9 "><strong> 操 作 </strong></td>
													                          		</tr>
													                          		<s:iterator id="firstpregnantarticle" value="pagination.list" status="userList">
													                          			<tr align="center" valign="middle">
																                            <td height="27">${userList.count}</td>
																                            <td height="27">${firstpregnantarticle.pregnantTitle}</td>
																                            <td height="27">
																                            	<s:if test="#firstpregnantarticle.pregnantContent.length()>10">
																                            		<a title="${firstpregnantarticle.pregnantContent}"><s:property value="#firstpregnantarticle.pregnantContent.substring(0,10)" /></a>
																                            	</s:if>
																                            	<s:else>
																                            		${firstpregnantarticle.pregnantContent}
																                            	</s:else>
																                            	
																                            </td>
																                            <td height="27">${firstpregnantarticle.firstPregnantType.name}</td>
																                            
																                            <td height="27">
																	                           	<a href="<%=basePath%>/pregnantart/pregnantart_edit.action?id=${firstpregnantarticle.id}" style="cursor:pointer" class="text4">修改</a>&nbsp;&nbsp;  
																	                            <a class="deleteButton" name="${firstpregnantarticle.id}" style="cursor:pointer" class="text4"><s:text name="删除" /></a>
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

