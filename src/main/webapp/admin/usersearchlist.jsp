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
<title>用户列表</title>
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
			page = ((page + 1) < maxPage) ? (page + 1) : maxPage;
		} else if(para == "last") {
			page = maxPage;
		}
		$("#page").val(page);
		$("#form").submit();
	}
</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>用户列表</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="userSearchList" id="form">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="userName" value="${userName }">
				<input type="hidden" name="userEmail" value="${userEmail }">
				<input type="hidden" name="page" id="page" value="${page.page }">
				<div>
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<th style="text-align:center;" class="success col-sm-2">ID</th>
							<th style="text-align:center;" class="success col-sm-2">用户名</th>
							<th style="text-align:center;" class="success col-sm-4">邮箱</th>
							<th colspan="3" style="text-align:center;" class="success col-sm-2">用户操作</th>
						</tr>
						<c:forEach items="${users }" var="user" varStatus="i">
							<tr>
							<td>${(page.page-1)*10 + i.index+1 }</td>
							<td>${user.name }</td>
							<td>${user.email }</td>
							<td><a href="userDetail?userId=${user.id}"><button type="button" class="btn btn-primary">详细信息</button></a></td>
							<td><a href="wordSearchList?userId=${user.id}"><button type="button" class="btn btn-success">查看文档</button></a></td>
							<td><a href="deleteUser?userId=${user.id }&page=${page.page }"><button type="button" class="btn btn-danger">删除用户</button></a></td>
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