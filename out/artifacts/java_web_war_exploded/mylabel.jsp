<%@ page import="Domain.Label" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/17
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    String email=(String) session.getAttribute("email");
    ArrayList<Label> labellist=(ArrayList<Label>)session.getAttribute("allLabel");
%>
<html>
<head>
    <title>我的标签</title>
    <style>
        .m{
            width: 1200px;
            height: 800px;
            margin: 0 auto;
            /*border: 1.5px solid #ccc;*/
        }
        header{
            height: 85px;
            border-bottom: 2px solid deepskyblue;
        }
        input{
            border-radius: 10px;
            border: 2px solid #ccc;
            height: 30px;
            width: 200px;
            padding-left: 10px;
            margin-left: 250px;
            margin-top: 20px;
        }
        .logo {
            float: left;
            display: flex;
        }
        .middle{
            margin: 20px auto 30px;
            width: 800px;
            height: 600px;
            /*border: 1.5px solid #ccc;*/
        }
    </style>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script>
        function addlabel() {
            document.getElementById("form").submit();
        }
        function delelable(e) {
            $("#delelabel").val(e);
            document.getElementById("form1").submit();
        }
        function updatelable(e,h) {
            $.ajax({
                type:"post",
                url:"http://localhost:8080/java_web_war_exploded/updatelabelServlet",
                data:{
                    "id":e,
                    "label":h
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
        <header>
            <div class="logo">
                <img src="pic/blog1.png"><p>博客</p>
            </div>
            <a href="<%=path%>/myblogServlet?email=<%=email%>" style="float: right;margin-top: 20px">返回</a>
        </header>

        <div class="middle">
            <div style="margin-top: 30px">
                <form method="post" id="form" action="<%=path%>/addlabelServlet">
                    <input id="label" name="label" type="text">
                    <button onclick="addlabel();">添加标签</button>
                </form>
            </div>
            <div>
                <h3 style="margin-top: 30px;text-align: center">我的标签</h3>
                <div class="labellist">
                    <% for(Label label:labellist)
                    {
                    %>
                    <div>
                            <input type="text" id="<%=label.getId()%>" value="<%=label.getLabel()%>">
                            <button type="button" onclick="delelable('<%=label.getLabel()%>')">删除</button>
                            <button type="button" onclick="updatelable(<%=label.getId()%>,$('#<%=label.getId()%>').val())">修改</button>
                    </div>
                    <%
                        }
                    %>
                </div>
                <form method="post" id="form1" action="<%=path%>/delelabelServlet">
                    <input hidden type="text" id="delelabel" name="delelabel" value="${delelabel}">
                </form>
            </div>
        </div>

    </div>
</body>
</html>
