<%@ page import="Domain.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Domain.register" %>
<%@ page import="Dao.selectDao" %>
<%@ page import="Domain.Category" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/13
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<Blog> bloglist=(ArrayList<Blog>)session.getAttribute("bloglist");

    ArrayList<register> searchblogger=new ArrayList<>();
    session.setAttribute("bloggerlist",searchblogger);

    ArrayList<register> bloggerblog=new ArrayList<>();
    session.setAttribute("bloggerbloglist",bloggerblog);

    String head=(String)session.getAttribute("head");

%>


<html>
<head>
    <title>博客首页</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function category(e) {
            $("#category").val(e);
            document.getElementById("form1").submit();
        }
    </script>
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

        .left{
            margin-top: 20px;
            margin-left: 115px;
            float: left;
            width: 160px;
            border: 1.5px solid #ccc;

        }
        .left a{
            display: block;
            margin: 10px auto;
            text-align: center;
            line-height: 30px;
            height: 30px;
            width: 150px;
            border-radius: 20px;
        }
        .left a:hover{
            background: #cccccc;
        }
        .right a{
            display: block;
            margin-top: 10px;
            height: 30px;
        }
        .person{
            float: right;
            display: flex;
            margin-top: 10px;
            margin-right: 70px;
        }
        .writeblog{
            margin-right: 30px;
            height: 40px;
            width: 80px;
            color: white;
            background-color: red;
            border: 1px solid ;
            border-radius: 30px;
        }
        .person a{
            margin-right: 20px;
        }

        .droplist{
            width: 90px;
            border: 1.5px solid #ccc;
            margin-right: 190px;
        }
        .droplist a{
            height: 25px;
            margin: 10px auto;
            text-align: center;
            line-height: 30px;
            text-decoration: none
        }
        .droplist a:hover{
            background: #cccccc;
        }

        .bloglist{
            margin-top: 20px;
            float: left;
            margin-left:40px;
            width: 900px;
            height: 670px;
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
                <li><a href="#" style="color: blue">首页</a></li>
                <li><a href="searchblogger.jsp?email=${email}">博主</a></li>
                <li><a href="#" >    </a></li>
            </ul>
        </div>

        <div class="search">
            <form method="post" id="form" action="<%=path%>/searchServlet">
                    <input type="text" id="keyword" name="keyword" placeholder="输入关键字" style="color: black">
                    <button type="button" onclick="searche()">搜索</button>
            </form>
            <script>
                function searche() {
                    document.getElementById("form").submit();
                 }
            </script>
        </div>

        <div class="person" style="margin-right: 35px">
                <button class="writeblog" onclick="window.location='markdown.jsp?email=${email}'">创作博客</button>
                <img  src="<%=head%>"  width="40px" height="40px" style="border-radius: 20px">
                <div style="display: inline-block;margin-top: 8px;margin-left: 5px">${email}</div>
            <input hidden form="form" type="text" id="email" name="email" value="${email}">
            <input hidden form="form1" type="text" id="1email" name="1email" value="${email}">
        </div>


    </header>

    <div class="left">
        <%
            ArrayList<Category> allCategory = new selectDao().category();
        %>
        <a id="推荐" href="javascript:;" onclick="category('推荐')">推荐</a>
        <%
            for(Category Category:allCategory)
            {
                String category=Category.getCategory();
        %>
        <a id="<%=category%>" href="javascript:;" onclick="category('<%=category%>')"><%=category%></a>
        <%
            }
        %>
        <script type="text/javascript">
            document.getElementById("${bgc}").style.backgroundColor=("#cccccc");
        </script>
        <form method="post" id="form1" action="<%=path%>/homecategoryServlet">
            <input hidden type="text" id="category" name="category" value="${category}">
        </form>
    </div>

    <div class="bloglist">
        <%--    轮播图--%>
<%--        <div>--%>
<%--            <img id="img" style="margin-top: 20px; float: left;margin-left:40px;width: 900px;height: 100px;">--%>
<%--        </div>--%>
<%--        <script type="text/javascript">--%>
<%--            var imgContainer=[--%>
<%--                "https://img-market.csdnimg.cn/aicms/question/1608605470101067.jpg",--%>
<%--            ]--%>
<%--            var num=1;--%>
<%--            function fun(){--%>
<%--                if(num>=4) num=0;--%>
<%--                var img=document.getElementById("img");--%>
<%--                img.src=imgContainer[num];--%>
<%--                num++;--%>
<%--            }--%>
<%--            setInterval(fun,3000);--%>
<%--        </script>--%>

        <%

         for(Blog blog:bloglist)
        {
            //判断博客是否已被审核
            String audit=new selectDao().findCheck(blog.getId());
            if("已审核".equals(audit))
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
        }
        %>

        <% Integer pag = Integer.parseInt(request.getAttribute("page") + "");%>
        <input hidden type="text" value="<%=pag%>">

        <div class="page" style="width: 100px;margin: 20px auto 20px">
            <%
                Integer i;
                for(i=1;i<=pag;i++){
            %>
                <div id="<%=i%>" style="display: inline-block;border: 2px solid #ccc;width: 25px;height: 25px;border-radius: 5px">
                    <a href="<%=path%>/pageServlet?page=<%=i%>&email=${email}" style="margin-left: 7px;color: #007bff;font-size: 20px;"><%=i%></a>
                </div>
            <%
                }
            %>
            <script type="text/javascript">
                document.getElementById("${p}").style.backgroundColor=("#cccccc");
            </script>
        </div>
    </div>

    <div class="droplist" id="droplist" style="float: right;margin-right: 150px" >
        <a href="<%=path%>/percenterServlet?email=${email}" style="display: block">个人资料</a>
        <a href="<%=path%>/myblogServlet?email=${email}" style="display: block">我的博客</a>
        <a href="<%=path%>/mycollectServlet?email=${email}" style="display: block">我的收藏</a>
        <a href="login.jsp" style="display: block">退出登录</a>
    </div>

    </div>
</body>
</html>
