<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 3/4/18
  Time: 12:29 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="Application">
</head>

<body>
<div class="container">
    <div class="col-lg-6">

        <g:render template="userDEL"/>

        <br><br><br><br>
        <div class="col-lg-12"><br></div>
        <br><br><br><br>


        <g:render template="subscriptions"/>
        <br>
        <div class="col-lg-12"><br></div>
        <br>



        <g:render template="trendingTopic"/>
    </div>
    <div class="col-lg-6">

        <g:render template="indox"/>
    </div>
</div>


</body>
</html>