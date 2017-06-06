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
        <li><a href="event?eventID=" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件</span></a> </li>
        <li><a href="hotWords?eventID=" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
        <li> <a href="sourceWebsiteStatistics?eventID=" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
        <li class="active"><a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
        <%--<li><a href="sentiment.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>表情分析</span></a></li>--%>
        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>--%>
        <%--<ul>--%>
        <%--<li><a href="publish.html" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>--%>
        <%--<li><a href="sex.html" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>--%>
        <%--<li><a href="count.html" style="font-family: 新宋体;font-size: 18px;">统计</a></li>--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="communicate.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>--%>
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
                href="#" class="current">媒体来源比例分析</a></div>
        <h1>媒体来源比例分析</h1>
        <hr>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 1200px;height: 600px;"></div>
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

    var data = [
        {
            "name": "宇哥考研",
            "symbolSize": 27,
            "draggable": "True",
            "value": "ssss",
            "category": "宇哥考研",
            "label": {
                "normal": {
                    "show": "True"
                }
            }
        },
        {
            "name": "张宇考研图书交流论坛",
            "symbolSize": 35,
            "draggable": "True",
            "value": "wqer",
            "category": "张宇考研图书交流论坛",
            "label": {
                "normal": {
                    "show": "True"
                }
            }
        },
        {
            "name": "悠悠伟心",
            "symbolSize": 5,
            "draggable": "False",
            "value": 1,
            "category": "悠悠伟心",
            "label": {
                "normal": {
                    "show": "True"
                }
            }
        },
        {
            "name": "晓艳考研",
            "symbolSize": 5,
            "draggable": "False",
            "value": 1,
            "category": "晓艳考研",
            "label": {
                "normal": {
                    "show": "True"
                }
            }
        },
        {
            "name": "胖子不是壮士",
            "symbolSize": 5,
            "draggable": "False",
            "value": 1,
            "category": "胖子不是壮士",
            "label": {
                "normal": {
                    "show": "True"
                }
            }
        },
        {
            "name": "吕小越越越",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "Ada哞哞",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "小含页",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "不搞事boy",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "暴走de影魔",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "Cen笔中情",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "宇哥考研"
        },
        {
            "name": "萌萌哒的贝吉塔丶",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "love_binguo",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "悬空空空",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "___考研喵",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "宇哥考研"
        },
        {
            "name": "爱启航在线考研",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "灼卓燃烧的蔬菜",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "宇哥考研"
        },
        {
            "name": "lovely小倩儿",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "美丽大方的周小颖",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "YoungLani",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "小破孩1057",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "agitte",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "老妖家风七",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "宇哥考研"
        },
        {
            "name": "薯条FF",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "宇哥考研o",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "i寒霜",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "有一颗心叫良心",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "张宇考研图书交流论坛"
        },
        {
            "name": "2018我要去成都啊",
            "symbolSize": 5,
            "draggable": "False",
            "value": 0,
            "category": "宇哥考研"
        }]
    var links = [
        {
            "source": "宇哥考研",
            "target": "Bob_bOb_boB_"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "宇哥考研",
            "target": "仔细思考晚上该吃"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "TubeChen"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "7SeVen启程"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "独自一人奔未来"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "用户6045119904"
        },
        {
            "source": "宇哥考研",
            "target": "Slade灬Willson"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇宙区区长"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "BelieveMonster"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "GT好好学英语吧"
        },
        {
            "source": "宇哥考研",
            "target": "Leanna_ZL"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "追着光影奔跑的小裤衩"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "能做的只有珍惜"
        },
        {
            "source": "宇哥考研",
            "target": "ONB_brave"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "yiyuanymyf"
        },
        {
            "source": "宇哥考研",
            "target": "LESSSSSSSSON"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "一只特立独行的朱朱朱"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "风太大我当你傻"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "风太大我当你傻"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "lyf8797"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "风太大我当你傻"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "汉子琳Lin"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "Astrorical"
        },
        {
            "source": "宇哥考研",
            "target": "睡得头痛"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "ELSA0720"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "原来的原本wyju"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "姜旭57150"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "用户5311839154"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "l颢影"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "Powerful朱海"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "Chen晓敏xs"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "可能真的是小仙女"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "今有心兮"
        },
        {
            "source": "宇哥考研",
            "target": "谢东33198"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "宇哥考研"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "武大_颖"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "yuzuodeyunwcj"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "DesignedSpark"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "八点半的光"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "是李婧瑶呀"
        },
        {
            "source": "晓艳考研",
            "target": "陈滋凯亚厉克斯"
        },
        {
            "source": "张宇考研图书交流论坛",
            "target": "晓艳考研"
        }];

    var categories = [
        {
            "name": "宇哥考研"
        },
        {
            "name": "张宇考研图书交流论坛"
        },
        {
            "name": "悠悠伟心"
        },
        {
            "name": "晓艳考研"
        },
        {
            "name": "胖子不是壮士"
        }
    ];

    var cont = 'a'
    var mid = 'b'
    var user1 = 'c'
    option = {
//
//        title: {
//            text: "微博转发关系图",
//            subtext: '@' + user1 + ':' + cont,
//            sublink: 'http://m.weibo.cn/status/' + mid,
//            top: "top",
//            left: "center"
//        },

        tooltip: {},

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
            name: '微博',
            type: 'graph',
            layout: 'force',

            force: {
                //initLayout:'circular'
                edgeLength: 50,
                repulsion: 50,
                gravity: 0.2
            },
            data: data,
            edges: links,
            categories: categories,
            focusNodeAdjacency: true,
            roam: true,
            label: {
                normal: {
                    position: 'right',
                    formatter: '{b}'
                }
            },
            edgeSymbol: 'arrow',
            lineStyle: {
                normal: {
                    // color: 'target',
                    curveness: 0
                }
            }
        }]
    };
    myChart.setOption(option)
</script>
</body>
</html>
