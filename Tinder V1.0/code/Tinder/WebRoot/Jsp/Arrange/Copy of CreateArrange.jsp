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
  		overflow:auto; 
  		text-align:center;
  	}
  	#container{
  	  width:1245px;
  	}
  	#login_image{
  	   
  	  width:1245px;
  	  height:451px;
  	   
  	}
  	
    #login_form{
      margin-top:-210px;
      margin-left:340px;
    }
    #input_btn{
      margin-bottom:30px;
      
    }
    #select_btn {
      margin-bottom:20px;
    }
    #submit_btn input{
      width:60px;
      margin-left:10px;
      margin-right:10px;
    }
    #error{
      margin-top:-175px;
      margin-left:70px;
      font-size:14px;
      color:red;
    }

  </style>
<title>Insert title here</title>
</head>
<script language="javascript"> 
<!-- 
var row_index=0; 
//建立一个函数build_row()用于建立新的一行且增加的四个文本框为空的且被禁用 
function build_row(){ 

     var a = ",,\\,\\,\\,\\,,,,";
     var input_holiday =  document.getElementById("holidays_hidden");
     var a = input_holiday.value;

	 var restDays= new Array();
     restDays = a.split(",");
 
    row_index++; 
 
    var new_row=Table1.insertRow(Table1.rows.length); 
    new_row.setAttribute("id", "row"+row_index);   
    var new_col=new_row.insertCell(0); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].name' size='10' >"; 

    var new_col=new_row.insertCell(1); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].job' size='10' >"; 
   
   
     var i = 0;
   for(i=0;i<restDays.length ;i++ )
   {
     var new_col=new_row.insertCell(i+2); 
     var itemName  = 'arrangeDatas[' + row_index + '].d' + i;
     var itemVal  = restDays[i];
	 var b = '\\';
	 if(itemVal == b)
	 {
	    new_col.innerHTML="<input type='text' style='WIDTH: 30px;' name='"+itemName+"' value='"+itemVal+"'size='10' disabled>"; 
	 }
     else
	 {
	   new_col.innerHTML="<input type='text' style='WIDTH: 30px;' name='"+itemName+"' value='"+itemVal+"'size='10' >"; 
	 }
   }
	 

    var new_col=new_row.insertCell(restDays.length+2); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].sumHours' size='10' >"; 
	
	var new_col=new_row.insertCell(restDays.length+3); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].sumDays' size='10' >"; 
	
	var new_col=new_row.insertCell(restDays.length+4); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].holidays' size='10' >"; 
	
	var new_col=new_row.insertCell(restDays.length+5); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].overHours' size='10' >"; 
	
	var new_col=new_row.insertCell(restDays.length+6); 
    new_col.innerHTML="<input type='text' name='arrangeDatas["+row_index+"].restDays' size='10' >"; 
	
	var new_col=new_row.insertCell(restDays.length+7); 

    new_col.innerHTML="<input type='button' value='删除此行' name='B4"+row_index+"' LANGUAGE='javascript' onclick=\"delete_row('row"+row_index+ "')\">"; 
    } 
//建立一个函数age_average()用于计算年龄的平均值 
function age_average()   
{ 
    var i,j,temp,age_sum=0;var j=0; 
    for (i=1;i<=Table1.rows.length-1;i++) 
    { 
        temp=eval("form1.T4"+Table1.rows(i).id.substr(3)); 
        if (temp.value==""){ 
          
        j++; 
        age_sum=age_sum; 
        } 
        else{ 
        age_sum+=parseInt(temp.value); 
        } 
          
    } 
    form1.T5.value=(age_sum/(Table1.rows.length-1-j)); 
} 
//建立一个函数add_data()用于添加数据 
function add_data(rname){ 
var i; 
form1.hidden_index.value=Table1.rows(rname).rowIndex; 
var win_new=open("list.htm") 
    } 

//建立一个函数delete_row用于删除一行 
function delete_row(rname)   
{ 
    var i; 
    i=Table1.rows(rname).rowIndex; 
    alert(i); 
    Table1.deleteRow(i); 
    } 
