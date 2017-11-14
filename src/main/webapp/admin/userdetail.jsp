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
<title>详细信息</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>详细信息</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="">
				<div class="form-group">
	    <label class="col-sm-2 control-label">用户ID：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.id }</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">用户名：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.name == null ? "未填写" : user.name }</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">用户邮箱：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.email == null ? "未填写" : user.email}</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">用户性别：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.sex == null ? "未填写" : user.sex == true ? "男" : "女"}</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">所在行业：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.industry == null ? "未填写" : user.industry}</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">自我介绍：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.introduction == null ? "未填写" : user.introduction }</p>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">是否激活：</label>
	    <div class="col-sm-10">
	      <p class="form-control-static">${user.identity == true ? "已激活" : "未激活" }</p>
	    </div>
	  </div>
			</form>
		</div>
	</div>

</body>
</html>