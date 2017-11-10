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
<title>因果分析</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jtopo-0.4.8-min.js"></script> 
<script type="text/javascript">
	var count2 = ${count2 };
	var count3 = new Array(50);
	for (var i = 0; i < count3.length; i++) {
		count3[i] = 0;
	}
	<% 
		int i=1; 
	//	System.out.println(request.getAttribute("count3-2"));
	%>
<%-- 	for (var i=1;i<=count2;i++) {
		
		count3[i] = <% out.print(request.getAttribute("count3-" + i++)); %>;
//		alert(i);
<% System.out.println(request.getAttribute("count3-" + i++)); %>
	} --%>
	<%
		for(i=1;i<=(Integer)request.getAttribute("count2");i++) {
	%>
		count3[<%=i%>]=<% out.print(request.getAttribute("count3-" + i)); %>;
//		alert(count3[<%=i%>]);
		<%
//		System.out.println(request.getAttribute("count3-" + i));
		}
	%>
	var canvas; 
    var stage; // 创建一个舞台对象
    var scene; // 创建一个场景对象
	
	$(document).ready(function() {
	
		canvas = document.getElementById('canvas'); 
        stage = new JTopo.Stage(canvas); // 创建一个舞台对象
        scene = new JTopo.Scene(stage); // 创建一个场景对象
		scene.addEventListener('mouseup', function(e){
			if(e.target && e.target.layout){
				JTopo.layout.layoutNode(scene, e.target, true);	
			}				
		});
		
		$("#mainreason").focus();
		
		$("#causal").delegate("input","change",function(){
			$("#wordId").before("<input type='hidden' name='changedWord'  value='" + $(this).attr("id") + "'>");
		});
		
		$("#causal").delegate(".btn", "click", function() {
			var parentid = $(this).parent().prev().children().attr("id");
			var id;
			var name;
			var label;
			var btn;
	//		alert($(this).attr("id").substring($(this).attr("id").length - 1));
			if($(this).attr("id").substring(0,6) != "delete") {
				if (parentid == "mainreason") {
					//alert(parentid);
					count2++;
					if(count2 < 10) {
						id = "reason1-0" + count2;
						label = "原因1-0" + count2 + "：";
					} else {
						id = "reason1-" + count2;
						label = "原因1-" + count2 + "：";
					}
					$("#count2").val(count2);
					$("#count2").after("<input type='hidden' name='count2-" + count2 + "' id='count2-" + count2 + "' value=''>");
					$("#wordId").before("<input type='hidden' name='newWord'  value='" + id + "'>");
					btn = "添加原因3";
					$("#last").before("<div class='form-group'><label for=" + id + " class='col-sm-2 control-label'>" + label + "</label><div class='col-sm-6'><input type='text' class='form-control level2' id=" + id + " name=" + id + " ></div><div class='col-sm-4 reasonbtn'><button class='btn btn-default' type='button' id='r2add'>" + btn + "</button><button class='btn btn-danger' type='button' id='delete2'>删除</button></div></div>");
				} else if (parentid.substring(0, 7) == "reason1") {
					var i = parseInt(parentid.substring(parentid.length - 2));
					count3[i]++;
					$("#count2-" + i).val(count3[i]);
					if(i<10) {
						if(count3[i] < 10) {
							id = "reason1-0" + i + "-0" + count3[i];
							label = "原因1-0" + i + "-0" + count3[i] + "：";
						} else {
							id = "reason1-0" + i + "-" + count3[i];
							label = "原因1-0" + i + "-" + count3[i] + "：";
						}
						
					} else {
						if(count3[i] < 10) {
							id = "reason1-" + i + "-0" + count3[i];
							label = "原因1-" + i + "-0" + count3[i] + "：";
						} else {
							id = "reason1-" + i + "-" + count3[i];
							label = "原因1-" + i + "-" + count3[i] + "：";
						}
						
					}
					$("#wordId").before("<input type='hidden' name='newWord'  value='" + id + "'>");
					if(i < 10) {
						if ($("#reason1-0" + (i + 1)).length > 0) {
							//					alert("reason1-" + (i + 1));
							$("#reason1-0" + (i + 1)).parent().parent().before("<div class='form-group'><label for=" + id + " class='col-sm-2 control-label'>" + label + "</label><div class='col-sm-6'><input type='text' class='form-control level3' id=" + id + " name=" + id + " ></div><div class='col-sm-4 reasonbtn'><button class='btn btn-danger' type='button' id='delete3'>删除</button></div></div>");
						} else {
							$("#last").before("<div class='form-group'><label for=" + id + " class='col-sm-2 control-label'>" + label + "</label><div class='col-sm-6'><input type='text' class='form-control level3' id=" + id + " name=" + id + " ></div><div class='col-sm-4 reasonbtn'><button class='btn btn-danger' type='button' id='delete3'>删除</button></div></div>");
						}
					} else {
						if ($("#reason1-" + (i + 1)).length > 0) {
							//					alert("reason1-" + (i + 1));
							$("#reason1-" + (i + 1)).parent().parent().before("<div class='form-group'><label for=" + id + " class='col-sm-2 control-label'>" + label + "</label><div class='col-sm-6'><input type='text' class='form-control level3' id=" + id + " name=" + id + " ></div><div class='col-sm-4 reasonbtn'><button class='btn btn-danger' type='button' id='delete3'>删除</button></div></div>");
						} else {
							$("#last").before("<div class='form-group'><label for=" + id + " class='col-sm-2 control-label'>" + label + "</label><div class='col-sm-6'><input type='text' class='form-control level3' id=" + id + " name=" + id + " ></div><div class='col-sm-4 reasonbtn'><button class='btn btn-danger' type='button' id='delete3'>删除</button></div></div>");
						}
					}
					
	
				}
			} else {
				if(confirm("您真的要删除吗？")) {
					$("#wordId").before("<input type='hidden' name='deletedWord'  value='" + $(this).parent().prev().children("input").attr("id") + "'>");
					if($(this).attr("id").substring($(this).attr("id").length - 1) == 3) {
				//		alert($(this).parent().prev().children("input").attr("id").substring(parentid.length - 2));
						$(this).parent().parent().remove();
					} else {
						var iddel2 = $(this).parent().prev().children("input").attr("id");
						$(".level3").each(function() {
							var iddel3 = $(this).attr("id");
				//			alert(iddel3.substring(0,9));
							if(iddel3.substring(0,10) == iddel2) {
								$(this).parent().parent().remove();
							}
				//			alert(iddel3);
						});
				//		alert(iddel);						
						$(this).parent().parent().remove();
					}					
				}
				
			}
		});
		
		$("#createflowchart").click(function() {
		//	alert("a");
			var count2 = 0;
			var maintext;
			var secondtext = new Array();
			var thirdtext = new Array();
			CanvasRenderingContext2D.prototype.wrapText = function(str,x,y){
	            var index = str.indexOf('-');
	            str2= str.substr(index+1,str.length);
	            str1= str.substr(0,index);
			    var textArray = new Array(str1,str2);
			    if(textArray==undefined||textArray==null)return false;
			    var rowCnt = textArray.length;
			    var i = 0,imax  = rowCnt,maxLength = 0;maxText = textArray[0];
			    for(;i<imax;i++){
			        var nowText = textArray[i],textLength = nowText.length;
			        if(textLength >=maxLength){
			            maxLength = textLength;
			            maxText = nowText;
			        }
			    }
			    var maxWidth = this.measureText(maxText).width;
			    var lineHeight = this.measureText("元").width;
			    x-= lineHeight*2;
			    for(var j= 0;j<textArray.length;j++){
			        var words = textArray[j];
			        this.fillText(words,x,y);
			        y+= lineHeight;
			    }
			};
			$("#showflowchart").css("display","block");
			$("#mainreason").each(function() {
				maintext = ($(this).val());
			});
			$(".level2").each(function() {
				secondtext[count2] = ($(this).val());
				var id2str = $(this).attr("id");
				var id2num = parseInt(id2str.substring(id2str.length - 2));
		//		alert(id2num);
				var count3 = 0;
				thirdtext[count2] = new Array();
				$(".level3").each(function() {
			//	alert();
				//	secondtext[count2][count3] = ($(this).val());
					var id3str = $(this).attr("id");
					var id3num = parseInt(id3str.substring(id3str.length - 5,id3str.length - 3));
					if(id3num == id2num) {
						thirdtext[count2][count3] = /*"abdfgdfsgdscd\r\nadadsfsgfds";//*/($(this).val());
			//			alert(thirdtext[count2][count3]);
						count3 ++;
						
					}
			//		alert(id3num);
			//		count3 ++;
				});
				count2 ++;
			});
			scene.clear();
	//		alert(secondtext[0].length);
			var cloudNode = new JTopo.Node('root');
			cloudNode.text = maintext;
			cloudNode.font = '26px 宋体'; // 字体
			cloudNode.fontColor = "0,0,0";
			cloudNode.textPosition = 'Middle_Center';// 文字居中
			cloudNode.setSize(100*2, 60*2);  // 尺寸
            cloudNode.setLocation(260*2,30*2);            
            cloudNode.layout = {type: 'tree', width:200*2, height: 100*2}
            
            scene.add(cloudNode);
			
			for(var i=0; i<secondtext.length; i++){
                var node = new JTopo.Node('host' + i);
                node.text = secondtext[i];
                node.font = '26px 宋体'; // 字体
    			node.fontColor = "0,0,0";
				node.textPosition = 'Middle_Center';// 文字居中
                node.fillStyle = '200,255,0';
                node.radius = 15;
                node.setLocation(-40+i*200,130);
				node.setSize(70*2, 60*2); 
                node.layout = {type: 'tree', width:70*2, height: 100*2};
                
                scene.add(node);                                
                var link = new JTopo.Link(cloudNode, node);
                scene.add(link);
                
                for(var j=0; j<thirdtext[i].length; j++){
                    var vmNode = new JTopo.Node('vm-' + i + '-' + j);
                  //  vmNode.radius = 10;
                  	vmNode.text = thirdtext[i][j];
                  	vmNode.paintText = function(a){
                  		a.beginPath(),
                  		a.font = this.font,
                  		a.wrapText(this.text,this.height/2,this.height);
                  		a.closePath()   
                  		                }
                  	vmNode.font = '26px 宋体'; // 字体
                  	vmNode.fontColor = "0,0,0";
					vmNode.textPosition = 'Middle_Center';// 文字居中
                    vmNode.fillStyle = '255,255,0';
					vmNode.setSize(40*2, 60*2); 
                    vmNode.setLocation(-110+i*200+j*50,230);
                    scene.add(vmNode);                                
                    scene.add(new JTopo.Link(node, vmNode));                            
                }
            }
			
			JTopo.layout.layoutNode(scene, cloudNode, true);			
		});
		
		$("#saveimg").click(function() {
			var c = document.getElementById("canvas");
			var dataURL = c.toDataURL("image/png");
			var imageData = dataURL.substring(22);
		//	stage.saveImageInfo();
		//	alert(dataURL);
		//	$("#img").attr("src",dataURL);
			$.ajax({  
	            type : 'post',  
	            url : '${pageContext.request.contextPath}/center/CausalImgJson',  
	            data: 'dataURL=' + imageData + '&wordId=' + ${wordId},  
	            async : false, //同步方式  
	            success : function() {   
	            }  
		    });  
		});
		
	});
