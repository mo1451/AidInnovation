<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] rowText = {"复杂性","成本","简易程度","智能程度","器材数量","可行性"};
	int countRow = 0;
	String[] color = {"179,181,198,","255,99,132,","255,218,185,","47,79,79,","132,112,255,","0,255,255,","127,255,0,","218,165,32,","186,85,21,"};
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>技术方案总结</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/Chart.min.js"></script> 
<script src="../js/bootstrapValidator.min.js"></script>
<link href="../css/bootstrapValidator.min.css" rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$(".btn").click(function() {
			for(var j=1;j<=8;j++) {
				if($(this).attr("id") == ("create" + j)) {
					var i = 0;
					var color = new Array("179,181,198,","255,99,132,","255,218,185,","47,79,79,","132,112,255,","0,255,255,","127,255,0,","218,165,32,","186,85,21,");
					var radarTxt = new Array();
					$("#radar" + j + " td input").each(function() {
						radarTxt[i++] = $(this).val();
					});
					
					var ctx = $("#canvas" + j); 
					
		            var data = {
						labels: ["复杂性", "成本", "简易程度", "智能程度", "器材数量", "可行性"],
						datasets: [
							{
								label: "思路" + j,
								backgroundColor: "rgba(" + color[j-1] + "0.2)",
								borderColor: "rgba(" + color[j-1] + "1)",
								pointBackgroundColor: "rgba(" + color[j-1] + "1)",
								pointBorderColor: "#fff",
								pointHoverBackgroundColor: "#fff",
								pointHoverBorderColor: "rgba(" + color[j-1] + "1)",
								data: [radarTxt[0], radarTxt[1], radarTxt[2], radarTxt[3], radarTxt[4], radarTxt[5]]
							}
						]
					};
					var myRadarChart = new Chart(ctx, {
						type: 'radar',
						data: data,
						options: {
							scale: {
				                ticks: {
				                    beginAtZero: true
				                }
				            }
		    			}
					});
					$("#showflowchart" + j).css("display","block");
				}
			}
			<% countRow = 0; %>
			if($(this).attr("id") == ("create")) {
				var radar = new Array();
				for(var i=1;i<=8;i++) {
					radar[i-1] = new Array();
					var j = 0;
					$("#radar" + i + " td input").each(function() {
						radar[i-1][j++] = $(this).val();
						
					});
			//		alert(radar[])
				}
				var ctx = $("#canvas"); 
	            var data = {
					labels: ["复杂性", "成本", "简易程度", "智能程度", "器材数量", "可行性"],
					datasets: [
					    <%
					    for(int i=0;i<8;i++) {
					    	%>
					    	{
								label: "思路<%=(i+1) %>",
								backgroundColor: "rgba(<%=color[i] %>0.2)",
								borderColor: "rgba(<%=color[i] %>1)",
								pointBackgroundColor: "rgba(<%=color[i] %>1)",
								pointBorderColor: "#fff",
								pointHoverBackgroundColor: "#fff",
								pointHoverBorderColor: "rgba(<%=color[i] %>1)",
								data: [radar[<%=i %>][0], radar[<%=i %>][1], radar[<%=i %>][2], radar[<%=i %>][3], radar[<%=i %>][4], radar[<%=i %>][5]]
							}<%= i==8?"":","%>
					    	<%
					    }
					    %>
						
					]
				};
				var myRadarChart = new Chart(ctx, {
					type: 'radar',
					data: data,
					options: {
						scale: {
			                ticks: {
			                    beginAtZero: true
			                }
			            }
	    			}
				});
				$("#showflowchart").css("display","block");
			}
			
		});
		
		$('form').bootstrapValidator({
	　　　　　　　　message: 'This value is not valid',
	            　feedbackIcons: {
	                　　　　　　　　valid: 'glyphicon glyphicon-ok',
	                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
	                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
	            　　　　　　　　   },
	            fields: {
	                radar1: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar2: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar3: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar4: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar5: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar6: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar7: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar8: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                },
	                radar9: {
	                    message: '请输入0-10之间的数字',
	                    validators: {
	                        between: {
	                            min: 0,
	                            max: 10,
	                            message: '请输入0-10之间的数字'
	                        }
	                    }
	                }
	            }
	        });
	});
</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>技术方案总结</strong>
		</div>
		
		
				
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Summer">
				
				<input type="hidden" name="wordId" value="${wordId }">
				
				<c:forEach begin="1" end="8" varStatus="j">
				<% countRow = 0; %>
				<div class="form-group" style="margin-top:20px;">
					<label for="solution${j.index }" class="col-sm-2 control-label">思路${j.index }：</label>
					<div class="col-sm-9">
						<textarea class="form-control" rows="4" id="solution${j.index }" name="solution${j.index }">${solu[j.index-1] }</textarea>
					</div>
				</div>
				
				<div>
					<table class="table" style="margin:auto;text-align:center;">
						<tr>
							<c:forEach begin="1" end="7" varStatus="i">
								<c:if test="${i.index < 7 }">
									<td style="vertical-align:middle;"><%=rowText[countRow++] %></td>
								</c:if>
								<c:if test="${i.index == 7 }">
									<td></td>
								</c:if>							
							</c:forEach>
						</tr>
						
						<tr id="radar${j.index }">
							<c:forEach begin="1" end="7" varStatus="i">
								<c:if test="${i.index < 7 }">
									<td style="vertical-align:middle;">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="请输入0-10间的数字" name="radar${j.index }" value="${radar[j.index-1][i.index-1] }">
										</div>
										
									</td>
								</c:if>
								<c:if test="${i.index == 7 }">
									<td>
										<div><button type="button" class="btn btn-primary" id="create${j.index }">生成雷达图</button></div>
									</td>
								</c:if>							
							</c:forEach>
						</tr>
					</table>
				</div>
				
				<div class="form-group display1" style="text-align:center;display:none;width:400px;margin:0 auto;" id="showflowchart${j.index }">						
						<canvas width="100" height="100" id="canvas${j.index }"></canvas>					
				</div>
				</c:forEach>
				
				<div class="form-group" style="margin-top:20px;">
					<label for="solu" class="col-sm-2 control-label">最终思路：</label>
					<div class="col-sm-9">
						<textarea class="form-control" rows="4" id="solu" name="solu">${solu[8] }</textarea>
					</div>
				</div>
				<div class="form-group display" style="text-align:center;display:none;width:600px;margin:0 auto;" id="showflowchart">						
						<canvas width="100" height="100" id="canvas"></canvas>					
				</div>
				<!-- 提交 -->
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-warning" id="create">生成总雷达图</button>
						<button type="submit" class="btn btn-primary">提交</button>						
					</div>
				</div>
				
				
				
			</form>
		</div>
	</div>

</body>
</html>