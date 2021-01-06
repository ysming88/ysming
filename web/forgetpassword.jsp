<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/24
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
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
        function ensure() {
            document.getElementById("form").submit();
        }
    </script>

    <style>
        .f{
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
        form{
            margin-top: 70px;
            margin-left: 300px;
            width: 600px;

        }
        h3{
            margin-left: 250px;
            color: #0000cc;
        }
        form li{
            margin-top: 20px;
            margin-left: 120px;
            list-style-type:none;
        }
        label{
            font-family: 微软雅黑;
            font-size: 20px;
        }
        form li input{
            margin-top: 10px;
            margin-left: 15px;
            height: 30px;
            width: 300px;
            padding-left: 15px;
        }
        .submit {
            height: 35px;
            width: 100px;
            margin-top: 20px;
            margin-left: 120px;
            background-color: #00a4ff;
            color: white;
            border-radius:15px;
            border: 0;
        }
        .verity{
            width: 175px;
            margin-left: 0px;
            padding-left: 50px;
        }
        .sendVerity{
            width: 180px;
            height: 30px;
        }
    </style>
</head>
<body>
    <div class="f">
        <header>
            <div class="logo">
                <img src="pic/blog1.png" alt=""><p>博客</p>
            </div>
        </header>

      <form method="post" id="form" action="<%=path%>/forgetpasswordServlet">
        <h3>忘记密码</h3>
         <li><label >邮箱:</label><input type="text" id="email" name="email" value="${email}" placeholder="请输入邮箱号"></li>
         <li><input class="verity" type="text"  id="verity" name="verity" value="${verity}" placeholder="短信验证码">
            <button class="sendVerity" type="button" name="sendVerityButton" onclick="sendVerity()";>发送验证码 </button>${error}
         </li>
         <li><label >密码:</label><input type="password" id="password" name="password" value="${password}" placeholder="请输入新密码" >
         <li><button class="submit" type="button" name="ensureButton" onclick="ensure()";>提交</button></li>

      </form>

    </div>
</body>
</html>
