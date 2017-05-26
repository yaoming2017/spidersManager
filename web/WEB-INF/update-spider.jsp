<%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017/5/5
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>SocialMind底层配置管理平台</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/maruti-style.css" />
    <link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />
</head>

<body>

<!--Header-part-->
<div id="header">
    <h1><a href="http://www.mafiashare.net">SocialMind底层配置管理平台</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-messaages-->
<div class="btn-group rightzero">
    <a class="top_message tip-left" title="Manage Files">
        <i class="icon-file">

        </i>
    </a>
    <a class="top_message tip-bottom" title="Manage Users">
        <i class="icon-user">

        </i>
    </a>
    <a class="top_message tip-bottom" title="Manage Comments">
        <i class="icon-comment">

        </i>
        <span class="label label-important">5</span>
    </a>
    <a class="top_message tip-bottom" title="Manage Orders">
        <i class="icon-shopping-cart">

        </i>
    </a>
</div>
<!--close-top-Header-messaages-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li class=""><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
        <!--<li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>-->
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Login</span></a></li>
    </ul>
</div>
<div id="search">
    <input type="text" placeholder="Search here..." />
    <button type="submit" class="tip-left" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-Header-menu-->

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> 爬虫管理</a>
    <ul>
        <li class="active"><a href="event.jsp"><i class="icon icon-home"></i> <span>爬虫管理</span></a></li>
        <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>数据可视化</span></a> </li>
        <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>指标展示</span></a> </li>
    </ul>
</div>

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> <a href="event.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span3"></div>
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title">
                            <span class="icon">
									<i class="icon-pencil"></i>
								</span>
                        <h5>修改信息</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form class="form-horizontal" method="post" action="updateSpider" onsubmit="validateSpiderName()">
                            <input id="spiderID" name="spiderID" type="hidden" hidden="hidden" value="${spiderID}">
                            <div class="control-group">
                                <label class="control-label">爬虫名</label>
                                <div class="controls">
                                    <input id="spiderName" type="text" name="spiderName" value="${spiderInfo[0].spiderName}" onblur="validateSpiderName()"/>
                                    <label id="prompt_spider_name" style="font-size: 9px;display: none"></label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">网站名称</label>
                                <div class="controls">
                                    <select id="website-name" onchange="siteChange()" name="website-name">
                                        <c:forEach items="${websiteList}" var="website" varStatus="status">
                                            <c:choose>
                                                <c:when test="${website.id == spiderInfo[1].id}">
                                                    <option value="${website.id}" selected="selected" type-data="${website.websiteType}">${website.websiteName}
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${website.id}" type-data="${website.websiteType}">${website.websiteName}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">网站类型</label>
                                <div class="controls ">
                                    <input id="websiteType" name="websiteType" readonly="readonly" type="text" value="${spiderInfo[1].websiteType}">
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">保存</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row-fluid">
    <div id="footer" class="span12"> 2017 &copy; <a href="http://www.SICD.com/" target="_blank" title="SICD">SICD</a> - Collect from <a href="http://www.baidu.com/"
                                                                                                                                        title="Social Mind" target="_blank">Social Mind</a> </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/jquery.wizard.js"></script>
<script src="js/maruti.js"></script>
<script src="js/maruti.wizard.js"></script>
<script src="js/maruti.form_common.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>

<script>
    var checkSpiderName = false;
    function siteChange() {
        var siteType = $("#website-name").find("option:selected").attr("type-data");
        $("#websiteType").val(siteType);
    }

    function validateSpiderName() {
        var spiderName = $("#spiderName").val();

        if(spiderName == "" || spiderName.trim() == "") {
            $("#prompt_spider_name").html("爬虫名不能为空！！");
            $("#prompt_spider_name").css("display", "inline");
            $("#prompt_spider_name").css("color", "red");
            $("#prompt_spider_name").css("font-size", "14px");

            checkSpiderName = false;

            return false;
        } else {
            $("#prompt_spider_name").html("");
            $("#prompt_spider_name").css("display", "inline");

            checkSpiderName = true;
            return true;
        }
    }
</script>

</body>

</html>
