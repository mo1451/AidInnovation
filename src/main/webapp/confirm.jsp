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
<title>确定最终方案</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jtopo-0.4.8-min.js"></script> 
<script src="js/bootstrapValidator.min.js"></script>
<link href="css/bootstrapValidator.min.css" rel="stylesheet" />
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>确定最终方案</strong>
		</div>
		
		
				
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="" id="objectField">
				
				
				
				<!-- 思路 -->
				
				<div class="form-group" id="finaldiv">
					<label for="finalsolution" class="col-sm-2 control-label">最终方案：</label>
					<div class="col-sm-9">
						<textarea class="form-control" rows="16" id="finalsolution" name="finalsolution"></textarea>
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