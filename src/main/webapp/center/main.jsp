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
<title>辅助创新</title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery-3.1.1.min.js"></script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>辅助创新</h1>
		</div>
		<div class="head-l text-white" style="padding-top:10px;margin-left:30px;">
			欢迎您！<a href="usercenter.jsp" class="text-black">${username } </a>。
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="userCenter?userId=${userId }&username=${username }&wordId=${wordId }"><span class="icon-home"></span> 用户中心</a>
			<a class="button button-little bg-red" href="../userOut"><span class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav" style="height:580px;overflow-y:auto;">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>步骤流程</strong>
		</div>
		<h2 id="wordName">
			<span class="icon-pencil-square-o"></span><a href="changeWordName?wordId=${wordId }"
				target="right">文档命名</a>
		</h2>
		<li></li>
		<h2>
			<span class="icon-pencil-square-o"></span>问题描述
		</h2>
		<ul>
			<li><a href="projectOverview?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>项目概述</a></li>
			<li><a href="initialSolution?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>发明问题初始形式</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>系统分析
		</h2>
		<ul>
			<li><a href="Causal?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>因果分析</a></li>
			<li><a href="nineScreen?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>九屏分析</a></li>
			<li><a href="Life?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>生命曲线</a></li>
			<li><a href="Source?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>资源分析</a></li>
			<li><a href="Function?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>功能分析</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>运用Triz解决问题
		</h2>
		<ul>
			<li><a href="Final?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>最终理想解</a></li>
			<li><a href="StcOperator?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>STC算子</a></li>
			<li><a href="Technology?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>技术矛盾分析</a></li>
			<li><a href="Physical?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>物理矛盾分析</a></li>
			<li><a href="ObjectField?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>物-场分析</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>技术方案整理与评价
		</h2>
		<ul>
			<li><a href="Summer?wordId=${wordId }" target="right"><span
					class="icon-caret-right"></span>方案总结与确定</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>知识库
		</h2>
		<ul>
			<li><a href="invention.jsp" target="right"><span
					class="icon-caret-right"></span>发明原理</a></li>
			<li><a href="contradiction.jsp" target="right"><span
					class="icon-caret-right"></span>矛盾矩阵</a></li>
			<li><a href="standard.jsp" target="right"><span
					class="icon-caret-right"></span>标准解</a></li>
			<li><a href="purify.jsp" target="right"><span
					class="icon-caret-right"></span>进化法则</a></li>
			<li><a href="science.jsp" target="right"><span
					class="icon-caret-right"></span>科学效应</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
			$("#wordName").click(function() {
				$("#a_leader_txt").text($(this).text());
			})
			$(window).resize(function(){
				$(".leftnav").css("height",$(document).height()-80);
			});
		});
	</script>
	<ul class="bread">
		<li><a href="##" id="a_leader_txt" class="icon-home">文档命名</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="changeWordName?wordId=${wordId }" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align:center;"></div>
</body>
</html>