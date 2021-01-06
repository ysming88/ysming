<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/8/29
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <style>
        .L{
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
        .loginarea{
            height: 620px;
            border: 1px solid #ccc;
            margin-top: 20px;
            background: url("pic/夜晚.jpg") no-repeat;
        }
        .loginform{
            height: 500px;
            width: 350px;
            /*border: 2px solid #ccc;*/
            margin: 40px auto 0px;

        }
        h3{
            display: inline-block;
            width: 350px;
            text-align: center;
            color: deepskyblue;
            font-size: 28px;
        }
        .log_form{
            width: 300px;
            margin: 30px auto 0px;
        }
        .log_form form li{
            margin-bottom: 30px;
            margin-left: 25px;
            list-style-type:none;
        }
        .log_form form li input{
            margin-left: 10px;
            width: 200px;
            height: 30px;
            border: 1px solid #ccc ;
            padding-left: 15px;
            border-radius: 15px;
        }
        .login1{
            width: 100px;
            margin: 30px auto 0px;
            margin-top: 40px;
            margin-left: 90px;
        }
        .login{
            background-color: #007bff;
            color: white;
            height: 30px;
            width: 120px;
            border: 0px solid ;
            border-radius: 5px;
        }
        .footer{
            font-size: 15px;
            font-weight: 400;
            margin-top: 40px;
            margin-left: 30px;
        }
        .remember{
            width: 290px;
            float:right;
        }
    </style>
</head>
<body>
<div class="L">
    <header>
        <div class="logo">
            <img src="pic/blog1.png" alt=""><p>博客</p>
            ${registersucceed}
        </div>
        <div class="register">没有账号，立即 <a href="register.jsp">注册</a></div>
    </header>
    <div class="loginarea">
        <div class="loginform">
            <h3 >登录</h3>
            <div class="log_form">
                <form method="post" id="form" action="<%=path%>/loginServlet" >
                    <li><label >邮箱</label><input type="text" id="email" name="email" value="${email}" placeholder="请输入邮箱号"></li>
                    <li><label >密码</label><input type="password" id="password" name="password" placeholder="请输入密码"></li>
                    <div class="login1">
                        <button class="login" type="button" name="loginButton" onclick="loginVerify();" >登录</button>
                        ${error}
                    </div>
                    <h3 class="footer">
                        <a href="forgetpassword.jsp">忘记密码</a>
                        <div class="remember"><input type="checkbox" checked="checked" >记住密码</div>
                    </h3>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    function loginVerify() {

        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        if(email == ''){
            alert('邮箱号不能为空，请您重新输入！');
            return;
        }
        if(password == '') {
            alert('密码不能为空，请您重新输入！');
            return;
        }
        //调用后端servlet,并将数据进行传递
        document.getElementById("form").submit();
    }
</script>
