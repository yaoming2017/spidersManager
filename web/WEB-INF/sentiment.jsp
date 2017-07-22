<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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

<!--sidebar-menu start-->
<div id="sidebar">
  <ul style="display: block;background: #2E363F;height: 800px;">
    <li><a href="eventsList" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-home"></i> <span>事件列表</span></a> </li>
    <li><a href="event?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-tint"></i> <span>事件趋势</span></a> </li>
    <li><a href="hotWords?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i> <span>热点词</span></a> </li>
    <li> <a href="#" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>媒体来源分析</span></a> </li>
    <li><a href="articleSpread?eventID=${eventID}" style="font-family:新宋体;font-size: 18px;"><i class="icon icon-th"></i> <span>文章传播</span></a></li>
    <li> <a href="eventTrend?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-inbox"></i> <span>事件走势</span></a> </li>
    <li><a href="hotInformation?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-fullscreen"></i> <span>热门信息</span></a></li>
    <li><a href="sentiment?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-signal"></i><span>舆情影响力</span></a></li>
    <li><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>网民参与度</span></a></li>
    <li ><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>舆情负面指数</span></a></li>
    <li><a href="participant?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-tint"></i><span>db scan算法</span></a></li>
    <li ><a href="negativeIndex?eventID=${eventID}" style="font-family: 新宋体;font-size: 18px;"><i class="icon icon-home"></i><span>dp</span></a></li>
  </ul>
