<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mo1451.model.ComFun" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String[] rowText = {"种类","物质资源","能量资源","信息资源","空间资源","时间资源","功能资源"};
	String[] colText = {"系统","子系统","超系统"};
	String[] colText21 = {"价值","数量","质量","可用性"};
	String[] colText22 = {"免费","廉价","昂贵","无限","足够","不足","有益","中性","有害","成品","改变可用","需要建造"};
	String[] rowText3 = {"资源类型","价值","数量","质量","可用性"};
	int countRow = 0;
	int countCol = 0;
	String component = (String)request.getAttribute("component");
	List<ComFun> cfs = (List<ComFun>)request.getAttribute("cfs");
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>资源分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script> 
<script type="text/javascript">

	var canvas; 
	var stage; // 创建一个舞台对象
	var scene; // 创建一个场景对象
	$(document).ready(function () {
		
		<%	if(cfs != null) {
			if(cfs.size() > 0) {
				int row = 0;
				int col = 0;
				String[] com = component.split("，");
				for(int i=0;i<cfs.size();i++) {
					ComFun cf = cfs.get(i);
					for(int j=0;j<com.length;j++) {
						if(cf.getPrename().equals(com[j])) {
							row = j+1;
						}
						if(cf.getAftername().equals(com[j])) {
							col = j+1;
						}
					}
					if(col < row) {
						%>
						$("#rel<%=row + "" + col %> option[value='<%=cf.getPrename() + ","  + cf.getAftername() %>']").attr("selected","true");
						<%
					}
					%>
			//		alert($("#<%=cf.getPrename() + "," + cf.getAftername() %>").attr(id));
					$("#funtype<%=i %> option[value='<%=cf.getType() %>']").attr("selected","true");
					$("#level<%=i %> option[value='<%=cf.getLevel() %>']").attr("selected","true");
					<%
				}
			}
		}
		%>
		
		canvas = document.getElementById('canvas'); 
        stage = new JTopo.Stage(canvas); // 创建一个舞台对象
        scene = new JTopo.Scene(stage); // 创建一个场景对象
        scene.background = '../images/chartback.jpg';
		/* $("#function").delegate("#createcom","click",function() {
			$("#comtable").remove();
			$("#combtn").remove();
			var text = $("#component").val();
			var tablestr = "<table class='table' style='margin:auto;text-align:center;margin-top:40px;' id='comtable'>"
						+ "<tr><th colspan='7' style='text-align:center;' class='success'>组成部分</th></tr>"
						;
			textsplit = text.split("，");
	//		alert(textsplit);
			var countcol = 0;
			var countrow = 0;
			for(var i=0;i<textsplit.length+1;i++) {
				tablestr += "<tr>";
				for(var j=0;j<textsplit.length+1;j++) {
					if(i==0 && j!=0) {
						tablestr += "<td style='vertical-align:middle;'>" + textsplit[j-1] + "</td>";
					} else if(i!=0 && j==0) {
						tablestr += "<td style='vertical-align:middle;'>" + textsplit[i-1] + "</td>";
					} else if(i==0 && j==0) {
						tablestr += "<td style='vertical-align:middle;'></td>";
					} else if(i<=j) {
						tablestr += "<td style='vertical-align:middle;background:grey;'></td>";
					} else {
						tablestr += "<td style='vertical-align:middle;'>" 
								+ "<select name='relative' id='relsel" + i + j + "' class='form-control relsel'>"
								+ "<option value='notrelative' selected>无关</option>"
								+ "<option value='" + textsplit[i-1] + "," + textsplit[j-1] + "'>有关</option>"						
					    		+ "</select></td>";
					}
				}
				tablestr += "</tr>";
			}
			tablestr += "</table>"
					+ "<div class='form-group' id='combtn'  style='margin-top:40px;margin-left:40px;text-align:center;'>"
					+ "<div class='col-sm-2' style='margin:0 auto;'>"
					+ "<button class='btn btn-default' type='button' id='createfun'>生成功能表格</button>"
					+ "</div></div>";
			$("#componentdiv").after(tablestr);
		});
		
		
		$("#function").delegate("#createfun","click",function() {
			$("#funtable").remove();
			$("#funbtn").remove();
			var tablestr = "<table class='table' style='margin:auto;text-align:center;margin-top:40px;' id='funtable'>"
						+ "<tr><th colspan='7' style='text-align:center;' class='success'>组成相互作用</th></tr>"
						;
			var seltext = new Array();
			var countsel = 0;
			$(".relsel option:selected").each(function(selindex,selitem) {
		//		alert($(this).val());
				var selval = $(selitem).val();
				if(selval != "notrelative") {
					seltext[countsel++] =selval.split(",");
				}				
		//		alert(seltext.length);
			});  
			var rowtext = new Array("功能","功能载体","作用","功能对象","改变参数","功能种类","实现水平");
			for(var i=0;i<seltext.length+1;i++) {
				if(i==0) {
					tablestr += "<tr>";
					for(var j=0;j<rowtext.length;j++) {
						tablestr += "<td style='vertical-align:middle;'>" + rowtext[j] + "</td>";							
					}
					tablestr += "</tr>";
				} else {
					tablestr += "<tr><td style='vertical-align:middle;'>" + (i*2-1) +"</td>" 
						+ "<input type='hidden' name='preAfter' id='preAfter' value='" + seltext[i-1][0] + "," + seltext[i-1][1] + "'>"
						+ "<td style='vertical-align:middle;'>" + seltext[i-1][0] + "</td>"
						+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='func' value=''></td>"
						+ "<td style='vertical-align:middle;'>" + seltext[i-1][1] + "</td>"
						+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='para' value=''></td>"
						+ "<td style='vertical-align:middle;'>"
							+ "<select class='form-control funsel' name='funtype'>"
							+ "<option value='1' selected>有益</option>"
							+ "<option value='2'>有害</option>"						
				    		+ "</select>"
				    	+ "</td>"
						+ "<td style='vertical-align:middle;'>"
							+ "<select class='form-control funsel' name='level'>"
							+ "<option value='1' selected>适当</option>"
							+ "<option value='2'>不足</option>"
							+ "<option value='3'>过度</option>"
				    		+ "</select>"
						+ "</td></tr>";
						
					tablestr += "<tr><td style='vertical-align:middle;'>" + (i*2) +"</td>" 
						+ "<input type='hidden' name='preAfter' id='preAfter' value='" + seltext[i-1][1] + "," + seltext[i-1][0] + "'>"
						+ "<td style='vertical-align:middle;'>" + seltext[i-1][1] + "</td>"
						+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='func' value=''></td>"
						+ "<td style='vertical-align:middle;'>" + seltext[i-1][0] + "</td>"
						+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='para' value=''></td>"
						+ "<td style='vertical-align:middle;'>"
							+ "<select class='form-control funsel' name='funtype'>"
							+ "<option value='1' selected>有益</option>"
							+ "<option value='2'>有害</option>"						
				    		+ "</select>"
				    	+ "</td>"
						+ "<td style='vertical-align:middle;'>"
							+ "<select class='form-control funsel' name='level'>"
							+ "<option value='1' selected>适当</option>"
							+ "<option value='2'>不足</option>"
							+ "<option value='3'>过度</option>"
				    		+ "</select>"
						+ "</td></tr>";
				}
			}
			tablestr += "</table>"
					+ "<div class='form-group' id='funbtn'  style='margin-top:40px;margin-left:40px;text-align:center;'>"
					+ "<div class='col-sm-2' style='margin:0 auto;'>"
					+ "<button class='btn btn-default' type='button' id='createchart'>生成流程图</button>"
					+ "</div></div>";
			$("#combtn").after(tablestr);
		});
		 */
		$("#function").delegate("#createchart","click",function() {
			var chartext = new Array();
			var charcount = 0;			
			var bule = "0,0,255";
			var red = "255,0,0";
			$("#funtable tr").each(function(trindex,tritem) {
				if(trindex > 1) {
					chartext[charcount] = new Array();
					$(tritem).find("td").each(function (tdindex,tditem) {
						if(tdindex > 0 && tdindex < 5 && tdindex%2 != 0) {
							chartext[charcount][tdindex-1] = $(tditem).text();
						} else if(tdindex > 0 && tdindex < 5 && tdindex%2 == 0) {
							chartext[charcount][tdindex-1] = $(tditem).find("input").val();
						} else if(tdindex >= 5) {
							chartext[charcount][tdindex-1] = $(tditem).find("select").val();
						}
					});
					charcount ++;
				}
			});
		//	alert(chartext[0][4]);
			$("#showflowchart").css("display","block");
			scene.clear();
			
			// 节点
            function newNode(x, y, w, h, text){
                var node = new JTopo.Node(text);
                node.textPosition = 'Middle_Center';// 文字居中
                node.setLocation(x, y);
                node.setSize(w, h);
                scene.add(node);
                return node;
            }
			
         	// ---------- FoldLink
            function newFoldLink(nodeA, nodeZ, text, lineWidth, lineColor, direction, dashedPattern){
                var link = new JTopo.FoldLink(nodeA, nodeZ, text);
                link.direction = direction || 'horizontal';
                link.arrowsRadius = 15; //箭头大小
                link.lineWidth = lineWidth; // 线宽
                link.bundleOffset = 60; // 折线拐角处的长度
                link.bundleGap = 20; // 线条之间的间隔
                link.textOffsetY = 3; // 文本偏移量（向下3个像素）
                link.strokeColor = lineColor; // 线条颜色随机
                link.dashedPattern = dashedPattern; 
                scene.add(link);
                return link;
            }
         	
         	// 曲线
            function newCurveLink(nodeA, nodeZ, text){
                var link = new JTopo.CurveLink(nodeA, nodeZ, text);
                link.arrowsRadius = 15; //箭头大小
                link.lineWidth = 3; // 线宽
                link.strokeColor = "255,0,0";
                scene.add(link);
                return link;
            }
         	var x = 50;
         	var y = 50;
         	var countNode = 2;
         	var nodeArr = new Array();
         	var node1 = newNode(x, y, 60, 60, chartext[0][0]);
     		var node2 = newNode(x+100, y+100, 60, 60, chartext[0][2]);
     		nodeArr[0] = node1;
     		nodeArr[1] = node2;
         	for(var i=0; i < (chartext.length/2); i++) {
         		var j = 0;
         		for(j=0;j<nodeArr.length;j++) {
         			if(nodeArr[j].text == chartext[i*2][0]) {
         				break;
         			}
         		}
         		if(j == nodeArr.length) {
         			if(x+250<=800) {
             			x += 150;
             		} else {
             			x = 50;
             			y += 150; 
             		}
         			nodeArr[countNode] = newNode(x, y, 60, 60, chartext[i*2][0]);
         			node1 = nodeArr[countNode];
         			countNode ++;
         		} else {
         			node1 = nodeArr[j];
         		}
         		for(j=0;j<nodeArr.length;j++) {
         			if(nodeArr[j].text == chartext[i*2][2]) {
         				break;
         			}
         		}
         		if(j == nodeArr.length) {
         			if(x+250<=800) {
             			x += 150;
             		} else {
             			x = 50;
             			y += 150; 
             		}
         			nodeArr[countNode] = newNode(x, y, 60, 60, chartext[i*2][0]);
         			node2 = nodeArr[countNode];
         			countNode ++;
         		} else {
         			node2 = nodeArr[j];
         		}         		
         		if(chartext[i*2][4] == "useful") {
             		if(chartext[i*2][5] == "proper") {
             			newFoldLink(node1, node2, chartext[i*2][1],3,bule);
             		} else if(chartext[i*2][5] == "lack") {
             			newFoldLink(node1, node2, chartext[i*2][1],3,bule,5);
             		} else if(chartext[i*2][5] == "over") {
             			newFoldLink(node1, node2, chartext[i*2][1],6,bule);
             		}
             	} else {                           
             		newFoldLink(node1, node2, chartext[i*2][1],3,red);
             	}
         		if(chartext[i*2+1][4] == "useful") {
             		if(chartext[i*2+1][5] == "proper") {
             			newFoldLink(node2, node1, chartext[i*2+1][1],3,bule,'vertical');
             		} else if(chartext[i*2+1][5] == "lack") {
             			newFoldLink(node2, node1, chartext[i*2+1][1],3,bule,'vertical',5);
             		} else if(chartext[i*2+1][5] == "over") {
             			newFoldLink(node2, node1, chartext[i*2+1][1],6,bule,'vertical');
             		}
             	} else {                           
             		newFoldLink(node2, node1, chartext[i*2+1][1],3,bule,'vertical');
             	}
         	}
       //  	alert();
		});
	});
