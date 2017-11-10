<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String[] rowText = {"种类","物质资源","能量资源","信息资源","空间资源","时间资源","功能资源"};
	String[] colText = {"系统","子系统","超系统"};
	String[] colText21 = {"价值","数量","质量","可用性"};
	String[] colText22 = {"免费","廉价","昂贵","无限","足够","不足","有益","中性","有害","成品","改变可用","需要建造"};
	String[] rowText3 = {"资源名称","类型","系统","价值","数量","质量","可用性"};
	int countRow = 0;
	int countCol = 0;
	int countSource = (Integer)request.getAttribute("countSource");
	int countSource2 = countSource;
	String[] title = {"type","system","value","quantity","quality","usable"};
	request.setAttribute("title", title);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>资源分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		var countS = <%= countSource %>;
		var countD = 0;
		<% 
		for(int i=1;i<=countSource;i++) { 
			for(int j=0;j<title.length;j++) {
		%>
		
		$("#<%=title[j] %><%=i %> option[value='<%= request.getAttribute(title[j] + i) %>']").attr("selected","true");
		<% 
		}
		}
		%>
	//	$("#type2 option[value='" + i +"']").attr("selected","true");
		$("#resourcetable").delegate("#addresource","click",function() {
			//alert();
			countS ++;
			<%
				countCol = 0;
			%>
			$("#finaltr").before("<tr><td class='col-sm-1'><input type='text' class='form-control' name='name" + countS + "'></td>"
					+ "<td class='col-sm-1'>"
					+ "<select name='<%=title[0] %>" + countS + "' id='<%=title[0] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=rowText[++countCol] %></option>"
					+ "<option value='2'><%=rowText[++countCol] %></option>"
					+ "<option value='3'><%=rowText[++countCol] %></option>"
					+ "<option value='4'><%=rowText[++countCol] %></option>"
					+ "<option value='5'><%=rowText[++countCol] %></option>"
					+ "<option value='6'><%=rowText[++countCol] %></option>"
					+ "</select>"
					+ "</td>"
					<% countCol = 0; %>
					+ "<td class='col-sm-1'>"
					+ "<select name='<%=title[1] %>" + countS + "' id='<%=title[1] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=colText[countCol++] %></option>"
					+ "<option value='2'><%=colText[countCol++] %></option>"
					+ "<option value='3'><%=colText[countCol++] %></option>"
					+ "</select></td>"
					<% countCol = 0; %>
					+ "<td class='col-sm-1'><select name='<%=title[2] %>" + countS + "' id='<%=title[2] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=colText22[countCol++]%></option>"
					+ "<option value='2'><%=colText22[countCol++]%></option>"
					+ "<option value='3'><%=colText22[countCol++]%></option>"
					+ "</select></td>"
					+ "<td class='col-sm-1'><select name='<%=title[3] %>" + countS + "' id='<%=title[3] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=colText22[countCol++]%></option>"
					+ "<option value='2'><%=colText22[countCol++]%></option>"
					+ "<option value='3'><%=colText22[countCol++]%></option>"
					+ "</select></td>"
					+ "<td class='col-sm-1'><select name='<%=title[4] %>" + countS + "' id='<%=title[4] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=colText22[countCol++]%></option>"
					+ "<option value='2'><%=colText22[countCol++]%></option>"
					+ "<option value='3'><%=colText22[countCol++]%></option>"
					+ "</select></td>"
					+ "<td class='col-sm-1'><select name='<%=title[5] %>" + countS + "' id='<%=title[5] %>" + countS + "' class='form-control'>"
					+ "<option selected value='1'><%=colText22[countCol++]%></option>"
					+ "<option value='2'><%=colText22[countCol++]%></option>"
					+ "<option value='3'><%=colText22[countCol++]%></option>"
					+ "</select></td>"
					+ "<td><button type='button' class='btn btn-danger' id='deleteresource'>删除</button></td>"	
					+ "</tr>");
			$("#countSource").val(countS);
		//	alert($("#countSource").val());
		});
		
		$("#resourcetable").delegate("#deleteresource","click",function() {
			if(confirm("您确定要删除吗？")) {
				var name = $(this).parent().parent().children("td").first().children("input").attr("name");
				var value = $(this).parent().parent().children("td").first().children("input").val();
	//			alert(value);
				
				countD++;
				countS--;
				$("#countSource").val(countS);
				$("#deleteCount").val(countD);
				$("#deleteCount").after("<input type='hidden' name='delete' value='" + name + "," + value + "'>");
				$(this).parent().parent().remove();
			}
			
		});
	});
