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
<title>修改密码</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrapValidator.min.js"></script>
<link href="../css/bootstrapValidator.min.css" rel="stylesheet" />

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
				oldpassword : {
					message : '用户名验证失败',
					validators : {
						notEmpty : {
							message : '密码不能为空'
						}
					}
				},
				nowpassword : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						}
					}
				},
				nowpassword2 : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						identical : {
							field : 'nowpassword',
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
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>修改密码</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="changePassword">
				<div class="form-group" id="oldpassworddiv"  style="margin-top:40px;">
					<label for="oldpassword" class="col-sm-2 control-label">原密码：</label>
					<div class="col-sm-8">
					  <input type="password" class="form-control" id="oldpassword" name="oldpassword">
					</div>
					<small style="color:red;">${msg }</small>
				</div>
				<input type="hidden" name="name" value="${user.name }">
				<div class="form-group" id="nowpassworddiv"  style="margin-top:40px;">
					<label for="nowpassword" class="col-sm-2 control-label">修改密码：</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="nowpassword" name="nowpassword">
					</div>
				</div>
				<div class="form-group" id="nowpassword2div"  style="margin-top:40px;">
					<label for="nowpassword2" class="col-sm-2 control-label">确认密码：</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="nowpassword2" name="nowpassword2">
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