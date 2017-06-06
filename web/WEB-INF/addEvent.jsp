<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
    <title>舆情分析大平台</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <%--<link rel="stylesheet" href="css/css1/common.css" />
    <link rel="stylesheet" href="css/css1/eventAnalysis.css" />
    <link rel="stylesheet" href="css/css1/other.css" />--%>
    <%--<link rel="stylesheet" href="css/css1/report.css" />--%>
    <link rel="stylesheet" href="css/css1/style.css" />
    <link rel="stylesheet" href="font-awesome/css/font-awesome.css" />

    <style>
        .quick-actions li{
            min-width : 0%;
        }
        .wyqBorder .mwblist2 > ul > li{
            width : 24%;
            height : 200px;
        }

    </style>
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
        <li  class="dropdown" id="profile-messages" >
            <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i><span class="text">欢迎用户</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="icon-user"></i>个人资料</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="icon-key"></i>注销</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">信息</span> <b class="caret"></b></a>
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
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<div id="search">
    <input type="text" placeholder="在此搜索...."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--sidebar-menu-->
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>分析</a>
    <ul style="display: block;background: #2E363F;height: 1150px;">
        <li class="active" style="font-family: 新宋体;font-size: 18px;"><a href="addEvent"><i class="icon icon-home"></i> <span>新增事件</span></a> </li>
        <li style="font-family: 新宋体;font-size: 18px;"><a href="eventsList"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
        <li><a href="comment.html" style="font-family: 新宋体;font-size:18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
        <li><a href="opinion.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>意见领袖</span></a> </li>
        <li><a href="transmission.html" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>传播途径</span></a></li>
        <li><a href="sentiment.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>表情分析</span></a></li>
        <li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>
            <ul>
                <li><a href="publish.html" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>
                <li><a href="sex.html" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>
                <li><a href="count.html" style="font-family: 新宋体;font-size: 18px;">统计</a></li>
            </ul>
        </li>
        <li><a href="communicate.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>
        <li><a href="hot.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-pencil"></i><span>热门信息</span></a></li>
        <li><a href="data.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-file"></i><span>数据类型</span></a></li>
        <li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-info-sign"></i> <span>分布</span> <span class="label label-important">3</span></a>
            <ul>
                <li><a href="weibo.html" style="font-family: 新宋体;font-size: 18px;">微博分布</a></li>
                <li><a href="area.html" style="font-family:新宋体;font-size: 18px;">地域分布</a></li>
                <li><a href="device.html"style="font-family: 新宋体;font-size: 18px;">设备分布</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
    <!--breadcrumbs-->
    <div id="content-header">
        <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a></div>
    </div>
    <!--End-breadcrumbs-->

    <!--Action boxes-->
    <div class="container-fluid">
        <!--事件简介 start-->
        <div class="row-fluid" id="ui-accordion-1" name="r1">
            <div class="widget-box">
                <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
                    <h1 style="font-family: 华文行楷;font-size:20px;">增加事件</h1>
                </div>
                <form action="<%=basePath%>eventSimiEssayList" method="post">
                    <div class="widget-content" style="font-size: 16px;width: 22%;">
                        <label>事件名称：</label>
                        <input type="text" name="eventName" style = "height:30px;" placeholder="新增事件...">
                        <div id="search" style="position:relative; float:right">
                            <button type="submit" class="tip-bottom" title="Search" style="margin-top: -6px;">
                                <i class="icon-ok icon-white"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="table table4 float_l echartAdpter2" id="tab">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="5%">事件名称</th>
                        <th width="20%">事件介绍</th>
                        <th width="20%">事件总结</th>
                        <th width="10%">事件开始时间</th>
                        <th width="10%">事件结束时间</th>
                        <th width="10%">事件峰值时间</th>
                        <th width="10%">事件峰值数量</th>
                        <th width="5%">事件趋势</th>
                    </tr>
                    </thead>
                    <tbody id="c5_top10" class="ui-sortable">
                    <c:forEach items="${events}" var="e">
                        <tr>
                            <td>${e.eventName}</td>
                            <td>${e.eventIntroduction}</td>
                            <td>${e.eventSummary}</td>
                            <td>${e.eventStartTime}</td>
                            <td>${e.eventEndTime}</td>
                            <td>${e.eventRushTime}</td>
                            <td>${e.eventRushNum}</td>
                            <td>${e.eventTrend}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <%--<div class="pagination-wrap">
                    <ul class="pagination">
                        <li><a href="publish.html?pageNo=1">1</a></li>
                        <li><a href="publish.html?pageNo=2">2</a></li>
                        <li><a href="publish.html?pageNo=3">3</a></li>
                        <li><a href="publish.html?pageNo=4">4</a></li>
                        <li><a href="publish.html?pageNo=5">5</a></li>
                        <li><a href="publish.html?pageNo=${page.nextPage}" aria-label="Next"><span aria-hidden="true"><i class="fa fa-play"></i></span></a></li>
                    </ul>
                </div>--%>
            </div>

        </div>
    </div>
</div>
</div>

</body>
</html>
