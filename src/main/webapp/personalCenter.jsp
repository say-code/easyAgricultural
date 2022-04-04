<%--
  Created by IntelliJ IDEA.
  User: 994914269
  Date: 2022/4/3
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/onlineSale.css">
  <link rel="stylesheet" type="text/css" href="css/normalize.css" />
  <link rel="stylesheet" type="text/css" href="bootstrap-3.4.1-dist/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/personalCenter.css">
    <title>个人中心</title>
</head>
<body>
<div id="lead">
  <div id="lead_img">
    <img src="image/logo_transparency_small.png">
  </div>
  <div id="lead_middle">
    <ul id="lead_ul">
      <li><a href="home.html">首页</a><br>
        <div></div>
      </li>
      <li><a href="onlineSale.html">线上展销</a><br>
        <div></div>
      </li>
      <li><a href="seeCultivation.html">看见耕耘</a><br>
        <div></div>
      </li>
      <li><a href="farmerUnion.html">社交农联</a><br>
        <div></div>
      </li>
      <li><a href="MarketServlet">市场分析</a><br>
        <div></div>
      </li>
      <li><a href="xxl/project/voluntaryService.html" >志愿服务</a><br>
        <div></div>
      </li>
      <li><a href="RuralInsuranceCustomization.html">农险定制</a><br>
        <div></div>
      </li>
    </ul>
  </div>
  <div id="lead_slogan">
    <p>易农为农&nbsp&nbsp&nbsp沟通两岸</p>
  </div>
  <div id="lead_person">
    <p>欢迎登录！</p>
    <div>
      <p><a href="/person">个人中心</a></p>
      <div></div>
    </div>
    <div>
      <p><a href="index.html">退出登录</a></p>
      <div></div>
    </div>
  </div>
</div>
<%
  session = request.getSession();
  String userName = session.getAttribute("userName").toString();
  String phone = session.getAttribute("phone").toString();
  String nickname = session.getAttribute("nickName").toString();
  String contributes = session.getAttribute("contribute").toString();
  String fans = session.getAttribute("fans").toString();
%>
<div id="message">
  <div id="message_personal">
    <p id="message_personal_name"><%=nickname%></p>
    <p id="message_personal_contribute"><span class="glyphicon glyphicon-play-circle"></span> 视频播放数：<%=contributes%></p>
    <p id="message_personal_fans"><span class="glyphicon glyphicon-user"></span> 粉丝数：<%=fans%>6</p>
  </div>
  <div id="message_userInformation">
    <ul>
      <li class="message_userInformation_username">用户名：<%=userName%></li>
      <li class="message_userInformation_phone">电话号码：<%=phone%></li>
    </ul>
  </div>
</div>

<div class="video_box">
  <ul class="video_box_list">
    <li><a><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;已投稿的视频</a></li>
    <li><a><span class="glyphicon glyphicon-time"> </span>&nbsp;审核中的视频</a></li>
    <li><a><span class="glyphicon glyphicon-star"></span>&nbsp;已关注的视频</a></li>
  </ul>
  <br>
  <div class="video_box_tail"></div>
</div>
</body>
</html>
