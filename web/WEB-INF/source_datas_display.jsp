<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String htable = (String) request.getAttribute("htable");
%>
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
</head>
<body>

<jsp:include page="static/header.jsp"/>


<div class="widget-box">
  <div class="widget-title"><span class="icon"><i class="icon-bookmark"></i></span><h5>All Buttons</h5></div>
  <div class="widget-content">
    <h3>各类网站源数据</h3>

    <div class="btn-group">
      <button class="btn btn-primary">中华网</button>
      <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle"><span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a href="javascript:click_bbs_1();">论坛表1</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
    <div class="btn-group">
      <button class="btn btn-danger">Danger</button>
      <button data-toggle="dropdown" class="btn btn-danger dropdown-toggle"><span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
    <div class="btn-group">
      <button class="btn btn-warning">Warning</button>
      <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle"><span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
    <div class="btn-group">
      <button class="btn btn-success">Success</button>
      <button data-toggle="dropdown" class="btn btn-success dropdown-toggle"><span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
      </ul>
    </div>
  </div>
</div>

<script>
  function click_bbs_1(){
    $("#div_ChinaBBS_1").css("display", "");
  }

  function page(value){
    if(value == 'first'){
      window.location.href = "source_datas_display";
    }
    if(value == 'prev'){
      window.location.href = "get_cur_pre_next_page?curPage=${curPageNo-1}&&startRow=${startRow}&&nextPageFlag=0";
    }
    if(value == 'next'){
      window.location.href = "get_cur_pre_next_page?curPage=${curPageNo+1}&&startRow=${startRow}&&nextPageFlag=1";
    }
    if(value == 'last'){
      window.location.href = "get_cur_pre_next_page?curPage=-1&&startRow=${startRow}";
    }
  }
</script>

<div id="content" style="margin-top:36px;overflow:scroll;">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div id="div_ChinaBBS_1" class="span12" style="">

        <div class="widget-title" style="float:right;width:500px;">
          <span class="icon"><i class="icon-th"></i></span>
          <h5>共${rowCount}条,每页200条</h5>
          <a class="btn btn-info" href="javascript:page('first')">首页</a>
          <a class="btn btn-primary"  href="javascript:page('prev')">上页</a>
          <a class="btn btn-success">${curPageNo}</a>
          <a class="btn btn-danger" href="javascript:page('next')">下页</a>
          <a class="btn btn-info" href="javascript:page('last')">末页</a>
        </div>
        <div class="widget-box" style="margin-top: -40px;">

          <div class="widget-title">
             <span class="icon"><i class="icon-th"></i></span>
            <h5 id="id_htable"><%=session.getAttribute("htable")%></h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <c:forEach var="field" items="${field}">
                    <th><a href="clean_data?field=${field}&&htable=<%=session.getAttribute("htable")%>">${field}</a></th>
                  </c:forEach>
                </tr>
                <tr>
                  <c:forEach var="fm" items="${field_meanings}">
                    <th>${fm}</th>
                  </c:forEach>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="values" items="${values_list}">
                    <tr class="gradeX">
                      <c:forEach var="v" items="${values}">
                        <th>${v}</th>
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
