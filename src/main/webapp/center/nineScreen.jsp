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
<title>九屏分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/nineScreen.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>九屏分析</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="nineScreen" id="causal">
				<div class="formtable">
					<table class="ninetable">
						<c:forEach begin="1" end="5" varStatus="i">
							<tr>
								<c:forEach begin="1" end="5" varStatus="j">
										<c:choose>
											<c:when test="${i.index%2 != 0 && j.index %2 != 0}">
												<td>													
													<c:choose>
														<c:when test="${i.index == 1 && j.index == 1}">
															<textarea rows="3" class="form-control" name="screen1" placeholder="过去系统的超系统">${screen1 }</textarea>	
														</c:when>
														<c:when test="${i.index == 1 && j.index == 3}">
															<textarea rows="3" class="form-control" name="screen2" placeholder="当前系统的超系统">${screen2 }</textarea>	
														</c:when>
														<c:when test="${i.index == 1 && j.index == 5}">
															<textarea rows="3" class="form-control" name="screen3" placeholder="未来系统的超系统">${screen3 }</textarea>	
														</c:when>
														<c:when test="${i.index == 3 && j.index == 1}">
															<textarea rows="3" class="form-control" name="screen4" placeholder="过去系统">${screen4 }</textarea>	
														</c:when>
														<c:when test="${i.index == 3 && j.index == 3}">
															<textarea rows="3" class="form-control" name="screen5" placeholder="当前系统">${screen5 }</textarea>	
														</c:when>
														<c:when test="${i.index == 3 && j.index == 5}">
															<textarea rows="3" class="form-control" name="screen6" placeholder="未来系统">${screen6 }</textarea>	
														</c:when>
														<c:when test="${i.index == 5 && j.index == 1}">
															<textarea rows="3" class="form-control" name="screen7" placeholder="过去系统的子系统">${screen7 }</textarea>	
														</c:when>
														<c:when test="${i.index == 5 && j.index == 3}">
															<textarea rows="3" class="form-control" name="screen8" placeholder="当前系统的子系统">${screen8 }</textarea>	
														</c:when>
														<c:when test="${i.index == 5 && j.index == 5}">
															<textarea rows="3" class="form-control" name="screen9" placeholder="未来系统的子系统">${screen9 }</textarea>	
														</c:when>
													</c:choose>														
												</td>									
											</c:when>
											<c:when test="${i.index == 2 && (j.index+1)%2 == 0 }">
												<td style="text-align:center;">
													<img src="../images/up.jpg" style="width:50px;height:75px;">
												</td>
											</c:when>
											<c:when test="${i.index == 4 && (j.index+1)%2 == 0 }">
												<td style="text-align:center;">
													<img src="../images/down.jpg" style="width:50px;height:75px;">
												</td>
											</c:when>
											<c:when test="${i.index == 3 && j.index == 2 }">
												<td style="text-align:center;">
													<img src="../images/left.jpg" style="width:75px;height:50px;">
												</td>
											</c:when>
											<c:when test="${i.index == 3 && j.index == 4 }">
												<td style="text-align:center;">
													<img src="../images/right.jpg" style="width:75px;height:50px;">
												</td>
											</c:when>
											<c:otherwise>
												<td>
												</td>
												<!-- <input type="text"  value="b"> -->
											</c:otherwise>
										</c:choose>									
								</c:forEach>
							<tr>
						</c:forEach>						
					</table>
				</div>
				
				<div class="form-group" id="solutiondiv">
					<label for="solution1" class="col-sm-2 control-label">思路2：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="6" id="solution2" name="solution2">${solution2 }</textarea>
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