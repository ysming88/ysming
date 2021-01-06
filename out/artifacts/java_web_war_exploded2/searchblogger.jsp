<%@ page import="Domain.register" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Domain.Blog" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/11
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String email = request.getParameter("email");
%>
<html>
<head>
    <title>博主</title>
    <style>
        li{
            list-style-type:none;
        }
        a{
            text-decoration: none;
            color: black;
        }
        header{
            height: 60px;
            border-bottom: 2px solid deepskyblue;
        }
        .logo {
            float: left;
            display: flex;
            margin-left: 130px;
        }
        .nav{
            float: left;
            margin-left: 50px;
        }
        .nav ul li{
            float: left;
            list-style-type:none;
            width: 80px;
        }
        .nav ul li a{
            text-decoration: none;
        }
        .nav ul li a:hover{
            border-bottom: 2px solid #00a4ff;
            color: #00a4ff;
        }
        .search{
            float: left;
            width: 412px;
            height: 42px;
            margin-left: 10px;
            margin-top: 8px;
        }
        .search input{
            float: left;
            width: 345px;
            height: 40px;
            border: 1px solid deepskyblue;
            border-right: 0;
            color: #bfbfbf;
            font-size: 14px;
            padding-left: 15px;
        }
        .search button{
            float: left;
            width: 50px;
            height: 40px;
            background-color:#00a4ff;
            border: 0;
            color: #cccccc;
        }
        .writeblog{
            margin-left: 130px;
            height: 40px;
            width: 80px;
            color: white;
            background-color: red;
            border: 1px solid ;
            border-radius: 30px;
        }
        .bloggerAndblog{
            margin-top: 20px;
            float: left;
            margin-left:315px;
            width: 900px;
            height: 800px;
            border: 2px solid #cccccc;
        }
        .blog{
            margin-top: 20px;
            margin-left: 20px;
            height: 80px;
            width: 860px;
            border: 1.5px solid #ccc;
        }
    </style>
</head>
<body>
<header>

    <div class="logo">
        <img src="pic/blog.png" alt=""><p>博客</p>
    </div>
    <div class="nav">
        <ul>
            <li><a href="<%=path%>/homeServlet?email=<%=email%>" >首页</a></li>
            <li><a href="#" style="color: blue">博主</a></li>
            <li><a href="#" >    </a></li>
        </ul>
    </div>

    <div class="search">
        <form method="post" id="form" action="<%=path%>/searchbloggerServlet">
            <input type="text" id="keyword" name="keyword" placeholder="请输入博主名或账号" style="color: black">
            <button type="button" onclick="searche()">搜索</button>
        </form>
        <script>
            function searche() {
                document.getElementById("form").submit();
            }
        </script>
    </div>

    <div class="person">
        <button class="writeblog" onclick="window.location='markdown.jsp?email=<%=email%>'">创作博客</button>
        <a><img src="pic/个人.png"></a>
        <%=email%>
        <input hidden form="form" type="text" id="email" name="email" value="<%=email%>">
    </div>

</header>

<div class="bloggerAndblog">
    <%
        ArrayList<register> bloggerlist=(ArrayList<register>)session.getAttribute("bloggerlist");
    %>
    <% for(register bloggger:bloggerlist)
    {
    %>
    <div style="border: 2px solid #06b6ef;margin-top: 10px">
        <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=bloggger.getUsername()%></p>
        <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">邮箱：<%=bloggger.getEmail()%></h4>
        <a href="<%=path%>/bloggerblogServlet?writer=<%=bloggger.getEmail()%>&email=<%=email%>" style="float: right;margin-right: 20px">查看博客</a>
    </div>
    <%
        }
    %>

    <%
        ArrayList<Blog> bloggerbloglist=(ArrayList<Blog>)session.getAttribute("bloggerbloglist");
    %>
    <% for(Blog blog:bloggerbloglist)
    {
    %>
    <div class="blog">
        <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=blog.getOriginal()%></p>
        <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">标题：<%=blog.getTitle()%></h4>
        <a href="<%=path%>/showblogServlet?title=<%=blog.getTitle()%>&id=<%=blog.getId()%>&email=${email}" style="float: right;margin-right: 20px">查看</a>
        <p style="text-indent: 10px;font-size: 13px;margin-top: 10px"><%=blog.getDate()%></p>
    </div>
    <%
        }
    %>
</div>

</body>
</html>
