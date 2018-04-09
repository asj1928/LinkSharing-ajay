<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 2/4/18
  Time: 11:33 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>HELLO</title>
    <meta name="layout" content="Application"/>
</head>

<body>
<g:message message="${flash.message}">

</g:message>

<h1>WHATSUP</h1>
<g:message message="${flash.message}"></g:message>
<div class=" container">
    <div class="col-lg-6">
        %{--recent share--}%
        <div class="col-lg-12" style="margin-top: 25px">

            <g:render template="recntShare"/>

        </div>

        %{--top post--}%
        <div class="col-lg-12" style="margin-top: 25px">

            <g:render template="topPost"/>
        </div>

    </div>

    <div class="col-lg-6">
        <div class="col-lg-12 " style="margin-top: 25px">

            <div class=" panel panel-default  ">
                <div class="panel-heading " style="background:#1b1e21">
                    <p>

                    <h3 style="color:white">Login</h3></p>
                </div>

                <div class="panel-body ">
                    <g:form controller="login" action="loginHandler">
                        <div class="form-group col-lg-10">
                            <label for="em">Email</label>
                            <input class="form-control" type="email" name="email" id="em"
                                   placeholder="enter your email ID">
                        </div>

                        <div class="col-lg-2"></div>

                        <div class="form-group col-lg-10">
                            <label for="psw">Password</label>
                            <input class="form-control" type="password" id="psw" name="password"
                                   placeholder="enter your password">

                        </div>

                        <div class="col-lg-12"></div>

                        <div class="form-group col-lg-10">
                            <input type="submit" class="form-control btn-default" style="background-color: #5e5e5e;color: white">
                        </div>

                    </g:form>
                    <div class=" col-lg-5">
                        <p><a href="#fpass" data-toggle="modal"
                              data-target="#fpass">Forgot Password</a></p>

                        <div id="fpass" class="modal fade" role="dialog">
                            <g:render template="/user/forgotPassword"/>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="col-lg-12" style="margin-top: 25px;">
            <g:render template="register"/>

        </div>
    </div>

</div>

</body>
</html>