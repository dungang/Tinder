<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
  <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
   String basePath = request.getContextPath();
   
   String mainJspPath = basePath + "/Jsp/Arrange/"+"SelectCondition.jsp" ;
 %>
<html>
 
<head>
</head>
	<frameset rows="130px,15px,*" frameborder="no"  border="0" framespacing="0">
	  <frame src="<%=request.getContextPath()%>/Jsp/Arrange/Head.jsp" scrolling="no" noresize="noresize" name="Head" />
	  <frame src="<%=request.getContextPath()%>/Jsp/Arrange/Head2.jsp" scrolling="no" noresize="noresize" name="Head" />
	  <frameset cols="180px,*" frameborder="no"  border="0" framespacing="0">
	     <frame src="<%=request.getContextPath()%>/Jsp/Arrange/Item.jsp" scrolling="no" noresize="noresize" name="Item" />
	     <frame src="<%=request.getContextPath()%>/Jsp/Arrange/Init.jsp" scrolling="yes" noresize name="mainFrame" id="mainFrame" />
	  </frameset>
	</frameset>
</html>