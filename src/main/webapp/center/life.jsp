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
<title>生命曲线</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>生命曲线</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Life">
				<div class="formtable" style="text-align:center;">
					<img src="../images/life.jpg" style="width:400px;height:300px;">
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution1" class="col-sm-2 control-label">思路3：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="solution3" name="solution3">${solution3 }</textarea>
					</div>
				</div>
				<input type="hidden" name="wordId" value="${wordId }">
				
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