<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <html lang="en">
  <head>
  <title>Matrix Admin</title>
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
    <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
    <li class="active"><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>舆情影响力</span></a></li>
  </ul>
</div>
<!--sidebar-menu-->
  <div>
  <!--为Echarts准备一个具备大小（宽高）的Dom-->
  <div id="main" style="width: 1200px;height: 600px;margin-top:100px;">
  </div>
  </div>
  <!--中间部分 end-->
  <script src="js/echarts.min.js"></script><!--引入echarts.js-->
  <script type="text/javascript">
  //基于准备好的dom,初始化echarts实例
  var myChart = echarts.init(document.getElementById('main'));
  //指定图表的配置项和数据
  option = {
  tooltip : {
  trigger: 'axis',
  axisPointer : {            // 坐标轴指示器，坐标轴触发有效
  type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
  }
  },
  legend: {
  data:['豆瓣小组','凯迪社区','搜狐BBS','天涯BBS','西祠社区','总评论量']
  },
  grid: {
  left: '3%',
  right: '4%',
  bottom: '3%',
  containLabel: true
  },
  xAxis : [
  {
  type : 'category',
  data : ['周一','周二','周三','周四','周五','周六','周日']
  }
  ],
  yAxis : [
  {
  type : 'value'
  }
  ],
  series : [
  {
  name:'总评论量',
  type:'bar',
  data:[40, 30, 45, 54, 78, 71, 68],
  markLine : {
  lineStyle: {
  normal: {
  type:'dashed'
  }
  },
  data : [
  [{type:'min'}, {type:'max'}]
  ]
  }
  },
  {
  name:'豆瓣小组',
  type:'bar',
  stack: '总评论量',
  data:[1, 2, 21, 14, 29, 23, 22]
  },
  {
  name:'凯迪社区',
  type:'bar',
  stack: '总评论量',
  data:[6, 2, 1, 4, 19, 13, 11]
  },
  {
  name:'搜狐BBS',
  type:'bar',
  stack: '总评论量',
  data:[2, 2, 1, 4, 10, 11, 12]
  },
  {
  name:'天涯BBS',
  type:'bar',
  stack: '总评论量',
  data:[20, 12, 11, 4, 10, 11, 11]
  },
  {
  name:'西祠社区',
  type:'bar',
  stack: '总评论量',
  data:[11, 12, 11, 14, 10, 13, 12]
  }
  ]
  };
  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);
  </script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/matrix.js"></script>
</body>
</html>
