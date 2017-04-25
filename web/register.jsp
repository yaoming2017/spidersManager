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
            <form id="loginform" class="form-vertical" method="post" onsubmit="return valid_all()" action="register">
				 <div class="control-group normal_text"><h3>注 册</h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" id="username" name="userName" placeholder="用户名" onblur="valid_username()" />
                            <label id="lab_username" style="color:red"></label>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password"  id="password" name="passwd" placeholder="密码" onblur="valid_password()" />
                            <label id="lab_password" style="color:red"></label>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" id="repassword" placeholder="重复密码" onblur="valid_repassword()" />
                            <label id="lab_repassword" style="color:red"></label>
                        </div>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text"  id="email" name="eMail" placeholder="邮箱" onblur="valid_email()" />
                            <label id="lab_email" style="color:red"></label>
                        </div>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="text"  id="telephone" name="telephone" placeholder="手机号" onblur="valid_telephone()" />

                            <label id="lab_telephone" style="color:red"></label>
                        </div>
                    </div>
                    <!--显示手机验证码 -->
                    <div class="controls" id="div_mobilecode" style="display : none; ">
                        <div class="main_input_box" style="text-align: right; padding-right : 7%;">
                            <span class="add-on" style="display: none"><i class="icon-lock"></i></span><input type="text" style="width:25%;"  id="mobile_code" name="telephone" placeholder="手机验证码" onblur="valid_mobile_code();" />
                            <span class="add-on" style="width:24%; background-color: #62c462;"><input id="btn_sendmobilecode" type="button" onclick="sendMobileCode()" style="border:0; background-color: #62c462;" class="btn btn-success" value="发送验证码" /></span>

                            <label id="lab_mobilecode" style="color:red"></label>
                        </div>
                    </div>

                </div>

                <div class="form-actions">
                    <span class="pull-left"><a href="login.jsp" class="flip-link btn btn-warning" id="to-recover">已有账户? 返回登录</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-success" value="注 册" /></span>
                </div>

            </form>

        </div>
        
        <script src="js/jquery.min.js"></script>  
        <script src="js/maruti.login.js"></script>
        <script src="js/validationForms.js"></script>

    <script>
        function valid_username() {
            var username = $("#username").val();
            var isStr = IsString(username);
            var isTrue = false;
            if(!isStr){
                $("#lab_username").text("必须为数字和字母组合，且至少6位");
                return false;
            }else{
                $.ajax({
                    type : "post",
                    async : false,
                    url : "validate_usernameIsExist?username="+username,
                    success : function (data){
                        if(data == 'success'){
                            $("#lab_username").text("");
                            isTrue = true;
                        }else{
                            $("#lab_username").text("该用户已存在");
                            isTrue = false;
                        }
                    }
                });
            }
            return isTrue;
        }

        function valid_password() {
            var value = $("#password").val();
            var isStr = IsString(value);
            if(!isStr){
                $("#lab_password").text("必须为数字和字母组合，且至少6位");
                return false;
            }else{
                $("#lab_password").text("");
                return true;
            }
        }

        function valid_repassword() {
            var password = $("#password").val();
            var repassword = $("#repassword").val();

            if(password != repassword){
                $("#lab_repassword").text("两次密码不同");
                return false;
            }else{
                $("#lab_repassword").text("");
                return true;
            }
        }

        function valid_email() {
            var value = $("#email").val();
            var isStr = validation_email(value);
            if(!isStr){
                $("#lab_email").text("邮箱格式不正确");
                return false;
            }else{
                $("#lab_email").text("");
                return true;
            }
        }

        function valid_telephone() {
            var value = $("#telephone").val();
            var isStr = validation_telephone(value);
            if(!isStr){
                $("#lab_telephone").text("手机格式不正确");
                $("#div_mobilecode").css("display", "none");
                return false;
            }else{
                $("#lab_telephone").text("");
                $("#div_mobilecode").css("display", "");
                return true;
            }
        }

        function valid_usernameIsExist(){
            var username = $("#username").val();
            var isTrue = false;
            $.ajax({
                type : "post",
                async : false,
                url : "validate_usernameIsExist?username="+username,
                success : function (data){
                    if(data == 'success'){
                        $("#lab_username").text("");
                        isTrue = true;
                    }else{
                        $("#lab_username").text("该用户已存在");
                        isTrue = false;
                    }
                }
            });
            return isTrue;
        }

        //发送手机号
        function sendMobileCode(){
            var telephone = $("#telephone").val();
            $.ajax({
                type : "post",
                url : "telephoneActivation?telephone="+telephone,
                success : function(data){
                    if(data == "success"){
                        //$("#").text("");
                    }
                }
            })
            timeCount();

        }

        function timeCount(){
            var i = 10;
            var timer = setInterval(function(){
                if(i== -1){
                    clearInterval(timer);
                    $("#btn_sendmobilecode").val("发送验证码");
                    $("#btn_sendmobilecode").attr("disabled",false);
                }else{
                    $("#btn_sendmobilecode").val(i+"s");
                    $("#btn_sendmobilecode").attr("disabled",true);
                    $("#btn_sendmobilecode").css("color","white");
                    --i;
                }

            },1000);
        }

        function valid_mobile_code(){
            var mobile_code = $("#mobile_code").val();
            var isTrue = false;
            $.ajax({
                type : "POST",
                async : false,
                url : "valid_mobile_code?mobile_code="+mobile_code,
                success : function (data){
                    if(data == 'success'){
                        $("#lab_mobilecode").text("");
                        isTrue = true;
                    }else{
                        $("#lab_mobilecode").text("验证码错误或失效");
                        isTrue = false;
                    }
                }
            });
            return isTrue;
        }

        //验证所有
        function valid_all(){
            //验证用户名、用户名是否存在、密码
            if(valid_username() && valid_usernameIsExist() && valid_password()
                    //验证重复密码、邮箱
                    && valid_repassword() && valid_email()
                    //验证重复手机号、手机验证码
                    && valid_telephone()  && valid_mobile_code()){
                return true;
            }
            return false;
        }

    </script>
    </body>

</html>
