<%@ page import="Domain.Blog" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/9
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<Blog> bloglist=(ArrayList<Blog>)session.getAttribute("bloglist");
%>
<html>
<head>
    <title>我的收藏</title>

    <style>
        a{
            text-decoration: none;
            color: black;
        }
        .c{
            width: 1200px;
            margin: 0 auto;
        }
        header{
            height: 85px;
            border-bottom: 2px solid deepskyblue;
        }
        .logo {
            float: left;
            display: flex;
        }
        .home{
            height: 50px;
            float: right;
            margin-top: 20px;
            display: flex;
        }
        .home a{
            font-size: 22px;
            text-decoration: none;
            line-height: 60px;
        }
        .logo p{
            font-family: 微软雅黑;
            font-size: 25px;
            margin-bottom: 20px;
        }


    </style>

</head>
<body>

<div class="c">

        <header>
            <div class="logo">
                <img src="pic/blog1.png"><p>博客</p>
            </div>
            <div class="home">
                <img src="pic/home_icon.jpg" ><a href="<%=path%>/homeServlet?email=${email}">主页</a>
            </div>
        </header>

        <div class="bloglist" >
            <% for(Blog blog:bloglist)
            {
            %>

            <div class="blog" style="width: 1200px; height: 80px;margin: 10px auto; border: 2px solid #ccc;">
                <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=blog.getOriginal()%></p>
                <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">标题：<%=blog.getTitle()%></h4>
                <a href="<%=path%>/deletecollectServlet?blogger=<%=blog.getWriter()%>&blogid=<%=blog.getId()%>&visitor=${email}" style="float: right;margin-right: 20px">取消收藏</a>
                <a href="<%=path%>/showblogServlet?title=<%=blog.getTitle()%>&id=<%=blog.getId()%>&email=${email}" style="float: right;margin-right: 20px">查看</a>
                <p style="text-indent: 10px;font-size: 13px;margin-top: 10px"><%=blog.getDate()%></p>
            </div>

            <%
                }
            %>
        </div>
</div>

</body>
</html>
