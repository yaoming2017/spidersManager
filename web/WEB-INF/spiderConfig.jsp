<%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017/4/28
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <li class="active"><a href="event.jsp"><i class="icon icon-home"></i> <span>爬虫管理</span></a></li>
        <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>数据可视化</span></a> </li>
        <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>指标展示</span></a> </li>
    </ul>
</div>

<div id="content" style="height: 80%;">
    <div id="content-header">
        <div id="breadcrumb"> <a href="event.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
    </div>

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
                            <h5>第二步 爬虫配置</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <div class="form-horizontal">
                                <input id="spider-id" data="${spiderID}" type="hidden">
                                <div id="conf-info" fuck="${fn:length(configItemList)}">
                                    <c:forEach var="configItem" items="${configItemList}" varStatus="status">
                                        <div class="control-group">
                                            <label class="control-label">${configItem.displayName} :</label>
                                            <div class="controls">
                                                &nbsp;&nbsp;
                                                <c:if test="${configItem.type == 'int'}">
                                                    <input id="sel_${status.index}" conf-id="${configItem.id}" type="text" class="span6" placeholder="默认值" onblur="checkType('int', '${configItem.id}');"/>
                                                </c:if>
                                                <c:if test="${configItem.type == 'boolean'}">
                                                    <select id="sel_${status.index}" conf-id="${configItem.id}" class="span6">
                                                        <option value="" selected="selected">默认值</option>
                                                        <option value="True">True</option>
                                                        <option value="False">False</option>
                                                    </select>
                                                </c:if>
                                                <c:if test="${configItem.type == 'text'}">
                                                    <textarea id="sel_${status.index}" conf-id="${configItem.id}" placeholder="默认值" class="span6"></textarea>
                                                </c:if>

                                                <label id="prompt_${status.index}" style="font-size: 9px;display: none"></label>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                                <div class="form-actions">
                                    <button onclick="saveConfig()" class="btn btn-success">保存</button>
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
    var headerHeight = $('#headerId').height();
    var bottomHeight = $('#bottomId').height();
    var minBodyHeight = window.screen.height - headerHeight - bottomHeight;
    $('#body').style.minHeight = minBodyHeight;
</script>

<script>
    var validate = true;
    function checkType(type, id) {
        var input_id = 'sel_' + id;
        var label_id = 'prompt_' + id;

        var val = $("#"+input_id).val();
//        if(val == "" || val.trim() == "") {
//            $("#" + label_id).html("不能为空！！");
//            $("#" + label_id).css("display", "inline");
//            $("#" + label_id).css("color", "red");
//            $("#" + label_id).css("font-size", "14px");
//
//            return false;
//        }

        if(type == "int") {
            var num_reg = new RegExp("^[0-9]*$");
            if(!num_reg.test(val)) {
                $("#" + label_id).html("请输入数字！！");
                $("#" + label_id).css("display", "inline");
                $("#" + label_id).css("color", "red");
                $("#" + label_id).css("font-size", "14px");

                validate = false;

                return false;
            } else {
                $("#" + label_id).html("");
                $("#" + label_id).css("display", "inline");

                validate = true;

                return true;
            }
        }

    }

    function saveConfig() {
        if(!validate) {
            alert("输入不正确！！")
            return false;
        }
        var spider_id = $("#spider-id").attr("data");
        var shit = $("#conf-info").attr("fuck");
        var configJSON = "{";
        for(var i = 0; i < shit; i++) {
            configJSON = configJSON + "'" + $("#sel_" + i).attr("conf-id") + "': '" + $("#sel_" + i).val() + "'";
            if(i < shit - 1) {
                configJSON += ","
            }
        }
        configJSON += "}";

        $.ajax({
            type : 'post',
            url : 'saveSpiderConfig',
            data : {
                "spider_id": spider_id,
                "config": configJSON
            },
            success : function (msg) {
                if(msg == "success") {
                    alert("保存成功！！");
                    window.location.href = "viewSpiderConfig";
                } else {
                    alert("保存失败！！");
                }
            }
        })
    }
</script>

</body>

</html>