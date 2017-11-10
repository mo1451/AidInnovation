<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
<title>用户中心</title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#createNewWord").click(function() {
		//	alert("createWord?userId=${userId}&username=${username }");
			window.parent.frames.location.href="createWord?userId=${userId}&username=${username }";
		});
	});
</script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>用户中心</h1>
		</div>
		<div class="head-l text-white" style="padding-top:10px;margin-left:30px;">
			欢迎您！
			<c:if test="${username != null }">${username }</c:if>
			</a>。
		</div>
		<div class="head-l">
			<c:if test="${wordId != null }">
				<a class="button button-little bg-green" href="Main?userId=${userId }&username=${username }&wordId=${wordId }"><span class="icon-home"></span> 辅助创新</a>
			</c:if>
			<a class="button button-little bg-red" href="../userOut"><span class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav" style="height:595px;overflow-y:auto;">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>用户管理</strong>
		</div>
		<h2 class="basicInfo">
			<span class="icon-pencil-square-o"></span><a href="userInfo?userId=${userId}" target="right">用户信息</a>
		</h2>
		<h2 class="basicInfo">
			<span class="icon-pencil-square-o"></span><a href="changePassword" target="right">修改密码</a>
		</h2>
		<h2 class="basicInfo">
			<span class="icon-pencil-square-o"></span><a href="javascript:void(0);" target="_top" id="createNewWord">新建文档</a>
		</h2>
		<h2 class="basicInfo">
			<span class="icon-pencil-square-o"></span><a href="historyWord?userId=${userId}&username=${username }" target="right">历史文档</a>
		</h2>		

</div>
	
	<script type="text/javascript">
		$(function() {
			$(".basicInfo").click(function() {
				$("#a_leader_txt").text($(this).text());
			})
		});
	</script>
	<ul class="bread">
		<li><a href="##" id="a_leader_txt" class="icon-home">历史文档</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="historyWord?userId=${userId}&username=${username }" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align:center;"></div>
</body>
</html>