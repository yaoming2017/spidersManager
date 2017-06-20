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
    <title>舆情分析系统</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="css/uniform.css"/>
    <link rel="stylesheet" href="css/select2.css"/>
    <link rel="stylesheet" href="css/matrix-style.css"/>
    <link rel="stylesheet" href="css/matrix-media.css"/>
    <link rel="stylesheet" href="css/css1/common.css"/>
    <link rel="stylesheet" href="css/css1/eventAnalysis.css"/>
    <link rel="stylesheet" href="css/css1/other.css"/>
    <link rel="stylesheet" href="css/css1/report.css"/>
    <link rel="stylesheet" href="css/css1/style.css"/>
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet"/>
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
                <li><a href="#"><i class="icon-check"></i>我的工作</a></li>
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
        <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
        <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
        <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
        <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
        <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
        <li><a href="authorIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>发布者指标</span></a></li>
        <li class="active"> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
        <%--<li><a href="sentiment.html" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>表情分析</span></a></li>--%>
        <%--<li class="submenu"> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-th-list"></i> <span>分析</span> <span class="label label-important">3</span></a>--%>
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
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a
                href="#" class="current">传播途径</a></div>
    </div>

        <div class="widget-box">
            <div class="widget-title bg_lb"><span class="icon"><i class="icon-comment"></i></span>
                <h1>传播途径</h1>
            </div>
            <div class="widget-content" style="height:1480px;">
                <!---传播途径 事件溯源start-->
                <div class="row-fluid" id="ui-accordion-4" name="r4">
                    <div class="textShow">
                        <ul class="column ui-sortable">
                            <li>
                                <div id="eventProfile" class="yb2 rel">
                                    <h2>
                                        <div><span class="contenteditable" contenteditable="false">事件走势 </span></div>
                                    </h2>
                                    <div class="more">
                                        <span class="packUp2"><a href="javascript:void(0)">
                                        <label>展开事件进展&nbsp;<i></i></label></a>
                                        </span>
                                    </div>
                                    <ul style="padding-bottom: 0;" id="trend" class="ui-sortable">
                                        <c:forEach items="${tableHotValues}" var="h" varStatus="st">
                                            <c:if test="${h.doubanGroupPost != null}">
                                                <li>
                                                    <div class="float_l">
                                                        <span class="line"></span>
                                                        <span class="round"></span>
                                                        <span class="line"></span>
                                                    </div>
                                                    <div class="sz"></div>
                                                    <div class="text text2">
                                                        <i class="icon-arrows yb-move" style="display: none;"></i>
                                                        <i class="icon-trash-o yb-delete" style="display: none;" onclick="del(this);"></i>
                                                        <i class="icon-control_point yb-add" style="display: none;" onclick="add();"></i>
                                                        <div class="contenteditable" contenteditable="false">
                                                            <a target="_blank" style="color: #000;text-decoration:none;" href="${h.doubanGroupPost.url}">
                                                                豆瓣小组：标题：${h.doubanGroupPost.title}
                                                                内容：${h.doubanGroupPost.content} 热度：${h.hotValue}
                                                                <p class="f_c1">(可能是事件源头，仅供参考)时间：${h.doubanGroupPost.dateTime}</p>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </li>
                                            </c:if>

                                            <c:if test="${h.bbsPeoplePost != null}">
                                                <li>
                                                    <div class="float_l">
                                                        <span class="line"></span>
                                                        <span class="round"></span>
                                                        <span class="line"></span>
                                                    </div>
                                                    <div class="sz"></div>
                                                    <div class="text text2">
                                                        <i class="icon-arrows yb-move" style="display: none;"></i>
                                                        <i class="icon-trash-o yb-delete" style="display: none;" onclick="del(this);"></i>
                                                        <i class="icon-control_point yb-add" style="display: none;" onclick="add();"></i>
                                                        <div class="contenteditable" contenteditable="false">
                                                            <a target="_blank" style="color: #000;text-decoration:none;" href="${h.bbsPeoplePost.url}">
                                                                人民网BBS：标题：${h.bbsPeoplePost.title}
                                                                内容：${h.bbsPeoplePost.content} 热度：${h.hotValue}
                                                                <p class="f_c1">(可能是事件源头，仅供参考)时间：${h.bbsPeoplePost.dateTime}</p>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </li>
                                            </c:if>

                                        </c:forEach>
                                    </ul>
                                    <ul style="padding-top: 10px;">
                                        <li>
                                            <div class="float_l"><span class="roundEnd">续</span></div>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>

                    </div>
                </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.js"></script>
<script src="js/matrix.tables.js"></script>
<script type="text/javascript">
    $(function () {
        $("#trend >li:gt(3)").hide();
        var num=1;
        $(".more").on("click",function () {
            if(num){
                num--;
                $("#trend > li:gt(3)").show();
                $(this).html("<span class='packUp'><a href='javascript:void(0)'><label>收拢事件进展&nbsp;<i></i></label></a></span>");
            }else {
                num++;
                $("#trend >li:gt(3)").hide();
                $(this).html("<span class='packUp2'><a href='javascript:void(0)'><label>展开事件进展&nbsp;<i></i></label></a></span>");
            }
        });
    });
function saveReport(){
    var eleIds = "{\"elementList\":[";
    var sum = 0;
    var list = $(".ui-sortable>div.row-fluid");
    $.each(list,function (n) {
        var thisId = $(this).attr("id");
        var pos = thisId.lastIndexOf("-");
        sum++;
        var eId = parseInt(thisId.substring(pos+1,thisId.length));
        eleIds +="{\"elementId\":"+eId+",\"name\":\""+Trim($(".modification").eq(sum -1).text().replace(/"|'/g,""))+"\"";
        if(thisId =="ui-accordion-4"){//传播途径
          var elementId = thisId.substr(thisId.length-1);
            var treeTxts =$(this).find(".textShow.ui-sortable.text div.texteditor");
            if(treeTxts.length>0){
                eleIds +=",\"content\":\"";
                for(var i=0;i<treeTxts.length;i++){
                   var treeTxt = treeTxts[i];
                    eleIds +=$(treeTxt).html();
                    if(i !=(treeTxts.length-1)){
                        eleIds +="</br>";
                    }
                }
              eleIds +="\"";
            }
            var treeTime=$("#eventProfile").find("h2 div span.contenteditable");
            if($.trim(treeTime.text())!=""){
                eleIds += ",\"treeTime\":\"" + $(treeTime).text().replace(/"|'/g,"") + "\"";
            }
            var treeTexts = $("#trend>li>.text2").find("div");
             if(treeTexts.length >0){
               eleIds += ",\"treeText\":\"";
               for (var j = 0; j < treeTexts.length; j++) {
                   var treeText = treeTexts[j];
                   var url=$(treeText).find("a")[0];
                   if($(url).length>0){
                       eleIds+=url.href+"<n/>";
                   }

                   eleIds += $(treeText).text().replace(/"|'/g,"").replace(/\r\n/g,"");
                   if(j!=(treeTexts.length-1)){
                       eleIds+= "</br>"
                   }
               }
               eleIds += "\"";
           }
        }
    })
}
</script>
</body>
</html>
