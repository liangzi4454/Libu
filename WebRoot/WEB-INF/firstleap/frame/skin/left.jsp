<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
	<table width="179" height="397" border="0" cellpadding="0" cellspacing="0" >
		<tr>
	    	<td height="580" align="center" valign="top" bgcolor="#bd0884">
	    		<table width="179" border="0" cellspacing="0" cellpadding="0">
	    			
	    			<tr>
		          		<td height="34" align="center" valign="top">
		          			<table width="159" height="60" border="0" cellpadding="0" cellspacing="0">
		              			<tr>
		                			<td height="19" align="center" valign="top">
		                				<table width="179" border="0" cellspacing="0" cellpadding="0">
			                    			<tr>
			                      				<td height="27" align="right" background="<%=basePath%>/images/2_04.jpg" style="background-repeat:no-repeat; ">
			                      					<table width="150" border="0" cellspacing="0" cellpadding="0">
			                        					<tr>
			                          						<td width="127" align="center"><a href="#" class="text0b">网站大类管理</a></td>
			                        					</tr>
			                      					</table>
			                      				</td>
			                    			</tr>
		                				</table>
		                			</td>
		              			</tr>
		              			<tr>
		                			<td align="center" valign="top">
		                				<table width="171" border="0" cellspacing="0" cellpadding="0">
			                  				<tr>
			                    				<td width="157" height="10" align="center" valign="bottom"></td>
			                  				</tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/ftype" action="ftype_list" cssClass="text0c" target="main">网站大类管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                 <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/ftype" action="ftype_listi" cssClass="text0c" target="main">网站二类管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
		                				</table>
		                			</td>
		              			</tr>
		          			</table>
		          			<table width="159" height="91" border="0" cellpadding="0" cellspacing="0">
		              			<tr>
		                			<td height="19" align="center" valign="top">
		                				<table width="179" border="0" cellspacing="0" cellpadding="0">
			                    			<tr>
			                      				<td height="27" align="right" background="<%=basePath%>/images/2_04.jpg" style="background-repeat:no-repeat; ">
			                      					<table width="150" border="0" cellspacing="0" cellpadding="0">
			                        					<tr>
			                          						<td width="127" align="center"><a href="#" class="text0b">孕妈宝典</a></td>
			                        					</tr>
			                      					</table>
			                      				</td>
			                    			</tr>
		                				</table>
		                			</td>
		              			</tr>
		              			<tr>
		                			<td align="center" valign="top">
		                				<table width="171" border="0" cellspacing="0" cellpadding="0">
			                  				<tr>
			                    				<td width="157" height="10" align="center" valign="bottom"></td>
			                  				</tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/pregnanttype" action="pregnanttype_list" cssClass="text0c" target="main">孕妇类型管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                 <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/pregnanttype" action="pregnanttype_listi" cssClass="text0c" target="main">孕妇二类管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/pregnantart" action="pregnantart_list" cssClass="text0c" target="main">孕妇文章管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
		                				</table>
		                			</td>
		              			</tr>
		          			</table>
		          			<table width="159" height="91" border="0" cellpadding="0" cellspacing="0">
		              			<tr>
		                			<td height="19" align="center" valign="top">
		                				<table width="179" border="0" cellspacing="0" cellpadding="0">
			                    			<tr>
			                      				<td height="27" align="right" background="<%=basePath%>/images/2_04.jpg" style="background-repeat:no-repeat; ">
			                      					<table width="150" border="0" cellspacing="0" cellpadding="0">
			                        					<tr>
			                          						<td width="127" align="center"><a href="#" class="text0b">育儿宝典</a></td>
			                        					</tr>
			                      					</table>
			                      				</td>
			                    			</tr>
		                				</table>
		                			</td>
		              			</tr>
		              			<tr>
		                			<td align="center" valign="top">
		                				<table width="171" border="0" cellspacing="0" cellpadding="0">
			                  				<tr>
			                    				<td width="157" height="10" align="center" valign="bottom"></td>
			                  				</tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/childtype" action="childtype_list" cssClass="text0c" target="main">儿童类型管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/childtype" action="childtype_listi" cssClass="text0c" target="main">儿童二类管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/childartic" action="childartic_list" cssClass="text0c" target="main">儿童文章管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
		                				</table>
		                			</td>
		              			</tr>
		          			</table>
		          			<table width="159" height="91" border="0" cellpadding="0" cellspacing="0">
		              			<tr>
		                			<td height="19" align="center" valign="top">
		                				<table width="179" border="0" cellspacing="0" cellpadding="0">
			                    			<tr>
			                      				<td height="27" align="right" background="<%=basePath%>/images/2_04.jpg" style="background-repeat:no-repeat; ">
			                      					<table width="150" border="0" cellspacing="0" cellpadding="0">
			                        					<tr>
			                          						<td width="127" align="center"><a href="#" class="text0b">网站管理</a></td>
			                        					</tr>
			                      					</table>
			                      				</td>
			                    			</tr>
		                				</table>
		                			</td>
		              			</tr>
		              			<tr>
		                			<td align="center" valign="top">
		                				<table width="171" border="0" cellspacing="0" cellpadding="0">
			                  				<tr>
			                    				<td width="157" height="10" align="center" valign="bottom"></td>
			                  				</tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/webtype" action="webtype_list" cssClass="text0c" target="main">网站类型管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/webart" action="webart_list" cssClass="text0c" target="main">网站文章管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
		                				</table>
		                			</td>
		              			</tr>
		          			</table>
		          			<table width="159" height="91" border="0" cellpadding="0" cellspacing="0">
		              			<tr>
		                			<td height="19" align="center" valign="top">
		                				<table width="179" border="0" cellspacing="0" cellpadding="0">
			                    			<tr>
			                      				<td height="27" align="right" background="<%=basePath%>/images/2_04.jpg" style="background-repeat:no-repeat; ">
			                      					<table width="150" border="0" cellspacing="0" cellpadding="0">
			                        					<tr>
			                          						<td width="127" align="center"><a href="#" class="text0b">育儿常识</a></td>
			                        					</tr>
			                      					</table>
			                      				</td>
			                    			</tr>
		                				</table>
		                			</td>
		              			</tr>
		              			<tr>
		                			<td align="center" valign="top">
		                				<table width="171" border="0" cellspacing="0" cellpadding="0">
			                  				<tr>
			                    				<td width="157" height="10" align="center" valign="bottom"></td>
			                  				</tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/yuertype" action="yuertype_list" cssClass="text0c" target="main">育儿类别管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/yuertype" action="yuertype_listi" cssClass="text0c" target="main">育儿二类管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
							                <tr>
							                    <td height="20" align="center" valign="bottom"><s:a namespace="/yuerartic" action="yuerartic_list" cssClass="text0c" target="main">育儿文章管理</s:a></td>
							                </tr>
							                <tr>
							                    <td height="5" align="center" valign="bottom" background="<%=basePath%>/images/2_14.jpg" style="background-repeat:repeat-x; background-position:center; "></td>
							                </tr>
		                				</table>
		                			</td>
		              			</tr>
		          			</table>
		         		</td>
		        	</tr>
			        <tr>
			          <td height="10"></td>
			        </tr>
		              			
		          		
	
  
  </body>

