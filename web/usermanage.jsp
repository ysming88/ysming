<%@ page import="Domain.register" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/8
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<register> userlist=(ArrayList<register>)session.getAttribute("userlist");
%>
<html>
<head>
    <title>用户管理</title>
    <style>
        a{
            color: black;
            text-decoration: none;
        }
        .a{
            width: 1200px;
            height: 800px;
            /*border: 2px solid #ccc;*/
            margin: 30px auto;
        }

        .left{
            margin-top: 30px;
            margin-left: 80px;
            float: left;
            width: 160px;
            /*border: 2px solid #ccc*/
        }
        .left a{
            display: block;
            margin: 10px auto;
            text-align: center;
            line-height: 40px;
            height: 40px;
            width: 150px;
            border-radius: 25px;
            border: 2px solid #ccc
        }
        .left a:hover{
            background: #cccccc;
        }

        .right{
            float: right;
            margin-top: 30px;
            margin-right: 50px;
            width: 900px;


        }
    </style>
</head>
<body>
<div class="a">
    <h2 style="margin: 10px auto 10px;text-align: center">管理系统</h2>
    <div class="left">

        <a class="" href="<%=path%>/blogmanageServlet">博客管理</a>
        <a id="usermanage" href="<%=path%>/usermanageServlet">用户管理</a>
        <a class="" href="<%=path%>/categorymanageServlet">分类管理</a>
        <a class="" href="<%=path%>/categorymanageServlet">广告管理</a>
        <a class="" href="<%=path%>/login.jsp">退出登录</a>
        <script type="text/javascript">
            document.getElementById("usermanage").style.backgroundColor=("#cccccc");
        </script>

    </div>
    <div class="right">

        <% for(register user:userlist)
        {
        %>

        <div class="user" style="border: 2px solid #06b6ef;margin-top: 10px">
            <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=user.getUsername()%></p>
            <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">邮箱：<%=user.getEmail()%></h4>
            <a href="<%=path%>/deleteuserServlet?email=<%=user.getEmail()%>" style="float: right;margin-right: 20px">删除</a>
            <a href="<%=path%>/updateuserServlet?email=<%=user.getEmail()%>" id="recommend" style="float: right;margin-right: 20px">修改</a>

        </div>

        <%
            }
        %>

    </div>
</div>
</body>
</html>
