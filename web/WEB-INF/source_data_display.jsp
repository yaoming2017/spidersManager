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
  <link rel="stylesheet" type="text/css" href="css/datasources/amazonmenu.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/datasources/amazonmenu.js"></script>
  <script>
    jQuery(function(){
      amazonmenu.init({
        menuid: 'mysidebarmenu'
      })
    })
  </script>

</head>
<body>

<jsp:include page="static/header.jsp"/>


<div class="widget-box">
  <div class="widget-title"><span class="icon"><i class="icon-bookmark"></i></span><h5>All Buttons</h5></div>
  <div class="widget-content" style="height: 300px;">
    <h3>源数据清洗过程</h3>
    <div class="widget-title">
      <span class="icon"><i class="icon-th"></i></span>
      <h5 id="">数据清洗策略</h5>
    </div>
    <nav id="mysidebarmenu" class="amazonmenu" style="float:left;">
      <ul>
          <c:forEach items="${cleanDataEntityList}" var="cd">
            <c:if test="${cd.fid == null}">
              <li>
                <a href="#">${cd.name}</a>
                <ul>
                  <c:forEach items="${cleanDataEntityList}" var="cde">
                    <c:if test="${cd.id == cde.fid}">
                      <li style="height:100%"><a href="#">${cde.name}</a>
                        <ul style="height:100%">
                          <c:forEach items="${cleanDataEntityList}" var="cden">
                            <c:if test="${cde.id == cden.fid}">
                              <li><a href="javascript: showDetail('${cden.id}', '${cden.name}');">${cden.name}</a></li>
                            </c:if>
                          </c:forEach>
                        </ul>
                      </li>
                    </c:if>
                  </c:forEach>
                </ul>
              </li>
            </c:if>
          </c:forEach>
        </ul>
    </nav>
<script>
//显示“具体清洗方法”:
  function showDetail(cid, cname) {
    $("#choose_name").html(cname);
    $.ajax({
      type : "get",
      dataType : 'JSON',
      url : "getcleanDataProcessByCleanDataId?cid="+cid,
      success : function (data) {
        var cleanDataProcessList = eval(data);
//        //初始化：
        $("#process_detail").html("");
        //动态添加
        $.each(cleanDataProcessList, function (i, item) {
          if (item.name == '自定义方法'){
            $("#process_detail").append(
              '<label style="font-size : 12px"><input type="radio" name = "process_id" value="'+item.id+'" onclick="javascript:showCustom();" id="process_id"/> 自定义方法</label>' +
              '<label id="custom" style="font-size : 12px; display:none;">自定义格式：<input type="text" name = "custom_value" style="font-size : 12px; width:100px;height:16px;"/> </label>'
            );
          }else{
            $("#process_detail").append(
              '<label style="font-size : 12px"><input type="radio" name = "process_id" value="'+item.id+'" onclick="javascript:showCustom();"/> '+ item.name +":"+item.value+'</label>'
            );
          }
        });
      }
    });
  }
