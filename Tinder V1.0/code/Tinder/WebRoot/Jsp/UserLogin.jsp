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
  		font-size:12px;
  		background-color:#065fb9;
  	    overflow:auto; 
  		text-align:center;
  	}
  	#select_btn{
  	    margin-top:-205px;
  	}
  	.input_style{
  	   margin-bottom:10px;
  	   margin-right:30px;
  	}
  	#tips{
  	  margin-top: -62px;
  	  margin-left:200px;
      font-size:14px;
      color:red;
  	}
 


  </style>
<title>Insert title here</title>
</head>
<script type="text/javascript">
function submitFun(act)
{

}
function enterDown(frm,event)
{ 
  var ev =window.event||e; //这样写是为了兼容FireFox和IE，因为IE的onkeydown在FF中不起作用
 
  if (ev.keyCode==13)
  { 
    document.myForm.attributes["action"].value  ="<%=request.getContextPath()%>/Login.do?submit=enter";   

    myForm.submit();
  } 
} 
</script>
<body>
  <div id="container">
  	<div id="login_image">
        <img src="<%=request.getContextPath()%>/image/welcome/welcome.jpg" /> 
        
        <form action="<%=request.getContextPath()%>/Login.do" name="myForm" method="post" >
        <div id="select_btn" class="input_style" >
          <select name="userName" style="width:155px;" onkeydown="enterDown(this.form,event);" tabindex="1" >   
          <logic:iterate id="optionValue" name="userOptions">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
          </select>
        </div>    
        <div class="input_style" >
          <input type="password" style="width:150px;" name="password" tabindex="2" onkeydown="enterDown(this.form,event);"/>

        </div> 
         <div class="input_style" >
              <input type="submit" name="submit" value="登录" tabindex="3"/>&nbsp;&nbsp;&nbsp;&nbsp;                   
              <input type="submit" name="submit" value="返回" tabindex="4"/>
          </div> 
          <div id="tips">
                ${loginExceptonMessage}
          </div>
          <input type="hidden" name="role" value="${role}"/>
        </form>
	</div>
  </div>
</body> 
</html>