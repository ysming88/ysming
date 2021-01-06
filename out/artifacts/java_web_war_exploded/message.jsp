<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/24
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息通知</title>
    <style>
        .top{
            position:fixed;
            left:-1px;
            /* 设置宽度高度背景颜色 */
            height: 50px; /*高度改为自动高度*/
            width:100%;
            margin-left: 0;
            background: rgba(255,255,255,0.5);
            position: fixed; /*固定在顶部*/
            top: 0;/*离顶部的距离为0*/
            margin-bottom: 5px;
        }
        .top ul{
            /* 清除ul标签的默认样式 */
            width: auto;/*宽度也改为自动*/
            list-style-type: none;
            white-space:nowrap;
            overflow: hidden;
            margin-left: 5%;
            /* margin-top: 0;          */
            padding: 0;

        }
        .top li {
            float:left; /* 使li内容横向浮动，即横向排列  */
            margin-right:2%;  /* 两个li之间的距离*/
            position: relative;
            overflow: hidden;
        }

        .top li a{
            /* 设置链接内容显示的格式*/
            display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
            color:white;
            text-align: center;
            padding: 3px;
            overflow: hidden;
            text-decoration: none; /* 去除下划线 */
        }

        .top li a:hover{
            /* 鼠标选中时背景变为黑色 background-color: #0300ff;*/
            /* 因为是hover'选择器，所以鼠标选中时出现下下划线*/
            list-style-type:none;
            color: #00d1ff;
            border-bottom:2px solid #00d2ff;
            padding-bottom: 2px;
        }
        .top ul li ul{
            /* 设置二级菜单 */
            margin-left: -0.2px;
            background: rgba(255,255,255,0.5);
            position: relative;
            display: none; /* 默认隐藏二级菜单的内容 */
        }
        .top ul li ul li{
            /* 二级菜单li内容的显示 */
            float:none;
            text-align: center;
        }
        .top ul li:hover ul{
            /* 鼠标选中二级菜单内容时 */
            display: block;
        }
    </style>
</head>
<body>

<div class="top" style="position: absolute; z-index: 10">
    <nav class="nav" id="nav">
        <ul>
            <li style="list-style-type:none;border-bottom:2px solid #00d2ff;padding-bottom: 2px;z-index:-1; " ><a style="color: #00d1ff;" href="index.html">首页</a><>
            <li ><a  href="boke.jsp">博客</a><>
            <li><a href="#">笔记</a><>
            <li><a href="#">碎语墙</a><>
            <li><a href="#">创作中心</a><>
            <li>
                <a href="#">登录/注册</a>
                <ul>
                    <li><a href="login.jsp">登录</a><>
                    <li><a href="resgist.jsp">注册</a><>
                </ul>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
