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
	  $("#userId").focus();
	});
}

</script>
</head>
<body onLoad="load()">
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>搜索用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="userSearch">  
      <div class="form-group">
        <div class="label">
          <label>用户ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userId" id="userId" placeholder="选填" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userName" id="userName" placeholder="选填" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userEmail" id="userEmail" placeholder="选填" />
        </div>
      </div>
      <input type="hidden" name="search" value="search">
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" name="action"> 搜索</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>