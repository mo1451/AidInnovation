<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="icon/favicon.ico">
<title>用户注册</title>

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
							url : 'emailJson',
							message : '邮箱已存在',
							delay : 2000,
							type : 'POST'
						},
						emailAddress : {
							message : '邮箱地址格式有误'
						}
					}
				},
				username : {
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						},
						stringLength : {
							min : 2,
							max : 18,
							message : '用户名长度必须在2到18位之间'
						},
						remote : {
							url : 'userJson',
							message : '用户已存在',
							delay : 2000,
							type : 'POST'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_]+$/,
							message : '用户名只能包含大写、小写、数字和下划线'
						}
					}
				},
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
				},
				verifycode : {
					validators : {
						notEmpty : {
							message : '请填写验证码'
						} /*,
                        remote: {
                            url: 'codeJson',
                            message: '验证码错误',
                            delay :  2000,
                            type: 'POST'
                        }*/
					}
				},
				agree : {
					validators : {
						notEmpty : {
							message : '请接受声明'
						}
					}
				},
			}
		});

		$("img").click(function() {
			// 	alert("1");
			//	var img = $("#codeImg");
			//	alert($("#codeImg").attr("src"));
			//	alert("VerifyCode?date=" + new Date());
			$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
		//	img.src = "VerifyCode?date=" + new Date();
		});

	/*
	$("#verifycode").change(function () {
     //   	alert($(this).val());
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/codeJson',
			data:'value=' + $(this).val(),
			success:function(data) {
				alert(data.valid);
			}
		});
	});
	*/
	});
	function changeImg() {
		var img = $("#codeImg");
		$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
	}
	function codevalid() {
		//	alert();
		var flag = false;
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/codeJson',
			data : 'verifycode=' + $("#verifycode").val(),
			async : false, //同步方式
			success : function(data) {
				//	alert(data.valid);
				if (data.valid == false) {
					$("#codeImg").attr("src", "VerifyCode?date=" + new Date());
					//		alert("false");
					flag = false;
				} else {
					//		alert("true");
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
		<form class="form-signin form-horizontal" role="form" action="addUser"
			onsubmit="return codevalid();">
			<h2 class="form-signin-heading">欢迎注册</h2>
			<div class="form-group">
				<input type="email" class="form-control" name="email"
					placeholder="邮箱" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="username"
					placeholder="用户名" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="密码" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password2"
					placeholder="确认密码" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="verifycode"
					id="verifycode" placeholder="验证码" /> <br>
				<div style="text-align:center;">
					<img alt="换一张" src="VerifyCode" id="codeImg"> <a href='#'
						onclick="javascript:changeImg()">看不清？</a>
				</div>
			</div>


			<div class="form-group">
				<input name="agree" id="agree" type="checkbox" value=""> <span>已阅读并同意<a
					href="agreement.jsp" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit"
				id="submit">注册</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>
