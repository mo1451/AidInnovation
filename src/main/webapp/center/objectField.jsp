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
<title>物-场分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script> 

<script type="text/javascript">
	$(document).ready(function() {
		var canvas = document.getElementById('canvas'); 
        var stage = new JTopo.Stage(canvas); // 创建一个舞台对象
        var scene = new JTopo.Scene(stage); // 创建一个场景对象
        scene.background = '../images/chartback.jpg';
        
        var canvas1 = document.getElementById('canvas1'); 
        var stage1 = new JTopo.Stage(canvas1); // 创建一个舞台对象
        var scene1 = new JTopo.Scene(stage1); // 创建一个场景对象
        scene1.background = '../images/chartback.jpg';
        
        var canvas2 = document.getElementById('canvas2'); 
        var stage2 = new JTopo.Stage(canvas2); // 创建一个舞台对象
        var scene2 = new JTopo.Scene(stage2); // 创建一个场景对象
        scene2.background = '../images/chartback.jpg';
        
        var canvas3 = document.getElementById('canvas3'); 
        var stage3 = new JTopo.Stage(canvas3); // 创建一个舞台对象
        var scene3 = new JTopo.Scene(stage3); // 创建一个场景对象
        scene3.background = '../images/chartback.jpg';
        var nodeStr = new Array();
        nodeStr[0] = new Array("${nodes[0][0]}","${nodes[0][1]}","${nodes[0][2]}");
        nodeStr[1] = new Array("${nodes[1][0]}","${nodes[1][1]}","${nodes[1][2]}","${nodes[1][3]}");
        nodeStr[2] = new Array("${nodes[2][0]}","${nodes[2][1]}","${nodes[2][2]}","${nodes[2][3]}");
        nodeStr[3] = new Array("${nodes[3][0]}","${nodes[3][1]}","${nodes[3][2]}","${nodes[3][3]}","${nodes[3][4]}");
        function newNode(thisSce, x, y, r, text) {
			var circleNode = new JTopo.CircleNode(text);
			circleNode.radius = r; // 半径
			circleNode.alpha = 1;
			circleNode.dragable = false;
			circleNode.fillColor = '0, 0, 255'; // 填充颜色
			circleNode.setLocation(x, y);
			circleNode.textPosition = 'Middle_Center'; // 文本位置
			thisSce.add(circleNode);
			return circleNode;
		}
		var red = "255,0,0";
		var blue = "0,200,255";
		// 简单连线
        function newLink(thisSce, nodeA, nodeZ, color, text, dashedPattern){
            var link = new JTopo.Link(nodeA, nodeZ, text);        
            link.lineWidth = 3; // 线宽
            link.dashedPattern = dashedPattern; // 虚线
            link.bundleOffset = 60; // 折线拐角处的长度
            link.bundleGap = 20; // 线条之间的间隔
            link.textOffsetY = 3; // 文本偏移量（向下3个像素）
            link.strokeColor = color;
            thisSce.add(link);
            return link;
        }
		
        // 二次折线
        function newFlexionalLink(thisSce, nodeA, nodeZ, text, direction, dashedPattern){
            var link = new JTopo.FlexionalLink(nodeA, nodeZ, text);
            link.direction = direction || 'horizontal';
            link.arrowsRadius = 10;
            link.lineWidth = 3; // 线宽
            link.offsetGap = 35;
            link.bundleGap = 15; // 线条之间的间隔
            link.textOffsetY = 10; // 文本偏移量（向下15个像素）
            link.strokeColor = '0,250,0';
            link.dashedPattern = dashedPattern; 
            thisSce.add(link);
            return link;
        }
     //   alert(1);
        function solu1(str) {
        	var thiscene = scene1;
        	thiscene.clear();
        	var node1 = newNode(thiscene,51,150,24,str[0]);
			var node2 = newNode(thiscene,191,150,24,str[1]);
			var nodef = newNode(thiscene,121,60,24,str[2]);
			
			var link = newLink(thiscene,node2,node1,blue);
			link.arrowsRadius = 10;
			var link = newLink(thiscene,nodef,node2,blue);
			link.arrowsRadius = 10;
        }
       // alert(2);
        function solu2(str) {
        	var thiscene = scene1;
        	thiscene.clear();
        	var node1 = newNode(thiscene,51,130,24,str[0]);
			var node2 = newNode(thiscene,191,130,24,str[1]);
			var nodef = newNode(thiscene,121,40,24,str[2]);
			var node3 = newNode(thiscene,121,180,24,str[3]);
			
			var link = newLink(thiscene,node2,node1,red,"有害");
			link.arrowsRadius = 10;
			var link = newLink(thiscene,node1,nodef,blue);
			var link = newLink(thiscene,node2,nodef,blue);
			var link = newLink(thiscene,node3,nodef,blue);
        }
        function solu3(str) {
        	var thiscene = scene2;
        	thiscene.clear();
        	var node1 = newNode(thiscene,49,130,24,str[0]);
			var node2 = newNode(thiscene,189,130,24,str[1]);
			var nodef = newNode(thiscene,119,40,24,str[2]);
			var nodef2 = newNode(thiscene,119,180,24,str[3]);
			
			var link = newLink(thiscene,node2,node1,red,"有害");
			link.arrowsRadius = 10;
			var link = newLink(thiscene,node1,nodef,blue);
			var link = newLink(thiscene,node2,nodef,blue);
			var link = newLink(thiscene,nodef2,nodef,blue);
        }
        function solu4(str) {
        	var thiscene = scene1;
        	thiscene.clear();
        	var node1 = newNode(thiscene,51,150,24,str[0]);
			var node2 = newNode(thiscene,191,150,24,str[1]);
			var nodef = newNode(thiscene,121,60,24,str[2]);
			
			var link = newLink(thiscene,node2,node1,blue);
			link.arrowsRadius = 10;
			var link = newLink(thiscene,node1,nodef,blue);
			var link = newLink(thiscene,node2,nodef,blue);
        }
        function solu5(str) {
        	var thiscene = scene2;           	
			thiscene.clear();
        	var node1 = newNode(thiscene,49,130,24,str[0]);
			var node2 = newNode(thiscene,189,130,24,str[1]);
			var nodef = newNode(thiscene,119,40,24,str[2]);
			var node3 = newNode(thiscene,119,180,24,str[3]);
			
			var link = newLink(thiscene,node2,node1,blue);
			link.arrowsRadius = 10;
			var link = newLink(thiscene,node1,nodef,blue);
			var link = newLink(thiscene,node2,nodef,blue);
			var link = newLink(thiscene,node3,node2,blue);
			link.arrowsRadius = 10;
        }
        function solu6(str) {
        	var thiscene = scene3;
        	thiscene.clear();
        	var node1 = newNode(thiscene,48,150,24,str[0]);
			var node2 = newNode(thiscene,188,150,24,str[1]);
			var nodef1 = newNode(thiscene,118,60,24,str[2]);
			var nodef2 = newNode(thiscene,258,60,24,str[3]);
			var node3 = newNode(thiscene,328,150,24,str[4]);
			
			var link = newLink(thiscene,node2,node1,blue);
			link.arrowsRadius = 10;
			var link = newLink(thiscene,node1,nodef1,blue);
			var link = newLink(thiscene,node2,nodef1,blue);
			
			var link = newLink(thiscene,node3,node2,blue);
			link.arrowsRadius = 10;
			
			var link = newLink(thiscene,node3,nodef2,blue);
			var link = newLink(thiscene,node2,nodef2,blue);
        }
        function model1(str) {
        	//alert(str);
        	var node1 = newNode(scene,50,150,24,str[0][0]);
			var node2 = newNode(scene,190,150,24,str[0][1]);
			$("#thispro").text("不完整模型");
			$("#type").val("1");
			$("#thismodel").text("是第一类模型，不完整模型，有一个一般解法。");
			
			$("#thisid1").text("1");
			$("#thisdescr1").text("补齐所缺失的元素，增加场F或工具S2，完整模型。");
			
			solu1(str[1]);
			$(".display1").css("display","block");
			$(".display2").css("display","none");
			$(".display3").css("display","none");
        }
        
        function model2(str) {
        	var node1 = newNode(scene,50,150,24,str[0][0]);
			var node2 = newNode(scene,190,150,24,str[0][1]);
			var nodef = newNode(scene,120,60,24,str[0][2]);
			
			var link = newLink(scene,node2,node1,red,"有害");
			link.arrowsRadius = 10;
			var link = newLink(scene,node1,nodef,blue);
			var link = newLink(scene,node2,nodef,blue);
			
			$("#thispro").text("有害效应的完整模型");
			$("#type").val("2");
			$("#thismodel").text("是第二类模型，有害效应的完整模型，有两个一般解法。");
			
			$("#thisid1").text("2");
			$("#thisdescr1").text("加入第3种物质S3，S3用来阻止有害作用。S3可以是通过S1或S2改变而来，或者是S1/S2共同改变而来。");
			$("#thisid2").text("3");
			$("#thisdescr2").text("增加另外一个场F2来抵消原来有害场F的效应。");
			
			solu2(str[1]);
			solu3(str[2]);
			
			$(".display1").css("display","block");
			$(".display2").css("display","block");
			$(".display3").css("display","none");
        }
        
        function model3(str) {
        	var node1 = newNode(scene,50,150,24,str[0][0]);
			var node2 = newNode(scene,190,150,24,str[0][1]);
			var nodef = newNode(scene,120,60,24,str[0][2]);
			
			var link = newLink(scene,node2,node1,blue,"不足",5);
			link.arrowsRadius = 10;
			var link = newLink(scene,node1,nodef,blue);
			var link = newLink(scene,node2,nodef,blue);
			
			$("#thispro").text("效应不足的完整模型");
			$("#type").val("3");
			$("#thismodel").text("是第三类模型，效应不足的完整模型，有三个一般解法。");
			
			$("#thisid1").text("4");
			$("#thisdescr1").text("用另一个场F2（或者F2和S3一起）代替原来的场F1（或者F1和S2一起）。");
			$("#thisid2").text("5");
			$("#thisdescr2").text("增加另外一个场F2来强化有用的效应。");
			$("#thisid3").text("6");
			$("#thisdescr3").text("插进一个物质S3并加上另一个场F2来提高有用效应。");
			
			solu4(str[1]);
			solu5(str[2]);
			solu6(str[3]);
			
			$(".display1").css("display","block");
			$(".display2").css("display","block");
			$(".display3").css("display","block");
        }
        
        function model0() {
        	$("#showflowchart").css("display","none");
			$(".display0").css("display","none");
			$(".display1").css("display","none");
			$(".display2").css("display","none");
			$(".display3").css("display","none");
        }
        
		var typ = ${ofwbs.type};
        
		if(typ != null) {
			//alert();
			$("#showflowchart").css("display","block");
        	$(".display0").css("display","block");
        	scene.clear();
			if(typ == 1) {
	        	model1(nodeStr);
			} else if(typ == 2) {
				model2(nodeStr);
			} else if(typ == 3) {
				model3(nodeStr);
			} else {
				model0();
			}
		}
		
		 $("#objectField").delegate("#model","change",function() {
	        	$("#showflowchart").css("display","block");
	        	$(".display0").css("display","block");
				scene.clear();
				var chartext = $("#model").val();
		//		alert(chartext);
				if(chartext == "model1") {
					model1(nodeStr);
				} else if(chartext == "model2") {
					model2(nodeStr);
				} else if(chartext == "model3") {
					model3(nodeStr);
				} else {
					model0();
				}
	        });
		
		var textfield = $("#jtopo_textfield");
		scene.dbclick(function(event){
			if(event.target == null) return;
			var e = event.target;
			textfield.css({
				top: event.pageY,
				left: event.pageX - e.width/2
			}).show().attr('value', e.text).focus().select();
			textfield.val(e.text);
			e.text = "";
			textfield[0].JTopoNode = e;
		});
		
		scene1.dbclick(function(event){
			if(event.target == null) return;
			var e = event.target;
			textfield.css({
				top: event.pageY,
				left: event.pageX - e.width/2
			}).show().attr('value', e.text).focus().select();
			textfield.val(e.text);
			e.text = "";
			textfield[0].JTopoNode = e;
		});
		scene2.dbclick(function(event){
			if(event.target == null) return;
			var e = event.target;
			textfield.css({
				top: event.pageY,
				left: event.pageX - e.width/2
			}).show().attr('value', e.text).focus().select();
			textfield.val(e.text);
			e.text = "";
			textfield[0].JTopoNode = e;
		});
		scene3.dbclick(function(event){
			if(event.target == null) return;
			var e = event.target;
			textfield.css({
				top: event.pageY,
				left: event.pageX - e.width/2
			}).show().attr('value', e.text).focus().select();
			textfield.val(e.text);
			e.text = "";
			textfield[0].JTopoNode = e;
		});
		$("#jtopo_textfield").blur(function(){
			var txt = textfield.hide().val();
			textfield[0].JTopoNode.text = txt;
			var x = textfield[0].JTopoNode.x;
			var y = textfield[0].JTopoNode.y;
			switch(x) {
			case 50:
				$("#node11").val(txt);
				break;
			case 190:
				$("#node12").val(txt);
				break;
			case 120:
				$("#node13").val(txt);
				break;
			case 51:
				$("#node21").val(txt);
				break;
			case 191:
				$("#node22").val(txt);
				break;
			case 121:
				if(y < 70) {
					$("#node23").val(txt);
				} else {
					$("#node24").val(txt);
				}
				break;
			case 49:
				$("#node31").val(txt);
				break;
			case 189:
				$("#node32").val(txt);
				break;
			case 119:
			//	alert(y);
				if(y < 60) {
					$("#node33").val(txt);
				} else {
					$("#node34").val(txt);
				}
				break; 
			case 48:
				$("#node41").val(txt);
				break;
			case 188:
				$("#node42").val(txt);
				break;
			case 118:
				$("#node43").val(txt);
				break;
			case 258:
				$("#node44").val(txt);
				break;
			case 328:
				$("#node45").val(txt);
				break;
			default:break;
			}
		});
	});
