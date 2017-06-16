<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" xmlns:c="">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <title>Visual Admin Dashboard - Manage Users</title>
    <link href="http://cdn.files.wyq.cn/web/css/font-icon.css?v=201706091810" rel="stylesheet" type="text/css">
    <link href="dist/css/font-awesome.min.css" rel="stylesheet">
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/templatemo-style.css" rel="stylesheet">
    <link href="dist/css/bootstrap.css" rel="stylesheet"/>
    <link href="dist/css/style.css" rel="stylesheet"/>
    <script src="dist/js/echarts.min.js"></script><!--引入echarts.js-->
    <script text="text/javascript">
        function show(tag){
            var light=document.getElementById(tag);
            var fade=document.getElementById('fade');
            light.style.display='block';
            fade.style.display='block';
        }
        function hide(tag){
            var light=document.getElementById(tag);
            var fade=document.getElementById('fade');
            light.style.display='none';
            fade.style.display='none';
        }
    </script>
    <script language="javascript">
        $(function() {
            findKeyword(1,$("#categoryUl li:first"));
        });
        function searchRank(){
            if($.trim($("#searchName").val())==""){
                showMsgInfo(0,"请输入搜索词！",0);
                return;
            }
            $("#page").val(1);
            var hotOrRank = $("#hotOrRank").val();
            if(hotOrRank == 1){
                $("#province").val($.trim($("#searchName").val()));
                findKeyword(1,$("#categoryUl li:first"),1);
            }else if(hotOrRank == 2) {
                getRank();
            }
        }
    </script>
</head>
<body>
<!-- Main content -->
<!--head代码 start-->
<!--查询头部菜单 start-->
<div id="head" class="rel">
    <div class="head-top">
    <span class="logon float_l" >
        <img src="dist/images/logo.png"   style="width:190px;height:50px;">
    </span>
        <div class="user">
            <div class="userNav float_l">
                <ul>
                    <li>
                        <a href="javascript:void(0);" id="noticeLink">系统公告</a>
                    </li>
                    <li class="rel">
                        <a href="/call.html" style="margin-right: 250px;font-size:14px;">联系我们</a>
                        <span class="abs f_c3 fz18 bounce" style="top: -10px; right:235px;"><i class="icon-moneybagfill"></i></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <nav class="">
        <ul>
            <li class="curr"><a href="/index.shtml">舆情热度指数</a></li>
            <li><a href="/keyword.html">信息监测</a></li>
            <li><a href="/eventAnalysis.html">全网事件分析</a></li>
            <li><a href="/analysis.html">网站传播效果分析</a></li>
            <li><a href="/participant.html">网民参与度</a></li>
            <li><a href="/influcence.html">舆情影响力</a></li>
            <li><a href="/report.html">报告定制</a></li>
        </ul>

    </nav>
</div>
<!--查询头部菜单 end-->
<!--中间部分 start-->
<!--为Echarts准备一个具备大小（宽高）的Dom-->
<div id="main" style="width: 1200px;height: 600px;"></div>
<!--中间部分 end-->
<script type="text/javascript">
    //基于准备好的dom,初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var keyWords1 = JSON.parse('${keyWords}');
    var keyWords2 = JSON.parse('${}');
    //指定图表的配置项和数据
    var colors = ['#5793f3', '  #d14a61'];
    var  option = {
        color: colors,

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        grid: {
            right: '20%'
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['日流量','总流量']
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                data: ["2016-03-29", "2016-03-30", "2016-03-31", "2016-04-01", "2016-04-04", "2016-04-05", "2016-04-06", "2016-04-07", "2016-04-08", "2016-04-11", "2016-04-12", "2016-04-13", "2016-04-14", "2016-04-15", "2016-04-18", "2016-04-19", "2016-04-20", "2016-04-21", "2016-04-22", "2016-04-25", "2016-04-26", "2016-04-27", "2016-04-28", "2016-04-29", "2016-05-02", "2016-05-03", "2016-05-04", "2016-05-05", "2016-05-06", "2016-05-09", "2016-05-10", "2016-05-11", "2016-05-12", "2016-05-13", "2016-05-16", "2016-05-17", "2016-05-18", "2016-05-19", "2016-05-20", "2016-05-23", "2016-05-24", "2016-05-25", "2016-05-26", "2016-05-27", "2016-05-31", "2016-06-01", "2016-06-02", "2016-06-03", "2016-06-06", "2016-06-07", "2016-06-08", "2016-06-09", "2016-06-10", "2016-06-13", "2016-06-14", "2016-06-15", "2016-06-16", "2016-06-17", "2016-06-20", "2016-06-21", "2016-06-22"]
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '日流量',
                min: 0,
                max: 250,
                position: 'left',
                axisLine: {
                    lineStyle: {
                        color: colors[0]
                    }
                },
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '总流量',
                min: 0,
                max: 250,
                position: 'right',
                axisLine: {
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name:'日流量',
                type:'bar',
                data:keyWords1
            },
            {
                name:'总流量',
                type:'bar',
                yAxisIndex: 1,
                data:keyWords2
            }
        ]
    };
    //option.series[0].data = JosnList;
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
