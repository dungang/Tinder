<%@ page 
    pageEncoding="UTF-8" isELIgnored= "false"
%>
<html>
<head>
  <style>
  	body{

  		font-size:24px;
  		 background: #2d323b;
  		 text-align:center;
  	}
  	 
  	#menu{
  
  	}
  	#menu ul{
  	 
      float:left;
  	  margin-left: -10px;
 
  	}
  	#menu ul li
  	{
  	height:50px; width:180px;
  	 list-sytle:none;
  	}
  	#menu ul li a{
  	  display: block;
  	  padding-top:10px;
  	  height:100%; width:100%;
  	  font-size: 20px;
	  font-family: "幼圆";
	  color:#c0c0c0;
	  text-decoration:none;
  	}
  	
  	#menu ul li a:hover 
  	{
     color:f70bc2;
  	 background:#575b62; url(../../../image/item/item.jsp); repeat-y;
  	 text-decoration:none;
  	 font-size: 24px;
  	 color:#ffffff;
  	}

    #menu ul li .active {
    background: #575b62; url(../../../image/item/item.jsp); repeat-y;
    font-size: 24px;
     color:#ffffff;
    }
    

 </style>

</head>
<script type="text/javascript">
function submitFun(act)
{
  
   myForm.submit();   
    return false;
}
</script>
<body>
      <form action="<%=request.getContextPath()%>/SelectCondition.do" method="post">
 
      <input type="hidden" name="role" value="${role}"/>
      <input type="hidden" name="userName" value="${userName}"/>

     <div id="menu" >  
        <ul>
            <li><a href="<%=request.getContextPath()%>/SelectCondition.do?operate=CreateArrange" target="mainFrame">创建加油站排班</a></li>
            <li><a href="<%=request.getContextPath()%>/SelectCondition.do?operate=QeuryArrange" target="mainFrame">查询加油站排班</a></li>
            <li><a href="<%=request.getContextPath()%>/SelectCondition.do?operate=QeurySum" target="mainFrame">查询统计信息</a></li>
            <li><a href="<%=request.getContextPath()%>/Jsp/Manager/AlterPassword.jsp" target="mainFrame">用户管理</a></li>
            <li><a href="<%=request.getContextPath()%>/SelectCondition.do?operate=ManageGas" target="mainFrame">油站管理</a></li>
        </ul>
      </div>
     </form>
</body> 
</html>