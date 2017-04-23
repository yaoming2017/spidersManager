<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Social Mind 后台管理</title><meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="css/maruti-login.css" />
</head>
<body>
<div id="logo">
	<img src="img/login-logo.png" alt="" />
</div>
<div id="loginbox">
	<form id="loginform" class="form-vertical" action="index.html">
		<div class="control-group normal_text"><h3>登 录</h3></div>
		<div class="control-group">
			<div class="controls">
				<div class="main_input_box">
					<span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="用户名" />
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<div class="main_input_box">
					<span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="密码" />
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link btn btn-warning" id="to-recover">忘记密码?</a></span>
			<span class="pull-left"><a href="register.jsp" class="flip-link btn btn-warning" style="background-color: #5bc0de" id="to-recover">立即注册</a></span>
			<span class="pull-right"><input type="submit" class="btn btn-success" value="登录" /></span>
		</div>

	</form>
	<form id="recoverform" action="#" class="form-vertical">
		<p class="normal_text">密码找回 <br/><font color="#FF6633"></font></p>

		<div class="controls">
			<div class="main_input_box">
				<span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="请输入要找回密码的邮箱地址" />
			</div>
		</div>

		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link btn btn-warning" id="to-login">&laquo; 返回登录</a></span>
			<span class="pull-right"><input type="submit" class="btn btn-info" value="发送" /></span>
		</div>
	</form>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/maruti.login.js"></script>
</body>

</html>
