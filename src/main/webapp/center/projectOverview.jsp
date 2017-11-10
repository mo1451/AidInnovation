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
	  $("#source").focus();
	});
}

</script>
</head>
<body onLoad="load()">
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>项目概述</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="projectOverview">  
      <div class="form-group">
        <div class="label">
          <label>项目来源：</label>
        </div>
        <div class="field">
          <textarea class="input" name="source" style=" height:90px;" id="source"><c:if test="${source != null }">${source }</c:if></textarea>
        </div>
      </div>
      <input type="hidden" name="wordId" value="${wordId }"> 
      <div class="form-group">
        <div class="label">
          <label>问题描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="descr" style=" height:90px;" id="descr"><c:if test="${descr != null }">${descr }</c:if></textarea>
          <div class="tips"></div>
        </div>
      </div>
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