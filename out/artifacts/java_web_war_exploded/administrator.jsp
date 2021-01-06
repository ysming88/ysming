<%@ page import="Domain.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.selectDao" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/8
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<Blog> bloglist=(ArrayList<Blog>)session.getAttribute("bloglist");
%>
<html>
<head>
    <title>管理员</title>

    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function recommend(e) {
            $.ajax({
                type:"post",
                url:"http://localhost:8080/java_web_war_exploded/recommendServlet",
                data:{
                    "id":e,
                },
                success: function(data) {
                    alert("操作成功!");
                    window.location.reload()  //刷新页面
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }

        function check(e) {
            $.ajax({
                type:"post",
                url:"http://localhost:8080/java_web_war_exploded/checkServlet",
                data:{
                    "id":e,
                },
                success: function(data) {
                    alert("操作成功!");
                    window.location.reload()  //刷新页面
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }
    </script>

    <style>
        a{
            color: black;
            text-decoration: none;
        }
        .a{
            width: 1200px;
            /*height: 800px;*/
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
<body >
<div class="a">
    <h2 style="margin: 10px auto 10px;text-align: center">管理系统</h2>
    <div class="left">

        <a id="blogmanage">博客管理</a>
        <a class="" href="<%=path%>/usermanageServlet">用户管理</a>
        <a class="" href="<%=path%>/categorymanageServlet">分类管理</a>
        <a class="" href="<%=path%>/categorymanageServlet">广告管理</a>
        <a class="" href="<%=path%>/login.jsp">退出登录</a>
        <script type="text/javascript">
            document.getElementById("blogmanage").style.backgroundColor=("#cccccc");
        </script>

    </div>
    <div class="right">

        <% for(Blog blog:bloglist)
        {
        %>

        <div class="blog" style="border: 2px solid #06b6ef;margin-top: 10px">
            <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=blog.getOriginal()%></p>
            <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">标题：<%=blog.getTitle()%></h4>

            <a href="<%=path%>/deleteblogServlet?id=<%=blog.getId()%>&writer=1" style="float: right;margin-right: 20px;margin-top: 10px">删除</a>
            <a href="<%=path%>/showblogServlet?title=<%=blog.getTitle()%>&id=<%=blog.getId()%>&email=0" style="float: right;margin-right: 20px;margin-top: 10px">查看</a>
            <input type="button" id="recommend" style="float: right;margin-right: 20px;border:none;font-size: 15px;margin-top: 10px" onclick="recommend(<%=blog.getId()%>)" value="<%=blog.getRecommend()%>">
            <%
                String check =new selectDao().findCheck(blog.getId());
            %>
            <input type="button" id="check" style="float: right;margin-right: 20px;border:none;font-size: 15px;margin-top: 10px" onclick="check(<%=blog.getId()%>)" value="<%=check%>">
            <p style="text-indent: 10px;font-size: 13px;margin-top: 10px"><%=blog.getDate()%></p>

        </div>

        <%
            }
        %>

    </div>
</div>
</body>
</html>
