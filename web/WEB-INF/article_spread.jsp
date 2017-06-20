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
<!--Header-part-->
<div id="header">
    <h1 style="font-family: 华文行楷;font-size: 27px;padding-top:10px;color: red;">舆情分析大平台</h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li class="dropdown" id="profile-messages"><a title="" href="#" data-toggle="dropdown"
                                                      data-target="#profile-messages" class="dropdown-toggle"><i
                class="icon icon-user"></i> <span class="text">欢迎用户</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="icon-user"></i>个人资料</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="icon-key"></i>注销</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages"
                                                   class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
                class="text">信息</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i>新信息</a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i>收信信箱</a></li>
                <li class="divider"></li>
                <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i>待发箱</a></li>
                <li class="divider"></li>
                <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i>回收站</a></li>
            </ul>
        </li>
        <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a>
        </li>
    </ul>
</div>

<!--start-top-serch-->
<div id="search">
    <input type="text" placeholder="在此搜索...."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->

<!--sidebar-menu-->

<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>分析</a>
    <ul style="display: block;background: #2E363F;height: 800px;">
        <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
        <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
        <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
        <li> <a href="sourceWebsiteStatistics?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
        <li class="active"><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
        <li><a href="authorIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>发布者指标</span></a></li>
        <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
        <%--<li><a href="sentiment.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>表情分析</span></a></li>--%>
        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>--%>
        <%--<ul>--%>
        <%--<li><a href="publish.html" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>--%>
        <%--<li><a href="sex.html" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>--%>
        <%--<li><a href="count.html" style="font-family: 新宋体;font-size: 18px;">统计</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="hotCorePeople.jsp" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>--%>
        <%--<li><a href="hot.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-pencil"></i><span>热门信息</span></a></li>--%>
        <%--<li><a href="data.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-file"></i><span>数据类型</span></a></li>--%>
        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-info-sign"></i> <span>发布</span> <span class="label label-important">3</span></a>--%>
        <%--<ul>--%>
        <%--<li><a href="weibo.html" style="font-family: 新宋体;font-size: 18px;">微博分布</a></li>--%>
        <%--<li><a href="area.html" style="font-family: 新宋体;font-size: 18px;">地域分布</a></li>--%>
        <%--<li><a href="device.html" style="font-family: 新宋体;font-size: 18px;">设备分布</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
    </ul>
</div>
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
