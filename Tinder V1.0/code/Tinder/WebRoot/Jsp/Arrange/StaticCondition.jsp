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
  		background-color:016aa9;
  		overflow:hidden; 
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
	  margin-left: -830px;
	  margin-top: -100px;
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
<script type="text/javascript">
function submitFun(act)
{
  myForm.department.value = act;
  myForm.submit();
}
</script>
<body>
  <div id="container">
  	<div id="menu">
     
        <form action="<%=request.getContextPath()%>/ExportSumInfo.do" method="post">
         <div id="select_btn">
          <select id="year_id" name="year" class="inp" id="ns_sen" >
           <logic:iterate id="optionValue" name="years">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
          </select>  
           <select id="month_id" name="month" class="inp" id="ns_sen">
           <logic:iterate id="optionValue" name="months">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
          </select>  
		 </div>
          
         <div id="submit_btn">
              <input type="submit" name="submit" value="导出排班状态" tabindex="4"/>  
              <input type="submit" name="submit" value="导出汇总信息" tabindex="5"/>  
              <input type="submit" name="submit" value="导出排班信息" tabindex="6"/>               
              <input type="submit" name="submit" value="取消" tabindex="7"/>
          </div>
        </form>
        <div id="div_title">
  	        ${opeateTitle}
  	        ${opeateNote}
       </div>
       <logic:present name="gasArrangeStatusList">
          <logic:iterate id="optionValue" name="gasArrangeStatusList">    
               ${optionValue}
          </logic:iterate>
       </logic:present>
	</div>
  </div>
</body> 
</html>