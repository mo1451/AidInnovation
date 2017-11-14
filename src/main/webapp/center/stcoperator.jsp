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
<title>STC算子</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>STC算子</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="StcOperator">
				<input type="hidden" name="wordId" value="${wordId }">
				<div class="form-group" id="solutiondiv">
					<label for="aim" class="col-sm-2 control-label">研究对象的尺寸无穷大时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="big" name="big" value="${stc.big }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="result" class="col-sm-2 control-label">研究对象的尺寸无穷小时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="small" name="small" value="${stc.small }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="obstacle" class="col-sm-2 control-label">研究对象的时间无穷大时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="longTime" name="longTime" value="${stc.longTime }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="obsresult" class="col-sm-2 control-label">研究对象的时间无穷小时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="shortTime" name="shortTime" value="${stc.shortTime }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="condition" class="col-sm-2 control-label">研究对象的成本无穷大时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="expensive" name="expensive" value="${stc.expensive }">
					</div>
				</div>
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="resource" class="col-sm-2 control-label">研究对象的成本无穷小时的解决思路：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="chip" name="chip" value="${stc.chip }">
					</div>
				</div>
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution6" class="col-sm-2 control-label">思路7：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="6" id="stcSolution" name="stcSolution">${stcSolution }</textarea>
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