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
<title>最终理想解</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>最终理想解</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Final">
				<input type="hidden" name="wordId" value="${wordId }">
				<div class="form-group" id="solutiondiv">
					<label for="aim" class="col-sm-2 control-label">设计的最终目标：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="aim" name="aim" value="${idealres.aim }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="result" class="col-sm-2 control-label">理想化的最终结果：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="result" name="result" value="${idealres.result }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="obstacle" class="col-sm-2 control-label">达到理想解的障碍：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="obstacle" name="obstacle" value="${idealres.obstacle }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="obsresult" class="col-sm-2 control-label">出现这种障碍的结果：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="obsresult" name="obsresult" value="${idealres.obsRes }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="condition" class="col-sm-2 control-label">不出现这种障碍的条件：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="condition" name="condition" value="${idealres.cond }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="resource" class="col-sm-2 control-label">创造条件所用资源：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="resource" name="resource" value="${idealres.resource }">
					</div>
				</div>
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution6" class="col-sm-2 control-label">思路6：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="solution6" name="solution6">${solution6 }</textarea>
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