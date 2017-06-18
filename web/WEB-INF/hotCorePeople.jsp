<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>舆情分析大平台</title>
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
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i><span class="text">欢迎用户</span><b class="caret"></b></a>
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
  <input type="text" placeholder="在此搜索..."/>
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
        <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
        <li class="active"><a href="hotCorePeople?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热点网民</span></a></li>

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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a href="#" class="current">核心传播人</a> </div>
    <h1>核心传播人</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span6">
      </div>
        <div class="widget-box">
          <div class="widget-title">
            <ul class="nav nav-tabs">
                <li><a data-toggle="tab" class="active" href="#tab4">全部</a></li>
              <%--<li class="active"><a data-toggle="tab" href="#tab1">全部</a></li>--%>
              <li><a data-toggle="tab" href="#tab2">豆瓣小组</a></li>
                <li><a data-toggle="tab" href="#tab3">人民网BBS</a></li>
            </ul>
          </div>
          <div class="widget-content tab-content">
            <div id="tab4" class="tab-pane active">
              <div class="wyqBorder wyqBorder2">
                  <div class="mwblist" id="tab_modelTwo">
                  <ul>
                      <c:forEach items="${tableHotValuestop10}" var="h">
                          <c:if test="${h.doubanGroupPost != null}">
                              <li>
                                  <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg"></div>
                                  <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="io" class="a1">${h.doubanGroupPost.authorName}</a></p>
                                  <p class="msfs">
                                      <span><font class="f_c1">热度  </font>${h.hotValue}</span>
                                      <span><font class="f_c1">来源  </font>${h.websiteName}</span>
                                  </p>
                              </li>
                          </c:if>
                          <c:if test="${h.bbsPeoplePost != null}">
                              <li>
                                  <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg"></div>
                                  <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="io" class="a1">${h.bbsPeoplePost.authorName}</a></p>
                                  <p class="msfs">
                                      <span><font class="f_c1">热度  </font>${h.hotValue}</span>
                                      <span><font class="f_c1">来源  </font>${h.websiteName}</span>
                                  </p>
                              </li>
                          </c:if>
                      </c:forEach>
                  </ul>
                </div>
              </div>
            </div>

              <div id="tab2" class="tab-pane active">
                  <div class="wyqBorder wyqBorder2">
                      <div class="mwblist" id="tab_modelTwo">
                          <ul>
                              <c:forEach items="${tableHotValuestop10_doubans}" var="h">
                                  <li>
                                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg"></div>
                                      <p class="mscrame"><a href="${h.doubanGroupPost.authorHref}" target="io" class="a1">${h.doubanGroupPost.authorName}</a></p>
                                      <p class="msfs">
                                          <span><font class="f_c1">热度  </font>${h.hotValue}</span>
                                          <span><font class="f_c1">来源  </font>${h.websiteName}</span>
                                      </p>
                                  </li>
                              </c:forEach>
                          </ul>
                      </div>
                  </div>
              </div>

              <div id="tab3" class="tab-pane active">
                  <div class="wyqBorder wyqBorder2">
                      <div class="mwblist" id="tab_modelTwo">
                          <ul>
                              <c:forEach items="${tableHotValuestop10_bbsPeoples}" var="h">
                                  <li>
                                      <div class="tx"><img src="images/67be458fjw8exz23yekkwj2050050t8q.jpg"></div>
                                      <p class="mscrame"><a href="${h.bbsPeoplePost.authorHref}" target="io" class="a1">${h.bbsPeoplePost.authorName}</a></p>
                                      <p class="msfs">
                                          <span><font class="f_c1">热度  </font>${h.hotValue}</span>
                                          <span><font class="f_c1">来源  </font>${h.websiteName}</span>
                                      </p>
                                  </li>
                              </c:forEach>
                          </ul>
                      </div>
                  </div>
              </div>

              <div id="tab2" class="tab-pane">
              <div class="wyqBorder wyqBorder2">
                  <div class="mwblist" id="tab_modelThree">
                  <ul>
                      <li>
                          <div class="tx"><img src="images/006pEnUgjw8f39att90tkj30c80850tw.jpg"></div><p class="mscrame"><a href="http://weibo.com/5875830412/EiLSXxl78" target="io" class="a1">武汉生活小百科</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>680</span></p></li><li>
                      <div class="tx"><img src="images/8b082351jw8eo6t4xubmej2050050mx5.jpg"></div><p class="mscrame"><a href="http://weibo.com/2332566353/EiLKyj9JQ" target="io" class="a1">辣評娛樂圈</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>359</span></p></li><li>
                      <div class="tx"><img src="images/005TKu92jw8f5vnnwzp80j30kv0kygng.jpg"></div><p class="mscrame"><a href="http://weibo.com/5404441608/EiKzKEl4y" target="io" class="a1">呼和浩特微校园</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>189</span></p></li><li>
                      <div class="tx"><img src="images/8c3354b7gw1eo79h5fnbrj205005074h.jpg"></div><p class="mscrame"><a href="http://weibo.com/2352174263/EiKnXBQ5B" target="io" class="a1">娱大掌柜</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>168</span></p></li><li>
                      <div class="tx"><img src="images/db1747fcjw8ezkk2qznkkj20j90egwga.jpg"></div><p class="mscrame"><a href="http://weibo.com/3675736060/EiMPNFiEi" target="io" class="a1">西子丹67</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>130</span></p></li><li>
                      <div class="tx"><img src="images/006arEHwjw8f51xbphtn5j30e30dfdh1.jpg"></div><p class="mscrame"><a href="http://weibo.com/5651151666/EiLOFCjOU" target="io" class="a1">每日微博热门精选</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>122</span></p></li><li>
                      <div class="tx"><img src="images/7ccc87e2gw1ehbrm6mdbsj2050050q33.jpg"></div><p class="mscrame"><a href="http://weibo.com/2093778914/EiM3drBrm" target="io" class="a1">每日笑话微博</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>21</span></p></li><li>
                      <div class="tx"><img src="images/73b45dfejw1e8qgp5bmzyj2050050aa8.jpg"></div><p class="mscrame"><a href="http://weibo.com/1941200382/EiKiSkirU" target="io" class="a1">刘刚吃亏是福</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>18</span></p></li><li>
                      <div class="tx"><img src="images/7136220bjw8f8vgaqberqj20s20s2abn.jpg"></div><p class="mscrame"><a href="http://weibo.com/1899373067/EiKQIloyl" target="io" class="a1">白龙爷卍</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>15</span></p></li><li>
                      <div class="tx"><img src="images/9665d551jw1e8qgp5bmzyj2050050aa8.jpg"></div><p class="mscrame"><a href="http://weibo.com/2523256145/EiMvXvsSx" target="io" class="a1">郑州玩乐攻略</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>10</span></p></li><li>
                      <div class="tx"><img src="images/871c16b1jw8f9yxyms6gcj20ku0ku3zb.jpg"></div><p class="mscrame"><a href="http://weibo.com/2266764977/EiKDVdLZ1" target="io" class="a1">爆料潍坊</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>9</span></p></li><li>
                      <div class="tx"><img src="images/6264760ejw8f0w8zhbf74j20ku0kuwge.jpg"></div><p class="mscrame"><a href="http://weibo.com/1650750990/EiKhzouue" target="io" class="a1">看厦门</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>9</span></p></li><li>
                      <div class="tx"><img src="images/b60d4a83jw8elz379v4rfj20500503yl.jpg"></div><p class="mscrame"><a href="http://weibo.com/3054324355/EiQKiAUwg" target="io" class="a1">会看相的兔子</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>9</span></p></li><li>
                      <div class="tx"><img src="images/006gPo67jw8f7ysztm4c1j30ro0rpta1.jpg"></div><p class="mscrame"><a href="http://weibo.com/5745465731/EiK1i0cjZ" target="io" class="a1">八卦星扒客</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>8</span></p></li><li>
                      <div class="tx"><img src="images/4c88c75bjw1eajbvg4rapj20m90ewacv.jpg"></div><p class="mscrame"><a href="http://weibo.com/1284032347/EiM3BFimv" target="io" class="a1">姜岚昕</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>8</span></p></li><li>
                      <div class="tx"><img src="images/9287c5cejw8f4aam12iqfj205n03gt8k.jpg"></div><p class="mscrame"><a href="http://weibo.com/2458371534/EiN8KhPOF" target="io" class="a1">记者谈春平</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>7</span></p></li><li>
                      <div class="tx"><img src="images/b25c18c5jw8fa09ukvoezj20yi0yi76c.jpg"></div><p class="mscrame"><a href="http://weibo.com/2992380101/EiL5sgbud" target="io" class="a1">美丽沈阳</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li><li>
                      <div class="tx"><img src="images/5392eee7jw8f2kfsa8d5uj21kw16o48e.jpg"></div><p class="mscrame"><a href="http://weibo.com/1402138343/EiN8jn4yq" target="io" class="a1">李牧</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li><li>
                      <div class="tx"><img src="images/4cd0fbb5gw1f6uv3rhs8uj20fa0m80w7.jpg"></div><p class="mscrame"><a href="http://weibo.com/1288764341/EiR29wyhV" target="io" class="a1">苏渝</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li><li>
                      <div class="tx"><img src="images/97ec96aajw8el73xhs86aj205k05kwee.jpg"></div><p class="mscrame"><a href="http://weibo.com/2548864682/EiM3w6u0H" target="io" class="a1">笑话热门榜</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon_approve"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li>
                  </ul>
          </div>
        </div>
                </div>
              <div id="tab3" class="tab-pane">
                  <div class="wyqBorder wyqBorder2">
                      <div class="mwblist" id="tab_modelFour">
                      <ul>
                          <li>
                              <div class="tx"><img src="images/6bdf181ajw8eo6qtgboklj2050050aa3.jpg"></div><p class="mscrame"><a href="http://weibo.com/1809782810/EiM49FVIQ" target="io" class="a1">全娱乐爆料</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>421</span></p></li><li>
                          <div class="tx"><img src="images/e7d7aec0jw8f90ennhojlj20yi0yi76b.jpg"></div><p class="mscrame"><a href="http://weibo.com/3889671872/EiLG1iVQ4" target="io" class="a1">慕容妆主</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>234</span></p></li><li>
                          <div class="tx"><img src="images/75f1cd2bjw8evwt8xk6bkj20v90v9ta7.jpg"></div><p class="mscrame"><a href="http://weibo.com/1978780971/EiMZC7Maq" target="io" class="a1">会拍照的眼睛爱搞笑</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>161</span></p></li>
                          <li><div class="tx"><img src="images/798c65fcjw8f7ya38ftcpj20yi0xeac0.jpg"></div><p class="mscrame"><a href="http://weibo.com/2039244284/EiLMgnb9g" target="io" class="a1">段小姐读段子</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>144</span></p></li>
                          <li><div class="tx"><img src="images/b22c6427jw8f7gcp0eloaj20yi0zctb8.jpg"></div><p class="mscrame"><a href="http://weibo.com/2989253671/EiKz5frsv" target="io" class="a1">超级减肥王_小悦悦</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>66</span></p></li>
                          <li><div class="tx"><img src="images/006hHB37jw8f3vocw4g8dj3050050aa5.jpg"></div><p class="mscrame"><a href="http://weibo.com/5758385229/EiPRI2aTt" target="io" class="a1">全球猎奇视频</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>53</span></p></li>
                          <li><div class="tx"><img src="images/006dYpQ1jw8ew73vptrvpj31d81d8qk1.jpg"></div><p class="mscrame"><a href="http://weibo.com/5703288365/EiRzBjZTO" target="io" class="a1">悬疑</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>38</span></p></li>
                          <li><div class="tx"><img src="images/897695b0gw1f8pa2y4fn1j20bx0go0v5.jpg"></div><p class="mscrame"><a href="http://weibo.com/2306250160/EiM21zbj0" target="io" class="a1">娱乐明星坊</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>36</span></p></li>
                          <li><div class="tx"><img src="images/659daeadjw8f3u5ztuh73j20yi0yigmj.jpg"></div><p class="mscrame"><a href="http://weibo.com/1704832685/EiLgSgwGI" target="io" class="a1">happy热哥</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>22</span></p></li>
                          <li><div class="tx"><img src="images/006CvBXfjw8f9rv7q0yhuj30ku0kuq35.jpg"></div><p class="mscrame"><a href="http://weibo.com/6065831829/EiKTp0frO" target="io" class="a1">一锅水煮娱</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>20</span></p></li>
                          <li><div class="tx"><img src="images/006qQ5oHjw8f808jtzbhlj30ru0ruabp.jpg"></div><p class="mscrame"><a href="http://weibo.com/5893395535/EiRajEHPl" target="io" class="a1">搞笑小樱桃</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>14</span></p></li>
                          <li><div class="tx"><img src="images/006yMFz9jw8f9s04kff64j30e50e8jro.jpg"></div><p class="mscrame"><a href="http://weibo.com/6010791943/EiNDBwYFA" target="io" class="a1">一条小资讯</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li>
                          <li><div class="tx"><img src="images/006x5VwMjw8f84qxvbvkmj30ro0rojte.jpg"></div><p class="mscrame"><a href="http://weibo.com/5985828860/EiMs2oIeJ" target="io" class="a1">蓝色大海的传说官博资源</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li>
                          <li><div class="tx"><img src="images/head_pic.jpg"></div><p class="mscrame"><a href="http://weibo.com/5559884641/EiKRY10p0" target="io" class="a1">LYandYN</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>6</span></p></li>
                          <li><div class="tx"><img src="images/006jDx2Yjw8f20do4z7l5j30yi0yiq4p.jpg"></div><p class="mscrame"><a href="http://weibo.com/5786969204/EiLZzmOnH" target="io" class="a1">修正美添白Ada彩虹团队创始人</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>5</span></p></li>
                          <li><div class="tx"><img src="images/bed72095jw1e8qgp5bmzyj2050050aa8.jpg"></div><p class="mscrame"><a href="http://weibo.com/3201769621/EiKus5eds" target="io" class="a1">李敖观天下</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>5</span></p></li>
                          <li><div class="tx"><img src="images/51367a6ejw8f0atm1n90vj20ro0rptam.jpg"></div><p class="mscrame"><a href="http://weibo.com/1362524782/EiL7vCYpg" target="io" class="a1">芳菲7989</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>5</span></p></li>
                          <li><div class="tx"><img src="images/0064J1W2jw1f9weds1adnj30m80m8djv.jpg"></div><p class="mscrame"><a href="http://weibo.com/5566634538/EiLpwzjSN" target="io" class="a1">杨洋Ic0cn</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>4</span></p></li>
                          <li><div class="tx"><img src="images/6bab1acejw8f3gd1kd3lrj20yi0yiwgz.jpg"></div><p class="mscrame"><a href="http://weibo.com/1806375630/EiL8JwDkO" target="io" class="a1">揭秘网红</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>4</span></p></li>
                          <li><div class="tx"><img src="images/default_avatar_male_180.gif"></div><p class="mscrame"><a href="http://weibo.com/6072544839/EiL3e1U4w" target="io" class="a1">用户6072544839</a> <a href="http://company.verified.weibo.com/verify/orgapply"><i title="微博个人认证" class="W_icon icon"></i></a></p><p class="msfs"><span><font class="f_c1">转发数  </font>3</span></p></li>
                      </ul>
                  </div>
              </div>
      </div>
              <div id="tab4" class="tab-pane">
                  <div class="wyqBorder wyqBorder2">
                      <div class="mwblist" id="tab_modelOne" >
                      <div align="center" style="padding-top:50px"><p style="display:inline;font-size: 14px">
                          <img src="images/warn.png" style="width:60px"><br>此时间段暂无信息</p></div>
                      </div>
                 </div>
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
