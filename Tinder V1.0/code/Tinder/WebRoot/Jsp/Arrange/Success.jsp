<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
  <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
  <style>
  	body{
  		margin:0px;
  		padding:0px;
  		font-size:24px;
  		background-color:1dfeb6;
  		overflow:hidden; 
  		text-align:center;
  	}
  		.container{
  	  margin-top:100px;
  	}
  	.container img{
  	  margin-top:50px;
  	}
  </style>
<title>Insert title here</title>
</head>
<body>
  <div id="container">
     <img style="height:102px;width:630;"src="<%=request.getContextPath()%>/image/operate/success.jpg">
     <br>
     <br>
                 操作成功
  </div>
</body> 
</html>