</script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>物-场分析</strong>
		</div>
		
		<textarea id="jtopo_textfield" style="display:none;width: 60px;position: absolute;" onkeydown="if(event.keyCode==13)this.blur();"></textarea>
				
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="ObjectField" id="objectField">
				
				<input type="hidden" name="type" id="type" value="${ofwbs.type }">
				<input type="hidden" name="wordId" value="${wordId }">
				<div class="form-group">
					<label for="model" class="col-sm-2 control-label">确定物-场模型：</label>
					<div class="col-sm-4">
						<select id="model" class="form-control">
							<option value="model0" <c:if test="${ofwbs.type == null }">selected</c:if>>请选择模型</option>
							<option value="model1" <c:if test="${ofwbs.type == 1 }">selected</c:if>>不完整模型</option>
							<option value="model2" <c:if test="${ofwbs.type == 2 }">selected</c:if>>有害效应的完整模型</option>
							<option value="model3" <c:if test="${ofwbs.type == 3 }">selected</c:if>>效应不足的完整模型</option>
							
						</select>
					</div>
				</div>
				
				
				<!-- 流程图画板 -->
				<div class="form-group" style="text-align:center;display:none;" id="showflowchart">						
						<canvas width="300" height="270" id="canvas"></canvas>					
				</div>
				<input type="hidden" name="node1" id="node11" value="${nodes[0][0] }">
				<input type="hidden" name="node1" id="node12" value="${nodes[0][1] }">
				<input type="hidden" name="node1" id="node13" value="${nodes[0][2] }">
				
				<div class="form-group display0" style="margin-top:40px;display:none;">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp本问题属于</label>
					<label class="control-label" id="thispro"></label>
					<label class="control-label">，即</label>
					<input type="text" style="width:130px;height:40px;" id="word11" name="txt" value="${ofwbs.txt }">
					<label class="control-label" id="thismodel"></label>		
				</div>
				
				<!-- 第一版块 -->
				
				<div class="form-group display1" style="display:none;">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp一般解法</label>
					<label class="control-label" id="thisid1"></label>
					<label class="control-label">：</label>
					<label class="control-label" id="thisdescr1"></label>	
				</div>
				
				<!-- 流程图画板 -->
				<div class="form-group display1" style="text-align:center;display:none;" id="showflowchart1">						
						<canvas width="300" height="270" id="canvas1"></canvas>					
				</div>
				
				
				<input type="hidden" name="node2" id="node21" value="${nodes[1][0] }">
				<input type="hidden" name="node2" id="node22" value="${nodes[1][1] }">
				<input type="hidden" name="node2" id="node23" value="${nodes[1][2] }">
				<input type="hidden" name="node2" id="node24" value="${nodes[1][3] }">
				<div class="form-group display1" style="display:none;">
					<div class="col-sm-1">
						<textarea rows="4" class="form-control" style="display:none;"></textarea>
					</div>
					<div class="col-sm-10">
						<textarea rows="4" class="form-control" placeholder="在此输入解释" name="explain1">${ofwbs.explain1 }</textarea>
					</div>
				</div>
				
				
				<!-- 第二版块 -->
				
				<div class="form-group display2" style="margin-top:40px;display:none;">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp一般解法</label>
					<label class="control-label" id="thisid2"></label>
					<label class="control-label">：</label>
					<label class="control-label" id="thisdescr2"></label>	
				</div>
				
				<!-- 流程图画板 -->
				<div class="form-group display2" style="text-align:center;display:none;" id="showflowchart2">						
						<canvas width="300" height="300" id="canvas2"></canvas>					
				</div>
				<input type="hidden" name="node3" id="node31" value="${nodes[2][0] }">
				<input type="hidden" name="node3" id="node32" value="${nodes[2][1] }">
				<input type="hidden" name="node3" id="node33" value="${nodes[2][2] }">
				<input type="hidden" name="node3" id="node34" value="${nodes[2][3] }">
				<div class="form-group display2" style="display:none;">
					<div class="col-sm-1">
						<textarea rows="4" class="form-control" style="display:none;"></textarea>
					</div>
					<div class="col-sm-10">
						<textarea rows="4" class="form-control" placeholder="在此输入解释" name="explain2">${ofwbs.explain2 }</textarea>
					</div>
				</div>
				
				<!-- 第三版块 -->
				<div class="form-group display3" style="margin-top:40px;display:none;">
					<label class="control-label">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp一般解法</label>
					<label class="control-label" id="thisid3"></label>
					<label class="control-label">：</label>
					<label class="control-label" id="thisdescr3"></label>	
				</div>
				
				<!-- 流程图画板 -->
				<div class="form-group display3" style="text-align:center;display:none;" id="showflowchart3">						
						<canvas width="420" height="270" id="canvas3"></canvas>					
				</div>
				<input type="hidden" name="node4" id="node41" value="${nodes[3][0] }">
				<input type="hidden" name="node4" id="node42" value="${nodes[3][1] }">
				<input type="hidden" name="node4" id="node43" value="${nodes[3][2] }">
				<input type="hidden" name="node4" id="node44" value="${nodes[3][3] }">
				<input type="hidden" name="node4" id="node45" value="${nodes[3][4] }">
				<div class="form-group display3" style="display:none;">
					<div class="col-sm-1">
						<textarea rows="4" class="form-control" style="display:none;"></textarea>
					</div>
					<div class="col-sm-10">
						<textarea rows="4" class="form-control" placeholder="在此输入解释" name="explain3">${ofwbs.explain3 }</textarea>
					</div>
				</div>		
				
				<!-- 思路 -->
				
				<div class="form-group" id="solutiondiv"  style="margin-top:40px;">
					<label for="solution9" class="col-sm-2 control-label">思路9：</label>
					<div class="col-sm-9">
						<textarea class="form-control" rows="4" id="solution9" name="solution9">${solution9 }</textarea>
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