<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/29
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script  type="text/javascript">
        function passwordVerify() {
            var password = document.getElementById("password").value;
            var repassword = document.getElementById("repassword").value;
            if( password!=""&&repassword!=""){
                if( password == repassword)
                {
                    document.getElementById("tishi").innerHTML="<font color='green'>密码确认正确</font>";
                    document.getElementById("button").disabled = false;
                }
                else
                {
                    document.getElementById("tishi").innerHTML="<font color='red'>确认密码与密码输入不一致</font>";
                    document.getElementById("button").disabled = true;
                    return;
                }
            }

        }
        function emailVerity() {
            var email = document.getElementById('email').value;
            var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
            if(email!=""){
                if(myReg.test(email)){
                    document.getElementById("hmtishi").innerHTML="<font color='green'>邮箱格式正确</font>";
                }
                else
                {
                    document.getElementById("hmtishi").innerHTML="<font color='red'>邮箱格式错误</font>";
                }
            }

        }
        function sendVerity() {
            $.ajax({
                type:"get",
                url:"http://localhost:8080/java_web_war_exploded/emailServlet",
                data:{
                    "email":$("#email").val()
                },
                success: function(data) {
                    alert("发送成功!");
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }
        function registerVerity() {
            document.getElementById("form").submit();
        }

    </script>

    <style>
        .w{
            width: 1200px;
            margin: 0 auto;
        }
        header{
            height: 84px;
            border-bottom: 2px solid deepskyblue;
        }
        .logo{
            display: flex;
        }
        p{
            font-family: 微软雅黑;
            font-size: 25px;
            margin-bottom: 20px;
        }
        .registerarea{
            height: 522px;
            border: 1px solid #ccc;
            margin-top: 20px;
        }
        .registerarea h3{
            height: 42px;
            background-color: #ececec;
            border-bottom: 1px solid #ccc;
            margin-top: 0px;
            line-height: 42px;
            padding: 0 10px;
            font-size: 18px;
            font-weight: 400;
        }
        .login{
            float:right;
            font-size: 14px;
        }
        .reg_form{
            width: 700px;
            margin-top: 35px;
            margin-left: 390px;
        }
        .reg_form form li{
            margin-bottom: 15px;
        }
        .reg_form form li label{
            display: inline-block;
            width: 100px;
            text-align: right;
        }
        .reg_form form li input{
            width: 242px;
            height: 37px;
            border: 1px solid #ccc ;
            margin-left: 15px;
            padding-left: 15px;
        }
        .reg_form form li .verity{
            width: 200px;
            padding-left: 70px
        }
        .reg_form form li .sendVerity{
            margin-left: 30px;
            height: 36px;
            width: 108px;
        }
        .error{
            color: #c81523;
        }
        .error_icon,
        .success_icon {
            display: inline-block;
            vertical-align: middle;
            height: 24px;
            width: 24px;
            background: url("pic/error_icon.png") no-repeat;
            margin-top: -2px;
        }
        .success{
            color: green;
        }
        .success_icon{
            background: url("pic/success_icon.png") no-repeat;
        }
        .register{
            margin-top: 20px;
            margin-left: 90px;
            width: 200px;
            height: 36px;
            color: white;
            background-color: #337ab7;
            border: 1px solid white;
            border-radius: 15px;
        }
        .reg_form form div{
            margin-top: 30px;
            margin-left: 120px;
        }
        .foot{
            width: 200px;
            height: 50px;
            margin-right: 200px;
        }
        form li{
            list-style-type:none;
        }
    </style>
</head>
<body>
<div class="w">
    <header>
        <div class="logo">
            <img src="pic/blog1.png" alt=""><p>博客</p>
        </div>
    </header>
    <div class="registerarea">
        <h3>注册新用户
            <div class="login">我有账户，请 <a href="login.jsp" target="_self">登录</a></div>
        </h3>
        <div class="reg_form">
            <form method="post" id="form" action="<%=path%>/registerServlet" >
                <li><label >用户名：</label><input type="text" id="username" name="username" value="${username}" placeholder="请输入用户名">
<%--                    <span class="error"> <i class="error_icon"></i>手机号码格式不正确，请重新输入</span></li>--%>
                <li><label >登录密码：</label><input type="password" id="password" name="password" value="${password}" placeholder="请输入密码" >
<%--                    <span class="error"> <i class="error_icon"></i>手机号码格式不正确，请重新输入</span></li>--%>
                <li><label >确认密码：</label><input type="password" id="repassword" name="repassword" value="${repassword}"  onblur="passwordVerify()"  placeholder="请重新输入密码">
                        <span id="tishi"></span>
<%--                    <span class="error"> <i class="error_icon"></i>确认密码与密码不一致</span></li>--%>
                <li><label >邮箱：</label><input  type="text" id="email" name="email" onblur=" emailVerity()" placeholder="请输入邮箱账号">
                        <span id="hmtishi"></span>
<%--                    <span class="error"> <i class="error_icon"></i>邮箱账号格式不正确</span></li>--%>
                <li><input class="verity" type="text"  id="verity" name="verity" value="${verity}" placeholder="短信验证码">
                    <button class="sendVerity" type="button" name="sendVerityButton" onclick="sendVerity()";>发送验证码 </button>
<%--                    <span class="success"> <i class="success_icon"></i>短信验证码输入正确</span>--%>
                </li>
                <li><button class="register" type="button" name="registerButton" onclick="registerVerity()";>注册</button></li>
                ${error}
                <div class="agree"><input type="checkbox" checked="checked" >同意协议并注册</div>
            </form>
        </div>
    </div>

</div>
</body>
</html>


