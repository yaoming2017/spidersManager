<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Karaca Admin Theme</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/etljs/html5.js"></script>
    <![endif]-->

    <!-- core js files -->
    <script src="js/etljs/jquery-1.11.0.min.js"></script>
    <script src="js/etljs/bootstrap.min.js"></script>
    <script src="js/etljs/modernizr.custom.js"></script>
    <script src="js/etljs/core.js"></script>
    <script>src="js/etljs/mock.js"</script>
    <script>src="js/etljs/jquery.js"</script>
    <script>src="js/etljs/jquery.dropdown.js"</script>
    <!-- core js files -->

    <link rel="stylesheet" href="css/etlcss/bootstrap.min.css">
    <link rel="stylesheet" href="css/etlcss/font-awesome.min.css">
    <link rel="stylesheet" href="css/etlcss/style.css">


    <link rel="stylesheet" href="css/etlcss/plugins/chosen/chosen.css">
    <script src="js/etljs/plugins/chosen.jquery.min.js"></script>

    <link rel="stylesheet" href="css/etlcss/demo_table.css">
    <link rel="stylesheet" href="css/etlcss/dtable.css">
    <script src="js/etljs/jquery.dataTables.min.js"></script>
    <script src="js/etljsjs/sorting.js"></script>

    <script src="js/etljs/plugins/jquery.tipsy.js"></script>
    <link rel="stylesheet" href="css/etlcss/plugins/files/tipsy.css">

    <link rel="stylesheet" href="css/etlcss/plugins/datepicker/datepicker.css">
    <script src="js/etljs/plugins/bootstrap-datepicker.js"></script>
    <script src="js/etljs/plugins/jquery.maskedinput.min.js"></script>

    <script src="js/etljs/plugins/bootstrap3-typeahead.min.js"></script>

    <script src="js/etljs/plugins/bootbox.min.js"></script>
    <script src="js/etljs/plugins/jquery.dlmenu.js"></script>

    <link rel="stylesheet" href="css/etlcss/plugins/files/bootstrap-checkbox.css">
    <script src="js/etljs/plugins/bootstrap-checkbox.js"></script>

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

    <script type="text/javascript">
        var ac_siteURL='';  //PHP Application üzerinde autocomplete verisi işlenmesi için temel adres tanımlaması için
    </script>
    <style type="text/css">
        #btn_bbs_mop{display: none}
        #btn_bbs_news{display: none}
        #btn_bbs_people{display: none}
        #btn_bbs_sohu{display: none}
        #btn_bbs_tianya{display: none}
        #btn_bbs_xici{display: none}
        #btn_blog_sina{display: none}
        #btn_blogchina{display: none}
        #btn_douban{display: none}
        #btn_kdnet{display: none}
        #btn_moe{display: none}
        #btn_sanqin{display: none}
        #btn_news_sina{display: none}
        #btn_people_news{display: none}
        #btn_weibo{display: none}
        #btn_xinhua_news{display: none}
        #btn_xinwen110{display: none}
    </style>
    <script>
        //1、获取到xmlhttprequest
        function xmlhttprequest() {
            var xmlhttp;
            if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else { // code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }
        //用户点击某表时，将该表名存入input引发其改变，从而触发ajax的onchange函数，清空
    function display(value) {
        $.post("TableServerlet",
            {
                tablename: value
            },
            function (data, status) {
//                alert("数据：" + data + "\n状态：" + status);
                var obj = eval('(' + data + ')');
                var html = "";
                html ="<thead><tr>";
                for(var i=0;i<obj.length;i++){    //遍历data数组
                    var ls = obj[i];
                    html +="<th><a class='infNews_wrod_a'>"+ls+"</a></th>";
                }
                html =html+"</tr></thead>";
                $("#displayTable").html(html); //在html页面id=的标签里显示html内容
            });

    }
//        //保存表的名字(修改了input的值
////        document.getElementById("tablename").value=value;
//        //清空展示区的内容来展示新内容
////        $("#tb_form").html("");
//
////处理点击表名字法ajax请求从而获得后台数据库中的内容
//
////        window.onload = function() {
//
////            document.getElementById('tablename').onchange = function() {
//
//                //1、获取到xmlhttprequest 对象
//        var xmlhttp = xmlhttprequest();
//                //2、xmlhttprequest的响应事件
//        xmlhttp.onreadystatechange = function() {
//            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//                        //5、操作获取到的信息
//                        //5.1ajax返回的数据,转换为javascript对象
//                        // 5.1.1 利用eval实现转换
//                var ajaxResult = eval("(" + xmlhttp.responseText + ")");
//                        //5.1.2 利用jquery的方法,对于jQuery.parseJSON(),键值必须为双引号
//                        /* var ajaxResult = jQuery.parseJSON(xmlhttp.responseText); */
//                alert(ajaxResult);
//                        //5.2获取JavaScript对象的属性
////                var age = ajaxResult.age;
////                var name = ajaxResult.name;
//
//                        //5.3获取到页面的DIV,并设置内容
//                var mydiv = document.getElementById("myAjax");
////                mydiv.innerHTML = "name:" + name + "," + "age:" + age;
//            }
//        }
//                //3、准备获取ajax请求
//                //3.1 对于get请求,带参数的方式,直接在open函数的请求地址带上参数
//        xmlhttp.open("POST", "TableServerlet", true);
//                //4、发送ajax请求
//        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//        xmlhttp.send("tablename=\'"+value+ "\'");
//
////            };
//    }

    </script>

</head>
<body>
    <div id="application">
        <div id="topLine">
            <div class="applogo">
                <img src="images/etlimg/applogo.png" />
            </div>
            <div class="topcontent hidden-xs">
                <i class="fa fa-tachometer"></i>
            </div>
            <div class="topmenu">
                <ul>
                    <li>
                        <a href="#" class="ta">
                        <img src="https://2.gravatar.com/avatar/621675677724d411a372dcdb1e50dbab6" width="50px" class="img-circle" />
                        <span>Test TestingName</span>
                        <i class="fa fa-sort-desc"></i>
                        </a>
                        <ul>
                            <li><a href="#">Profil</a></li>
                            <li><a href="#">Profil</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div id="appContent">

        <div id="dl-menu" class="dl-menuwrapper">
            <ul class="dl-menu">
                <li><a href="#"><i class="fa fa-tachometer"></i>Ana sayfa</a> </li>
                <li>
                    <a href="#"><i class="fa fa-user"></i>Kullanıcılar</a>
                    <ul class="dl-submenu">
                        <li><a href="#">Kullanıcı Listesi</a></li>
                        <li><a href="#">Yeni Kullanıcı Oluştur</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Formlar</a>
                    <ul class="dl-submenu">
                        <li><a href="#">İçerik 1</a></li>
                        <li><a href="#">İçerik 2</a></li>
                        <li><a href="#">İçerik 4</a></li>
                        <li><a href="#">İçerik 3</a></li>
                    </ul>
                </li>


            </ul>
        </div>

            <!--<div class="appmenu dl-menuwrapper">-->
                <!--<ul id="menu" class="dl-menu">-->
                    <!--<li><a href="#"><i class="fa fa-tachometer"></i>Ana sayfa</a></li>-->
                    <!--<li><a href="#" class="active"><i class="fa fa-user"></i>Kullanıcılar</a></li>-->
                    <!--<li><a href="#"><i class="fa fa-list-alt"></i>Formlar</a>-->
                        <!--<ul class="dl-submenu">-->
                            <!--<li><a href="#" class="active">Sub 1</a></li>-->
                            <!--<li><a href="#">Sub 2</a></li>-->
                            <!--<li><a href="#">Sub 3</a></li>-->
                        <!--</ul>-->
                    <!--</li>-->
                <!--</ul>-->
            <!--</div>-->
            <div class="appcontent" >
                <div class="appbreadcrumb">
                    <ol class="breadcrumb">
                        <li><a class="menuButton" href="#"><i class="fa fa-bars"></i> Menü</a></li>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Library</a></li>
                        <li class="active">Data</li>
                    </ol>
                </div>
                <div class="message">
                    <div class="alert alert-warning alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>数据清洗模块</strong>
                    </div>
                </div>
                <div class="content">
                    <div class="row">

                        <div class="col-md-4">
                            <div class="widget">
                                <div class="whead">
                                    <h6><i class="fa fa-cloud"></i> 请选择要操作的网站</h6>
                                    <a href="#" class="btn btn-sm btn-default">Kaydet</a>
                                    <a href="#" class="btn btn-sm btn-success">İptal</a>
                                </div>
                                <div class="wbody">
                                    <td>选择网站</td>
                                    <td>
                                        <select name="websites" id="websites" onchange="onchange_websites()">
                                            <option value="bbs_china" selected>中华网</option><%--bbs_china--%>
                                            <option value="bbs_mop">猫扑网</option><%--bbs_mop--%>
                                            <option value="bbs_news">新华网</option><%--bbs_news--%>
                                            <option value="bbs_people">强国论坛</option><%--bbs_people--%>
                                            <option value="bbs_sohu">搜狐BBS</option><%--bbs_sohu--%>
                                            <option value="bbs_tianya">天涯BBS</option><%--bbs_tianya--%>
                                            <option value="bbs_xici">西祠胡同</option><%--bbs_xici--%>
                                            <option value="blog_sina">新浪微博</option><%--blog_sina--%>
                                            <option value="blogchina">博客中国</option><%--blogchina--%>
                                            <option value="douban">豆瓣</option><%--douban--%>
                                            <option value="kdnet">凯迪网络</option><%--kdnet--%>
                                            <option value="moe">教育部</option><%--moe--%>
                                            <option value="sanqin">三秦网</option><%--sanqin--%>
                                            <option value="news_sina">新浪新闻</option><%--news_sina--%>
                                            <option value="people_news">人民新闻</option><%--people_news--%>
                                            <option value="weibo">微博</option><%--people_news--%>
                                            <option value="xinhua_news">新华新闻</option><%--xinhua_news--%>
                                            <option value="xinwen110">社会新闻</option><%--xiwenn110--%>
                                        </select>
                                    </td>
                                    <!-- Button trigger modal -->
                                    <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">--%>
                                        <%--Launch demo modal--%>
                                    <%--</button>--%>

                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                                </div>
                                                <div class="modal-body">
                                                    ...
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Save changes</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br/>
                                    <br/>
                                    <br/>



                                        <fieldset>
                                        <h6><i class="fa fa-cloud"> </i>请选择要操作的数据表</h6>

                                            <div id="btn_bbs_china">
                                                <a href="javascript:display('bbs_china_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_china_author</a>
                                                <a href="javascript:display('bbs_china_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_china_comment</a>
                                                <a href="javascript:display('bbs_china_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_china_post</a>
                                            </div>
                                            <div id="btn_bbs_mop">
                                                <a href="javascript:display('bbs_mop_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_mop_author</a>
                                                <a href="javascript:display('bbs_mop_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_mop_comment</a>
                                                <a href="javascript:display('bbs_mop_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_mop_post</a>
                                            </div>
                                            <div id="btn_bbs_news">
                                                <a href="javascript:display('bbs_news_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_news_author</a>
                                                <a href="javascript:display('bbs_news_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_news_comment</a>
                                                <a href="javascript:display('bbs_news_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_news_post</a>
                                            </div>
                                            <div id="btn_bbs_people">
                                                <a href="javascript:display('bbs_people_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_people_author</a>
                                                <a href="javascript:display('bbs_people_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_people_post</a>
                                            </div>
                                            <div id="btn_bbs_sohu">
                                                <a href="javascript:display('bbs_sohu_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_sohu_author</a>
                                                <a href="javascript:display('bbs_sohu_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_sohu_comment</a>
                                                <a href="javascript:display('bbs_sohu_comment')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_sohu_post</a>
                                            </div>
                                            <div id="btn_bbs_tianya">
                                                <a href="javascript:display('bbs_tianya_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">bbs_tianya_author</a>
                                                <a href="javascript:display('bbs_tianya_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_tianya_comment</a>
                                                <a href="javascript:display('bbs_tianya_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_tianya_post</a>
                                            </div>
                                            <div id="btn_bbs_xici">
                                                <a href="javascript:display('bbs_xici_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">bbs_xici_comment</a>
                                                <a href="javascript:display('bbs_xici_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">bbs_xici_post</a>
                                            </div>
                                            <div id="btn_blog_sina">
                                                <a href="javascript:display('blog_sina_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">blog_sina_author</a>
                                                <a href="javascript:display('blog_sina_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">blog_sina_comment</a>
                                                <a href="javascript:display('blog_sina_post')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">blog_sina_post</a>
                                            </div>
                                            <div id="btn_blogchina">
                                                <a href="javascript:display('blogchina_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">blogchina_author</a>
                                                <a href="javascript:display('blogchina_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">blogchina_comment</a>
                                                <a href="javascript:display('blogchina_blog')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">blogchina_blog</a>
                                            </div>
                                            <div id="btn_douban">
                                                <a href="javascript:display('douban_group_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">douban_group_author</a>
                                                <a href="javascript:display('douban_group_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">douban_group_comment</a>
                                                <a href="javascript:display('douban_group_group')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">douban_group_group</a>
                                                <a href="javascript:display('douban_group_post')" class="btn btn-success tipSag" original-title="Lorem ipsum dolar sit amed">douban_group_post</a>
                                            </div>
                                            <div id="btn_kdnet">
                                                <a href="javascript:display('kdnet_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">kdnet_author</a>
                                                <a href="javascript:display('kdnet_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">kdnet_comment</a>
                                                <a href="javascript:display('kdnet_comment')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">kdnet_post</a>
                                            </div>
                                            <div id="btn_moe">
                                                <a href="javascript:display('moe_data')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">moe_data</a>
                                                <a href="javascript:display('moe_declaration')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">moe_declaration</a>
                                                <a href="javascript:display('moe_news')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">moe_news</a>
                                            </div>
                                            <div id="btn_sanqin">
                                                <a href="javascript:display('news_sanqin')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">news_sanqin</a>
                                            </div>
                                            <div id="btn_news_sina">
                                                <a href="javascript:display('news_sina')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">news_sina</a>
                                            </div>
                                            <div id="btn_weibo">
                                                <a href="javascript:display('weibo_author')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">weibo_author</a>
                                                <a href="javascript:display('weibo_comment')" class="btn btn-success tipAlt" original-title="Lorem ipsum dolar sit amed">weibo_comment</a>
                                                <a href="javascript:display('weibo_comment')" class="btn btn-success tipSol" original-title="Lorem ipsum dolar sit amed">weibo_content</a>
                                            </div>
                                            <div id="btn_people_news">
                                                <a href="javascript:display('people_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">people_news</a>
                                            </div>
                                            <div id="btn_xinhua_news">
                                                <a href="javascript:display('xinhua_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">xinhua_news</a>
                                            </div>
                                            <div id="btn_xinwen110">
                                                <a href="javascript:display('xinwen110_news')" class="btn btn-success tipUst" original-title="Lorem ipsum dolar sit amed">xinwen110_news</a>
                                            </div>

                                    </fieldset>


                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="widget">
                                <div class="whead">
                                    <h6><i class="fa fa-cloud"></i> 数据清洗策略的选择</h6>
                                    <div class="btn-group">
                                        <a href="" class="btn btn-primary" data-message=""><i class="fa fa-share"></i> Buton</a>
                                        <a href="" class="btn btn-info" data-message=""><i class="fa fa-plus"></i> Grup</a>
                                        <a href="" class="btn btn-default" data-message=""><i class="fa fa-home"></i> Denemesi</a>
                                    </div>
                                </div>
                                <div class="wbody">
                                    <table class="table">
                                        <tr>
                                            <td>Form Text</td>
                                            <td><input type="text" class="form-control"/></td>
                                        </tr>                                        <tr>
                                        <td>Select Form</td>
                                        <td>
                                            <select class="select form-control">
                                                <option>Value 1</option>
                                                <option>Value 2</option>
                                                <option>Value 3</option>
                                                <option>Value 4</option>
                                                <option>Value Value</option>
                                                <option>Value 5</option>
                                                <option>Value 6</option>
                                            </select>
                                        </td>
                                    </tr>
                                        <tr>
                                            <td>Date Picker</td>
                                            <td><input type="text" class="form-control dpform"/></td>
                                        </tr>
                                        <tr>
                                            <td>Auto Complete</td>
                                            <td><input type="text"  class="form-control autocomplete" data-source="etldemodata/autocomplete.json"/></td>
                                        </tr>
                                        <tr>
                                            <td>Chechbox</td>
                                            <td>
                                                <input type="checkbox"  class="checkboxcustom" value="yes" name="a" />
                                                <input type="checkbox"  class="checkboxcustom1" value="yes" name="b" />
                                                <input type="checkbox"  class="checkboxcustom2" value="yes" name="c" />
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="widget">
                                <div class="whead">
                                    <h6><i class="fa fa-cloud"></i>统计</h6>
                                    <a href="#" class="btn btn-sm btn-default">Kaydet</a>
                                    <a href="#" class="btn btn-sm btn-success">İptal</a>
                                </div>
                                <div class="wbody">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%--这里展示返回的数据表--%>
                        <form method="post" action="tbform" name="tbform1" id="tbform1">
                            <%--接收用户选择的表名--%>
                            <input type="hidden" name="tablename" id ="tablename" value="" />

                        <div class="col-md-12">
                            <div class="widget">
                                <div class="whead">
                                    <h6>数据展示与清洗</h6>
                                </div>
                                <div class="tablebody" id="tablebody">
                                    <table cellpadding="0" cellspacing="0" border="0" class="displayTable" id="displayTable" width="100%" data-table-ajax="">
                                    </table>
                                <%--<table cellpadding="0" cellspacing="0" border="0" class="displayTable" id="displayTable" width="100%" data-table-ajax="">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th>Rendering engine</th>--%>
                                    <%--<th>Browser</th>--%>
                                    <%--<th>Platform(s)</th>--%>
                                    <%--<th>Engine version</th>--%>
                                    <%--<th>CSS grade</th>--%>

                                <%--</tr>--%>
                                <%--<tr>--%>
                                <%--<c:forEach var="fm" items="${data}">--%>
                                    <%--<th>${fm}</th>--%>
                                <%--</c:forEach>--%>
                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>


                                <%--</tbody>--%>
                                <%--<tr class="gradeX">--%>
                                    <%--<td>Trident</td>--%>
                                    <%--<td>Internet--%>
                                        <%--Explorer 4.0</td>--%>
                                    <%--<td>Win 95+</td>--%>
                                    <%--<td class="center">4</td>--%>
                                    <%--<td class="center">X</td>--%>
                                <%--</tr>--%>

                                <%--</tr>--%>
                                <%--</tbody>--%>
                                <%--<tfoot>--%>
                                <%--<tr>--%>
                                    <%--<th></th>--%>
                                    <%--<th></th>--%>
                                    <%--<th></th>--%>
                                    <%--<th></th>--%>
                                    <%--<th></th>--%>
                                <%--</tr>--%>
                                <%--</tfoot>--%>
                                <%--</table>--%>
                                </div>
                                <div class="clearfix"></div>
                            </div>

                        <div class="clearfix"></div>
                        </div>
                        </form>
                    <div class="clearfix"></div>
                <div class="ara" id="ara"></div>
                </div>
            </div>
        </div>
    </div>
    </div>
<script>
    //选择不同网站时显示不同的对应数据表
    function onchange_websites() {
        var obj = document.getElementById("websites").value;
        switch (obj)
        {
            case "bbs_china":
                document.getElementById("btn_bbs_china").style.display="inline";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_mop":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="inline";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_news":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="inline";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_people":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="inline";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_sohu":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="inline";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_tianya":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="inline";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "bbs_xici":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="inline";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "blog_sina":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="inline";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "blogchina":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="inline";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "douban":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="inline";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "kdnet":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="inline";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "moe":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="inline";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "sanqin":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="inline";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "news_sina":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="inline";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "people_news":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="inline";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "weibo":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="inline";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "xinhua_news":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="inline";
                document.getElementById("btn_xinwen110").style.display="none";
                break;
            case "xinwen110":
                document.getElementById("btn_bbs_china").style.display="none";
                document.getElementById("btn_bbs_mop").style.display="none";
                document.getElementById("btn_bbs_news").style.display="none";
                document.getElementById("btn_bbs_people").style.display="none";
                document.getElementById("btn_bbs_sohu").style.display="none";
                document.getElementById("btn_bbs_tianya").style.display="none";
                document.getElementById("btn_bbs_xici").style.display="none";
                document.getElementById("btn_blog_sina").style.display="none";
                document.getElementById("btn_blogchina").style.display="none";
                document.getElementById("btn_douban").style.display="none";
                document.getElementById("btn_kdnet").style.display="none";
                document.getElementById("btn_moe").style.display="none";
                document.getElementById("btn_sanqin").style.display="none";
                document.getElementById("btn_news_sina").style.display="none";
                document.getElementById("btn_people_news").style.display="none";
                document.getElementById("btn_weibo").style.display="none";
                document.getElementById("btn_xinhua_news").style.display="none";
                document.getElementById("btn_xinwen110").style.display="inline";
                break;
            default:
                alert("error");
        }
    }
</script>
</body>
</html>