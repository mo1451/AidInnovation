<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../icon/favicon.ico">

    <title>管理员登录</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
	
	<script src="../js/jquery-3.1.1.min.js"></script>
	
	<script src="../js/bootstrap.min.js"></script>
	
	<script src="../js/bootstrapValidator.min.js"></script>
    <link href="../css/bootstrapValidator.min.css" rel="stylesheet" />
	
	<script>
		$(function () {
        $('form').bootstrapValidator({
　　　　　　　　message: 'This value is not valid',
            　feedbackIcons: {
                　　　　　　　　valid: 'glyphicon glyphicon-ok',
                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
            　　　　　　　　   },
            fields: {
                username: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                }
            }
        });
    });
	</script>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form" action="index.jsp">
        <h2 class="form-signin-heading">请登录</h2>
        <div class="form-group">
                <!-- <label>用户名</label> -->
                <input type="text" class="form-control" name="username" placeholder="用户名"/>
            </div>
            <div class="form-group">
                <!-- <label>密码</label> -->
                <input type="password" class="form-control" name="password"placeholder="密码"/>
            </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
			&nbsp&nbsp&nbsp
			<a href="forgetpassword.jsp" class="text-right" id="forgetpassword" >忘记用户名或密码？</a>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div>
  </body>
</html>
