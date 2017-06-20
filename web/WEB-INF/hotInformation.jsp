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
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="css/css1/common.css" />
  <link rel="stylesheet" href="css/css1/eventAnalysis.css" />
  <link rel="stylesheet" href="css/css1/other.css" />
  <link rel="stylesheet" href="css/css1/report.css" />
  <link rel="stylesheet" href="css/css1/style.css" />
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
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>分析</a>
  <ul style="display: block;background: #2E363F;height: 800px;">
    <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
    <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
    <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
    <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
    <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
    <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
    <li class="active"><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
    <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>
    <%--<ul>--%>
    <%--<li><a href="publish.html" style="font-family: 新宋体;font-size: 18px;">博主分析</a></li>--%>
    <%--<li><a href="sex.html" style="font-family: 新宋体;font-size: 18px;">男女比例</a></li>--%>
    <%--<li><a href="count.html" style="font-family: 新宋体;font-size: 18px;">统计</a></li>--%>
    <%--</ul>--%>
    <%--</li>--%>
    <%--<li><a href="hotCorePeople.jsp" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>核心传播人</span></a></li>--%>
    <%--<li><a href="hotInformation.jsp" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-pencil"></i><span>热门信息</span></a></li>--%>
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
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a href="#" class="current">热门信息</a> </div>
    <h1>热门信息</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span6">
      </div>
        <div class="widget-box">
          <div class="widget-title">
            <ul class="nav nav-tabs">
              <li class="active"><a data-toggle="tab">全部热门信息</a></li>
              <li><a data-toggle="tab" href="#tab2">豆瓣小组 热门信息</a></li>
              <li><a data-toggle="tab" href="#tab3">人民网BBS 热门信息</a></li>
              <%--<li><a data-toggle="tab" href="#tab5">新华网 热门信息</a></li>--%>
            </ul>
          </div>
          <div class="widget-content tab-content">
            <div id="tab1" class="tab-pane active">
              <div class="wyqBorder wyqBorder2">
              <div class="mwblist mwblist2" id="hotList">
              <ul>
                <c:forEach items="${tableHotValuestop10}" var="h">
                  <c:if test="${h.doubanGroupPost != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="${h.doubanGroupPost.authorHref}" class="a1">${h.doubanGroupPost.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.doubanGroupPost.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      <p class="msfs"><span class="float_l"><span><font class="f_c1">喜欢</font>&nbsp;${h.doubanGroupPost.likeNum}</span><span><font class="f_c1">推荐</font>&nbsp;${h.doubanGroupPost.recommendNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span></span></p>
                    </li>
                  </c:if>

                  <c:if test="${h.bbsPeoplePost != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="${h.bbsPeoplePost.authorHref}" class="a1">${h.bbsPeoplePost.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.bbsPeoplePost.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      <p class="msfs"><span class="float_l"><span><font class="f_c1">阅读</font>&nbsp;${h.bbsPeoplePost.readNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">回复</font>&nbsp;${h.bbsPeoplePost.replyNum}</span><span><font class="f_c1">打赏</font>&nbsp;${h.bbsPeoplePost.priseNum}</span></span></p>
                    </li>
                  </c:if>

                  <c:if test="${h.xinhuaNews != null}">
                    <li class="hotIn">
                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                      <p class="mscrame">
                        <a target="_blank" href="" class="a1">${h.xinhuaNews.authorName}</a>
                        <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                      </p>
                      <p class="wbText">${h.xinhuaNews.content}</p>
                      <p style="margin-top: 5px;"><span class="time">${h.xinhuaNews.dateTime}</span><a href="${h.xinhuaNews.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                    </li>
                  </c:if>

                </c:forEach>
              </ul>
            </div>
          </div>
        </div>

            <div id="tab2" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>

                    <c:forEach items="${tableHotValuestop10_doubans}" var="h">
                        <li class="hotIn">
                          <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                          <p class="mscrame">
                            <a target="_blank" href="${h.doubanGroupPost.authorHref}" class="a1">${h.doubanGroupPost.authorName}</a>
                            <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                          </p>
                          <p class="wbText">${h.doubanGroupPost.content}</p>
                          <p style="margin-top: 5px;"><span class="time">${h.doubanGroupPost.dateTime}</span><a href="${h.doubanGroupPost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                          <p class="msfs"><span class="float_l"><span><font class="f_c1">喜欢</font>&nbsp;${h.doubanGroupPost.likeNum}</span><span><font class="f_c1">推荐</font>&nbsp;${h.doubanGroupPost.recommendNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.doubanGroupPost.commentNum}</span></span></p>
                        </li>
                    </c:forEach>

                  </ul>
                </div>
                </div>
              </div>
            <div id="tab3" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>
                    <c:forEach items="${tableHotValuestop10_bbsPeoples}" var="h">
                      <li class="hotIn">
                        <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                        <p class="mscrame">
                          <a target="_blank" href="${h.bbsPeoplePost.authorHref}" class="a1">${h.bbsPeoplePost.authorName}</a>
                          <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                        </p>
                        <p class="wbText">${h.bbsPeoplePost.content}</p>
                        <p style="margin-top: 5px;"><span class="time">${h.bbsPeoplePost.dateTime}</span><a href="${h.bbsPeoplePost.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                        <p class="msfs"><span class="float_l"><span><font class="f_c1">阅读</font>&nbsp;${h.bbsPeoplePost.readNum}</span><span><font class="f_c1">评论</font>&nbsp;${h.bbsPeoplePost.commentNum}</span><span><font class="f_c1">回复</font>&nbsp;${h.bbsPeoplePost.replyNum}</span><span><font class="f_c1">打赏</font>&nbsp;${h.bbsPeoplePost.priseNum}</span></span></p>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>
            <%--<div id="tab5" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                <div class="mwblist mwblist2" id="hotList">
                  <ul>
                    <c:forEach items="${tableHotValuestop10_xinhuanews}" var="h">
                      <li class="hotIn">
                        <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg">${h.websiteName}</div>
                        <p class="mscrame">
                          <a target="_blank" href="" class="a1">${h.xinhuaNews.authorName}</a>
                          <label style="float:right;color:orangered">热度:${h.hotValue}</label>
                        </p>
                        <p class="wbText">${h.xinhuaNews.content}</p>
                        <p style="margin-top: 5px;"><span class="time">${h.xinhuaNews.dateTime}</span><a href="${h.xinhuaNews.url}" target="_blank" class="wblink"><i></i>原文链接</a></p>
                      </li>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>--%>

          </div>
    </div>
    <hr>
  </div>
</div>
<!--main-container-part-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/matrix.js"></script>
</body>
</html>
