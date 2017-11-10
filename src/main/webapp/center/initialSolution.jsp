<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery-3.1.1.min.js"></script> 
<script src="../js/pintuer.js"></script>
<script type="text/javascript">
function load() 
{
	$(document).ready(function(){
	  $("#function").focus();
	});
}

</script>
</head>
<body onLoad="load()">
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>发明问题初始形式</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="initialSolution">  
      <div class="form-group">
        <div class="label">
          <label>当前系统功能：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="function" id="function" <c:if test="${function != null }">value="${function }"</c:if> placeholder="请描述当前系统的功能"/>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>组成：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="component" id="component" <c:if test="${component != null }">value="${component }"</c:if> placeholder="请描述当前系统的组成"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>原理：</label>
        </div>
        <div class="field">
          <textarea class="input" name="principle" style=" height:90px;" id="principle" placeholder="请描述当前系统的原理"><c:if test="${principle != null }">${principle }</c:if></textarea>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>主要问题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="mainpro" id="mainpro" <c:if test="${mainpro != null }">value="${mainpro }"</c:if> placeholder="请描述当前系统存在的主要问题"/>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>技术参数：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="parameter" id="parameter" <c:if test="${parameter != null }">value="${parameter }"</c:if> placeholder="请描述当前系统的技术参数"/>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>解决目标：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="goal" id="goal" <c:if test="${goal != null }">value="${goal }"</c:if> placeholder="请描述要实现的目标"/>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>限制条件：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="restrict" id="restrict" <c:if test="${restrict != null }">value="${restrict }"</c:if> placeholder="请描述实现该目标的限制条件"/>
          <div class="tips"></div>
        </div>
      </div>
	  <div class="form-group">
        <div class="label">
          <label>已有方案：</label>
        </div>
        <div class="field">
          <textarea class="input" name="existsol" style=" height:180px;" id="existsol" placeholder="请详细列出目前解决的方案或类似产品的解决方案或已有专利，并分析存在问题"><c:if test="${existsol != null }">${existsol }</c:if></textarea>
          <div class="tips"></div>
        </div>
      </div>
	  <input type="hidden" name="wordId" value="${wordId }">
	  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" name="action"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>