<%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017/6/6
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>舆情分析大平台</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="static/fore_header.jsp"/>
<!--sidebar-menu-->
<jsp:include page="static/fore_lefter.jsp">
    <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
</jsp:include>
<!--sidebar-menu-->

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a
                href="#" class="current">文章传播图</a></div>
        <h1>文章传播分析</h1>
        <hr>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 1400px;height: 800px;"></div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js1/echarts.min.js"></script><!--引入echarts.js-->
<script src="js/js1/echarts-wordcloud.min.js"></script>
<script  type="text/javascript">
    //基于准备好的dom,初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));
    //指定图表的配置项和数据

    var category = JSON.parse('${category}');
    var nodesAndEdges = JSON.parse('${nodesAndEdges}');

    var nodes = nodesAndEdges['nodes'];
    var edges = nodesAndEdges['edges'];

    var titleMap = new Map();
    var numMap = new Map();
    var tableMap = new Map();
    var data = [];
    for (var i =0; i < nodes.length; i++) {
        titleMap.set(nodes[i]['id'], nodes[i]['title']);
        numMap.set(nodes[i]['id'], nodes[i]['num']);
        tableMap.set(nodes[i]['id'], nodes[i]['table']);

        data.push({
            "name": nodes[i]['id'],
            "symbolSize": (nodes[i]['num'] + 1) * 3,
            "draggable": true,
            "value": nodes[i]['title'],
            "category": nodes[i]['website'],
            "label": {
                "normal": {
                    "show": true
                }
            }
        });
    }

    option = {
        tooltip: {
            show: true,
            position: function (pos, params, dom, rect, size) {
                // 鼠标在左侧时 tooltip 显示到右侧，鼠标在右侧时 tooltip 显示到左侧。
                var obj = {top: 60};
                obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 5;
                return obj;
            },
            hideDelay: 250,
            formatter: function (params, ticket, callback) {
                var result = '';
                if (params.dataType == 'node') {
                    var id = params.name;
                    result = "<span style='color: sienna'>标题：</span> " + titleMap.get(id).replace(/(.{25})/g,'$1<br />') + "<br />";
                    result += "<span style='color: #1e23d5'>相关文章数：</span> ";
                    result += numMap.get(id);
                    result += "<br />";

//                    $.get('tooltipContent?table=' + tableMap.get(id) + '&articleID=' + id, function (content) {
//                        result += content;
//                        callback(ticket, result);
//                    });
                    $.ajax({
                        type : "post",
                        url : "tooltipContent",
                        data : {'table' : tableMap.get(id), 'articleID' : id},
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        success : function (msg) {
                            var content = msg.replace(/(.{30})/g,'$1<br />'); //换行显示
                            result += content;
                            callback(ticket, result);
                        },
                        error : function (msg) {
                            alert(msg)
                        }
                    });
                    return 'Loading';
                } else {
                    var src_id = params.data.source;
                    var tar_id = params.data.target;
                    result = "<span style='color: #b90c25'>source:</span> " + titleMap.get(src_id) + "  <span style='color: #5eb95e'>" + numMap.get(src_id) + "</span>";
                    result += "<br />"
                    result += "<span style='color: #d54ac9'>target: </span>" + titleMap.get(tar_id) + "  <span style='color: #5eb95e'>" + numMap.get(tar_id) + "</span>";

                    return result;
                }
            }
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    show: true,
                    readOnly: true
                },
                restore: {
                    show: true
                },
                saveAsImage: {
                    show: true
                }
            }
        },
        animationDuration: 1500,
        animationEasingUpdate: 'quinticInOut',
        series: [{
//            name: '媒体',
            type: 'graph',
            layout: 'force',

            force: {
                initLayout:'circular',
                edgeLength: 50,
                repulsion: 50,
                gravity: 0.2,
                layoutAnimation : true
            },
            data: data,
            edges: edges,
            categories: category,
            focusNodeAdjacency: true,
            roam: true,
            label: {
                normal: {
                    textStyle: {
                        color: ["#327df8"]
                    },
                    show: true,
                    position: 'right',
                    formatter: '{c}'
                }
            },
            edgeSymbol:['none', 'arrow'],
            lineStyle: {
                normal: {
                    color: {
                        type: 'linear',
                        x: 0,
                        y: 0,
                        x2: 0,
                        y2: 1,
                        colorStops: [{
                            offset: 0, color: 'black' // 0% 处的颜色
                        }, {
                            offset: 1, color: 'blue' // 100% 处的颜色
                        }],
                        globalCoord: false // 缺省为 false
                    },
                    width: 2
                }
            }
        }]
    };
    myChart.setOption(option)
</script>
</body>
</html>
