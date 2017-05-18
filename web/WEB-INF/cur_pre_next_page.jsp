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

</script>


<div id="content" style="margin-top:36px;">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div id="div_ChinaBBS_1" class="span12" style="">

        <div class="widget-title" style="float:right;width:500px;">
          <span class="icon"><i class="icon-th"></i></span>
          <h5>共${rowCount}条,每页200条</h5>
          <a class="btn btn-info" href="source_datas_display">首页</a>
          <a class="btn btn-primary"  href="get_cur_pre_next_page?curPage=${curPageNo-1}&&startRow=${startRow}">上页</a>
          <a class="btn btn-success">${curPageNo}</a>
          <a class="btn btn-danger" href="get_cur_pre_next_page?curPage=${curPageNo+1}&&startRow=${startRow}">下页</a>
          <a class="btn btn-info" href="get_cur_pre_next_page?curPage=0&&startRow=${startRow}">末页</a>
        </div>
        <div class="widget-box" style="margin-top: -40px;">
          <div class="widget-title">
             <span class="icon"><i class="icon-th"></i></span>
            <h5>中华网BBS数据表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>${field[0]}</th>
                  <th>${field[1]}</th>
                  <th>${field[2]}</th>
                  <th>${field[3]}</th>
                  <th>${field[4]}</th>
                  <th>${field[5]}</th>
                  <th>${field[6]}</th>
                  <th>${field[7]}</th>
                  <th>${field[8]}</th>
                  <th>${field[9]}</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="v" items="${values_list}">
                    <tr class="gradeX">
                        <th>${v[0]}</th>
                        <th>${v[1]}</th>
                        <th>${v[2]}</th>
                        <th>${v[3]}</th>
                        <th>${v[4]}</th>
                        <th>${v[5]}</th>
                        <th>${v[6]}</th>
                        <th>${v[7]}</th>
                        <th>${v[8]}</th>
                        <th>${v[9]}</th>
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
