<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String[] para = {"1、运动物体的重量","2、静止物体的重量","3、运动物体的长度","4、静止物体的长度","5、运动物体的面积","6、静止物体的面积","7、运动物体的体积","8、静止物体的体积","9、速度","10、力","11、应力或压力","12、形状","13、结构的稳定性","14、强度","15、运动物体作用时间","16、静止物体作用时间","17、温度","18、光照度","19、运动物体的能量","20、静止物体的能量","21、功率","22、能量损失","23、物质损失","24、信息损失","25、时间损失","26、物质或事物的数量","27、可靠性","28、测试精度","29、制造精度","30、物体外部有害因素作用的敏感性","31、物体产生的有害因素因素","32、可制造性","33、可操作性","34、可维修性","35、适应性及多用性","36、装置的复杂性","37、监控与测试的困难程度","38、自动化程度","39、生产率"};
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>技术矛盾分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#refresh").click(function() {
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/center/techJson',
			data: 'improve=' + $("#improve").val() + '&worse=' + $("#worse").val(),
			async : false, //同步方式
			success : function(prins) {
				$("#matrixTh").nextAll().remove();
				var tableStr = "";
				for(var i=0;i<prins.length;i++) {
					tableStr += "<tr><td>" + prins[i].id + "</td><td>" + prins[i].name + "</td><td style='text-align:left;''>" + prins[i].descr + "</td></tr>";
				}
				$("#matrixTh").after(tableStr);
		//		alert();
			}
		});
	});
});
</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>技术矛盾分析</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Technology">
				<input type="hidden" name="wordId" value="${wordId }">
				<div class="form-group">
					<label class="col-sm-2 control-label">原问题技术矛盾的表述：</label>					
				</div>
				
				<div class="form-group">
					<div class="col-sm-6">
						<label for="A+" class="col-sm-4 control-label">如果A+:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="A+" name="A+" value="${tech.a1 }">
						</div>
					</div>
					<div class="col-sm-6">
						<label for="A-" class="col-sm-2 control-label">如果A-:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="A-" name="A-" value="${tech.a2 }">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-6">
						<label for="B+" class="col-sm-4 control-label">那么B+:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="B+" name="B+" value="${tech.b1 }">
						</div>
					</div>
						
					<div class="col-sm-6">
						<label for="B-" class="col-sm-2 control-label">那么B-:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="B-" name="B-" value="${tech.b2 }">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-6">
						<label for="C-" class="col-sm-4 control-label">那么C-:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="C-" name="C-" value="${tech.c1 }">
						</div>
					</div>
						
					<div class="col-sm-6">
						<label for="C+" class="col-sm-2 control-label">那么C+:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="C+" name="C+" value="${tech.c2 }">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-1"></div>
					<label class="control-label col-sm-11">确定要解决的技术矛盾为 
					<select id="tech_con" name="tech_con" style="width:70px;height:40px;">
						<option value="1" <c:if test="${tech.techCon == 1 }">selected</c:if>>左边</option>
						<option value="2" <c:if test="${tech.techCon != null && tech.techCon == 2 }">selected</c:if>>右边</option>
					</select>
					EC-2，它发生在（
					<input type="text" style="width:130px;height:40px;" id="com1" name="com1" value="${tech.com1 }">
					 ）与（
					 <input type="text" style="width:130px;height:40px;" id="com2" name="com2" value="${tech.com2 }">
					 ）之间，发生在（
					 <input type="text" style="width:150px;height:40px;" id="com3" name="com3" value="${tech.com3 }">
					 ）的时候。</label>					
				</div>
				
				
				<div class="form-group" style="margin-top:40px;">
					<label class="col-sm-2 control-label">对应39个通用工程参数：</label>					
				</div>
				
				<div class="form-group">
					<label for="improve" class="col-sm-2 control-label">改善的参数：</label>
					<div class="col-sm-4">
						<select class="form-control" id="improve" name="improve">
						<%
							for(int i=0;i<para.length;i++) {
								session.setAttribute("i", i);
								%>
								<option value="<%=(i+1) %>" <c:if test="${tech.improve != null && tech.improve == (i+1) }">selected</c:if>><%=para[i] %></option>
								<%
							}
						%>
							<%-- <option title="这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字" value="1" <c:if test="${tech.improve != null && tech.improve == 1 }">selected</c:if>>a</option>
							<option title="这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字" value="2" <c:if test="${tech.improve != null && tech.improve == 2 }">selected</c:if>>b</option> --%>
						</select>
					</div>
					
				</div>
				
				<div class="form-group">
					<label for="worse" class="col-sm-2 control-label">恶化的参数：</label>
					<div class="col-sm-4">
						<select class="form-control" id="worse" name="worse">
						<%
							for(int i=0;i<para.length;i++) {
								session.setAttribute("i", i);
								%>
								<option value="<%=(i+1) %>" <c:if test="${tech.worse != null && tech.worse == (i+1) }">selected</c:if>><%=para[i] %></option>
								<%
							}
						%>
							<%-- <option title="这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字" value="1" <c:if test="${tech.worse != null && tech.worse == 1 }">selected</c:if>>a</option>
							<option title="这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字这是一段很长的文字" value="2" <c:if test="${tech.worse != null && tech.worse == 2 }">selected</c:if>>b</option>--%>	
						</select>
					</div>
				</div>				
				
				<!-- 刷新按钮 -->
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-10">
						<button type="button" class="btn btn-primary" id="refresh">刷新矩阵</button>
					</div>					
				</div>
				
				<div class="form-group" id="solutiondiv">
					<label for="result" class="control-label text-left">对应阿奇舒勒矛盾矩阵表得到参考创新原理为：</label>
				</div>
				
				<div>
					<table class="table" style="margin:auto;text-align:center;">
						<tr id="matrixTh">
							<th style="text-align:center;" class="success col-sm-1">序号</th>
							<th style="text-align:center;" class="success col-sm-2">发明原理</th>
							<th style="text-align:center;" class="success col-sm-10">简介</th>
						</tr>
						<c:choose>
							<c:when test="${prins != null}">
								<c:forEach items="${prins}" var="prin">
								<tr>
								<td>${prin.id }</td>
								<td>${prin.name }</td>
								<td style="text-align:left;">${prin.descr }</td>
								</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
				</table>
				</div>
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution7" class="col-sm-2 control-label">思路7：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="solution7" name="solution7">${solution7 }</textarea>
					</div>
				</div>
				
				<!-- 提交 -->
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">提交</button>						
					</div>
				</div>
				
				
				
			</form>
		</div>
	</div>

</body>
</html>