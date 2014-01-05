<%@ page pageEncoding="UTF-8" isELIgnored= "false"
%>
 <html>
<head>
  <style>
  	body{
  		margin:0px;
  		padding:0px;
  		font-size:12px;
  		background-color:#e2e2e2;
  		overflow:hidden; 
  		
  	}
#container{
 
      height:485px;
  	} 
  	#welcome{
     margin-top:-35px;
     margin-left:30px;
  	 font-size:31;
  	}
  	#container1{
 
      text-align:center;
      font-size:16;
       
  	}
    #container1 input{

    }
        #container1 select{
  	  margin-top:8px;
      margin-bottom:8px;
      size:16;
      font-size:16;
      color:blue;
    }
    #sp0{
      margin-left:-137px;
      margin-top:20px;
    }
    #sp1{
       margin-left:-250px;
       margin-top:20px;
    }
    #sp2{
      margin-left:-250px;
      margin-top:20px;
    }
    #sp3{
      margin-left:-250px;
      margin-top:20px;
    }
   
    #add{
      margin-top:40px;
      margin-left:-200px;
      size:17;
    }
  </style>
<title>Insert title here</title>
</head>
<body>
         <div id="welcome">
          <font color="#ff8040"><strong><font face="Lucida Console"><br><br>修改密码</font></strong></font>
          </div> 
  <div id="container">

   <form action="<%= request.getContextPath()%>/AlterPassword.do"  method="post">
   <div id="container1">
	   <div id="sp1">
	            原始密码<input type="password" name="oldPassword" tabindex="1"/><br>
	  </div>


		<div id="sp2">
	           修改密码<input type="password" name="newFirstPassword" tabindex="2"/><br>
	 
	   </div>
 	   <div id="sp3">
	           重新输入<input type="password" name="newSecondPassword" tabindex="3"/><br>
	 
	   </div>
         <div id="add">   
            <input style="height:25px;font-size:17;" type="submit" value="修改" name="submit" tabindex="22"/>
            &nbsp;&nbsp;&nbsp;
            <input style="height:25px;font-size:17;" type="submit" value="取消" name="submit" tabindex="23"/><br>
         </div>  
        </div> 
    </form> 
  </div>
</body> 
</html>