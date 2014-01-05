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
  		font-size:16px;
  		background-color:016aa9;
  		overflow:hidden; 
  		text-align:center;
  	}
  	#container{
  	      text-align:center;
      font-size:16;
  	}
  	
  	#menu{
  	  background-color:#e2e2e2;
  	  height:330px;
	  margin-top: 0px;
  	 
  	}
  	#div_title{
  	  font-size:30px;
	  margin-left: -850px;
	  margin-top: -100px;
  	}

  	#select_btn{
	 text-align:center;
	 margin-left: -30px;
  	}

  	#select_btn select{

  	   margin-top: 50px;
  	   margin-left: -30px;
       margin-right: 50px;
  	   width:120px;
	   
  	}
  	#submit_btn{
  	}
  	#submit_btn input{
  	  margin-top: 15px;
  	  margin-right: 70px;
	  margin-left: -20px;
  	  text-align:center;
  	}
  	
  	    #sp2{
  	   margin-top: 20px;
  	   margin-left: -130px;
 
 
    }
    #sp3{
       margin-top: 20px;
  	   margin-left: -130px;
 
 
    }
    
    #add_select{
     margin-top: 50px;
      margin-left: -90px;
 
    }
    
    #add_select select{
     
     width:100px;
 
    }
    #add_button{
	  margin-top: 15px;
  	  margin-right: 50px;
 
  	  text-align:center;
  	}
   #add_button input{
  	  margin-top: 15px;
  	  margin-right: 50px;
    margin-left: -10px;
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

function change()
{
 
var input_gas =  document.getElementById("gas_hidden");
var gasData = new Array();
var gasData = eval('(' + input_gas.value + ')');

var select_depart =  document.getElementById("depart_id");
 
gasStr = gasData[select_depart.value];
 
var gases = new Array();
gases = gasStr.split(",");
 
clear_gas();
var i;
for(i = 0;i<gases.length;i++)
{
   var div_view=document.createElement("option");      
   var text = document.getElementById("gas_id");     
   div_view.innerText=gases[i];     
   text.appendChild(div_view);  
}
}
function clear_gas()
{
 var parent = document.getElementById("gas_id");     
    //这里因为childNodes节点会动态变下标，所以用0的index实现全部删除     
    for (var i = 0, length= parent.childNodes.length; i < length; i++){     
         parent.removeChild(parent.childNodes[0]);     
    }  
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
<body onload="change();">

  <div id="container">
  	<div id="login_image">
  	 <div id="menu">
	         <form action="<%=request.getContextPath()%>/GasManage.do?" method="post">
          <div id="select_btn">
          
         <select id="depart_id"   class="inp" id="ns_sen" name="department" onChange="change();">
           <logic:iterate id="optionValue" name="departs">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
          </select>   
        <select id="gas_id" style="width:120px;" name="gasName" class="inp">
		  
        </select> 
         </div>  
         <div id="submit_btn">
              <input type="submit" value="重置密码" name="submit" tabindex="4"/>                  
              <input type="submit" value="删除油站" name="submit" tabindex="5"/>
        </div>
       <div id = "add_select">
        <select id="depart_id" class="inp" id="ns_sen" name="newDepartment" onChange="change();">
           <logic:iterate id="optionValue" name="departs">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
        </select>  
      </div>
       <div id="sp2">
	           油站名称<input type="text" name="newGasName" tabindex="2"/><br>
	 
	   </div>
 	   <div id="sp3">
	           油站编号<input type="text" name="newGasNum" tabindex="3"/><br>
	 
	   </div>
       <div id = "add_button" >
              <input type="submit" value="增加油站" name="submit" tabindex="4"/>                  
              <input type="submit" value="取消操作" name="submit" tabindex="5"/>
       </div>
         
       </form>
	 
  	    <div id="div_title">
  
           <div>
  	        ${opeateTitle}
  	        ${opeateNote} 
		   </div>	
 
       </div>
       


   </div>
		     <input type="hidden" id="gas_hidden"value='${departMapGas}' name="gas_hidden_name"/>   
	</div>
  </div>
</body> 
</html>