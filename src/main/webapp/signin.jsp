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

<title>用户登录</title>

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
				username : {
					message : '用户名验证失败',
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						}
					}
				},
				verifycode : {
					validators : {
						notEmpty : {
							message : '请填写验证码'
						}
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
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

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">

		<form class="form-signin" role="form" action="checkPassword" onsubmit="return codevalid();">
			<h2 class="form-signin-heading">请登录</h2>
			<div class="form-group">
				<!-- <label>用户名</label> -->
				<input type="text" class="form-control" name="username"
					placeholder="用户名或邮箱" />
				<small class="help-block">${msg }</small>
			</div>
			<div class="form-group">
				<!-- <label>密码</label> -->
				<input type="password" class="form-control" name="password"
					placeholder="密码" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="verifycode"
					id="verifycode" placeholder="验证码" /> <br>
				<div style="text-align:center;">
					<img alt="换一张" src="VerifyCode" id="codeImg"> 
					<a href='#' onclick="javascript:changeImg()">看不清？</a> 
					<a href="forgetPassword" class="text-right" id="forgetpassword">忘记密码？</a>
				</div>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
