<%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017/5/3
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

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

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>
            Home</a></div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span1"></div>
            <div class="span10">
                <div class="widget-box collapsible">
                    <input value="${fn:length(spiderInfoList)}" id="info-length" hidden="hidden" />
                    <c:forEach var="spiderInfo" items="${spiderInfoList}" varStatus="status">
                        <div class="widget-title" style="text-align:right; " id="title_${status.index}" data-spider="${spiderInfo[0].id}">
                            <a href="#collapse_${status.index}" data-toggle="collapse">
                                <span class="icon"><i class="icon-circle-arrow-right"></i></span>
                                <h5 style="color: #1c6e37; width: 6%; text-align: left">spider name :</h5><h5 style="width: 6%; text-align: left"> ${spiderInfo[0].spiderName} </h5>
                                <h5 style="color: #1c6e37;"> |&nbsp;&nbsp;&nbsp;website name :</h5> <h5>${spiderInfo[1].websiteName}</h5>
                                <h5 style="color: #1c6e37;"> |&nbsp;&nbsp;&nbsp;website type :</h5> <h5>${spiderInfo[1].websiteType} </h5>
                            </a>
                            <button class="btn btn-info" onclick="javascript:updateSpiderConfig('${spiderInfo[0].id}');">修改信息</button>
                        </div>
                        <div class="collapse" id="collapse_${status.index}">

                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
<script>

    function updateSpiderConfig(id) {
        window.location.href = "updateSpiderConfig?spiderID=" + id;
    }
</script>

</div>
<div class="row-fluid">
    <div id="footer" class="span12"> 2017 &copy; <a href="http://www.SICD.com/" target="_blank" title="SICD">SICD</a> -
        Collect from <a href="http://www.baidu.com/"
                        title="Social Mind" target="_blank">Social Mind</a></div>
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
    var info_length = $("#info-length").attr("value");

    $(function () {
        for(var i = 0; i < info_length; i++) {
            (function (i) {
                var spider_id =$("#title_" + i).attr("data-spider");
                $.ajax({
                    type : "post",
                    url : "getConfigItem",
                    data : {'spider_id' : spider_id},
                    success : function (msg) {
                        console.log(i);
                        var msgJson = JSON.parse(msg);

                        var result = msgJson.result;

                        if(result == "success") {
                            var dataMap = msgJson.data;
                            var html_code = jointConfig(dataMap);
                            $("#collapse_" + i).append(html_code);
                        } else {

                        }
                    },
                    error : function (msg) {
                        alert(msg)
                    }
                })

            }(i))

        }
    }());

    var jointConfig = function(dataMap) {
        if(dataMap == undefined || dataMap == '') {
            return '<div class="widget-content">' +
                        '<h5>没有配置项</h5>' +
                        '<button class="btn btn-info">添加配置项</button>' +
                        '<button class="btn btn-success">以默认配置运行</button>' +
                    '</div>';
        }

        var html = '';
        for(var key in dataMap) {
            html = html + '<div class="widget-content">' +
                            '<div class="widget-box">' +
                                '<div class="widget-content nopadding">' +
                                    '<table class="table table-striped table-bordered">' +
                                        '<thead>' +
                                            '<tr>' +
                                                '<th>配置项</th>' +
                                                '<th>名称</th>' +
                                                '<th>值</th>' +
                                                '<th>备注</th>' +
                                                '<th>Opts</th>' +
                                            '</tr>' +
                                        '</thead>' +
                                        '<tbody>';
            var configList = dataMap[key];
            for(var i = 0; i < configList.length; i++) {
                html = html + '<tr>' +
                                    '<td class=""><i class="icon-ok-sign"></i> 配置项 '+ ( i + 1 ) +'</td>' +
                                    '<td class="taskStatus"><span class="in-progress">' + configList[i][1].displayName + '</span></td>' +
                                    '<td class="taskStatus"><span class="in-progress">' + configList[i][0].configItemValue + '</span></td>' +
                                    '<td class="taskDesc">' + configList[i][1].remark + '</td>' +
                                    '<td class="taskOptions">' +
                                        '<a href="#" class="tip-top" data-original-title="Update">' +
                                            '<i class="icon-ok"></i></a> ' +
                                                '<a href="#" class="tip-top" data-original-title="Delete">' +
                                                    '<i class="icon-remove"></i></a>' +
                                    '</td>' +
                                '</tr>';
            }

            html = html + '</tbody>' +
                            '</table>' +
                            '</div>' +
                            '</div>' +
                            '<button class="btn btn-success" disabled="disabled">运行</button>' +
                            '</div>';
        }

        if(html == '') {
            return '<div class="widget-content">' +
                        '<h5>没有配置项</h5>' +
                        '<button class="btn btn-info">添加配置项</button>' +
                        '<button class="btn btn-success">以默认配置运行</button>' +
                    '</div>';
        }

        return html
    };

</script>

</body>

</html>
