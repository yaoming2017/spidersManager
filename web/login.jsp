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
	<form id="loginform" class="form-vertical" method="post" onsubmit="return validate_username_pwd()" action="login">
		<div class="control-group normal_text"><h3>登 录</h3></div>
		<div class="control-group">
			<div class="controls">
				<div class="main_input_box">
					<span class="add-on"><i class="icon-user"></i></span><input id="username" type="text" name="username" placeholder="用户名" onblur="usernameIsString();" />
					<label id="lab_username" style="color:red"></label>
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<div class="main_input_box">
					<span class="add-on"><i class="icon-lock"></i></span><input id="password" type="password" name="password" placeholder="密码" onblur="pwdIsString();" />
					<label id="lab_pwd" style="color:red"></label>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link btn btn-warning" id="to-recover">忘记密码?</a></span>
			<span class="pull-left"><a href="register.jsp" class="flip-link btn btn-warning" style="background-color: #5bc0de" id="to-register">立即注册</a></span>
			<label class="pull-left" id="lab_user_pwd" style="color:red"></label>
			<span class="pull-right"><input type="submit" class="btn btn-success" value="登录" /></span>
		</div>

	</form>
	<form id="recoverform" class="form-vertical">
		<p class="normal_text">密码找回 <br/><font color="#FF6633"></font></p>

		<div class="controls">
			<div class="main_input_box">
				<span class="add-on"><i class="icon-envelope"></i></span><input id="id_email" type="text" name="email" onblur="valid_email()" placeholder="请输入要找回密码的邮箱地址" />
				<label id="lab_email" style="color:red"></label>
			</div>
		</div>

		<div class="form-actions">
			<span class="pull-left"><a href="#" class="flip-link btn btn-warning" id="to-login">&laquo; 返回登录</a></span>
			<span class="pull-right"><input type="button" onclick="findPassword_sendMail()" class="btn btn-info" value="发送" /></span>
		</div>
		<label id="lab_send" style="color:red"></label>
	</form>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/maruti.login.js"></script>
<script src="js/validationForms.js"></script>

<script>
	//用户名验证
	function usernameIsString(){
		var value = $("#username").val();
		var isStr = IsString(value);
		if(!isStr){
			$("#lab_username").text("必须为数字和字母组合，且至少6位");
		}else{
			$("#lab_username").text("");
		}
	}

	//密码验证
	function pwdIsString(){
		var value = $("#password").val();
		var isStr = IsString(value);
		if(!isStr){
			$("#lab_pwd").text("必须为数字和字母组合，且至少6位");
		}else{
			$("#lab_pwd").text("");
		}
	}

	//验证用户名密码
	function validate_username_pwd() {
		var username = $("#username").val();
		var password = $("#password").val();
		var isTrue = false;
		$.ajax({
			type : "POST",
			async:false,
			url:"validate_login?username="+username+"&password="+password,
			success:function (data){
				if(data == 'success'){
					$("#lab_user_pwd").text("");
					isTrue = true;
				}else{
					$("#lab_user_pwd").text("用户名或密码不正确");
					isTrue = false;
				}
			}
		});
		return isTrue;
	}

	//验证邮箱格式、该邮箱下用户是否存在
	function valid_email() {
		var value = $("#id_email").val();
		var isStr = validation_email(value);
		var isTure = false;
		if(!isStr){
			$("#lab_email").text("邮箱格式不正确");
			return false;
		}else{
			$("#lab_email").text("");
			$.ajax({
				type : "post",
				async : false,
				url : "getUserByEmail?email="+value,
				success : function (data) {
					if(data == 'success'){
						isTure = true;
					}else{
						$("#lab_email").text("该邮箱未注册该系统");
						isTure = false;
					}
				}
			});
			return isTure;
		}
	}


	//忘记密码发送邮件
	function findPassword_sendMail(){
		var email = $("#id_email").val();
		if(valid_email() == true){
			$.ajax({
				type : "post",
				url : "findPassword_sendMail?email="+email,
				success : function (data) {
					if(data == 'success'){
						$("#lab_send").text("已成功发送，请登录邮箱验证...");
					}
				}
			});
		}
	}

</script>

</body>

</html>
