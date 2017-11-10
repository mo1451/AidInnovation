<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="icon/favicon.ico">

<title>忘记密码</title>

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
				email : {
					validators : {
						notEmpty : {
							message : '邮箱不能为空'
						},
						remote : {
							url : 'emailNotJson',
							message : '邮箱不存在',
							delay : 2000,
							type : 'POST'
						},
						emailAddress : {
							message : '邮箱地址格式有误'
						}
					}
				}
			}
		});
		$("img").click(function() {
			$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
		});
	});
	function changeImg() {
		var img = $("#codeImg");
		$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
	}
	function codevalid() {
		var flag = false;
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/codeJson',
			data : 'verifycode=' + $("#verifycode").val(),
			async : false, //同步方式
			success : function(data) {
				if (data.valid == false) {
					$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
					flag = false;
				} else {
					flag = true;
				}
			}
		});
		if (!flag) {
			alert("验证码错误");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body>
	<div class="container">
		<form class="form-signin" role="form" action="forgetPassword">
			<h2 class="form-signin-heading">${ msg }</h2>
			<div class="form-group">
				<!-- <label>用户名</label> -->
				<input type="email" class="form-control" name="email"
					placeholder="邮箱" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="verifycode"
					id="verifycode" placeholder="验证码" /> <br>
				<div style="text-align:center;">
					<img alt="换一张" src="VerifyCode" id="codeImg"> <a href='#'
						onclick="javascript:changeImg()">看不清？</a>
				</div>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">下一步</button>
		</form>

	</div>
</body>
</html>
