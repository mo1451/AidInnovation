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
<title>物理矛盾分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>物理矛盾分析</strong>
		</div>
		
		
				
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Physical">
				<input type="hidden" name="wordId" value="${wordId }">
				<div class="form-group">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp确定物理矛盾：</label>					
				</div>
				
				<div class="form-group">
					<div class="col-sm-1"></div>
					<label class="control-label">
					（
					<input type="text" style="width:130px;height:40px;" id="word11" name="word11" value="${phy.txt1 }">
					 ）应该（
					 <input type="text" style="width:180px;height:40px;" id="word12" name="word12" value="${phy.txt2 }">
					 ），以满足（
					 <input type="text" style="width:250px;height:40px;" id="word13" name="word13" value="${phy.txt3 }">
					 ）要求。</label>					
				</div>
				
				<div class="form-group">
					<div class="col-sm-1"></div>
					<label class="control-label">
					（
					<input type="text" style="width:130px;height:40px;" id="word21" name="word21" value="${phy.txt4 }">
					 ）应该（
					 <input type="text" style="width:180px;height:40px;" id="word22" name="word22" value="${phy.txt5 }">
					 ），以满足（
					 <input type="text" style="width:250px;height:40px;" id="word23" name="word23" value="${phy.txt6 }">
					 ）要求。</label>					
				</div>
				
				<div class="form-group" style="margin-top:40px;">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp拟采用分离原理：</label>					
				</div>
				
				<div class="form-group">
					<label for="space" class="col-sm-2 control-label">空间分离：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="space" name="space" value="${phy.space }">
					</div>
				</div>
				
				<div class="form-group">
					<label for="time" class="col-sm-2 control-label">时间分离：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="time" name="time" value="${phy.tim }">
					</div>
				</div>
				
				<div class="form-group">
					<label for="condition" class="col-sm-2 control-label">条件分离：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="cond" name="cond" value="${phy.cond }">
					</div>
				</div>
				
				<div class="form-group">
					<label for="whole" class="col-sm-2 control-label">整体与部分分离：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="whole" name="whole" value="${phy.whole }">
					</div>
				</div>
		
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution8" class="col-sm-2 control-label">思路8：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="6" id="solution8" name="solution8">${solution8 }</textarea>
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