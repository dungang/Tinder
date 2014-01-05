<%@ page 
    pageEncoding="UTF-8" isELIgnored= "false"
%>
 <html>
<head>
<title>Insert title here</title>

</head>
<style>

  	body{
  		background-color:#e2e2e2;
  		min-width: 1063px;
  	}
  	#container{
  	 background-color:#2222;
  	 height:80px;  
  	 
  	}
  	#head_style{
  	 font-size:18;
  	 color:blue;
  	 display:inline;
  	}
  	#head_style ul{
  	 display:inline;
  	 margin-top: 3px;
  	  float:left;
  	}
  	
  	#head_style ul img{
  	  float:left;
  	}

  	#head_style ul li
  	{
  	 
  	 display:inline;
  	 float:right;
  	 margin:45px 10px;
	 font-size: 18px;
	 font-family: "黑体";
	 color:#424242
  	}
  	#head_style ul li a { 
  	 font-family: "黑体";  
  	 color:#424242
  	}
</style>


<body>
 
  <div id="head_style"> 
    <ul>
     <img style="height:102px;width:630;"src="<%=request.getContextPath()%>/image/Head/head.png">
    </ul>
    <ul>
     <li><a href="<%=request.getContextPath()%>/Jsp/Exit.jsp">退出</a></li>
     <li>${userName}&nbsp;&nbsp;您好！</li>
     
    </ul>
    <ul>
    </ul>
  </div>
</body> 
</html>