</script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>资源分析</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Source">
				<input type="hidden" name="wordId" value="${wordId }">
				
				<!-- 资源选择 -->
				
				<%
					countRow = 0;
					countCol = 0;
				%>
				
				<div>
					<table class="table" style="margin:auto;text-align:center;" id="resourcetable">
						<tr>
							<th colspan="8" style="text-align:center;" class="success">
								资源选择
							</th>
						</tr>		
						<tr>									
						<c:forEach begin="1" end="7" varStatus="i">
							<td style="vertical-align:middle;">
								<%=rowText3[countRow++] %>
							</td>						
						</c:forEach>
							<td class="col-sm-1">
								<button type="button" class="btn btn-default" id="addresource">添加资源</button>
							</td>
						</tr>
				     	<% 
				     	for(int i=1;i<=countSource;i++) { 
				     		countCol = 0;
				     	%>
						<tr>
							<td class="col-sm-1">
								<input type="text" class="form-control" name="name<%=i %>" id="name<%=i %>" value="<%=(request.getAttribute("name" + i) != null) ? request.getAttribute("name" + i) : "" %>">
							</td>
							<c:forEach begin="1" end="6" varStatus="i">
								<c:choose>
								<c:when test="${i.index == 1 }">
									<td class="col-sm-1">
									<select name="${title[i.index-1] }<%=i %>" id="${title[i.index-1] }<%=i %>" class="form-control">
										<option selected value="1"><%=rowText[++countCol] %></option>
										<option value="2"><%=rowText[++countCol] %></option>
										<option value="3"><%=rowText[++countCol] %></option>
										<option value="4"><%=rowText[++countCol] %></option>
										<option value="5"><%=rowText[++countCol] %></option>
										<option value="6"><%=rowText[++countCol] %></option>
									</select>
								</td>
								<% countCol = 0; %>
								</c:when>
								<c:when test="${i.index == 2 }">
								<td class="col-sm-1">
									<select name="${title[i.index-1] }<%=i %>" id="${title[i.index-1] }<%=i %>" class="form-control">
										<option selected value="1"><%=colText[countCol++] %></option>
										<option value="2"><%=colText[countCol++] %></option>
										<option value="3"><%=colText[countCol++] %></option>
									</select>
								</td>
								<% countCol = 0; %>
								</c:when>
								<c:when test="${i.index > 2 }">
									<td class="col-sm-1">
									<select name="${title[i.index-1] }<%=i %>" id="${title[i.index-1] }<%=i %>" class="form-control">
										<option selected value="1"><%=colText22[countCol++] %></option>
										<option value="2"><%=colText22[countCol++] %></option>
										<option value="3"><%=colText22[countCol++] %></option>
									</select>
								</td>
								</c:when>
								</c:choose>
								
							</c:forEach>
							<td>
								<button type="button" class="btn btn-danger" id="deleteresource">删除</button>
							</td>							
						</tr>
						<% 
						}
				     	%>
						<tr id="finaltr">
						</tr>
										
					</table>
				</div>
				<input type="hidden" name="countSource" id="countSource" value="<%= countSource %>">
				<input type="hidden" name="deleteCount" id="deleteCount" value="">
				
				<div class="form-group" style="margin-top:20px;">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-success">资源分析</button>						
					</div>
				</div>
				<!-- 资源分析表 -->
				<%
					countRow = 0;
					countCol = 0;
				%>
				<div style="margin-top:20px;">
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<th colspan="7" style="text-align:center;" class="success">
								资源分析
							</th>
						</tr>
						<% 
						int col = 0;
						int row = 0;
						%>
						<c:forEach begin="1" end="4" varStatus="i">
						<% row++;
							col = 0;
						%>
							<tr>
								<c:forEach begin="1" end="7" varStatus="j">
								<% col++; %>
										<c:choose>
											<c:when test="${i.index == 1}">
												<td style="vertical-align:middle;">													
													<c:out value="<%=rowText[countRow++] %>"></c:out>									
												</td>									
											</c:when>
											<c:when test="${i.index != 1 && j.index == 1}">
												<td style="vertical-align:middle;">													
													<c:out value="<%=colText[countCol++] %>"></c:out>									
												</td>									
											</c:when>											
											<c:otherwise>
												<td>
													<textarea rows="3" class="form-control"><%
														for(int i=0;i<countSource2;i++) {
															int typeId = Integer.parseInt((String)request.getAttribute("type" + (i+1)));
															int systemId = Integer.parseInt((String)request.getAttribute("system" + (i+1)));
														//	out.print(typeId + ";" + col);
															if(typeId == (col-1) && systemId == (row-1)) {
																out.print(request.getAttribute("name" + (i+1)));
																out.print(";");
															//	System.out.println("aaa");
															}
														}
													%></textarea>
												</td>
											</c:otherwise>
										</c:choose>									
								</c:forEach>
							<tr>
						</c:forEach>						
					</table>
				</div>
				
				<!-- 资源比较 -->
				
				<%
					countRow = 0;
					countCol = 0;
				%>
				
				<div style="margin-top:40px;">
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<th colspan="7" style="text-align:center;" class="success">
								资源比较
							</th>
						</tr>
						<tr>
							<td colspan="2" class="col-sm-2">资源属性</td>
							<td colspan="1" class="col-sm-10">资源</td>
						</tr>	
						<%
							row = 0;
						col = 0;
						%>					
						<c:forEach begin="1" end="12" varStatus="i">
						
							<tr>
							<c:choose>
								<c:when test="${(i.index+2)%3 == 0 }">
									<td rowspan="3" style="vertical-align:middle;"><%=colText21[countCol ++] %></td>
									<td style="vertical-align:middle;"><%=colText22[countRow++] %></td>
									<td><textarea rows="2" class="form-control"><%
														for(int i=0;i<countSource2;i++) {
															if(row/3 == 0) {
																int id = Integer.parseInt((String)request.getAttribute("value" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 1) {
																int id = Integer.parseInt((String)request.getAttribute("quantity" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 2) {
																int id = Integer.parseInt((String)request.getAttribute("quality" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 3) {
																int id = Integer.parseInt((String)request.getAttribute("usable" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															}
															
														}
													%></textarea></td>
								</c:when>
								<c:otherwise>
									<td style="vertical-align:middle;"><%=colText22[countRow++] %></td>
									<td><textarea rows="2" class="form-control"><%
														for(int i=0;i<countSource2;i++) {
															if(row/3 == 0) {
																int id = Integer.parseInt((String)request.getAttribute("value" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 1) {
																int id = Integer.parseInt((String)request.getAttribute("quantity" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 2) {
																int id = Integer.parseInt((String)request.getAttribute("quality" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															} else if(row/3 == 3) {
																int id = Integer.parseInt((String)request.getAttribute("usable" + (i+1)));
																if(id == (row%3+1)) {
																	out.print(request.getAttribute("name" + (i+1)));
																	out.print(";");
																}
															}
														}
													%></textarea></td>
								</c:otherwise>
							</c:choose>
							</tr>
							<% row++; %>
						</c:forEach>
						
										
					</table>
				</div>
				
				
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution1" class="col-sm-2 control-label">思路4：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="solution4" name="solution4">${solution4 }</textarea>
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