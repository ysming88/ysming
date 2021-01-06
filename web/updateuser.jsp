<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    String email=request.getParameter("email");
    session.setAttribute("email", email);
%>
<html>
<head>
    <title>修改用户信息</title>
    <style>
        .u{
            width: 1200px;
            margin: 0 auto;
        }
        header{
            height: 84px;
            border-bottom: 2px solid deepskyblue;
        }
        .logo {
            float: left;
            display: flex;
        }
        input{
            border-radius: 10px;
            border: 2px solid #ccc;
            padding-left: 10px
        }
        .information{
            margin: 30px auto 50px;
            width: 980px;
            height: 500px;
        }
        .idInformation{
            margin: 10px auto;
            width: 900px;
            margin-bottom: 20px;
        }
        .idInformation div {
            margin-top: 10px;
            overflow: hidden;
        }
        .idInformation li{
            margin-top: 20px;
            overflow: hidden;
        }
        .idInformation input{
            display: inline-block;
            margin-left: 10px;
        }
        h3{
            margin-left: 400px;
            color: #0000cc;
        }
        li{
            overflow: hidden;
            margin-left: 300px;
        }
    </style>

    <script>
        function change() {
            document.getElementById("form").submit();
        }
    </script>
</head>
<body>
<div class="u">

    <header>
        <div class="logo">
            <img src="pic/blog1.png" alt=""><p>博客</p>
        </div>
    </header>

    <div class="information">
        <form method="post" id="form" action="<%=path%>/updateregisterServlet">
            <div class="idInformation">
                <div>
                    <h3 >账号信息</h3>${succeed}
                    <button style="margin-left: 800px" type="button" name="idInformationXG" onclick="change();">修改账号信息</button>
                </div>
                <li><label>用户名:</label><input type="text"  id="username" name="username" value="${username}"></li>
                <li><label>  邮箱:</label><input type="text"style="margin-left: 25px" readonly=“readonly” id="email" name="email" value="<%=email%>" ></li>
                <li><label>  密码:</label><input type="password" style="margin-left: 25px" id="password" name="password" value="${password}"></li>
                <li hidden><input type="text" id="flag" name="flag" value="1"></li>
            </div>
        </form>

    </div>

</div>
</body>
</html>
