<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/maruti-style.css" />
<link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />
  <link rel="stylesheet" href="css/fullcalendar.css" />
<style type="text/css">
  .quick-actions_homepage .quick-actions a:hover{
    background-color:#51a351;
  }
  .quick-actions_homepage .quick-actions a{

  }
</style>
</head>
<body>
<script>
  function click_websites(flag){
    if(flag == 1){
      $("#li_db_chinabbs").css("background-color", "#51a351");
      $("#tb_chinabbs").css("display", "");

      $("#li_db_doubangroup").css("background-color", "#FFFFFF");
      $("#tb_doubangroup").css("display", "none");

      $("#li_db_people").css("background-color", "#FFFFFF");
      $("#tb_people").css("display", "none");
    }

    if(flag == 2){
      $("#li_db_chinabbs").css("background-color", "#FFFFFF");
      $("#tb_chinabbs").css("display", "none");

      $("#li_db_doubangroup").css("background-color", "#51a351");
      $("#tb_doubangroup").css("display", "");

      $("#li_db_people").css("background-color", "#FFFFFF");
      $("#tb_people").css("display", "none");
    }

    if(flag == 3){
      $("#li_db_chinabbs").css("background-color", "#FFFFFF");
      $("#tb_chinabbs").css("display", "none");

      $("#li_db_doubangroup").css("background-color", "#FFFFFF");
      $("#tb_doubangroup").css("display", "none");

      $("#li_db_people").css("background-color", "#51a351");
      $("#tb_people").css("display", "");
    }

  }

</script>


<jsp:include page="static/header.jsp"/>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
  <div  class="quick-actions_homepage" style="margin:0px;">
    <ul class="quick-actions">
      <li id="li_db_chinabbs"> <a href="javascript:click_websites(1)"> <i class="icon-dashboard"></i> 中华网BBS </a> </li>
      <li id="li_db_doubangroup"> <a href="javascript:click_websites(2)"> <i class="icon-shopping-bag"></i> 豆瓣小组</a> </li>
      <li id="li_db_people"> <a href="javascript:click_websites(3)"> <i class="icon-web"></i> 人民网 </a> </li>
    </ul>
  </div>
<script>

  function display(value){
    //中华网BBS
    $("#bbs_china_author_disid").css("display", "none");
    $("#bbs_china_comment_disid").css("display", "none");
    $("#bbs_china_post_disid").css("display", "none");

    //豆瓣小组
    $("#douban_group_author_disid").css("display", "none");
    $("#douban_group_comment_disid").css("display", "none");
    $("#douban_group_fans_disid").css("display", "none");
    $("#douban_group_post_disid").css("display", "none");
    $("#"+value+"_disid").css("display", "");
  }

