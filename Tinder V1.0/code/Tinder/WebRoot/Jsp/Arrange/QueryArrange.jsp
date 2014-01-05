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
   width:40px;
   
}
.Times_td{
   width:40px;
}
.disable_item{
    background-color:#E6E6E6;
    color:#222222;
    font-style:oblique;
}
 table tr{
   border-collapse:collapse;
   border-left-width:0;
   border-right-width:0;
}
input[type="text"]{
  border:0;
  width:60px;
  text-align:center;
}
#div_title{
  text-align:center;
  font-size:30px;
}
#div_btn{
  text-align:center;
  margin-top:20px;
  margin-left:-120px;
  
}
#div_btn input{ 
  margin-left:30px;
  font-size:24px;
}
#div_cancel{
  text-align:center;
  margin-top:-34px;
  margin-left:440px;
}
#div_export{
  text-align:center;
  margin-top:-35px;  
  margin-left:240px;

}
#div_cancel input{ 
  font-size:24px;
}
#div_export input{ 
  font-size:24px;
}

#tips{
  
      font-size:24px;
      color:red;
}
</style>
</head>
<script language="javascript"> 

var row_index=0; 
var delete_names="";
//建立一个函数build_row()用于建立新的一行且增加的四个文本框为空的且被禁用 
function build_row(){ 

     var a = ",,\\,\\,\\,\\,,,,";
     var input_holiday =  document.getElementById("holidays_hidden");
     var a = input_holiday.value;

	 var restDays= new Array();
     restDays = a.split(",");
     
    var b =  document.getElementById("jobsJson_hidden");
    var jobs = b.value;

    var jobNames= new Array();
     jobNames = jobs.split(","); 
 
    
 
    var new_row=Table1.insertRow(Table1.rows.length); 
    new_row.setAttribute("id", "row"+row_index);   
    var new_col=new_row.insertCell(0); 
	var itemName = 'arrangeDatas[' + row_index + '].name';
    new_col.innerHTML="<input id='name"+row_index+"' type='text' style='WIDTH: 60px;' name='"+itemName+"' size='10' >"; 
    

    var i = 0;
    option_value ="";
    for(i=0;i<jobNames.length;i++)
    {
       option_value += "<option value='"+jobNames[i]+"'>" + jobNames[i] +"</option>";
    }
    var new_col=new_row.insertCell(1); 
	itemName = 'arrangeDatas[' + row_index + '].job';
    new_col.innerHTML="<select name='"+itemName+"'/>"+option_value+"</select>"; 
   
   
    
   for(i=1;i<=restDays.length ;i++ )
   {
     var new_col=new_row.insertCell(i+1); 
     itemName  = 'arrangeDatas[' + row_index + '].d' + i;
     var itemVal  = restDays[i-1];
	 var b = '-';
	 if(itemVal == b)
	 {
	    new_col.innerHTML="<input type='text' style='WIDTH: 30px;' name='"+itemName+"' value='"+itemVal+"'size='10' readonly>"; 
	 }
     else
	 {
	   new_col.innerHTML="<input type='text' style='WIDTH: 30px;' name='"+itemName+"' value='"+itemVal+"'size='10' >"; 
	 }
   }
	 

    var new_col=new_row.insertCell(restDays.length+2); 
	itemName = 'arrangeDatas[' + row_index + '].sumHours';
    new_col.innerHTML="<input type='text' name='"+itemName+"' size='10' readonly>"; 
	
	var new_col=new_row.insertCell(restDays.length+3); 
	itemName = 'arrangeDatas[' + row_index + '].sumDays';
    new_col.innerHTML="<input type='text' name='"+itemName+"' size='10' readonly>"; 
	
	var new_col=new_row.insertCell(restDays.length+4); 
	itemName = 'arrangeDatas[' + row_index + '].holidays';
    new_col.innerHTML="<input type='text' name='"+itemName+"' size='10' readonly>"; 
	
	var new_col=new_row.insertCell(restDays.length+5); 
	itemName = 'arrangeDatas[' + row_index + '].overHours';
    new_col.innerHTML="<input type='text' name='"+itemName+"' size='10' readonly>"; 
	
	var new_col=new_row.insertCell(restDays.length+6); 
	itemName = 'arrangeDatas[' + row_index + '].restDays';
    new_col.innerHTML="<input type='text' name='"+itemName+"' size='10' readonly>"; 
	
	var new_col=new_row.insertCell(restDays.length+7); 

    new_col.innerHTML="<input type='button' value='删除此行' name='B4"+row_index+"' LANGUAGE='javascript' onclick=\"delete_row("+row_index+ ")\">";
    
    row_index++;  
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
function delete_row(rowNum)   
{ 
    var i; 
	
	var rname;
	rname = 'row'+rowNum;
	

	
    i=Table1.rows(rname).rowIndex; 
    
	var name_id;
 
    name_id = 'name' + rowNum;
    alert(name_id);
	
	delete_names += document.getElementById(name_id).value +",";
	document.getElementById("delete_name_id").value = delete_names;
 

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
function build_first_row()
{
    var doc_size =  document.getElementById("arrangeSize_hidden");
    var rowSize = doc_size.value; 
    row_index = parseInt(rowSize);

    if(row_index == 0)
    {
      build_row();
    }
    
}
</script> 
<body onLoad="build_first_row();">
  <div id="container">
  	<div id="login_image">

  <form action="<%=request.getContextPath()%>/SaveArrange.do" method="post">
    <div id="div_title">
       ${arrangeIndex.year}年${arrangeIndex.month}月 ${arrangeIndex.departName}${arrangeIndex.gasName}
       
        <input type="hidden" value="${arrangeIndex.year}" name="index.year"/>
        <input type="hidden" value="${arrangeIndex.month}" name="index.month"/>
        <input type="hidden" value="${arrangeIndex.departName}" name="index.departName"/>
        <input type="hidden" value="${arrangeIndex.gasName}" name="index.gasName"/>
    </div>
   <table width="1339" height="391" border="1" align="center">
    <tr align="center" valign="middle">
      <td height="38">营业时间</td>
      <td colspan="7" class="disable_item"><input name="saleInfo.businessHours" type="text" readonly class="disable_item" id="saleInfo.businessHours" value="${gasInfo.saleInfo.businessHours}"/></td>
      <td width="86">持卡比例：</td>
      <td width="57" align="center"><input name="saleInfo.cardScale" type="text" id="saleInfo.cardScale" value="${gasInfo.saleInfo.cardScale}" /></td>
      <td colspan="4">用工人数</td>
      <td colspan="3" class="disable_item"><input name="staffInfo.staffNum" type="text" readonly class="disable_item" id="staffInfo.staffNum" value="${gasInfo.staffInfo.staffNum}"/></td>
      <td width="94">A（早班）:</td>
      <td width="76" class="disable_item"><input name="arrangeInfo.aMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.aMode.modeAvgNum" value="${gasInfo.arrangeInfo.aMode.modeAvgNum}"/></td>
      <td colspan="4">D（机动1班）:</td>
      <td colspan="3" class="disable_item"><input name="arrangeInfo.dMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.dMode.modeAvgNum" value="${gasInfo.arrangeInfo.dMode.modeAvgNum}"/></td>
      <td width="94">G（机动4班）:</td>
      <td width="84" class="disable_item"><input name="arrangeInfo.hMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.hMode.modeAvgNum" value="${gasInfo.arrangeInfo.hMode.modeAvgNum}"/></td>
    </tr>
    <tr>
      <td height="38" align="center" valign="middle">营业时段</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.startHours" type="text" class="Times_input" id="saleInfo.businessTime.startHours" value="${gasInfo.saleInfo.businessTime.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.startMin" type="text" class="Times_input" id="saleInfo.businessTime.startMin" value="${gasInfo.saleInfo.businessTime.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.endHours" type="text" class="Times_input" id="saleInfo.businessTime.endHours" value="${gasInfo.saleInfo.businessTime.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="saleInfo.businessTime.endMin" type="text" class="Times_input" id="saleInfo.businessTime.endMin" value="${gasInfo.saleInfo.businessTime.endMin}" /></td>
      <td align="center" valign="middle">月销量：</td>
      <td align="center" valign="middle"><input name="saleInfo.saleNum" type="text" id="saleInfo.saleNum" value="${gasInfo.saleInfo.saleNum}" /></td>
      <td colspan="4" align="center">每天休息</td>
      <td colspan="3" align="center" valign="middle" class="disable_item"><input name="staffInfo.avgRestStaff" type="text" readonly class="disable_item" id="staffInfo.avgRestStaff" value="${gasInfo.staffInfo.avgRestStaff}"/></td>
      <td align="center" valign="middle">B（中班）:</td>
      <td align="center" valign="middle" class="disable_item"><input name="arrangeInfo.bMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.bMode.modeAvgNum" value="${gasInfo.arrangeInfo.bMode.modeAvgNum}"/></td>
      <td colspan="4" align="center" valign="middle">E（机动2班）:</td>
      <td colspan="3" align="center" valign="middle" class="disable_item"><input name="arrangeInfo.eMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.eMode.modeAvgNum" value="${gasInfo.arrangeInfo.eMode.modeAvgNum}"/></td>
      <td align="center" valign="middle">H（机动5班）:</td>
      <td align="center" valign="middle" class="disable_item"><input name="arrangeInfo.hMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.hMode.modeAvgNum" value="${gasInfo.arrangeInfo.hMode.modeAvgNum}"/></td>
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
      <td align="center" valign="middle"><input name="saleInfo.saleMoney" type="text" id="saleInfo.saleMoney" value="${gasInfo.saleInfo.saleMoney}" /></td>
      <td colspan="4" align="center">月休息</td>
      <td colspan="3" align="center" valign="middle" class="disable_item"><input name="staffInfo.avgRestDay" type="text" readonly class="disable_item" id="staffInfo.avgRestDay" value="${gasInfo.staffInfo.avgRestDay}"/></td>
      <td align="center" valign="middle">C（晚班）:</td>
      <td align="center" valign="middle" bgcolor="#E6E6E6"><input name="arrangeInfo.cMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.cMode.modeAvgNum" value="${gasInfo.arrangeInfo.cMode.modeAvgNum}"/></td>
      <td colspan="4" align="center" valign="middle">F（机动3班）:</td>
      <td colspan="3" align="center" valign="middle" bgcolor="#E6E6E6" class="disable_item"><input name="arrangeInfo.fMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.fMode.modeAvgNum" value="${gasInfo.arrangeInfo.fMode.modeAvgNum}"/></td>
      <td align="center" valign="middle">Z（机动6班）:</td>
      <td align="center" valign="middle" bgcolor="#E6E6E6" class="disable_item"><input name="arrangeInfo.zMode.modeAvgNum" type="text" readonly class="disable_item" id="arrangeInfo.zMode.modeAvgNum" value="${gasInfo.arrangeInfo.zMode.modeAvgNum}"/></td>
    </tr>
    <tr>
      <td width="118" height="38" align="center" valign="middle"> A（早班:${gasInfo.arrangeInfo.aMode.modeHours}小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.aMode.modeTime1.startHours}" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.aMode.modeTime1.startMin}" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.aMode.modeTime1.endHours}" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.aMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.aMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.aMode.modeTime1.endMin}" /></td>
      <td colspan="2" align="center" valign="middle">B（中班:${gasInfo.arrangeInfo.bMode.modeHours}小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.bMode.modeTime1.startHours}" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.bMode.modeTime1.startMin}" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.bMode.modeTime1.endHours}" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.bMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.bMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.bMode.modeTime1.endMin}" /></td>
      <td colspan="2" align="center" valign="middle">C（夜班:${gasInfo.arrangeInfo.cMode.modeHours}小时）</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.cMode.modeTime1.startHours}" /></td>
      <td width="9" align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.cMode.modeTime1.startMin}" /></td>
      <td width="12" align="center" valign="middle" class="Times_spit">--</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.cMode.modeTime1.endHours}" /></td>
      <td width="5" align="center" valign="middle" class="Times_spit">:</td>
      <td width="40" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.cMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.cMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.cMode.modeTime1.endMin}" /></td>
      <td colspan="2"><table align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="160" height="32" colspan="5" align="center" valign="middle">其他需要说明的事项</td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td rowspan="3" align="center" valign="middle">D（机动1班：${gasInfo.arrangeInfo.dMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.dMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.dMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.dMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.dMode.modeTime1.endMin}" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">E（机动2班：${gasInfo.arrangeInfo.eMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.eMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.eMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.eMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.eMode.modeTime1.endMin}" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">F（机动3班：${gasInfo.arrangeInfo.fMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.fMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.fMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.fMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.fMode.modeTime1.endMin}" /></td>
      <td colspan="2" rowspan="6" align="center" valign="middle"><label>
        <textarea name="others" rows="6" id="others">${gasInfo.others}</textarea>
      </label></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.dMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.dMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.dMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.dMode.modeTime2.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.eMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.eMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.eMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.eMode.modeTime2.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.fMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.fMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.fMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.fMode.modeTime2.endMin}" /></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.dMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.dMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.dMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.dMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.dMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.dMode.modeTime3.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.eMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.eMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.eMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.eMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.eMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.eMode.modeTime3.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.fMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.fMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.fMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.fMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.fMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.fMode.modeTime3.endMin}" /></td>
    </tr>
    <tr>
      <td rowspan="3" align="center" valign="middle">G（机动4班：${gasInfo.arrangeInfo.gMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.gMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.gMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.gMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.gMode.modeTime1.endMin}" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">H（机动5班：${gasInfo.arrangeInfo.hMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.hMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.hMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.hMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.hMode.modeTime1.endMin}" /></td>
      <td colspan="2" rowspan="3" align="center" valign="middle">Z（机动6班：${gasInfo.arrangeInfo.zMode.modeHours}小时）</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.startHours" value="${gasInfo.arrangeInfo.zMode.modeTime1.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.startMin" value="${gasInfo.arrangeInfo.zMode.modeTime1.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.endHours" value="${gasInfo.arrangeInfo.zMode.modeTime1.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime1.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime1.endMin" value="${gasInfo.arrangeInfo.zMode.modeTime1.endMin}" /></td>
    </tr>
    <tr>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.gMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.gMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.gMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.gMode.modeTime2.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.hMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.hMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.hMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.hMode.modeTime2.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.startHours" value="${gasInfo.arrangeInfo.zMode.modeTime2.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.startMin" value="${gasInfo.arrangeInfo.zMode.modeTime2.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.endHours" value="${gasInfo.arrangeInfo.zMode.modeTime2.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime2.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime2.endMin" value="${gasInfo.arrangeInfo.zMode.modeTime2.endMin}" /></td>
    </tr>
    <tr>
      <td height="23" align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.gMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.gMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.gMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.gMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.gMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.gMode.modeTime3.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.hMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.hMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.hMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.hMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.hMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.hMode.modeTime3.endMin}" /></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.startHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.startHours" value="${gasInfo.arrangeInfo.zMode.modeTime3.startHours}" /></td>
      <td align="center" valign="middle" class="Times_spit"><label class="Times">:</label></td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.startMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.startMin" value="${gasInfo.arrangeInfo.zMode.modeTime3.startMin}" /></td>
      <td align="center" valign="middle" class="Times_spit">--</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.endHours" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.endHours" value="${gasInfo.arrangeInfo.zMode.modeTime3.endHours}" /></td>
      <td align="center" valign="middle" class="Times_spit">:</td>
      <td align="center" valign="middle" class="Times_td"><input name="arrangeInfo.zMode.modeTime3.endMin" type="text" class="Times_input" id="arrangeInfo.zMode.modeTime3.endMin" value="${gasInfo.arrangeInfo.zMode.modeTime3.endMin}" /></td>
    </tr>
  </table>


 
           
  <table border="1" width="58%" bordercolor="#000000" cellspacing="0" cellpadding="0" bordercolordark="#FFFFFF" height="16" id=Table1> 
   <tr> 
    <td width="15%" width="60" align="center" bgcolor="#E6E6E6" height="16">姓名</td> 
    <td width="24%" width="60" align="center" bgcolor="#E6E6E6" height="16">岗位</td> 
    <td width="7%" width="30" align="center" bgcolor="#E6E6E6" height="16">1</td> 
    <td width="7%" width="30" align="center" bgcolor="#E6E6E6" height="16">2</td> 
    <td width="7%" width="30" align="center" bgcolor="#E6E6E6" height="16">3</td> 
    <td width="7%" width="30" align="center" bgcolor="#E6E6E6" height="16">4</td> 
    <td width="7%" width="30" align="center" bgcolor="#E6E6E6" height="16">5</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">6</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">7</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">8</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">9</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">10</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">11</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">12</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">13</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">14</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">15</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">16</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">17</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">18</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">19</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">20</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">21</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">22</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">23</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">24</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">25</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">26</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">27</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">28</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">29</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">30</td> 
    <td width="7%" width='30' align="center" bgcolor="#E6E6E6" height="16">31</td> 
    
    <td width="7%" width='30'align="center" bgcolor="#E6E6E6" height="16">月累计工作小时</td> 
    <td width="8%" width='30'align="center" bgcolor="#E6E6E6" height="16">法定节日</td> 
    <td width="34%" width='30' align="center" bgcolor="#E6E6E6" height="16">平时超时</td> 
    <td width="21%" width='30' align="center" bgcolor="#E6E6E6" height="16">工作天数</td> 
    <td width="21%"  width='30'align="center" bgcolor="#E6E6E6" height="16">休息天数</td> 
    <td width="21%" width='30' align="center" bgcolor="#E6E6E6" height="16">操作</td> 
   </tr>      
    <logic:iterate id="rowValue" name="workArrangeDatas">    
    <tr id="row${rowValue.serialNum}">
		<td>
		  <input id="name${rowValue.serialNum}" type='text' style='WIDTH: 60px;'name='arrangeDatas[${rowValue.serialNum}].name' size='10' value="${rowValue.name}"> 
		</td>

		<td>
		<select  style='WIDTH: 60px;' name='arrangeDatas[${rowValue.serialNum}].job'>
			<option value="${rowValue.job}" selected>${rowValue.job}</option>  
             <logic:iterate id="optionValue" name="jobs">
		       <option value="${optionValue}" >${optionValue}</option>  
		     </logic:iterate>
		</select>
		</td>
		
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d1' value='${rowValue.d1}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d2' value='${rowValue.d2}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d3' value='${rowValue.d3}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d4' value='${rowValue.d4}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d5' value='${rowValue.d5}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d6' value='${rowValue.d6}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d7' value='${rowValue.d7}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d8' value='${rowValue.d8}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d9' value='${rowValue.d9}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d10' value='${rowValue.d10}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d11' value='${rowValue.d11}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d12' value='${rowValue.d12}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d13' value='${rowValue.d13}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d14' value='${rowValue.d14}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d15' value='${rowValue.d15}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d16' value='${rowValue.d16}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d17' value='${rowValue.d17}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d18' value='${rowValue.d18}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d19' value='${rowValue.d19}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d20' value='${rowValue.d20}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d21' value='${rowValue.d21}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d22' value='${rowValue.d22}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d23' value='${rowValue.d23}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d24' value='${rowValue.d24}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d25' value='${rowValue.d25}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d26' value='${rowValue.d26}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d27' value='${rowValue.d27}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d28' value='${rowValue.d28}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d29' value='${rowValue.d29}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d30' value='${rowValue.d30}'size='10'>
		</td>
		<td>
		  <input type='text' style='WIDTH: 30px;' name='arrangeDatas[${rowValue.serialNum}].d31' value='${rowValue.d31}'size='10'>
		</td>
		
		

		<td>
		<input type='text' name='arrangeDatas[${rowValue.serialNum}].sumHours' value="${rowValue.sumHours}" readonly/> 
		</td>

		<td>
		<input type='text' name='arrangeDatas[${rowValue.serialNum}].holidays' size='10' value="${rowValue.holidays}" readonly/> 
		</td>
		
		<td>
		<input type='text' name='arrangeDatas[${rowValue.serialNum}].overHours' size='10' value="${rowValue.overHours}" readonly/> 
		
		</td>
		
		<td>
		<input type='text' name='arrangeDatas[${rowValue.serialNum}].sumDays' size='10' value="${rowValue.sumDays}" readonly/> 
		</td>
		
		<td>
		<input type='text' name='arrangeDatas[${rowValue.serialNum}].restDays' size='10' value="${rowValue.restDays}" readonly/> 
		</td>
		<td>
		  <input type='button' value='删除此行' name='B4${rowValue.serialNum}'  onclick="delete_row(${rowValue.serialNum})";>
		  </td>
	</tr>
	</logic:iterate>
 
   
  </table> 
  
     <div id="div_btn">  

        <input type="button" value="增加" name="B3" onClick="build_row()"/>

     <input type="submit" value="提交" name="submit"/>
	 </div>
	 <div id="div_cancel">
		<input type="submit" value="取消" name="submit"/>
	 </div>
	 <div >
		<button type="submit"  name ="submit" value="download">Excel数据模版</button>
		<input type="file" name ="uploadFile"/>										
		<button  type="submit"  name ="submit" value="upload"  >通过Excel表格导入</button>	
											
	 </div>
	 
	 
	 <input type="hidden" id="delete_name_id" value=""  name="deleleNames"/>  

	 
  </form>
  <input type="hidden" id="holidays_hidden"value="${holidays}" name="holidays"/> 
 
  <for action="<%=request.getContextPath()%>/ExportArrange.do" method="post">
      <div id="div_export">
	     <input type="submit" value="导出" name="submit">
	 </div>
	         <input type="hidden" value="${arrangeIndex.year}" name="year"/>
        <input type="hidden" value="${arrangeIndex.month}" name="month"/>
        <input type="hidden" value="${arrangeIndex.departName}" name="departName"/>
        <input type="hidden" value="${arrangeIndex.gasName}" name="gasName"/>
        <input type="hidden" id="arrangeSize_hidden" value="${arrangeSize}" name="arrangeSize"/>
        <input type="hidden" id="jobsJson_hidden" value="${jobsJson}" name="jobsJson"/>  
  </form>
    
       
	</div>
	<div id="tips">
	   ${OperationMessage}
	</div>
	<div>
	  1.各种符号：出勤“按班次代码填写”，休息“﹨”，事假“○”，病假“△”，旷工“ⅹ”，工伤“﹢”，婚假“※”，产假“□”，计生、看护假“℅”，丧假“◇”，年休假“∥”，学习“☆”，献血“∽”，子女高考、中考“∑”。其它用文字说明。
	</div>
  </div>
</body> 
</html>