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
    <!--Header start-->
    <div id="header">
    <h1 style="font-family: 华文行楷;font-size: 27px;padding-top:10px;color: red;">舆情分析大平台</h1>
    </div>
    <!--Header end-->
    <!--Header-menu start-->
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
    <!--Header-menu end-->
    <!--serch start-->
    <div id="search">
    <input type="text" placeholder="在此搜索...."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
    </div>
    <!--serch end-->
    <!-- sidebar-menu start-->
    <div id="sidebar">
    <ul style="display: block;background: #2E363F;height: 800px;margin-top:-106px;">
    <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
    <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
    <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
    <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
    <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
    <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
    <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
    <li><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i><span>舆情影响力</span></a></li>
    <li><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>网民参与度</span></a></li>
    <li class="active"><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>舆情负面指数</span></a></li>
    </ul>
    </div>
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
    <!-- sidebar-menu start-->
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id= "main" style="width:1200px;height:600px;margin-top:100px;">
    </div>
    <script src="js/js3/echarts.min.js"></script><!--引入echarts.js-->
    <script type="text/javascript">
        <!--从后台传值到前台-->
        //豆瓣数据
        var arr_douban_index = [];
        var arr_douban_name = [];
        //人民网数据
        var arr_bbspeople_index = [];
        var arr_bbspeople_name = [];
        //搜狐bbs
        var arr_bbssohu_index = [];
        var arr_bbssohu_name = [];
        //公共参数
        var arr_time = [];
        var data = [];
        data = ${indexList};
        var douban_i = 0;
        var people_i = 0;
        var sohu_i = 0;
        var alldata = 0;
        for(var o in ${indexList}){
         if(data[o].tableName == 'douban_group_post'){
            arr_douban_index[douban_i] = data[o].index;
            arr_douban_name[douban_i] = data[o].tableName;
            arr_time[douban_i] = data[o].startTime;
            douban_i ++;
         }else if(data[o].tableName == 'bbs_people_post'){
            arr_bbspeople_index[people_i] = data[o].index;
            arr_bbspeople_name[people_i] = data[o].tableName;
            people_i ++;
         }else if(data[o].tableName == 'bbs_sohu_post'){
             arr_bbssohu_index[sohu_i] = data[o].index;
             arr_bbssohu_name[sohu_i] = data[o].tableName;
             sohu_i ++;
         }
        }
        for(var i=0;i < douban_i; i++){
          data[i] = arr_douban_index[i] + arr_bbspeople_index[i] + arr_bbssohu_index[i] ;
        }
    //基于准备好的dom，初始化echarts实例
   var myChart =echarts.init(document.getElementById('main'));
   var option = {
    title: {
    text: '舆情负面指数',
    },
    tooltip: {
    trigger: 'axis'
    },
    legend: {
    data:['总舆情负面指数','豆瓣小组指数','人民网社区指数','搜狐社区指数','天涯社区指数','西祠社区指数','猫扑社区指数','中华网社区指数','网易博客指数','博客指数','博客中国指数','三秦网指数']
    },
  grid: {
   left: '3%',
   right: '4%',
   bottom: '3%',
   containLabel: true
    },
       toolbox: {
           feature: {
               saveAsImage: {}
           }
       },
       xAxis: {
           type: 'category',
           boundaryGap: false,
           data: arr_time,
           axisLabel:{
               //X轴刻度配置
               interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
           }
       },
       yAxis: {
           type: 'value'
       },
       series: [
           {
               name:'总舆情负面指数',
               type:'line',
               data: data,
               markLine : {
                   lineStyle: {
                       normal: {
                           type:'dashed'
                       }
                   }
               },
               markPoint: {
                   data: [
                       {type: 'max', name: '最大值'},
                       {type: 'min', name: '最小值'}
                   ]
               },
               markLine: {
                   data: [
                       {type: 'average', name: '平均值'}
                   ]
               }
           },
           {
               name:'豆瓣小组指数',
               type:'line',
               stack: '舆情负面指数',
               data:arr_douban_index
           },
           {
               name:'人民网社区指数',
               type:'line',
               stack: '舆情负面指数',
               data:arr_bbspeople_index
           },
           {
               name:'搜狐社区指数',
               type:'line',
               stack: '舆情负面指数',
               data:arr_bbssohu_index
           }
           /*,
           {
               name:'天涯社区指数',
               type:'line',
               stack: '舆情负面指数',
               data:[0.2, 0.3, 0.2, 0.4, 0.0, 0.1, 0.3]
           },
           {
               name:'西祠社区指数',
               type:'line',
               stack: '总量',
               data:[0.3, 0.2, 0.11, 0.4, 0.4, 0.5, 0.2]
           }
           ,
           {
               name:'猫扑社区指数',
               type:'line',
               stack: '舆情负面指数',
               data:[820, 932, 901, 934, 1290, 1330, 1320]
           }
           ,
           {
               name:'中华网社区指数',
               type:'line',
               stack: '舆情负面指数',
               data:[820, 932, 901, 934, 1290, 1330, 1320]
           },
           {
               name:'网易博客指数',
               type:'line',
               stack: '舆情负面指数',
               data:[820, 932, 901, 934, 1290, 1330, 1320]
           },
           {
               name:'博客指数',
               type:'line',
               stack: '舆情负面指数',
               data:[0.1, 0.22, 0.3, 0.3, 0.2, 0.3, 0.9]
           },
           {
               name:'博客中国指数',
               type:'line',
               stack: '舆情负面指数',
               data:[0.3, 0.2, 0.1, 0.4, 0.3, 0.4, 0.5]
           }
           ,
           {
               name:'三秦网指数',
               type:'line',
               stack: '舆情负面指数',
               data:[0.12, 0.2, 0.1, 0.24, 0.4, 0.3, 0.2]
           }
*/
       ]
   };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    </script>
<!--Echarts end-->
<script src="js/jquery.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/matrix.js"></script>
</body>
</html>
