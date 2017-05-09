<%--
  Created by IntelliJ IDEA.
  User: haoyang
  Date: 2017/4/20
  Time: 10:08
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
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="css/fullcalendar.css"/>
    <link rel="stylesheet" href="css/maruti-style.css"/>
    <link rel="stylesheet" href="css/maruti-media.css" class="skin-color"/>
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
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span
                class="text">Login</span></a></li>
    </ul>
</div>
<div id="search">
    <input type="text" placeholder="Search here..."/>
    <button type="submit" class="tip-left" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-Header-menu-->

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> 爬虫管理</a>
    <ul>
        <li class="active"><a href="index.html"><i class="icon icon-home"></i> <span>爬虫管理</span></a></li>
        <li><a href="charts.html"><i class="icon icon-signal"></i> <span>数据可视化</span></a></li>
        <li><a href="widgets.html"><i class="icon icon-inbox"></i> <span>指标展示</span></a></li>
    </ul>
</div>

<div id="content" style="height: 80%;">
    <div id="content-header">
        <div id="breadcrumb"><a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>
            Home</a></div>
    </div>

    <div class="row-fluid">
        <div class="span3"></div>
        <div class="span6">
            <div class="widget-box">
                <div class="widget-title">
                    <span class="icon">
                        <i class="icon-align-justify"></i>
                    </span>
                    <h5>新增网站</h5>
                </div>
                <div class="widget-content nopadding">
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label">网站名称</label>
                            <div class="controls">
                                <input type="text" name="websiteName" id="websiteName" onblur="checkSiteName()" placeholder="网站名称"/>
                                <label id="prompt_site_name" ></label>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">URL</label>
                            <div class="controls">
                                <input name="websiteUrl" type="text" id="websiteUrl" onblur="checkSiteUrl()" placeholder="url"/>
                                <label id="prompt_site_url" style="font-size: 9px;display: none"></label>
                            </div>

                        </div>
                        <div class="control-group">
                            <label class="control-label">网站类型</label>
                            <div class="controls ">
                                <select id="siteType" name="websiteType">
                                    <c:forEach var="site" items="${siteVlaue}" varStatus="status">
                                        <option value="${site}">${site}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-actions">
                            <button onclick="saveWS();" class="btn btn-success">保存</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div id="footer" class="span12"> 2017 &copy; <a href="http://www.SICD.com/" target="_blank" title="SICD">SICD</a> -
        Collect from <a href="http://www.baidu.com/"
                        title="Social Mind" target="_blank">Social Mind</a></div>
</div>

<script>
    var validate_url = false;
    var validate_name = false;
    function saveWS(){
        var website = {};

//        var websiteName = $("#websiteName").val();
//        var websiteUrl = $("#websiteUrl").val();
//        var siteType = $("#siteType").val();
        website['websiteType'] = $("#siteType").val();
        website['websiteName'] = $("#websiteName").val();
        website['websiteUrl'] = $("#websiteUrl").val();

        if(!validate_url || !validate_name) {
            alert("输入不正确");
            return false;
        } else {
            $.ajax({
                async : false,//将async设置为false,才能使得return 返回true/false有效
                type : 'post',
                url : 'saveWebsite',
                data: website,
                success : function (msg){
                    if(msg == 'success'){
                        alert("添加成功");
                    }else{
                        alert("添加失败");
                    }
                }
            });
        }
    }

    function checkSiteName() {
        var siteName = $("#websiteName").val();
        var flag = 0;

        if(siteName == "") {
            $("#prompt_site_name").html("网站名称不能为空！！");
            $("#prompt_site_name").css("display", "inline");
            $("#prompt_site_name").css("color", "red");
            $("#prompt_site_name").css("font-size", "14px");

            validate_name = false;

            return false;
        }

        $.ajax({
            type : 'post',
            url : 'checkSiteName?siteName=' + siteName,
            success : function (msg) {
                if(msg == "exist") {
                    $("#prompt_site_name").html("网站名称已存在！！");
                    $("#prompt_site_name").css("display", "inline");
                    $("#prompt_site_name").css("color", "red");
                    $("#prompt_site_name").css("font-size", "14px");
                    validate_name = false;
                } else {
                    $("#prompt_site_name").html("");
                    $("#prompt_site_name").css("display", "inline");
                    validate_name = true;
                    flag = 0;
                }
            }
        });

        if(flag == 1) {
            return false;
        } else {
            return true;
        }
    }

    function checkSiteUrl() {
        var siteUrl = $("#websiteUrl").val();

        if(siteUrl == "") {
            $("#prompt_site_url").html("Url不能为空！！");
            $("#prompt_site_url").css("display", "inline");
            $("#prompt_site_url").css("color", "red");
            $("#prompt_site_url").css("font-size", "14px");
            validate_url = false;

            return false;
        }

        var is_url = isUrl(siteUrl);

        if(!is_url) {
            $("#prompt_site_url").html("不是正确的URL！！");
            $("#prompt_site_url").css("display", "inline");
            $("#prompt_site_url").css("color", "red");
            $("#prompt_site_url").css("font-size", "14px");
            validate_url = false;

            return false;
        }

        $.ajax({
            type : 'post',
            url : 'checkSiteUrl?siteUrl=' + siteUrl,
            success : function (msg) {
                if(msg == "exist") {
                    $("#prompt_site_url").html("网站URL已存在！！");
                    $("#prompt_site_url").css("display", "inline");
                    $("#prompt_site_url").css("color", "red");
                    $("#prompt_site_url").css("font-size", "14px");
                    validate_url = false;
                    return false;
                } else {
                    $("#prompt_site_url").html("");
                    $("#prompt_site_url").css("display", "inline");
                    validate_url = true;
                    return true;
                }
            }
        });
    }

    function isUrl(str_url) {
        var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
            + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
            + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
            + "|" // 允许IP和DOMAIN（域名）
            + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
            + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
            + "[a-z]{2,6})" // first level domain- .com or .museum
            + "(:[0-9]{1,4})?" // 端口- :80
            + "((/?)|" // a slash isn't required if there is no file name
            + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        var re=new RegExp(strRegex);
        //re.test()
        if (re.test(str_url)){
            return true;
        }else{
            return false;
        }
    }
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
</body>


</html>
