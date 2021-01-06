<%@ page import="Domain.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.selectDao" %>
<%@ page import="Domain.register" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/10/6
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%
    ArrayList<Comment> commentlist=(ArrayList<Comment>)session.getAttribute("commentlist");
%>

<script type="text/javascript" src="https://upcdn.b0.upaiyun.com/libs/jquery/jquery-2.0.2.min.js"></script>
<script src="static/editormd/lib/marked.min.js"></script>
<script src="static/editormd/lib/prettify.min.js"></script>
<script src="static/editormd/lib/raphael.min.js"></script>
<script src="static/editormd/lib/underscore.min.js"></script>
<script src="static/editormd/lib/sequence-diagram.min.js"></script>
<script src="static/editormd/lib/flowchart.min.js"></script>
<script src="static/editormd/lib/jquery.flowchart.min.js"></script>
<script src="static/editormd/editormd.min.js" type="text/javascript" charset="utf-8"></script>

<html>
<head>
    <title>博客</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var testEditor;
        $(function() {
            testEditor = editormd.markdownToHTML("doc-content", {//注意：这里是上面DIV的id
                htmlDecode : "style,script,iframe",
                emoji : true,
                taskList : true,
                tex : true, // 默认不解析
                flowChart : true, // 默认不解析
                sequenceDiagram : true, // 默认不解析
                codeFold : true
            });
        });
        function comment() {
            $.ajax({
                type:"get",
                url:"http://localhost:8080/java_web_war_exploded/commentServlet",
                data:{
                    "comment":$("#comment").val(),
                    "commented":${blogid},
                    "visitor":$("#visitor").val(),
                    "blogid":$("#blogid").val(),
                },
                success: function(data) {
                    alert("评论成功!");
                    window.location.reload()  //刷新页面
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }

        function reply(e,h) {
            $.ajax({
                type:"get",
                url:"http://localhost:8080/java_web_war_exploded/commentServlet",
                data:{
                    "comment":h,
                    "commented":e,
                    "visitor":$("#visitor").val(),
                    "blogid":$("#blogid").val(),
                },
                success: function(data) {
                    alert("回复成功!");
                    window.location.reload()  //刷新页面
                }, error: function(a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }
    </script>

    <style>
        a{
            text-decoration: none;
        }
        .panel-heading{
            text-align:center
        }
        .panel-body{
            margin-top: 50px;
            padding-left: 30px
        }
        .comment{
            width: 1000px;
            margin-top: 10px;
            margin-left: 260px;
            border: 2px solid #ccc;
        }
    </style>
</head>

<body>
<div class="panel panel-default" style="width: 1000px;margin-top: 30px;margin-left: 260px;border: 2px solid #ccc;">
    <div class="panel-heading" >
            <h2>${title}</h2>
            <img  src="${writerhead}"  width="36px" height="36px" style="border-radius: 18px;float: left;margin-left: 10px;margin-top: 8px">
            <h3 style="float: left;font-size: 15px;margin-top: 15px">${writername}</h3>
            <a id="BB" style="float: right;margin-top: 15px;margin-right: 10px" href="<%=path%>/homeServlet?email=${visitor}">返回首页</a>
    </div>

    <div class="subtitle "style="height: 50px;width: 800px;margin:0 auto;border: 2px solid #ccc">
            <p class="original"style="display: inline-block;font-size: 15px;margin-left: 15px;color: red">${original}</p>
            <p class="date" style="display: inline-block;font-size: 15px;margin-left: 20px">${date}</p>
            <p class="category"style="display: inline-block;font-size: 15px;margin-left: 20px">分类专栏：${category}</p>
            <p class="label"   style="display: inline-block;font-size: 15px;margin-left: 20px">文章标签：${label}</p>

            <a style=" margin-left: 30px;font-family: 楷体;font-size: 20px" href="<%=path%>/collectServlet?blogid=${blogid}&blogger=${blogger}&visitor=${visitor}&collect=${collect}&great=${great}">${collect}</a>
            <a style=" margin-left: 15px;font-family: 楷体;font-size: 20px" href="<%=path%>/greatServlet?blogid=${blogid}&visitor=${visitor}&great=${great}&collect=${collect}">${great}</a>${count}
            <a id="AA" style=" margin-left: 15px;font-family: 楷体;font-size: 20px" href="<%=path%>/transpondServlet?blogid=${blogid}&visitor=${visitor}">转发</a>
            <script type="text/javascript">
                document.getElementById("${aa}").style.display="none";
                document.getElementById("${bb}").style.display="none";
            </script>

            <input hidden type="text" id="blogid" name="blogid" value="${blogid}">
            <input hidden type="text" id="blogger" name="blogger" value="${blogger}">
            <input hidden type="text" id="visitor" name="visitor" value="${visitor}">
    </div>
<%--    <h style="margin-left: 105px">转载于</h>--%>

    <div class="panel-body">
        <!-- 用于显示md编辑器的md格式 -->
        <div id="doc-content">
            <textarea style="display: block">${content}</textarea>
        </div>
    </div>

</div>
<div class="comment">
    <input type="text" style="height: 35px;width: 800px;border-radius: 15px;margin-top: 20px;margin-bottom: 15px;margin-left: 50px;border: 2px solid #ccc" name="comment" id="comment">
    <button type="button" style="height: 35px;width: 80px;border-radius: 15px;color:whitesmoke;background-color: #007bff;border: 1px" onclick="comment();">发表评论</button>
    <div class="showcommment">
        <% for(Comment comment:commentlist)
        {
            ArrayList<register> user=new selectDao().findRegister(comment.getVisitor());
            for (register blogger:user){
        %>
            <div style=" margin-left: 50px;margin-bottom: 20px;height: 35px;width:880px;border-bottom:1px solid #ccc;">
                <img  src="<%=blogger.getHead()%>"  width="30px" height="30px" style="border-radius: 15px">
                <p style="display: inline-block;font-size: 15px;"><%=blogger.getUsername()%>:</p>
                <p style="display: inline-block;font-size: 15px;"><%=comment.getComment()%>.</p>
                <p style="display: inline-block;font-size: 10px;margin-left: 5px;margin-right: 10px"><%=comment.getTime()%></p>
                <button type="button"  onclick="$('#<%=comment.getCommentid()%>').show()" style="height: 20px;width: 60px;border-radius: 15px;color:whitesmoke;background-color: #007bff;border: 1px">回复</button>
            </div>
            <div id="<%=comment.getCommentid()%>" style="display: none">
                <input class="<%=comment.getCommentid()%>" type="text" style="height: 25px;width: 500px;border-radius: 15px;margin-top: 0px;margin-bottom: 10px;margin-left: 80px;border: 2px solid #ccc">
                <button type="button" style="height: 25px;width: 80px;border-radius: 15px;color:whitesmoke;background-color: #007bff;border: 1px" onclick="reply(<%=comment.getCommentid()%>,$('.<%=comment.getCommentid()%>').val())">发表回复</button>
            </div>
<%------------------------------------------------------子评论--%>
            <%
                ArrayList<Comment> soncommentlist=new selectDao().findComment(comment.getCommentid(),comment.getBlogid());
            %>
            <% for (Comment soncomment:soncommentlist)
            {
                ArrayList<register> user1=new selectDao().findRegister(soncomment.getVisitor());
                for (register blogger1:user1){
            %>
                <div style="margin-left: 150px;height: 25px;width: 750px;margin-bottom: 10px">
                    <img  src="<%=blogger1.getHead()%>"  width="30px" height="30px" style="border-radius: 15px">
                    <p style="display: inline-block;font-size: 15px;"><%=blogger1.getUsername()%>   回复:</p>
                    <p style="display: inline-block;font-size: 15px;"><%=soncomment.getComment()%>.</p>
                    <p style="display: inline-block;font-size: 10px;margin-left: 5px;margin-right: 10px"><%=soncomment.getTime()%></p>
                </div>
            <%
                    }
                }
            %>
<%---------------------------------------------------------------%>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
