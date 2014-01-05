<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
  <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<title>Insert title here</title>
<style>
.Times {
	border: thin #FFFFFF;
	text-align:center
}
.Times_spit{
   border-left:0;
   border-right:0;
   
}
.Times_input[type="text"]{
   border:0;
   size:20;
   width:20px;
   
}
.Times_td{
   width:40px;
}
 table tr{
   border-collapse:collapse;
   border-left-width:0;
   border-right-width:0;
}
input[type="text"]{
  border:0;
  width:40px;
  text-align:center;
}
</style>
</head>
<script language="javascript"> 

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
var win_new=open("list.htm");
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
</script> 
<body onload="build_row();">
  <div id="container">
  	<div id="login_image">

  <form action="<%=request.getContextPath()%>/SaveArrange.do" method="post">
    <div>
       ${arrangeIndex.year}年${arrangeIndex.month}月 ${arrangeIndex.departName}${arrangeIndex.gasName}
    </div>
   <table width="1339" height="411" border="1" align="center">
    <tr>
      <td height="38" align="center" valign="middle">营业时间</td>
      <td colspan="7" align="center" valign="middle"><input name="saleInfo.businessHours" type="text" id="saleInfo.businessHours" /></td>
      <td width="86" align="center" valign="middle">持卡比例：</td>
      <td width="57" align="center" valign="middle"><input name="saleInfo.cardScale" type="text" id="saleInfo.cardScale" /></td>
      <td colspan="4" align="center" valign="middle">用工人数</td>
      <td colspan="3" align="center" valign="middle"><input name="staffInfo.staffNum" type="text" id="staffInfo.staffNum" /></td>
      <td width="94" align="center" valign="middle">A（早班）:</td>
      <td width="76" align="center" valign="middle"><input name="arrangeInfo.aMode.modeAvgNum" type="text" id="arrangeInfo.aMode.modeAvgNum" /></td>
      <td colspan="4" align="center" valign="middle">D（机动1班）:</td>
      <td colspan="3" align="center" valign="middle"><input name="arrangeInfo.dMode.modeAvgNum" type="text" id="arrangeInfo.dMode.modeAvgNum" /></td>
      <td width="94" align="center" valign="middle">G（机动4班）:</td>
      <td width="84" align="center" valign="middle"><input name="arrangeInfo.hMode.modeAvgNum2" type="text" id="arrangeInfo.hMode.modeAvgNum2" /></td>
    </tr>
    <tr>
      <td height="38" align="center" valign="middle">营业时段</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.startHours" type="text" class="Times_input" id="saleInfo.businessTime.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.startMin" type="text" class="Times_input" id="saleInfo.businessTime.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.endHours" type="text" class="Times_input" id="saleInfo.businessTime.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.endMin" type="text" class="Times_input" id="saleInfo.businessTime.endMin" /></td>
      <td align="center" valign="middle">月销量：</td>
      <td align="center" valign="middle"><input name="saleInfo.saleMoney" type="text" id="saleInfo.saleMoney" /></td>
      <td colspan="4" align="center">每天休息</td>
      <td colspan="3" align="center" valign="middle"><input name="staffInfo.avgRestStaff" type="text" id="staffInfo.avgRestStaff" /></td>
      <td align="center" valign="middle">B（中班）:</td>
      <td align="center" valign="middle"><input name="arrangeInfo.bMode.modeAvgNum" type="text" id="arrangeInfo.bMode.modeAvgNum" /></td>
      <td colspan="4" align="center" valign="middle">E（机动2班）:</td>
      <td colspan="3" align="center" valign="middle"><input name="arrangeInfo.eMode.modeAvgNum" type="text" id="arrangeInfo.eMode.modeAvgNum" /></td>
      <td align="center" valign="middle">H（机动5班）:</td>
      <td align="center" valign="middle"><input name="arrangeInfo.hMode.modeAvgNum" type="text" id="arrangeInfo.hMode.modeAvgNum" /></td>
    </tr>
    <tr>
      <td height="38" align="center" valign="middle">排班方式</td>
      <td colspan="7" align="center" valign="middle"><label>
        <select name="arrangeInfo.arrangeName" class="Times_input" id="arrangeInfo.arrangeName">
          <logic:iterate id="optionValue" name="arrangeNames">    
               <option value="${optionValue}">${optionValue}</option>  
          </logic:iterate>
        </select>
      </label></td>
      <td align="center" valign="middle">非油品销售额</td>
      <td align="center" valign="middle"><input name="saleInfo.saleNum" type="text" id="saleInfo.saleNum" /></td>
      <td colspan="4" align="center">月休息</td>
      <td colspan="3" align="center" valign="middle"><input name="staffInfo.avgRestDay" type="text" id="staffInfo.avgRestDay" /></td>
      <td align="center" valign="middle">C（晚班）:</td>
      <td align="center" valign="middle"><input name="arrangeInfo.cMode.modeAvgNum" type="text" id="arrangeInfo.cMode.modeAvgNum" /></td>
      <td colspan="4" align="center" valign="middle">F（机动3班）:</td>
      <td colspan="3" align="center" valign="middle"><input name="arrangeInfo.fMode.modeAvgNum" type="text" id="arrangeInfo.fMode.modeAvgNum" /></td>
      <td align="center" valign="middle">Z（机动6班）:</td>
      <td align="center" valign="middle"><input name="arrangeInfo.zMode.modeAvgNum" type="text" id="arrangeInfo.zMode.modeAvgNum" /></td>
    </tr>
    <tr>
      <td width="118" height="38" align="center" valign="middle"> A（中班:小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.startHours" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.startMin" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endHours" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endMin" /></td>
      <td colspan="2" align="center" valign="middle">B（中班:小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.startHours" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.startMin" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.endHours" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.endMin" /></td>
      <td colspan="2" align="center" valign="middle">C（夜班:小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.startHours" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.startMin" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.endHours" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.endMin" /></td>
      <td colspan="2"><table align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="160" height="32" colspan="5" align="center" valign="middle">其他需要说明的事项</td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td rowspan="3" align="center" valign="middle">D（机动1班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.endMin" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">E（机动2班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.endMin" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">F（机动3班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.endMin" /></td>
      <td colspan="2" rowspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.endMin" /></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.endMin" /></td>
    </tr>
    <tr>
      <td rowspan="3" align="center" valign="middle">E（机动2班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.startHours2" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.startHours2" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.endMin" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">H（机动5班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.startHours2" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.startHours2" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.endMin" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">Z（机动6班：小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.endMin" /></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.endMin" /></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.endHours2" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.endHours2" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.endMin" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.startHours" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.startMin" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.endHours" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.endMin" /></td>
    </tr>
  </table>


 
           
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
	 	<button type="submit" name ="submit" value="download">Excel数据模版</button>
		<input type="file" name ="recieveAssetsFile"/>										
		<button type="submit" name ="submit" value="upload"  >通过Excel表格导入</button>	
											
    </form>
     <input type="hidden" id="holidays_hidden"value="${holidays}" name="holidays"/>   
	</div>
  </div>
</body> 
</html>