</script>
</head>
<body onLoad="load()">
	<div class="panel panel-default"> 
		<div class="panel-heading" id="add">
			<strong><span class="glyphicon glyphicon-edit"></span>因果分析</strong>
		</div>
		<div class="panel-body">
			<form method="post" class="form-horizontal" role="form"
				action="Causal" id="causal">
			//	<img alt="" src="" id="img">
				<input type="hidden" name="wordId" id="wordId" value="${wordId }">
				<input type="hidden" name="count2" id="count2" value="">
				<div class="form-group">
					<label for="mainreason" class="col-sm-2 control-label">原因1：</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="mainreason"
							name="mainreason" value="${mainreason }" placeholder="该问题的主要原因">
					</div>
					<div class="col-sm-4 reasonbtn">
						<button class="btn btn-default" type="button" id="r1">添加原因2</button>
					</div>
				</div>
				<% i=1; %>
				<c:if test="${count2 > 0 }">				
					<c:forEach var="i" begin="1" end="${count2 }">
					<% if(request.getAttribute("reason1-0" + i) != null) { %>
						<c:if test="${i<10 }"> 
						<div class="form-group">
							<label for="reason1-0${i }" class="col-sm-2 control-label">原因1-0${i }：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control level2" id="reason1-0${i }" 
									name="reason1-0${i }" value="<% out.print(request.getAttribute("reason1-0" + i));%>"> 
							</div>
							<div class="col-sm-4 reasonbtn">
								<button class="btn btn-default" type="button" id="r2add">添加原因3</button>
								<button class="btn btn-danger" type="button" id="delete2">删除</button>
							</div>
						</div>
					</c:if>
					<c:if test="${i>=10 }">
					<c:set var="reason2" value="${'reason1-' }${i }"></c:set>
						<div class="form-group">
							<label for="reason1-${i }" class="col-sm-2 control-label">原因1-${i }：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control level2" id="reason1-${i }"
									name="reason1-${i }" value="<% out.print(request.getAttribute("reason1-" + i));%>">
							</div>
							<div class="col-sm-4 reasonbtn">
							<button class="btn btn-default" type="button" id="r2add">添加原因3</button>
								<button class="btn btn-danger" type="button" id="delete2">删除</button>
							</div>
						</div>
					</c:if>
					<%
						}
						%>
						<%
							String[] strCount3 = new String[50];
									int[] count3 = new int[50];
									count3[i] = (Integer) request.getAttribute("count3-" + i);
									for (int j = 1; j <= count3[i]; j++) {
										if (i < 10) {
											if (j < 10) {
												if(request.getAttribute("reason1-0" + i) != null) {
						%>
						<div class="form-group">
							<label for="<%="reason1-0" + i + "-0" + j%>"
								class="col-sm-2 control-label"><%="原因1-0" + i + "-0" + j + "："%></label>
							<div class="col-sm-6">
								<input type="text" class="form-control level3"
									id="<%="reason1-0" + i + "-0" + j%>"
									name="<%="reason1-0" + i + "-0" + j%>"
									value="<%out.print(request.getAttribute("reason1-0" + i + "-0" + j));%>">
							</div>
							<div class="col-sm-4 reasonbtn">
								<button class="btn btn-danger" type="button" id="delete3">删除</button>
							</div>
						</div>
						<%
												}
							} else {
								if(request.getAttribute("reason1-0" + i) != null) {
						%>
						<div class="form-group">
							<label for="<%="reason1-0" + i + "-" + j%>"
								class="col-sm-2 control-label"><%="原因1-0" + i + "-" + j + "："%></label>
							<div class="col-sm-6">
								<input type="text" class="form-control level3"
									id="<%="reason1-0" + i + "-" + j%>"
									name="<%="reason1-0" + i + "-" + j%>"
									value="<%out.print(request.getAttribute("reason1-0" + i + "-" + j));%>">
							</div>
							<div class="col-sm-4 reasonbtn">
								<button class="btn btn-danger" type="button" id="delete3">删除</button>
							</div>
						</div>
						<%
								}
							}
										} else {
											if (j < 10) {
												if(request.getAttribute("reason1-0" + i) != null) {
						%>
						<div class="form-group">
							<label for="<%="reason1-0" + i + "-0" + j%>"
								class="col-sm-2 control-label"><%="原因1-0" + i + "-0" + j + "："%></label>
							<div class="col-sm-6">
								<input type="text" class="form-control level3"
									id="<%="reason1-0" + i + "-0" + j%>"
									name="<%="reason1-0" + i + "-0" + j%>"
									value="<%out.print(request.getAttribute("reason1-0" + i + "-0" + j));%>">
							</div>
							<div class="col-sm-4 reasonbtn">
								<button class="btn btn-danger" type="button" id="delete3">删除</button>
							</div>
						</div>
						<%
												}
							} else {
								if(request.getAttribute("reason1-0" + i) != null) {
						%>
						<div class="form-group">
							<label for="<%="reason1-0" + i + "-" + j%>"
								class="col-sm-2 control-label"><%="原因1-0" + i + "-" + j + "："%></label>
							<div class="col-sm-6">
								<input type="text" class="form-control level3"
									id="<%="reason1-0" + i + "-" + j%>"
									name="<%="reason1-0" + i + "-" + j%>"
									value="<%out.print(request.getAttribute("reason1-0" + i + "-" + j));%>">
							</div>
							<div class="col-sm-4 reasonbtn">
								<button class="btn btn-danger" type="button" id="delete3">删除</button>
							</div>
						</div>
						<%
								}
							}
										}
									}
									i++;
						%>
					</c:forEach>
				</c:if>
				<div id="last" class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-success" id="createflowchart">生成流程图</button>
						<button type="button" class="btn btn-success" id="saveimg">保存图片</button>
					</div>
				</div>
				<div class="form-group" style="text-align:center;display:none;margin:0 auto;" id="showflowchart">						
						<canvas width="1200" height="600" id="canvas" ></canvas>					
				</div>
				<div class="form-group">
					<label for="solution1" class="col-sm-2 control-label">思路1：</label>
					<div class="col-sm-6">
						<textarea class="form-control" rows="4" id="solution1" name="solution1">${solution1 }</textarea>
					</div>
				</div>
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