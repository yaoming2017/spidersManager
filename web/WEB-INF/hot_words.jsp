<%--
  Created by IntelliJ IDEA.
  User: YH
  Date: 2017/6/1
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>舆情分析大平台</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="static/fore_header.jsp"/>
<!--sidebar-menu-->
<jsp:include page="static/fore_lefter.jsp">
    <jsp:param name="eventID" value='<%=request.getSession().getAttribute("eventID")%>'/>
</jsp:include>
<!--sidebar-menu-->

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"><a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a> <a
                href="#" class="current">热点词分析</a></div>
        <h1>热点词分析</h1>
        <hr>
    </div>
    <!--为Echarts准备一个具备大小（宽高）的Dom-->
    <div id="main" style="width: 1200px;height: 600px;"></div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js1/echarts.min.js"></script><!--引入echarts.js-->
<script src="js/js1/echarts-wordcloud.min.js"></script>
<script  type="text/javascript">
    var keyWords = JSON.parse('${keyWords}');

    //基于准备好的dom,初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    //指定图表的配置项和数据
    var  option = {
        title: {
            text: '热点词分析',
            link: 'https://www.baidu.com/s?wd=' + encodeURIComponent('ECharts'),
            x: 'center',
            textStyle: {
                fontSize: 23
            }

        },
        backgroundColor: '#F7F7F7',
        tooltip: {
            show: true
        },
        toolbox: {
            feature: {
                saveAsImage: {
                    iconStyle: {
                        normal: {
                            color: '#FFFFFF'
                        }
                    }
                }
            }
        },
        series: [{
            name: '热点分析',
            type: 'wordCloud',
            //size: ['9%', '99%'],
            sizeRange: [6, 66],
            //textRotation: [0, 45, 90, -45],
            rotationRange: [-45, 90],
            //shape: 'circle',
            textPadding: 0,
            autoSize: {
                enable: true,
                minSize: 6
            },
            textStyle: {
                normal: {
                    color: function() {
                        return 'rgb(' + [
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160)
                            ].join(',') + ')';
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            data: []
        }]
    };

//    var JosnList = [];
//
//    JosnList.push({
//        name: "毫无关系",
//        value: "366"
//    }, {
//        name: "草率",
//        value: "220"
//    }, {
//        name: "抹泪",
//        value: "399"
//    });

    option.series[0].data = keyWords;

    myChart.setOption(option);
    myChart.on('click', function (params) {
        alert((params.name));
        window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));

    });
</script>
</body>
</html>
