<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>文档列表</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script> 
<script type="text/javascript">
	
	var maxPage = ${page.maxPage};
	function jump(para) {
		var page = parseInt($("#page").val());
		if(para == "first") {
			page = 1;			
		} else if(para == "pre") {
			page = ((page - 1) > 0) ? (page -1) : 1;
		} else if(para == "next") {
			page = ((page + 1) < 4) ? (page + 1) : 4;
		} else if(para == "last") {
			page = maxPage;
		}
		$("#page").val(page);
		$("#form").submit();
	}
	$(document).ready(function() {
		$(".deleteWord").click(function() {
			var id = $(this).attr("id");
			if(confirm("您确定要删除吗？")) {
				$.ajax({  
		            type : 'post',  
		            url : '${pageContext.request.contextPath}/center/deleteWordJson',  
		            data: 'wordId=' + id,  
		            async : false, //同步方式  
		            success : function(str) {  
		                alert(str[0]);
		                window.top.location.href="${pageContext.request.contextPath}/center/userCenter";
		            }  
		        });  
			}
			
		});
		
		$(".createWord").click(function() {
			var id = $(this).attr("id");		
			if(confirm("您确定要生成word吗？")) {
		        window.top.location.href="${pageContext.request.contextPath}/center/saveWord?wordId=" + id;
			}
			
		});
	});
</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>文档列表</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="wordSearchList" id="form">
				<input type="hidden" name="wordId" value="${wordId }">
				<input type="hidden" name="wordName" value="${wordName }">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="page" id="page" value="${page.page }">
				<div>
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<th style="text-align:center;" class="success col-sm-2">ID</th>
							<th style="text-align:center;" class="success col-sm-2">文档名称</th>
							<th colspan="3" style="text-align:center;" class="success col-sm-2">文档操作</th>
						</tr>
						<c:forEach items="${wordSearchResults }" var="word" varStatus="i">
							<tr>
							<td>${(page.page-1)*10 + i.index+1 }</td>
							<td>${word.name }</td>
							<td><a href="userSearchList?userId=${word.userid }" ><button type="button" class="btn btn-primary">查看作者</button></a></td>
							<td><a href="javascrpit:void(0);" class="createWord" id="${word.id }"><button type="button" class="btn btn-success" >生成word</button></a></td>
							<td><button type="button" class="btn btn-danger deleteWord" id="${word.id }">删除文档</button></td>
						</tr>	
						</c:forEach>
										
					</table>
				</div>
				<div>
					<ul class="pagination">
						<li><a href="#" onclick="jump('first')">首页</a></li>
						<li><a href="#" onclick="jump('pre')">上一页</a></li>
						<li class="disabled"><a href="#"  onclick="return false">${page.page }</a></li>
						<li><a href="#" onclick="jump('next')">下一页</a></li>
						<li><a href="#" onclick="jump('last')">尾页</a></li>		
						<li class="disabled"><a href="#"  onclick="return false">共${page.maxPage }页</a></li>				
					</ul>					
				</div>
				
			</form>
		</div>
	</div>

</body>
</html>