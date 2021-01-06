<%@ page import="Domain.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.selectDao" %>
<%@ page import="Domain.Label" %>
<%@ page import="Domain.Category" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/5
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Blog> bloglist=(ArrayList<Blog>)session.getAttribute("bloglist");
%>
<html>
<head>
    <title>我的博客</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function category(e) {
            $("#category").val(e);
            document.getElementById("form").submit();
        }
    </script>
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        .m{
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


        .category{
            margin-top: 10px;
            /*float: left;*/
            width: 200px;
            border: 1.5px solid #ccc;
        }
        .category a{
            display: block;
            margin: 10px auto;
            text-align: center;
            line-height: 30px;
            height: 30px;
            width: 150px;
            border-radius: 20px;
        }
        .category a:hover{
            background-color: #cccccc;
        }

        .bloglist{
            margin-top: 15px;
            float: right;
            width: 980px;
            border: 1.5px solid #ccc;
        }
        .blog{
            margin-top: 20px;
            margin-bottom: 20px;
            margin-left: 20px;
            height: 80px;
            width: 930px;
            border: 1.5px solid #ccc;
        }
    </style>

</head>
<body>
    <div class="m">
        <header>
            <div class="logo">
                <img src="pic/blog1.png"><p>博客</p>
            </div>
            <div class="home">
                <img src="pic/home_icon.jpg" ><a href="<%=path%>/homeServlet?email=${email}">主页</a>
                <input form="form" hidden type="text" id="email" name="email" value="${email}">
                <input form="timesearch" hidden type="text" id="emailt" name="emailt" value="${email}">
                <input form="labelsearch" hidden type="text" id="emaill" name="emaill" value="${email}">
            </div>
        </header>

        <div style="float: left">

            <div class="timesearch" style="margin-top: 15px;">
                <form method="post" id="timesearch" action="<%=path%>/timesearchServlet">
                    <input type="text" id="time" name="time" placeholder="输入时间:  xxxx-xx-xx" style="padding-left: 10px;width: 150px;height: 25px;">
                    <button type="button" onclick="timesearch()" style="margin-left: 5px">搜索</button>
                </form>
                <script>
                    function timesearch() {
                        document.getElementById("timesearch").submit();
                    }
                </script>
            </div>

            <div class="category">
                <a id="全部博客"  style="margin-top: 10px;font-weight: bold;text-align: center;font-family: 楷体;font-size: 20px;" href="javascript:;" onclick="category('全部博客')">全部博客</a>
                <p style="margin-top: 10px;color: red;text-align: center;font-family: 楷体;font-size: 20px;">分类专栏</p>
                <%
                    ArrayList<Category> allCategory = new selectDao().category();
                %>
                <%
                    for(Category Category:allCategory)
                    {
                        String category=Category.getCategory();
                %>
                <a id="<%=category%>" href="javascript:;" onclick="category('<%=category%>')"><%=category%></a>
                <%
                    }
                %>
                <p  style="margin-top: 10px;color: red;text-align: center;font-family: 楷体;font-size: 20px;">文章类型</p>
                <a id="原创" href="javascript:;" onclick="category('原创')">原创</a>
                <a id="转发" href="javascript:;" onclick="category('转发')">转发</a>

                <script type="text/javascript">
                    document.getElementById("${bgc}").style.backgroundColor=("#cccccc");
                </script>

                <a href="<%=path%>/mylabelServlet?email=${email}" style="margin-top: 10px;color: red;text-align: center;font-family: 楷体;font-size: 20px;">我的标签</a>
                <div class="labelsearch" style="margin-left: 20px">
                    <%
                        String email = request.getParameter("email");
                        ArrayList<Label> allLabel = new selectDao().label(email);
                    %>
                    <form method="post" id="labelsearch" action="<%=path%>/labelsearchServlet">
                        <select style="height: 25px;" id="label" name="label">
                            <option value="0">--请选择标签--</option>
                            <%
                                for(Label Label:allLabel)
                                {
                                    String label=Label.getLabel();
                            %>
                            <option value="<%=label%>"><%=label%></option>
                            <%
                                }
                            %>
                        </select>
                        <button type="button" onclick="labelsearch()">搜索</button>
                    </form>

                    <script>
                        function labelsearch() {
                            document.getElementById("labelsearch").submit();
                        }
                    </script>
                </div>

            </div>
            <form method="post" id="form" action="<%=path%>/categoryServlet">
                <input hidden type="text" id="category" name="category" value="${category}">
            </form>

        </div>

        <div class="bloglist">
        <% for(Blog blog:bloglist)
        {
         %>

        <div class="blog">
            <p style="text-indent:10px;  display: inline-block;font-size: 13px"><%=blog.getOriginal()%></p>
            <h4 style="text-indent: 20px;margin-top: 10px;display: inline-block">标题：<%=blog.getTitle()%></h4>
            <a href="<%=path%>/deleteblogServlet?id=<%=blog.getId()%>&writer=<%=blog.getWriter()%>" style="float: right;margin-right: 20px">删除</a>
            <a href="<%=path%>/editblogServlet?title=<%=blog.getTitle()%>&id=<%=blog.getId()%>&writer=<%=blog.getWriter()%>" style="float: right;margin-right: 20px">编辑</a>
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
