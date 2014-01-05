<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

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
  	#welcome_image{
      
  	}
    #select_form{
      margin-top:-150px;
    }
    #submit_btn input{
         width:96px;    
         height:96px;  
         cursor:pointer;    
         font-size:0;    
         line-height:0;
         margin-top:-60px;    
         margin-left:30px;
         text-indent:-9999px;
    }
    
    #role_name label{
         width:96px;    
         height:96px;  
         cursor:pointer;    
         font-size:28;    
         line-height:0;
         margin-top:-45px;    
         margin-left:30px;
         text-indent:-9999px;
    }
    .STYLE2 {
	font-size: 13px;
	font-family: "微软雅黑";
    }
  </style>
<title>Insert title here</title>
</head>

<script type="text/javascript">
function submitFun(act)
{
  myForm.role.value = act;
  myForm.submit();
}
</script>
<body>

  	<div id="welcome_image">
  	<img src="<%=request.getContextPath()%>/image/welcome/welcome.jpg" /> 
  	
  	<div id="select_form">
    <form action="<%=request.getContextPath()%>/SelectRole.do" method="post" name="myForm"> 

         <div id="submit_btn">
             
             <input type="hidden" name="role" value="depart"/>
             <input type="image" src="<%=request.getContextPath()%>/image/welcome/depart.png;" onclick="submitFun('depart');" name="man" value="manager" />
             <input type="image" src="<%=request.getContextPath()%>/image/welcome/gas.png;" onclick="submitFun('gas');" name="gas" value="gas" />
             <input type="image" src="<%=request.getContextPath()%>/image/welcome/admin.png;" onclick="submitFun('admin');" name="admin" value="admin"/>
         </div>
     </form>
     </div>
	</div>
</body> 
</html>