</div>
<!--sidebar-menu end-->
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
  <div>
  <!--为Echarts准备一个具备大小（宽高）的Dom-->
  <div id="main" style="width: 1200px;height: 600px;margin-top:100px;">
  </div>
  </div>
  <!--中间部分 end-->
  <script src="js/js3/echarts.min.js"></script><!--引入echarts.js-->
  <script type="text/javascript">
    <!--从后台传值到前台-->
    //豆瓣数据
    var arr_douban_num = [];
    var arr_douban_name = [];
    //人民网数据
    var arr_bbspeople_num = [];
    var arr_bbspeople_name = [];
    //凯迪社区
    var arr_kdnet_num = [];
    var arr_kdnet_name = [];
    //搜狐bbs
    var arr_bbssohu_num = [];
    var arr_bbssohu_name = [];
    //天涯bbs
    var arr_bbstianya_num = [];
    var arr_bbstianya_name = [];
    //西祠社区
    var arr_bbsxici_num = [];
    var arr_bbsxici_name = [];
    //猫扑社区
    var arr_bbsmop_num = [];
    var arr_bbsmop_name = [];
    //中华网社区
    var arr_bbschina_num = [];
    var arr_bbschina_name = [];
    //网易博客
    var arr_blog163_num = [];
    var arr_blog163_name = [];
    //博客
    var arr_blogsina_num = [];
    var arr_blogsina_name = [];
    //博客中国
    var arr_blogchina_num = [];
    var arr_blogchina_name = [];
    //中国社会新闻网
    var arr_xinwen_num = [];
    var arr_xinwen_name = [];
    //公共参数
    var arr_time = [];
    var data = [];
    data = ${commlist};
    var douban_i = 0;
    var people_i = 0;
    var kdnet_i = 0;
    var sohu_i = 0;
    var tianya_i = 0;
    var xici_i = 0;
    var mop_i = 0;
    var china_i = 0;
    var blog163_i = 0;
    var blogsina_i = 0;
    var blogchina_i = 0;
    var xinwen_i = 0;
    var alldata = 0;
    for (var o in ${commlist}){
        if(data[o].tableName == 'douban_group_post'){
            arr_douban_num[douban_i] = data[o].num;
            arr_douban_name[douban_i] = data[o].tableName;
            arr_time[douban_i] = data[o].startTime;
            douban_i ++;
        }else if(data[o].tableName == 'bbs_people_post'){
            arr_bbspeople_num[people_i] = data[o].num;
            arr_bbspeople_name[people_i] = data[o].tableName;
            people_i ++;
        }else if(data[o].tableName =='kdnet_post'){
            arr_kdnet_num[kdnet_i] = data[o].num;
            arr_kdnet_name[kdnet_i] = data[o].tableName;
            kdnet_i ++;
        }else if(data[o].tableName == 'bbs_sohu_post'){
            arr_bbssohu_num[sohu_i] = data[o].num;
            arr_bbssohu_name[sohu_i] = data[o].tableName;
            sohu_i ++;
        }else if(data[o].tableName == 'bbs_tianya_post'){
            arr_bbstianya_num[tianya_i] = data[o].num;
            arr_bbstianya_name[tianya_i] = data[o].tableName;
            tianya_i ++;
        }else if(data[o].tableName =='bbs_xici_post'){
            arr_bbsxici_num[xici_i] = data[o].num;
            arr_bbsxici_name[xici_i] = data[o].tableName;
            xici_i ++;
        }else if(data[o].tableName =='bbs_mop_post'){
            arr_bbsmop_num[mop_i] = data[o].num;
            arr_bbsmop_name[mop_i] = data[o].tableName;
            mop_i ++;
        }else if(data[o].tableName == 'bbs_china_post'){
            arr_bbschina_num[china_i] = data[o].num;
            arr_bbschina_name[china_i] = data[o].tableName;
            china_i ++;
        }else if(data[o].tableName =='blog_163_post'){
            arr_blog163_num[blog163_i] = data[o].num;
            arr_blog163_name[blog163_i] = data[o].tableName;
            blog163_i ++;
        }else if(data[o].tableName =='blog_sina_post'){
            arr_blogsina_num[blogsina_i] = data[o].num;
            arr_blogsina_name[blogsina_i] = data[o].tableName;
            blogsina_i ++;
        }else if(data[o].tableName == 'blogchina_blog'){
            arr_blogchina_num[blogchina_i] = data[o].num;
            arr_blogchina_name[blogchina_i] = data[o].tableName;
            blogchina_i ++;
        }else if(data[o].tableName =='xinwen110_news'){
            arr_xinwen_num[xinwen_i] = data[o].num;
            arr_xinwen_name[xinwen_i] = data[o].tableName;
            xinwen_i ++;
        }
    }
    for (var i = 0;i < douban_i; i++){
        data[i] = arr_douban_num[i] + arr_bbspeople_num[i]  + arr_bbssohu_num[i] + arr_bbstianya_num[i] + arr_bbsxici_num[i] + arr_kdnet_num[i] + arr_bbsmop_num[i] + arr_bbschina_num[i] + arr_blog163_num[i] + arr_blogsina_num[i] + arr_blogchina_num[i] + arr_xinwen_num[i];
    }
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
   orient: 'horizontal',
   x:'center',
  data:['总评论量','豆瓣小组','人民网社区','凯迪社区','搜狐社区','天涯社区','西祠社区','猫扑社区','中华网论坛','网易博客','新浪博客','博客中国','中国社会新闻网']
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
  data : arr_time,
  axisLabel:{
      //X轴刻度配置
      interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
  }
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
  data: data,
  markLine : {
  lineStyle: {
  normal: {
  type:'dashed'
  }
  },
  data : [
  ]
  }
  },
  {
  name:'豆瓣小组',
  type:'bar',
  stack: '评论量',
  data: arr_douban_num
  },
  {
  name:'人民网社区',
  type:'bar',
  stack: '评论量',
  data: arr_bbspeople_num
  },
  {
  name:'凯迪社区',
  type:'bar',
  stack: '评论量',
  data:[]
  },
  {
  name:'搜狐社区',
  type:'bar',
  stack: '评论量',
  data:arr_bbssohu_num
  },
  {
  name: '天涯社区',
  type:'bar',
  stack: '评论量',
  data: arr_bbstianya_num
  },
  {
  name:'西祠社区',
  type:'bar',
  stack: '评论量',
  data:arr_bbsxici_num
  },
  {
  name:'猫扑社区',
  type:'bar',
  stack: '评论量',
  data:arr_bbsmop_num
  },
  {
  name:'中华网社区',
  type:'bar',
  stack: '评论量',
  data:arr_bbschina_num
  },
  {
  name:'网易博客',
  type:'bar',
  stack: '评论量',
  data:arr_blog163_num
  },
  {
  name:'新浪博客',
  type:'bar',
  stack: '评论量',
  data:arr_blogsina_num
   },
  {
  name:'博客中国',
  type:'bar',
  stack: '评论量',
  data:arr_blogchina_num
  },
 {
  name:'中国社会新闻网',
  type:'bar',
  stack: '评论量',
  data:arr_xinwen_num
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
