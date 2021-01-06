<%@ page import="Domain.Label" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.selectDao" %>
<%@ page import="Domain.Category" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/23
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String email=request.getParameter("email");%>
<%--直接获取homepage.jsp传过来的email--%>
<html>
<head>
    <title>创作博客</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/editormd/css/editormd.min.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/editormd/editormd.min.js"></script>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        //@ sourceURL=sv_popWin.js
        $(function() {
            editormd("test-editormd", {
                width : "98%",
                height : 640,
                syncScrolling : "single",
                //你的lib目录的路径，和你引入js,css路径一样
                path    : "${pageContext.request.contextPath}/static/editormd/lib/",
                //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                saveHTMLToTextarea : true,
                imageUpload : true,
                imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL : "${pageContext.request.contextPath}/imageServlet"
            });
        })
        function

        clickUpload(){
            document.getElementById("WriteBlogForm").submit();
        }

    </script>

    <style>
        .writeBlogHeader{
            margin-top: 20px;
        }
       .managerBtn{
            margin-left: 15px;
           height: 35px;
        }
       .title{
           padding-left: 10px;
           margin-left: 15px;
           width: 1300px;
           height: 35px;
       }
       .editormd{
           margin-top: 20px;
       }
    </style>

</head>
<body>
<form method="post" id="WriteBlogForm" action="<%=path%>/writeServlet">
    <div id="layout">
        <header class="writeBlogHeader" id="writeBlogHeader">
            <div id="manageDiv1">

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    发布文章
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label >标签:</label>
                                    <%
                                        ArrayList<Label> allLabel = new selectDao().label(email);
                                    %>
                                    <%
                                        for(Label Label:allLabel)
                                        {
                                            String label=Label.getLabel();
                                    %>
                                    <input type="checkbox" name="label"  value="<%=label%>"><%=label%>
                                    <%
                                        }
                                    %>
                                </div>
                                <div class="form-group" style="margin-top: 20px">
                                    <label for="category">分类专栏</label>
                                    <%
                                        ArrayList<Category> allCategory = new selectDao().category();
                                    %>
                                    <select form="WriteBlogForm" id="category" name="category">
                                        <option value="0">请选择</option>
                                        <%
                                            for(Category Category:allCategory)
                                            {
                                                String category=Category.getCategory();
                                        %>
                                        <option value="<%=category%>"><%=category%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="original">文章类型</label>
                                    <select form="WriteBlogForm" id="original" name="original">
                                        <option value="0">请选择</option>
                                        <option value="原创">原创</option>
                                        <option value="转载">转载</option>
                                    </select>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" onclick="clickUpload()">发布文章</button>
                            </div>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <button class="managerBtn" type="button" id="managerBtn" onclick="javascript:history.back(-1);">返回首页</button>
                <input type="hidden" id="writer" name="writer" value="<%=email%>" /><%--隐藏域获取显示email--%>
                <input class="title" placeholder="输入文章标题" type="text" id="title" name="title"/>
                <button type="button"  id="publish" data-toggle="modal" data-target="#myModal" style="height: 40px;width: 80px;text-align: center;background-color: #007bff;border-radius:15px;border: 1px solid;color: white">
                    发布文章
                </button>

            </div>
        </header>

        <div class="editormd" id="test-editormd">
            <textarea form="WriteBlogForm" class="editormd-markdown-textarea" name="test"></textarea>
        </div>

    </div>
</form>


</body>
</html>

