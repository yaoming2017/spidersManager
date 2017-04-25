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

    <form id="resetform" action="resetPassword_action" class="form-vertical">
        <p class="normal_text">密码重置 <br/><font color="#FF6633"></font></p>

        <div class="controls">
            <div class="main_input_box">
                <span class="add-on"><i class="icon-envelope"></i></span><input id="id_password" type="password" name="password" placeholder="重置密码" />
            </div>
        </div>
        <div class="controls">
            <div class="main_input_box">
                <span class="add-on"><i class="icon-envelope"></i></span><input id="id_repassword" type="password" name="repassword" placeholder="重置密码" />
            </div>
        </div>

        <div class="form-actions">
            <span class="pull-left"><a href="#" class="flip-link btn btn-warning" id="to-relogin">&laquo; 返回登录</a></span>
            <span class="pull-right"><input type="submit" class="btn btn-info" value="重置" /></span>
        </div>
    </form>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/maruti.login.js"></script>
<script src="js/validationForms.js"></script>

<script>

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

    //忘记密码发送邮件
    findPassword_sendMail(){
        var email = $("#id_email").val();
        $.ajax({
            type : "post",
            url : "findPassword_sendMail?email="+email,
            success : function (data) {
                if(data == 'success'){
                    $("#recoverform").css("display", "none");
                }
            }
        });
    }
</script>

</body>

</html>
