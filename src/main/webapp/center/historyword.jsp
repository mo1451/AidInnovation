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
<title>历史文档</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jtopo-0.4.8-min.js"></script> 
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>历史文档</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="">
				<div>
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<th style="text-align:center;" class="success col-sm-2">ID</th>
							<th style="text-align:center;" class="success col-sm-6">文档名称</th>
							<th colspan="3" style="text-align:center;" class="success col-sm-2">文档操作</th>
						</tr>
						
						<tr>
							<td>1</td>
							<td>测试用</td>
							<td><button type="button" class="btn btn-primary">预览文档</button></td>
							<td><button type="button" class="btn btn-primary">修改文档</button></td>
							<td><button type="button" class="btn btn-primary">删除文档</button></td>
						</tr>					
					</table>
				</div>
			</form>
		</div>
	</div>

</body>
</html>