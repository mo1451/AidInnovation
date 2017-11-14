<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery-3.1.1.min.js"></script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>后台管理中心</h1>
		</div>
		<div class="head-l text-white" style="padding-top:10px;margin-left:30px;">
			欢迎您！管理员。
		</div>
	</div>
	<div class="leftnav" style="height:595px;overflow-y:auto;">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-pencil-square-o"></span>用户列表
		</h2>
		<ul>
			<li><a href="UserList" target="right"><span
					class="icon-caret-right"></span>用户列表</a></li>
					<li><a href="userSearch" target="right"><span
					class="icon-caret-right"></span>搜索用户</a></li>
					<li><a href="wordList" target="right"><span
					class="icon-caret-right"></span>文章列表</a></li>
					<li><a href="wordSearch" target="right"><span
					class="icon-caret-right"></span>搜索文章</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").next().slideToggle(200);
			$(".leftnav h2").toggleClass("on");
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
			$("#basicInfo").click(function() {
				$("#a_leader_txt").text($(this).text());
			})
		});
	</script>
	<ul class="bread">
		<li><a href="##" id="a_leader_txt" class="icon-home">用户列表</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="UserList" name="right" width="100%" height="100%"></iframe>
	</div>
	<div style="text-align:center;"></div>
</body>
</html>