</script>
    <form action="clean_detailed_method" method="post">
        <div style="width:100%; height:300px; border:1px solid red">
          <div style="float:left; padding-right:20px;" class="widget-title">
            <div class="widget-content nopadding" style="border-bottom:0">
              <h5>选定的清洗字段：</h5>
              <!-- 传递到后台htable中数据的fields，即chose_fields -->
              <input id="hidden_fields" type="hidden" name="chose_fields"/>
              <br><br>
              <div id="clean_fields_show" style="height:150px; border:1px solid #cdcdcd; border-radius:3px; overflow:auto">
                <%--<div class="widget-content nopadding" style="border-bottom:0">
                  <code>bbs_china_author:</code>
                  <code>address</code>
                </div>
                <div class="widget-content nopadding">
                  <code>bbs_china_author:</code>
                  <code>address</code>
                </div>--%>
              </div>
            </div>
          </div>
          <!-- “选定的清洗字段”的显示与取消 -->
          <script>
            var htable_names = new Array();
            //显示“选定的字段清洗”：
            function show_choose_field(htable, id, name) {
              var htable_name = htable + ":" + name + ":" + id;
              //htable_name不存在htable_names中, 且被选中
              if(htable_names.indexOf(htable_name) == -1 && $("#clean_field"+id).attr("checked") == 'checked'){
                htable_names[htable_names.length] = htable_name;
                $("#clean_fields_show").append(
                        '<div class="widget-content nopadding" id="htable_name_id'+id+'">' +
                        '<code>'+htable+':</code>' +
                        '<code>'+name+'</code>' +
                        '</div>'
                );
              }
              if(htable_names.indexOf(htable_name) != -1 && $("#clean_field"+id).attr("checked") != 'checked'){
                $.each(htable_names, function(index, item){
                  if(item == htable_name){
                    htable_names.splice(index, 1);
                  }
                });
                $("#htable_name_id"+id).remove();
              }
              //将htable_names数组中数据放入value中赋值到input[hidden]中
              var value = '';
              $.each(htable_names, function (index, item) {
                value = value + item +",";
              });
              $("#hidden_fields").val(value);
            }
          </script>

          <!-- 选择左边的清洗策略 -->
          <div style="float:left; padding-right:20px;" class="widget-title">
            <div class="widget-content nopadding" style="border-bottom:0">
              <h5>选定的清洗策略：</h5>
              <br><br>
              <div style="border:1px solid #cdcdcd; border-radius:3px;">
                <div class="widget-content nopadding" style="border-bottom:0">
                  <!-- 传到后台的clean_data中id 即：clean_id -->
                  <input id="clean_id" type="hidden" name="clean_id"/>
                  <code id="choose_name">选择左边的清洗策略</code>
                </div>
              </div>
            </div>
          </div>

          <!-- 选择具体清洗方法 -->
          <div style="float:left; border-right:1px solid #CDCDCD" class="widget-title">
            <div class="widget-content nopadding" style="border-bottom:0">
              <h5>具体清洗方法：</h5>
              <br><br>
              <div style="border:1px solid #cdcdcd; border-radius:3px; padding-right:20px;">
                <div class="widget-content nopadding" style="border-bottom:0">
                    <div class="controls" id = "process_detail">
                        <%--<label style="font-size : 12px"><input type="radio" name = "process_id" onclick="javascript:showCustom();"/> 清洗方法1 ： XXXX-XX-XX</label>
                        <label style="font-size : 12px"><input type="radio" name = "process_id" onclick="javascript:showCustom();"/> 清洗方法2 ： XXXX.XX.XX</label>--%>
                      <%--<label style="font-size : 12px"><input type="radio" name = "process_id" onclick="javascript:showCustom();" id="process_id"/> 自定义方法</label>
                      <label id="custom" style="font-size : 12px; display:none;">自定义格式：<input type="text" name = "clean_process_id" style="font-size : 12px; width:100px;height:16px;"/> </label>--%>
                    </div>
                    <button class="btn btn-primary" style="float:right; margin-top:15px;">确定</button>
                </div>
              </div>
            </div>
          </div>
        </div>
    </form>
  </div>
</div>
<script>
  //是否显示自定义按钮：
  function showCustom(){
    if($("#process_id").attr("checked") == 'checked'){
      $("#custom").css("display", "");
    }else{
      $("#custom").css("display", "none");
    }
  }
</script>

<div id="content" style="margin-top:36px; overflow:scroll; clear: both;">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
  </div>
  <div class="widget-title">
    <span class="icon"><i class="icon-th"></i></span>
    <h5>选择清洗对象</h5>
  </div>
  <c:forEach var="tf" items="${tableFieldsList}">
    <div class="container-fluid">
    <div class="row-fluid">
      <div id="div_ChinaBBS_1" class="span12" style="">
        <div class="widget-box" style="">

          <div class="widget-title">
             <span class="icon"><i class="icon-th"></i></span>
            <h5 class="cls_htable" id="id_htable">${tf.htable.keyName}</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <c:forEach var="f" items="${tf.fields}">
                    <th style="font-size: 14px;">
                      <div class="controls">
                        <label><div class="checker" id="uniform-undefined">
                            <span class=""><input type="checkbox" name="radios" id="clean_field${f.id}" onclick="javascript:show_choose_field('${tf.htable.keyName}', '${f.id}', '${f.keyName}');" style="opacity: 0;">
                            </span>
                          </div>${f.keyName}</label>
                      </div>
                    </th>
                  </c:forEach>
                </tr>
                <tr>
                  <c:forEach var="f" items="${tf.fields}">
                    <th style="font-size: 14px;">${f.meaning}</th>
                  </c:forEach>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="lv" items="${tf.values}">
                    <tr class="gradeX">
                      <c:forEach var="v" items="${lv}">
                        <td>${v}</td>
                      </c:forEach>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

      </div>
    </div>
  </div>
  </c:forEach>
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

</body>
</html>
