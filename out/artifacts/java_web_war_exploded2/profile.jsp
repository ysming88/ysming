<%--
  Created by IntelliJ IDEA.
  User: lzb
  Date: 2020/9/13
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>

<%--个人资料中心--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
    <script type="text/javascript" src="../static/jquery-3.5.1/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
<%--    <link rel="stylesheet" type="text/css" href="../static/css/backimage.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="../static/css/commonsCss.css">--%>
    <script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/js/modal.js"></script>
    <script type="text/javascript" src="../static/js/popover.js"></script>
    <script type="text/javascript" src="../static/js/check/commonsJs.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">abc</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand">Blog</span>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                <li><a href="#">个人中心</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索博客，博主">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav">
                <li><a href="/view/writeBlog.jsp"><button class="btn btn-danger">创作中心</button></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

    <div class="container-fluid">
        <div class="row" style="background: url('/pic/sky1.jpg');background-size: 100% 100%;background-repeat: no-repeat;">
            <div class="col-md-12">
                <div class="col-md-3" style="padding: 1%">
                    <label style="margin-left: 2%; font-size: x-large">Welcome</label>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 3%">
            <div class="col-md-3">
                <div class="list-group text-center">
                    <a href="/view/profile.jsp" class="list-group-item active">个人资料</a>
                    <a href="#" class="list-group-item" onclick="myblog();" id="tomyblog">我的博客</a>
                    <a href="#" class="list-group-item">1</a>
                </div>

                <div style="margin-left: 5%"><img  class="img-circle" height="30%" width="70%" src="/checkhead" id ="head" onclick="changeHead()"></div>
                <form enctype="multipart/form-data" action="/test">
                <input type="file"  id="fileInput" accept="image/jpeg" style="display: none">
                </form>
                <div style="margin-left: 70%"><button onclick="uploadpic();" class="btn btn-default">更换头像</button></div>



            </div>
            <div class="col-md-9">
                <div class="list-group">
                    <div class="list-group">
                        <div class="list-group-item list-inline">
                            <label>邮箱（账号）：</label>
                            ${id != null ? id : "暂未填写"}
                        </div>
                    </div>
                    <div class="list-group-item list-inline">
                        <label>昵称：</label>
                        ${nickname != null ? nickname : "暂未填写"}
                    </div>
                </div>
                <div class="list-group">
                    <div class="list-group-item list-inline">
                        <label>性别：</label>
                        ${gender != null ? gender : "暂未填写"}
                    </div>
                </div>
                <div class="list-group">
                    <div class="list-group-item list-inline">
                        <label>手机号：</label>
                        ${phone != null ? phone : "暂未填写"}
                    </div>
                </div>
                <div class="list-group form-horizontal">
                    <div class="list-group-item list-inline">
                        <label>简介：</label>
                        ${introduction != null ? introduction : "暂未填写"}
                    </div>
                </div>
                <div class="list-group form-horizontal">
                    <div class="list-group-item list-inline">
                        <label>生日：</label>
                        ${birthday != null ? birthday : "暂未填写"}
                    </div>
                </div>
                <div>
                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="margin-left: 45%">
                        修改信息
                    </button>
                </div>

                <form action="/save" method="post">
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">修改信息</h4>
                            </div>

<%--                            禁用表格--%>
                            <fieldset disabled>
                            <div class="modal-body">
                                <label>邮箱账号：</label>
                                <input type="text" class="form-control"value="${id}" id="hiddenEmail">
                            </div>
                            </fieldset>

<%--                            设置隐藏域，方便表单提交--%>
                            <input type="hidden" id="trueEmail" name="email">
                            <div class="modal-body">
                                <label>昵称：</label>
                                <input type="text" placeholder="请输入昵称" name="nickname" class="form-control"value="${nickname != null ? nickname : '暂未填写'}">
                            </div>
                            <div class="modal-body">
                                <label>性别：</label>
                                <select class="form-control" name="gender">
                                    <c:if test="${gender == '男'}">
                                    <option selected>男</option>
                                    <option>女</option>
                                    </c:if>
                                    <c:if test="${gender == '女'}">
                                        <option>男</option>
                                        <option selected>女</option>
                                    </c:if>
                                </select>
                            </div>
                            <div class="modal-body">
                                <label>联系方式（手机号）：</label>
                                <input type="text" placeholder="请输入联系方式" name="phone" class="form-control"value="${phone != null ? phone : '暂未填写'}">
                            </div>
                            <div class="modal-body">
                                <label>个人简介：</label>
                                <input type="text" placeholder="请输入昵称" name="introduction" class="form-control"value="${introduction != null ? introduction : '暂未填写'}">
                            </div>
                            <div class="modal-body">
                                <label>生日：</label>
                                <input type="hidden" name="birthday" id="trueBirthday">
                                <input type="date" placeholder="请选择生日时间" id="birthday" class="form-control"value="${birthday != null ? birthday : '暂未填写'}">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary" onclick="save()" >保存修改</button>
                            </div>
                        </div>
                    </div>
                </div>
<%--                <input type="button" value="修改信息" class="btn btn-danger" href="#" style="margin-left: 50%; margin-top: 5%">--%>
                    <input type="hidden" value="${splituser}" id="splituser">
                </form>
            </div>
        </div>
    </div>

</body>

<script type="text/javascript">
    function save() {
        var str = $("#birthday").val();
        $("#trueBirthday").val(str);
        var str1 = $("#hiddenEmail").val();
        $("#trueEmail").val(str1);
    }
    function changeHead() {
        $("#fileInput").click();
    }

    function uploadpic() {
        var s = $("#fileInput").val();
        if(s == ""){
            alert("请点击图片更换头像");
        }else{
            alert("ttt");
            var traslate = document.getElementById("fileInput");
            var formData = new FormData();
            var tfile = traslate.files[0];
            formData.append("pic",tfile);
            $.ajax({
                url:"/head",
                data:formData,
                type:"post",
                cache:false,
                contentType: false,
                processData: false,
                async:false,
                success:function (data) {
                    alert("ok");
                    alert(data);
                    $("#head").attr("src",data);
                    // document.getElementById("head").src = data;
                },
                error:function () {
                    alert("nnn...")
                }
            })
        }
    }

    function myblog() {
        var author = $("#splituser").val();

        $("#tomyblog").attr("href","/myblog?splituser="+author);
        $("#tomyblog").click();
    }
</script>
</html>
