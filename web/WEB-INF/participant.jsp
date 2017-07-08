<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
        <html lang="en">
        <head>
            <title>舆情分析大平台</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/css3/css1/bootstrap.min.css" />
        <link rel="stylesheet" href="css/css3/css1/matrix-style.css" />
        <link rel="stylesheet" href="css/css3/css1/matrix-media.css" />
        <link rel="stylesheet" href="css/css3/css1/common.css" />
        <link rel="stylesheet" href="css/css3/css1/eventAnalysis.css" />
        <link rel="stylesheet" href="css/css3/css1/other.css" />
        <link rel="stylesheet" href="css/css3/css1/style.css" />
        <link href="css/css3/font-awesome.min.css" rel="stylesheet">
        <link href="css/css3/templatemo-style.css" rel="stylesheet">
        <link href="css/css3/bootstrap.css" rel="stylesheet"/>
        <link href="css/css3/home.css" rel="stylesheet"/>
        <link href="css/css3/common.css" rel="stylesheet" />
        <link href="css/css3/bootstrap.css" rel="stylesheet">
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
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">欢迎用户</span><b class="caret"></b></a>
    <ul class="dropdown-menu">
    <li><a href="#"><i class="icon-user"></i>个人资料</a></li>
    <li class="divider"></li>
    <li><a href="#"><i class="icon-check"></i>我的任务</a></li>
    <li class="divider"></li>
    <li><a href="login.html"><i class="icon-key"></i>注销</a></li>
    </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">信息</span><b class="caret"></b></a>
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

    <!--start-top-serch-->
    <div id="search">
    <input type="text" placeholder="在此搜索...."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
    </div>
    <!--close-top-serch-->

    <!--sidebar-menu-->
    <div id="sidebar">
        <ul style="display: block;background: #2E363F;height: 800px;">
            <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
            <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
            <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
            <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
            <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
            <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
            <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
            <li><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i><span>舆情影响力</span></a></li>
            <li class="active"><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>网民参与度</span></a></li>
            <li><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>舆情负面指数</span></a></li>
        </ul>
    </div>
    <!--sidebar-menu-->
    <!--search start-->
    <div class="search-wrapper search-wrapper2">
        <form action="keywords" method="post">
            <div class="search" style="margin-left:300px;width:600px;margin-top:60px;">
                <span style="margin-left:100px;"><input type="text" class="keyWord searchkey" name="keywords"   maxlength="20"  id="search-keyword" value="事件关键词"></span>
                <span><button type="submit" class="searchBtn">搜索</button></span>
            </div>
        </form>
    </div>
    <!--search end-->
<!--main-container-part-->
<div id="content">
    <div id="content-header" style="margin-top:65px;">
        <h1>热点的网民参与度</h1>
    </div>
    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="widget-box">
                <div class="widget-title">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab1">全部</a></li>
                        <li><a data-toggle="tab" href="#tab2">豆瓣社区</a></li>
                        <li><a data-toggle="tab" href="#tab3">人民网社区</a></li>
                        <li><a data-toggle="tab" href="#tab4">搜狐社区</a></li>
                    </ul>
                </div>
                <!--全部热点网民  start-->
                <div style="width:1380px;" class="widget-content tab-content" >
                    <div id="tab1" class="tab-pane active">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                <c:forEach items="${tbNetizenParticiTop10}" var="h">
                                  <c:if test="${h.doubanGroupPost != null}">
                                    <li>
                                        <div class="tx"><img src="images/images3/1.jpg"></div>
                                        <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1">${h.doubanGroupPost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.doubanGroupPost.recommendNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                    </li>
                                  </c:if>
                                  <c:if test="${h.bbsPeoplePost !=null}">
                                    <li>
                                        <div class="tx"><img src="images/images3/01.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1">${h.bbsPeoplePost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsPeoplePost.priseNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                  </c:if>
                                   <c:if test="${h.bbsSohuPost !=null}">
                                     <li>
                                        <div class="tx"><img src="images/images3/001.jpg"></div>
                                         <p class="mscrame"><a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1">${h.bbsSohuPost.authorName}</a><a href="javascript:void(0)"><i class="W_icon"></i></a>
                                             <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                         </p>
                                         <p style="margin-top: 5px;"><span class="time">${h.bbsSohuPost.dateTime}</span><a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                         <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsSohuPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsSohuPost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                     </li>
                                   </c:if>
                                </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--全部热点网民  end-->
                    <!--豆瓣热点网民  start-->
                    <div id="tab2" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_douban}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/1.jpg"></div>
                                        <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="_blank" class="a1">${h.doubanGroupPost.authorName}</a><a href="javascript:void(0)"><i title="" class="W_icon "></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.doubanGroupPost.recommendNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                    </c:forEach>
                                </ul>

                            </div>
                        </div>
                    </div>
                    <!--豆瓣热点网民  end-->
                    <!--人民网社区热点网民  start-->
                    <div id="tab3" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_bbspeople}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/01.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="_blank" class="a1">${h.bbsPeoplePost.authorName}</a><a href="javascript:void(0)"><i title=" " class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsPeoplePost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--人民网社区热点网民  end-->
                    <!--搜狐社区热点网民 start-->
                    <div id="tab4" class="tab-pane">
                        <div class="wyqBorder wyqBorder2">
                            <div class="mwblist mwblist2" id="hotPeople">
                                <ul>
                                    <c:forEach items="${tbNetizenParticiTop10_bbssohu}" var="h">
                                    <li>
                                        <div class="tx"><img src="images/images3/001.jpg"></div>
                                        <p class="mscrame"><a href="${h.bbsSohuPost.authorHref}" target="_blank" class="a1">${h.bbsSohuPost.authorName}</a><a href="javascript:void(0)"><i title=" " class="W_icon"></i></a>
                                            <label style="float:right;color:orangered">参与度：${h.engagement}</label>
                                        </p>
                                        <p style="margin-top: 5px;"><span class="time">${h.bbsSohuPost.dateTime}</span><a href="${h.bbsSohuPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                                        <p class="msfs"><span class="float_l"><span><font class="f_c1">评论</font>&nbsp;${h.bbsSohuPost.commentNum}</span><span><font class="f_c1">点击</font>&nbsp;${h.bbsSohuPost.readNum+1}</span>&nbsp;&nbsp;<span><font class="f_c1">来源：</font>${h.websiteName}</span></span></p>

                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--搜狐社区热点网民 end-->
                </div>
            </div>
            <hr>
        </div>
    </div>
</div>
<!--JS-->
<script src="js/js3/js1/jquery.min.js"></script>
<script src="js/js3/js1/bootstrap.min.js"></script>
<script src="js/js3/js1/jquery.ui.custom.js"></script>
<script src="js/js3/js1/matrix.js"></script>
</body>
</html>
