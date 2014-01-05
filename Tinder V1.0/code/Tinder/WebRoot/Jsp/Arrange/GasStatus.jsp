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
  		font-size:18px;
  		background-color:016aa9;
   		text-align:center;
  	}
  	#container{
  	
  	}
  	
  	#menu{
  	  background-color:#e2e2e2;
  	  height:130px;
	  margin-top: 0px;
  	 
  	}
  	#div_title{
  	  font-size:30px;
	   margin-bottom:40px;
  	}

  	#select_btn{
	 text-align:center;
	 margin-left: -30px;
  	}
  	#select_btn select{

  	   margin-top: 50px;
       margin-right: 70px;
	   margin-left: -40px;
  	   width:80px;
	   
	   
  	}
  	#submit_btn{
  	}
  	#submit_btn input{
  	  margin-top: 15px;
  	  margin-right: 90px;
	  margin-left: -50px;
  	  text-align:center;
  	}

  </style>
<title>Insert title here</title>
</head>
 
<body>
  <div id="container">
        <div id="div_title">
                 加油站排版状态
       </div>
   <table border="0" width="58%" bordercolor="#000000" cellspacing="0" cellpadding="0" height="16" id=Table1 align="center"> 
 
       <logic:present name="gasArrangeStatusList">

          <logic:iterate id="optionValue" name="gasArrangeStatusList">   
           <tr align="right"> 
              <td align="right">
              ${optionValue.status} 
              </td>
              <td>
              ${optionValue.department}
              </td>
              <td>
              ${optionValue.gasName}
              </td>
           </tr> 
          </logic:iterate>
       </logic:present>
    </table>
  </div>
 
</body> 
</html>