//建立一个函数check_form()用于检查文本框是否为空 
function check_form(){ 
         var i; 
         for(i=1;i<=Table1.rows.length-1;i++){ 
                if (eval("form1.T1"+Table1.rows(i).id.substr(3)).value=="" || eval("form1.T2"+Table1.rows(i).id.substr(3)).value=="" || eval("form1.T3"+Table1.rows(i).id.substr(3)).value=="" || eval("form1.T4"+Table1.rows(i).id.substr(3)).value==""){ 
            alert("请检察是否有文本框为空"); 
            return false; 
        } 
    } 
}            

//--> 
</script> 
<body>
  <div id="container">
  	<div id="login_image">

        <form action="<%=request.getContextPath()%>/SaveArrange.do" method="post">
         <div>
            <input type="text" name="index.year" value="${arrangeIndex.year}"/>
            <input type="text" name="index.month" value="${arrangeIndex.month}"/>
            <input type="text" name="index.departName" value="${arrangeIndex.departName}"/>
            <input type="text" name="index.gasName" value="${arrangeIndex.gasName}"/>
         </div>
         
          <div>
                        营业时段<input type="text" name="saleInfo.businessTime.startHours" value=""/><input type="text" name="saleInfo.businessTime.startMin" value=""/>
                ~<input type="text" name ="saleInfo.businessTime.endHours"value=""/><input type="text" name="saleInfo.businessTime.endMin" value=""/> 
                        营业时间<input type="text" name="saleInfo.businessHours" value="" tabindex="4"/>  
                       排班方式<select name="arrangeInfo.arrangeName" tabindex="1" > 
                  <logic:iterate id="vau" name="arrangeNames"> 
                       <option value="${vau}">${vau}</option>  
                   </logic:iterate>     
                </select>
                         
          </div>
         <div>
                       月销量<input type="text" name="saleInfo.saleNum" value="" tabindex="4"/> 
                      持卡比例<input type="text"  name="saleInfo.saleMoney" value="" tabindex="4"/>
                        非油品销售额<input type="text"  name="saleInfo.cardScale" value="" tabindex="4"/>                             
          </div>
          
          <div>
                       用工人数<input type="text"  name="staffInfo.staffNum" value="" tabindex="4"/> 
                      每天休息<input type="text"   name="staffInfo.avgRestStaff" value="" tabindex="4"/>
                         月休息<input type="text"  name="staffInfo.avgRestDay" value="" tabindex="4"/>                             
          </div>
          
         <div>
           A班（早班）人数<input type="text" name="arrangeInfo.aMode.modeAvgNum" value="" tabindex="4"/> 
           B班（中班）人数<input type="text" name="arrangeInfo.bMode.modeAvgNum" value="" tabindex="4"/> 
           C班（晚班）人数<input type="text" name="arrangeInfo.cMode.modeAvgNum" value="" tabindex="4"/>                           
          </div>
          
          <div>
           C班（机动1班）人数<input type="text" name="arrangeInfo.dMode.modeAvgNum" value="" tabindex="4"/> 
           D班（机动2班）人数<input type="text" name="arrangeInfo.eMode.modeAvgNum"  value="" tabindex="4"/> 
           E班（机动3班）人数<input type="text" name="arrangeInfo.fMode.modeAvgNum" value="" tabindex="4"/>                           
          </div>
          
          <div>
           F班（机动4班）人数<input type="text" name="arrangeInfo.gMode.modeAvgNum" value="" tabindex="4"/> 
           G班（机动5班）人数<input type="text" name="arrangeInfo.hMode.modeAvgNum" value="" tabindex="4"/> 
           Z班（机动6班）人数<input type="text" name="arrangeInfo.zMode.modeAvgNum" value="" tabindex="4"/>                           
          </div>
          
          
          <div>
           A班（早班）时间<input type="text" name="arrangeInfo.aMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.aMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.aMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.aMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.aMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.aMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.aMode.modeTime3.endMin" value="" tabindex="4"/>  
           B班（中班）时间<input type="text" name="arrangeInfo.bMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.bMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.bMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.bMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.bMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.bMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.bMode.modeTime3.endMin" value="" tabindex="4"/>  
           C班（晚班）时间<input type="text" name="arrangeInfo.cMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.cMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.cMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.cMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.cMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.cMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.cMode.modeTime3.endMin" value="" tabindex="4"/>                            
          </div>
          
          <div>
           D班（机动1班）时间<input type="text" name="arrangeInfo.dMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.dMode.modeTime1.endMin" value="" tabindex="4"/>
                     
                      <input type="text" name="arrangeInfo.dMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.dMode.modeTime2.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.dMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.dMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.dMode.modeTime3.endMin" value="" tabindex="4"/>  
           E班（机动2班）时间<input type="text" name="arrangeInfo.eMode.modeHours"  value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.eMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.eMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.eMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.eMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.eMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.eMode.modeTime3.endMin" value="" tabindex="4"/>  
           F班（机动3班）时间<input type="text" name="arrangeInfo.fMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.fMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.fMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.fMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.fMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.fMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.fMode.modeTime3.endMin" value="" tabindex="4"/>                            
          </div>
          
          <div>
           G班（机动4班）时间<input type="text" name="arrangeInfo.gMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.gMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.gMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.gMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.gMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.gMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.gMode.modeTime3.endMin" value="" tabindex="4"/>  
           H班（机动5班）时间<input type="text" name="arrangeInfo.hMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.hMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.hMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.hgMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.hMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.hMode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.hMode.modeTime3.endMin" value="" tabindex="4"/>  
           z班（机动6班）时间<input type="text" name="arrangeInfo.zMode.modeHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime1.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime1.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime1.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.zMode.modeTime1.endMin" value="" tabindex="4"/>
                      
                      <input type="text" name="arrangeInfo.zMode.modeTime2.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime2.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime2.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.zMode.modeTime2.endMin" value="" tabindex="4"/>
                       
                      <input type="text" name="arrangeInfo.zMode.modeTime3.startHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zMode.modeTime3.endHours" value="" tabindex="4"/>
                      <input type="text" name="arrangeInfo.zode.modeTime3.startMin" value="" tabindex="4"/> 
                      <input type="text" name="arrangeInfo.zMode.modeTime3.endMin" value="" tabindex="4"/>                            
          </div>


 
           
  <table border="1" width="58%" bordercolor="#000000" cellspacing="0" cellpadding="0" bordercolordark="#FFFFFF" height="16" id=Table1> 
   <tr> 
    <td width="15%" align="center" bgcolor="#E6E6E6" height="16">姓名</td> 
    <td width="24%" align="center" bgcolor="#E6E6E6" height="16">岗位</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">1</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">2</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">3</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">4</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">5</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">6</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">7</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">8</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">9</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">10</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">11</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">12</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">13</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">14</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">15</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">16</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">17</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">18</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">19</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">20</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">21</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">22</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">23</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">24</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">25</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">26</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">27</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">28</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">29</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">30</td> 
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">31</td> 
    
    <td width="7%" align="center" bgcolor="#E6E6E6" height="16">月累计工作小时</td> 
    <td width="8%" align="center" bgcolor="#E6E6E6" height="16">法定节日</td> 
    <td width="34%" align="center" bgcolor="#E6E6E6" height="16">平时超时</td> 
    <td width="21%" align="center" bgcolor="#E6E6E6" height="16">工作天数</td> 
    <td width="21%" align="center" bgcolor="#E6E6E6" height="16">休息天数</td> 
    <td width="21%" align="center" bgcolor="#E6E6E6" height="16">操作</td> 
   </tr>      
  </table> 
     <input type="button" value="增加" name="B3" onclick="build_row()">
     <input type="submit" value="提交" name="B1">
     <input type="button" value="取消" name="B6" onClick="age_average()">
    </form>
     <input type="hidden" id="holidays_hidden"value="${holidays}" name="holidays"/>   
	</div>
  </div>
</body> 
</html>