</script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>资源分析</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Function" id="function">
				<input type="hidden" name="wordId" value="${wordId }"> 
				<div class="form-group" id="solutiondiv">
					<label for="system" class="col-sm-2 control-label">技术系统：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="system" name="system" value="${system }">
					</div>
				</div>
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="function" class="col-sm-2 control-label">主要功能：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="function" name="function" value="${function }">
					</div>
				</div>
				<div class="form-group" id="componentdiv"  style="margin-top:40px;">
					<label for="component" class="col-sm-2 control-label">组成部分：</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="component" name="component" value="${component }" placeholder="请用，（中文）分离组成">
					</div>
					<div class="col-sm-2 reasonbtn">
						<button class="btn btn-default" type="submit" id="createcom">生成组件表格</button>
					</div>
				</div>
				<% 
					
					if(component != null && !component.equals("")) {
						String[] com = component.split("，");
						String tablestr = "<table class='table' style='margin:auto;text-align:center;margin-top:40px;' id='comtable'>"
								+ "<tr><th colspan='7' style='text-align:center;' class='success'>组成部分</th></tr>";
						for(int i=0;i<com.length+1;i++) {
							tablestr += "<tr>";
							for(int j=0;j<com.length+1;j++) {
								if(i==0 && j!=0) {
									tablestr += "<td style='vertical-align:middle;'>" + com[j-1] + "</td>";
								} else if(i!=0 && j==0) {
									tablestr += "<td style='vertical-align:middle;'>" + com[i-1] + "</td>";
								} else if(i==0 && j==0) {
									tablestr += "<td style='vertical-align:middle;'></td>";
								} else if(i<=j) {
									tablestr += "<td style='vertical-align:middle;background:grey;'></td>";
								} else {
									tablestr += "<td style='vertical-align:middle;'>" 
											+ "<select name='relative' id='rel" + i + j + "' class='form-control relsel'>"
											+ "<option value='notrelative' selected>无关</option>"
											+ "<option value='" + com[i-1] + "," + com[j-1] + "'>有关</option>"						
								    		+ "</select></td>";
								}
							}
							tablestr += "</tr>";
						}
						tablestr += "</table>"
								+ "<div class='form-group' id='combtn'  style='margin-top:40px;margin-left:40px;text-align:center;'>"
								+ "<div class='col-sm-2' style='margin:0 auto;'>"
								+ "<button class='btn btn-default' type='submit' id='createfun'>生成功能表格</button>"
								+ "</div></div>";
						out.print(tablestr);
					}
				%>
				
				<%
					if(cfs != null) {
					if(cfs.size() > 0) {
						String tablestr = "<table class='table' style='margin:auto;text-align:center;margin-top:40px;' id='funtable'>"
								+ "<tr><th colspan='7' style='text-align:center;' class='success'>组成相互作用</th></tr>";
						String[] rowtext = {"功能","功能载体","作用","功能对象","改变参数","功能种类","实现水平"};
						for(int i=0;i<cfs.size()+1;i++) {
							if(i==0) {
								tablestr += "<tr>";
								for(int j=0;j<rowtext.length;j++) {
									tablestr += "<td style='vertical-align:middle;'>" + rowtext[j] + "</td>";							
								}
								tablestr += "</tr>";
							} else {
								tablestr += "<tr><td style='vertical-align:middle;'>" + (i*2-1) +"</td>" 
									+ "<input type='hidden' name='preAfter' id='" + cfs.get(i-1).getPrename() + "," + cfs.get(i-1).getAftername() + "' value='" + cfs.get(i-1).getPrename() + "," + cfs.get(i-1).getAftername() + "'>"
									+ "<td style='vertical-align:middle;'>" + cfs.get(i-1).getPrename() + "</td>"
									+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='func' value='" + (cfs.get(i-1).getFunction() != null?cfs.get(i-1).getFunction():"") + "'></td>"
									+ "<td style='vertical-align:middle;'>" + cfs.get(i-1).getAftername() + "</td>"
									+ "<td style='vertical-align:middle;'><input type='text' class='form-control text-center' name='para' value='" + (cfs.get(i-1).getPara() != null?cfs.get(i-1).getPara():"") + "'></td>"
									+ "<td style='vertical-align:middle;'>"
										+ "<select class='form-control funsel' name='funtype' id='funtype" + (i-1) + "'>"
										+ "<option value='1' selected>有益</option>"
										+ "<option value='2'>有害</option>"						
							    		+ "</select>"
							    	+ "</td>"
									+ "<td style='vertical-align:middle;'>"
										+ "<select class='form-control funsel' name='level' id='level" + (i-1) +"'>"
										+ "<option value='1' selected>适当</option>"
										+ "<option value='2'>不足</option>"
										+ "<option value='3'>过度</option>"
							    		+ "</select>"
									+ "</td></tr>";
									
								
							}
						}
						tablestr += "</table>"
								+ "<div class='form-group' id='funbtn'  style='margin-top:40px;margin-left:40px;text-align:center;'>"
								+ "<div class='col-sm-2' style='margin:0 auto;'>"
								+ "<button class='btn btn-default' type='button' id='createchart'>生成流程图</button>"
								+ "</div></div>";
						out.print(tablestr);
					}
					}
				%>
				<div class="form-group" style="text-align:center;display:none;" id="showflowchart">						
						<canvas width="850" height="550" id="canvas"></canvas>					
				</div>
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution1" class="col-sm-2 control-label">思路5：</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="4" id="solution5" name="solution5">${solution5 }</textarea>
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