<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 99               4914269
  Date: 2022/2/18
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/MarketAnalysis.css">
    <link rel="stylesheet" type="text/css" href="bootstrap-3.4.1-dist/css/bootstrap.css">
    <title>市场分析</title>
</head>
<body>
<div id="lead">
    <div id="lead_img">
        <img src="image/logo_transparency_small.png">
    </div>
    <ul id="lead_ul">
        <li><a href="home.html">首页</a><br><div></div></li>
        <li><a href="onlineSale.html">线上展销</a><br><div></div></li>
        <li><a href="seeCultivation.html">看见耕耘</a><br><div></div></li>
        <li><a href="farmerUnion.html" >社交农联</a><br><div></div></li>
        <li><a href="/market">市场分析</a><br><div></div></li>
        <li><a>志愿服务</a><br><div></div></li>
        <li><a>农险定制</a><br><div></div></li>
    </ul>
    <div id="lead_slogan">
        <p>易农为农&nbsp&nbsp&nbsp沟通两岸</p>
    </div>
    <div id="lead_person">
        <p>欢迎登录！</p>
        <div><p><a href="index.html">个人中心</a></p><div></div></div>
        <div><p><a href="index.html">退出登录</a></p><div></div></div>
    </div>
</div>

<div id="sidebar">
    <ul>
        <li><a>中国农业农村部</a></li>
    </ul>
</div>
<div id="detail">
    <ul>


<%
    session = request.getSession();
    Object message = session.getAttribute("messageMARA");
    Object date = session.getAttribute("timeMARA");
    Object link = session.getAttribute("linkMARA");
    Object messageNum = session.getAttribute("messageNum");
    List<String> titleData = (List<String>) message;
    List<Date> dateData = (List<Date>) date;
    List<String> linkData = (List<String>) link;
    Integer numData = (Integer)messageNum;
    for (int i = 0;i < numData.intValue(); i++) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String dateStr = dateFormat.format(dateData.get(i));
//        System.out.println(dateStr);
%>
        <li><a href=<%= linkData.get(i) %>><%= titleData.get(i) %><p class="date"><%= dateStr%></p></a></li>
<%

    }
%>
    </ul>
</div>
</body>
</html>
