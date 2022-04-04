<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./css/MarketAnalysis_optimize.css">
    <title>市场分析</title>
    <style>
        .footer>ul>li{
         /* display: ; */
        margin-top: 12px;
        list-style: none;
         }
         .foot_text>a{
            color: rgb(89, 130, 63);
            font-size: 15px;
            margin-left: 30px;
            text-decoration: none;
         }
    </style>
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
        <li><a href="market">市场分析</a><br><div></div></li>
        <li><a href="xxl/project/voluntaryService.html">志愿服务</a ><br><div></div></li>
        <li><a href="RuralInsuranceCustomization.html">农险定制</a ><br><div></div></li>
    </ul>
    <div id="lead_slogan">
        <p>易农为农&nbsp&nbsp&nbsp沟通两岸</p>
    </div>
    <div id="lead_person">
        <p>欢迎登录！</p>
        <div><p><a href="/person">个人中心</a></p><div></div></div>
        <div><p><a href="index.html">退出登录</a></p><div></div></div>
    </div>
</div>
<div class="top_pit">
<!--    <img src="./image/marketPit1.png">-->
<p>农业农村重要经济指标</p>
</div>

<div class="dataPit">

    <span class="dataPit_divider"></span>
    <p class="dataPit_tittle">GDP变化</p>
    <span class="dataPit_divider"></span>
</div>

<div class="dataPit_lastHalf">
    <div class="dataPit_sideBar">
        <ul>
            <li class="dataPit_sideBar_module"><a href="./MarketAnalysis/1.宏观经济.html"target="hhh" style="" class="nn">宏观经济</a></li>
            <li class="dataPit_sideBar_module"><a href="./MarketAnalysis/2.农业农村发展.html"target="hhh" style="" class="nn">农业农村发展</a></li>
            <li class="dataPit_sideBar_module"><a href="./MarketAnalysis/3.农产品市场.html"target="hhh" style="" class="nn">农产品市场</a></li>
            <li class="dataPit_sideBar_module"><a href="./MarketAnalysis/4.农产品进出口.html"target="hhh" style="" class="nn">农产品进出口</a></li>
            <li class="dataPit_sideBar_module"><a href="./MarketAnalysis/5.资源环境.html"target="hhh" style=""class="nn">资源环境</a></li>
        </ul>
    </div>
    <iframe src="./MarketAnalysis/1.宏观经济.html" name="hhh"id="frame" >

    </iframe>
    
</div>

<!-- <div class="dataPit">
    <span class="dataPit_divider"></span>
    <p class="dataPit_tittle">宏观经济——商品零售价格分类指数变化</p>
    <span class="dataPit_divider"></span>
    <img  class="dataPit_Pit" src="image/marketPit4.png">
</div>

<div class="dataPit">
    <span class="dataPit_divider"></span>
    <p class="dataPit_tittle">农业农村发展——农民人均可支配收入变化</p>
    <span class="dataPit_divider"></span>
    <img  class="dataPit_Pit" src="image/marketPit5.png">
</div>

<div class="dataPit">
    <span class="dataPit_divider"></span>
    <p class="dataPit_tittle">宏观经济——GDP变化</p>
    <span class="dataPit_divider"></span>
    <img  class="dataPit_Pit" src="image/marketPit2.png">
</div> -->
<div class="dataPit">

    <span class="dataPit_divider"></span>
    <p class="dataPit_tittle">农产行情</p>
    <span class="dataPit_divider"></span>
</div>
<div id="detail">

    <ul class="first_ul">
        <li>中国农业农村部</li>
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
        <li> <a href="http://www.moa.gov.cn/">点击跳转>></a></li>
<%--        <li ><span style="display: inline-block;width: 20px;background-color: red;text-align: center;">1</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;background-color: orange;text-align: center;">2</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">3</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">4</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">5</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">6</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">7</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">8</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">9</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">10</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>

    </ul>
    <ul class="second_ul">
        <li>中国农资导报网</li>
        <%
            session = request.getSession();
            message = session.getAttribute("messageNZDB");
            date = session.getAttribute("timeNZDB");
            link = session.getAttribute("linkNZDB");
            messageNum = session.getAttribute("messageNum");
            titleData = (List<String>) message;
            dateData = (List<Date>) date;
            linkData = (List<String>) link;
            numData = (Integer)messageNum;
            for (int i = 0;i < numData.intValue(); i++) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                String dateStr = dateFormat.format(dateData.get(i));
                //        System.out.println(dateStr);
        %>
        <li><a href=<%= linkData.get(i) %>><%= titleData.get(i) %><p class="date"><%= dateStr%></p></a></li>
        <%

            }
        %>
        <li><a href="http://www.nzdb.com.cn/">点击跳转>></a></li>
<%--        <li ><span style="display: inline-block;width: 20px;background-color: red;text-align: center;">1</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;background-color: orange;text-align: center;">2</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">3</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">4</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">5</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">6</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">7</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">8</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">9</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
<%--        <li><span style="display: inline-block;width: 20px;text-align: center;">10</span><span class="foot_text"><a href="">汪亦涵大帅逼</a></span></li>--%>
    </ul>
</div>



</body>
</html>