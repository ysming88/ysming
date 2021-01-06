<%@ page import="Domain.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/18
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<Category> categorylist=(ArrayList<Category>)session.getAttribute("allCategory");
%>
<html>
<head>
    <title>分类管理</title>
    <style>
        .m{
            width: 1200px;
            /*height: 800px;*/
            /*border: 2px solid #ccc;*/
            margin: 30px auto;
        }
        header{
            height: 85px;
            border-bottom: 2px solid deepskyblue;
        }
        a{
            color: black;
            text-decoration: none;
        }
        input{
            border-radius: 10px;
            border: 2px solid deepskyblue;
            height: 30px;
            width: 200px;
            padding-left: 10px;
            margin-left: 250px;
            margin-top: 20px;
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
        .middle{
            float: right;
            margin: 20px auto 30px;
            width: 800px;
            height: 600px;
            /*border: 1.5px solid #ccc;*/
        }
    </style>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function addcategory() {
            document.getElementById("form").submit();
        }
        function decategory(e) {
            $("#decategory").val(e);
            document.getElementById("form1").submit();
        }
        function updatecategory(e,h) {
            $.ajax({
                type:"post",
                url:"http://localhost:8080/java_web_war_exploded/updatecategoryServlet",
                data:{
                    "id":e,
                    "category":h
                },
                success: function(data) {
                    alert("修改成功!");
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }
    </script>
</head>
<body>
<div class="m">
    <h2 style="margin: 10px auto 10px;text-align: center">管理系统</h2>
    <div class="left">

        <a  href="<%=path%>/blogmanageServlet">博客管理</a>
        <a  href="<%=path%>/usermanageServlet">用户管理</a>
        <a  id="categorymanage" href="<%=path%>/categorymanageServlet">分类管理</a>
        <a  href="<%=path%>/categorymanageServlet">广告管理</a>
        <a  href="<%=path%>/login.jsp">退出登录</a>
        <script type="text/javascript">
            document.getElementById("categorymanage").style.backgroundColor=("#cccccc");
        </script>

    </div>
<%--    <header>--%>
<%--                <a href="<%=path%>/administratorServlet" style="float: left">返回</a>--%>
<%--                <h2 style="margin: 30px auto 10px;text-align: center">分类管理</h2>--%>
<%--    </header>--%>

    <div class="middle" style="margin-right: 150px">
        <div >
            <form method="post" id="form" action="<%=path%>/addcategoryServlet">
                <input id="category" name="category" type="text">
                <button onclick="addcategory();">添加分类</button>
            </form>
        </div>
        <div>
            <h3 style="text-align: center">分类专栏</h3>
            <div class="categorylist">
                <% for(Category category:categorylist)
                {
                %>
                <div>
                    <input type="text" id="<%=category.getId()%>" value="<%=category.getCategory()%>">
                    <button type="button" onclick="decategory('<%=category.getCategory()%>')">删除</button>
                    <button type="button" onclick="updatecategory(<%=category.getId()%>,$('#<%=category.getId()%>').val())">修改</button>
                </div>
                <%
                    }
                %>
            </div>
            <form method="post" id="form1" action="<%=path%>/delecategoryServlet">
                <input hidden type="text" id="decategory" name="decategory" value="${decategory}">
            </form>
        </div>
    </div>

</div>
</body>
</html>
