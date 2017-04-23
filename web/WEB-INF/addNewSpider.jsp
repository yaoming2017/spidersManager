<%--
  Created by IntelliJ IDEA.
  User: haoyang
  Date: 2017/4/22
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.sicdlib.dto.WebsiteEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html lang="en" style="height: 100%">

<head>
    <title>SocialMind底层配置管理平台</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/maruti-style.css" />
    <link rel="stylesheet" href="css/uniform.css" />
    <link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />

    <%--webuploader--%>
    <link rel="stylesheet" type="text/css" href="others/webuploader/webuploader.css">

</head>

<body style="height: 100%">

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
        <li class="active"><a href="index.html"><i class="icon icon-home"></i> <span>爬虫管理</span></a></li>
        <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>数据可视化</span></a> </li>
        <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>指标展示</span></a> </li>
    </ul>
</div>

<div id="content" style="height: 80%;">
    <div id="content-header">
        <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
    </div>
    <!--<div class="quick-actions_homepage">-->
    <!--<ul class="quick-actions">-->
    <!--<li>-->
    <!--<a href="#"> <i class="icon-dashboard"></i> 新增爬虫 </a>-->
    <!--</li>-->
    <!--<li>-->
    <!--<a href="#"> <i class="icon-shopping-bag"></i> 爬虫配置管理</a>-->
    <!--</li>-->
    <!--<li>-->
    <!--<a href="#"> <i class="icon-web"></i> 爬虫管理 </a>-->
    <!--</li>-->
    <!--</ul>-->
    <!--</div>-->
    <div class="container-fluid">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3"></div>
                <div class="span6">
                    <div class="widget-box">
                        <div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>
								</span>
                            <h5>新增爬虫</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <div class="form-horizontal">
                                <div class="control-group">
                                    <label class="control-label">爬虫名 :</label>
                                    <div class="controls"><input type="text" placeholder="First name" /></div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">网站 :</label>
                                    <div class="controls">
                                        <select>
                                            <c:forEach var="ws" items="${wsList}" varStatus="status">
                                                <option value="${ws.id}">${ws.websiteName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">爬虫源码 :</label>
                                    <div class="controls">
                                        <div class="uploader" id="uniform-undefined">
                                            <input id="picker" type="file" size="19" style="opacity: 0;">
                                            <span class="filename">No file selected
                                            </span>
                                            <span class="action">Choose File</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <button id="saveBtn" class="btn btn-success"> 保存 </button>
                                </div>
                            </div>
                        </div>
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

<script>
    var uploader = WebUploader.create({

        // swf文件路径
        swf : '<%=path%>/others/webuploader/Uploader.swf',

        // 文件接收服务端。
        server : 'saveSpider',

        auto : true,

        chunked : true,

        threads : 4,

        chunkRetry:4,  //分片上传失败之后的重试次数

        threads:3,  //上传并发数。允许同时最大3个上传进程
        //去重
        duplicate:true,

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick : '#picker',

        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize : false
    });

    $("#saveBtn").on('click', function() {
        if ($(this).hasClass('disabled')) {
            return false;
        }
//        uploader.options.formData.guid = Math.random();
        uploader.upload();

    });
</script>

<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/jquery.ui.custom.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/jquery.validate.js"></script>
<script src="<%=path%>/js/jquery.wizard.js"></script>
<script src="<%=path%>/js/maruti.js"></script>
<script src="<%=path%>/js/maruti.wizard.js"></script>
<script src="<%=path%>/js/maruti.form_common.js"></script>
<script src="<%=path%>/js/select2.min.js"></script>
<script src="<%=path%>/js/bootstrap-datepicker.js"></script>
<script src="<%=path%>/others/webuploader/webuploader.js"></script>
</body>

</html>
