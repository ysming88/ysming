<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/13
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email=request.getParameter("email");
    session.setAttribute("email", email);
%>
<html>
<head>
    <title>个人中心</title>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        function update() {
            var sex=document.getElementById("sex1").value;
            $("input[name='sex'][value='"+sex+"'").attr("checked",true);
            var job = $("#job1").val();
            $("#job option[value = '"+job+"']").attr("selected",true);

            var year = $("#year1").val();
            $("#year option[value = '"+year+"']").attr("selected",true);
            var month = $("#month1").val();
            $("#month option[value = '"+month+"']").attr("selected",true);
            var day = $("#day1").val();
            $("#day option[value = '"+day+"']").attr("selected",true);

        }

        function change() {
            document.getElementById("form").submit();
        }
        function change1() {
            document.getElementById("form1").submit();
        }
    </script>
    <style>
        a{
            text-decoration: none;
        }
        input{
            border-radius: 10px;
            border: 2px solid #ccc;
            padding-left: 10px
        }
        .p{
            width: 1200px;
            margin: 0 auto;
        }
        header{
            height: 84px;
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
        p{
            font-family: 微软雅黑;
            font-size: 25px;
            margin-bottom: 20px;
        }

        .pic{
            background-image: url("pic/天空.jpg");
            height: 100px;
            border: 1.5px solid #ccc;
            margin-top: 10px;
        }
        .middle{
            margin-top: 10px;
        }
        .label a{
            display: block;
            margin: 10px auto;
            text-align: center;
            line-height: 30px;
            height: 30px;
            width: 150px;
            text-decoration: none;
            color: black;
        }
        .label a:hover{
            background: #cccccc;
        }
        .information{
            margin-top: 10px;
            float: right;
            width: 980px;
            height: 500px;
            border: 1.5px solid #ccc;
        }
        .idInformation{
            margin: 10px auto;
            width: 900px;
            margin-bottom: 20px;
        }
        .idInformation div {
            margin-top: 10px;
            overflow: hidden;
        }
        .idInformation li{
            margin-top: 10px;
            overflow: hidden;
        }
        .idInformation input{
            display: inline-block;
            margin-left: 10px;
        }
        .left
        {
            float: left;
        }
        .right{
            float: right;
            margin-top: 20px;
        }
        .perInformation{
            border-top: 2px solid #ccc;
            margin: 10px auto;
            width: 900px;
        }
        .perInformation div{

            margin-top: 10px;
            overflow: hidden;
        }
        .perInformation li{
            margin-top: 10px;
            overflow: hidden;
        }
        .perInformation input{
            display: inline-block;
        }
        .left1 {
            float: left;
        }
        .right1{
            float: right;
            margin-top: 20px;
        }
    </style>
</head>

<body onload="update()">
    <div class="p">
        <header>
            <div class="logo">
                <img src="pic/blog1.png" alt=""><p>博客</p>
            </div>
            <div class="home">
                <img src="pic/home_icon.jpg" alt=""><a href="<%=path%>/homeServlet?email=<%=email%>"target="_self">主页</a>
            </div>
        </header>

        <div class="pic"></div>

        <div class="middle">

            <div class="left" style="float: left;margin-top: 40px">
                <div class="head">
                    <img  src="${head}" id ="headimg"  width="140px" height="140px" style="border-radius: 70px;margin-left: 20px" onclick="$('#fileInput').click()">
                    <input form="form" type="hidden" name="head" id="head" value="${head}">
                    <input type="file"  id="fileInput" name="fileInput"  accept="image/jpeg" style="display: none">
                    <script type="text/javascript">
                        $("#fileInput").change(function (){
                            var file=$(this)[0].files[0];
                            var formData=new FormData();
                            formData.append("upload",file);
                            var index=file.name.lastIndexOf(".");
                            var type=file.name.substring(index);
                            if(type!==".jpg"){
                                alert("只能上传jpg格式的图片！！");
                                return;
                            }
                            $.ajax({
                                url:"http://localhost:8080/java_web_war_exploded/headServlet",
                                data:formData,
                                method:"post",
                                processData: false,
                                contentType: false,
                                async:false,
                                cache:false,
                                success:function (data){
                                    alert("上传头像成功")
                                    window.location.href = '<%=path%>/PercenterServlet?email=<%=email%>';
                                },
                                error:function (data){
                                    alert("头像上传失败");
                                }
                            })
                            window.location.reload();
                        })
                    </script>
                </div>

            </div>


            <div class="information">
                <form method="post" id="form" action="<%=path%>/updateregisterServlet">
                    <div class="idInformation">
                        <div>
                            <h3 class="left">账号信息</h3>${succeed}
                            <button class="right" type="button" name="idInformationXG" onclick="change();">修改账号信息</button>
                        </div>
                        <li><label>用户名:</label><input type="text" id="username" name="username" value="${username}"></li>
                        <li><label>  邮箱:</label><input style="margin-left: 25px" type="text" readonly=“readonly” id="email" name="email" value="<%=email%>" >
                            <label style="color: #3E7087"> 无法修改！</label>
                        </li>
                        <li><label>  密码:</label><input  style="margin-left: 25px" type="password" readonly=“readonly id="password" name="password" value="${password}">
                            <a href="updatepassword.jsp?email=<%=email%>">修改密码</a>
                        </li>
                    </div>
                </form>

                <form class="perInformation" method="post" id="form1" action="<%=path%>/informationServlet">
                    <div>
                        <h3 class="left1">个人信息</h3>${return1}
                        <button class="right1" type="button"id="perInformationXG" name="perInformationXG" onclick="change1();">修改个人信息</button>
                    </div>
                    <li><label>姓名：</label><input type="text" id="name" name="name" value="${name}" ></li>

                    <input  type="hidden" id="sex1" name="sex1" value="${sex}" /><%--隐藏域获取显示sex--%>
                    <li><label>性别：</label>  男<input type="radio" name="sex"  id="man" value="男"  />
                                               女<input type="radio" name="sex"  id="woman" value="女" />
                    </li>

                    <input type="hidden" id="year1" name="year1" value="${year}" />
                    <input type="hidden" id="month1" name="month1" value="${month}" />
                    <input type="hidden" id="day1" name="day1" value="${day}" />
                    <li><label>出生日期：</label>
                        <select  name="year" id="year">
                            <option>-请选择年-</option>
                            <option value="1998">1998</option>
                            <option value="1999">1999</option>
                            <option value="2000">2000</option>
                            <option value="2001">2001</option>
                            <option value="2002">2002</option>
                            <option value="2003">2003</option>
                            <option value="2004">2004</option>
                            <option value="2005">2005</option>
                            <option value="2006">2006</option>
                            <option value="2007">2007</option>
                            <option value="2008">2008</option>
                        </select>
                        <select name="month" id="month">
                            <option>-请选择月-</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        <select name="day" id="day">
                            <option>-请选择日-</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>
                    </li>

                    <input type="hidden" id="job1" name="job1" value="${job}" /><%--隐藏域获取显示job,取名job1防id重复--%>
                    <li><label>职业：</label>
                        <select name="job" id="job">
                            <option>-请选择-</option>
                            <option value="学生">学生</option>
                            <option value="教师">教师</option>
                            <option value="白领">白领</option>
                            <option value="其他">其他</option>
                        </select>
                    </li>
                    <li><label>联系方式：</label><input type="text" id="phone" name="phone" value="${phone}"></li>
                    <li hidden><label>邮箱  :</label><input type="text" id="email_" name="email" value="<%=email%>" ></li>
                </form>

            </div>
        </div>

    </div>
</body>
</html>
