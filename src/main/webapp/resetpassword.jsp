<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>重设密码</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

<script src="js/jquery-3.1.1.min.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/bootstrapValidator.min.js"></script>
<link href="css/bootstrapValidator.min.css" rel="stylesheet" />
<script>
	$(function() {
		$('form').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						}
					}
				},
				password2 : {
					validators : {
						notEmpty : {
							message : '请确认密码'
						},
						identical : {
							field : 'password',
							message : '两次密码不一致'
						}
					}
				}
			}
		});
	});
</script>
</head>
<body>
	<c:if test="${msg == 'abc' }">
		<div class="container">
			<form class="form-signin form-horizontal" role="form"
				action="changePassword">
				<input type="hidden" name="email" value="${email}">
				<div class="form-group">
					<input type="password" class="form-control" name="password"
						placeholder="密码" />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password2"
						placeholder="确认密码" />
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">修改密码</button>
			</form>
		</div>
	</c:if>
	<c:if test="${msg != 'abc' }">
		<div class="text-center">
			<div>
				<br> <br> <br> <br>
				<h2>${msg }</h2>
			</div>
		</div>
	</c:if>

</body>
</html>