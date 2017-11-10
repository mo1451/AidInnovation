<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.mo1451.model.User" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>用户信息</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>用户信息</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="changeInfo">
				<div class="form-group" id="sexdiv" style="margin-top:40px;">
					<label for="sex" class="col-sm-2 control-label">性别：</label>
					<div class="radio col-sm-2">
						<label> <input type="radio" name="sex" id="male"
							value="male" 
							<c:if test="${user.sex == true || user.sex == null }">checked </c:if>
							>男
						</label> <label> <input type="radio" name="sex" id="female"
							value="female"
							<c:if test="${user.sex == false }"> checked </c:if>
							>女
						</label>
					</div>
				</div>
				<input type="hidden" name="userId" value="${user.id }">
				<div class="form-group" id="industrydiv" style="margin-top:40px;">
					<label for="industry" class="col-sm-2 control-label">所在行业：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="industry"
							name="industry" value="${user.industry }">
					</div>
				</div>
				<div class="form-group" id="introductiondiv"
					style="margin-top:40px;">
					<label for="introduction" class="col-sm-2 control-label">自我介绍：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="introduction"
							name="introduction" >${user.introduction }</textarea>
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