</script>

  <!-- 中华网BBS -->
  <div id="tb_chinabbs" class="quick-actions_homepage" style="margin:0px;padding-top:-20px;">
    <ul class="quick-actions" >
      <li> <a href="javascript:display('bbs_china_author')"> 作者author </a> </li>
      <li> <a href="javascript:display('bbs_china_comment')"> 评论comment</a> </li>
      <li> <a href="javascript:display('bbs_china_post')"> 帖子post </a> </li>
    </ul>

    <!-- 中华网 - 作者 -->
    <form action="choose_datas" method="post" id="bbs_china_author_disid">
      <input type="hidden" name="htable" value="bbs_china_author"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
        <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
          <h5>作者</h5>
        </div>
        <div class="widget-content nopadding">
          <table class="table table-bordered table-striped with-check">
            <thead>
            <tr>
              <th><i class="icon-resize-vertical"></i></th>
              <th>序号</th>
              <th>字段</th>
              <th>释义</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="km" items="${bbs_china_author_keyMeanings}" varStatus="ind">
              <tr>
                <td>
                  <div class="checker" id="uniform-undefined">
                    <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                  </div>
                </td>
                <td>${ind.index + 1} </td>
                <td>${km.keyName}</td>
                <c:forEach var="field" items="${bbs_china_author_fields}">
                  <c:if test="${km.keyName eq field}">
                    <td>${km.meaning}</td>
                  </c:if>
                </c:forEach>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <div style="float: right;margin-top: -10px;">
       <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
      </div>
    </div>
    </form>

    <!-- 中华网 - 评论 -->
    <form action="choose_datas" method="post" id="bbs_china_comment_disid" style="display: none">
      <input type="hidden" name="htable" value="bbs_china_comment"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>评论</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${bbs_china_comment_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${bbs_china_comment_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

    <!-- 中华网 - 发布 -->
    <form action="choose_datas" method="post" id="bbs_china_post_disid" style="display: none">
      <input type="hidden" name="htable" value="bbs_china_post"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>发布</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${bbs_china_post_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${bbs_china_post_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

  </div>

  <!-- 豆瓣小组 -->
  <div id="tb_doubangroup" class="quick-actions_homepage" style="margin:0px;padding-top:-20px; display: none">
    <ul class="quick-actions">
      <li> <a href="javascript:display('douban_group_author')"> 作者author </a> </li>
      <li> <a href="javascript:display('douban_group_comment')"> 评论comment</a> </li>
      <li> <a href="javascript:display('douban_group_fans')"> 粉丝fans</a> </li>
      <li> <a href="javascript:display('douban_group_post')"> 发布post</a> </li>
    </ul>
    <!-- 豆瓣小组 - 作者 -->
    <form action="choose_datas" method="post" id="douban_group_author_disid" style="display: block">
      <input type="hidden" name="htable" value="douban_group_author"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5></h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${douban_group_author_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${douban_group_author_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

    <!-- 豆瓣小组 - 评论 -->
    <form action="choose_datas" method="post" id="douban_group_comment_disid" style="display: none;">
      <input type="hidden" name="htable" value="douban_group_comment"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>评论</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${douban_group_comment_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${douban_group_comment_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

    <!-- 豆瓣小组 - 粉丝 -->
    <form action="choose_datas" method="post" id="douban_group_fans_disid" style="display: none;">
      <input type="hidden" name="htable" value="douban_group_fans"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>粉丝</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${douban_group_fans_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${douban_group_fans_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

    <!-- 豆瓣小组 - 发布 -->
    <form action="choose_datas" method="post" id="douban_group_post_disid" style="display: none;">
      <input type="hidden" name="htable" value="douban_group_post"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>发布</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${douban_group_post_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${douban_group_post_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

  </div>

  <!-- 人民网 -->
  <div id="tb_people" class="quick-actions_homepage" style="margin:0px;padding-top:-20px; display: none">
    <ul class="quick-actions">
      <li> <a href="javascript:display('people_news')"> 新闻news </a> </li>
    </ul>

    <form action="choose_datas" method="post" id="people_news_disid">
      <input type="hidden" name="htable" value="people_news"/>
      <div style="width: 35%; margin:0 auto;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon">
            <div class="checker" id="uniform-title-checkbox"><span><input type="checkbox" id="title-checkbox" name="title-checkbox" style="opacity: 0;"></span></div>
            </span>
            <h5>新闻</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
              <tr>
                <th><i class="icon-resize-vertical"></i></th>
                <th>序号</th>
                <th>字段</th>
                <th>释义</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="km" items="${people_news_keyMeanings}" varStatus="ind">
                <tr>
                  <td>
                    <div class="checker" id="uniform-undefined">
                      <span><input type="checkbox" name="show_field_id" value="${km.id}" style="opacity: 0;"></span>
                    </div>
                  </td>
                  <td>${ind.index + 1} </td>
                  <td>${km.keyName}</td>
                  <c:forEach var="field" items="${people_news_fields}">
                    <c:if test="${km.keyName eq field}">
                      <td>${km.meaning}</td>
                    </c:if>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div style="float: right;margin-top: -10px;">
          <input class="btn btn-success" type="submit" value="显示选中字段数据"/>
        </div>
      </div>
    </form>

  </div>

  <div class="container-fluid">

    <div class="widget-box">

    </div>

  </div>
</div>

<jsp:include page="static/footer.jsp"/>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/maruti.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/maruti.tables.js"></script>

<script type="text/javascript">
  $(function(){
    var count = 0;
    $(".tablist :checkbox").click(function(){
      var txtvalue = $(this).parent().next().text();
      if ($(".txtValue").val() == ""){
        if ($(this).attr("checked") == true){
          var txtalso = $.trim(txtvalue);
        } else {
          var txtalso = "";
        }
      }
      else {
        if ($(this).attr("checked") == true){
          var txtalso = $.trim($(".txtValue").val()) + "," + $.trim(txtvalue);
        }
        else {
          var txtelse = $.trim($(".txtValue").val());
          var txtnow = $.trim(txtvalue);
          var reg1 = "," + txtnow;
          var reg2 = txtnow + ",";
          var reg3 = txtnow;
          var txtelse = txtelse.replace(reg1, "").replace(reg2, "").replace(reg3, "");
          var txtalso = txtelse;
        }
      }
      $(".txtValue").val(txtalso);
      count++;

    });
  });
</script>


</body>
</html>
