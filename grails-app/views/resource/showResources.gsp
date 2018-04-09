<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 9/4/18
  Time: 1:33 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:500,100,300,700,400);

</style>

<html>
<head>

    <meta charset="UTF-8">
    <title>view</title>
    <meta name="layout" content="Application">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    %{--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--}%
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <asset:link rel="stylesheet" href="star.css"/>
</head>

<body>
<div class="container">
    <div class="col-lg-7">

        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class=" panel panel-default     ">

                    <div class="panel-body  ">
                        <div class="col-lg-12">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                            </div>

                            <div class="col-lg-9">
                                <div class="col-sm-12">
                                    <br>

                                    <div class="col-lg-4">
                                        <span>${resource.user.firstName} <small
                                                class="text-muted">@${resource.user.userName}  ${resource.dateCreated}</small>
                                        </span>

                                    </div>

                                    <div class="col-lg-8" style="text-align: right">
                                        <p><a href="#" class="pull-right">${resource.topic.name}</a></p><br>

                                        <p>2:45PM, 22FEB 2014</p>
                                        %{--<g:if test="${!session.user || session.user.getScore(resource) == 1}">--}%

                                            %{--<g:form  class="stars" controller="resource" action="storeRating"--}%
                                                    %{--method="post">--}%

                                                %{--<input class="star star-5" id="star-5" type="radio" name="star"--}%
                                                       %{--value="5"/>--}%
                                                %{--<label class="star star-5" for="star-5"></label>--}%
                                                %{--<input class="star star-4" id="star-4" type="radio" name="star"--}%
                                                       %{--value="4"/>--}%
                                                %{--<label class="star star-4" for="star-4"></label>--}%
                                                %{--<input class="star star-3" id="star-3" type="radio" name="star"--}%
                                                       %{--value="3"/>--}%
                                                %{--<label class="star star-3" for="star-3"></label>--}%
                                                %{--<input class="star star-2" id="star-2" type="radio" name="star"--}%
                                                       %{--value="2"/>--}%
                                                %{--<label class="star star-2" for="star-2"></label>--}%
                                                %{--<input class="star star-1" id="star-1" type="radio" name="star"--}%
                                                       %{--value="1"/>--}%
                                                %{--<label class="star star-1" for="star-1"></label>--}%
                                                %{--<g:hiddenField name="id" value="${resource.id}"/>--}%
                                                %{--<input type="submit" value="Rate" class="btn-default form-control"--}%
                                                       %{--style="background-color: yellow">--}%
                                            %{--</g:form>--}%

                                        %{--</g:if>--}%
                                        %{--<g:else>--}%
                                            <g:set var="score" value="${session.user.getScore(resource)}"/>
                                            <g:form
                                                    class="stars" controller="resource" action="storeRating"
                                                    method="post">

                                                <input class="star star-5" id="star-5" type="radio" name="star"
                                                       value="5" <g:if test="${score == 5}">checked</g:if>/>
                                                <label class="star star-5" for="star-5"></label>
                                                <input class="star star-4" id="star-4" type="radio" name="star"
                                                       value="4" <g:if test="${score == 4}">checked</g:if>/>
                                                <label class="star star-4" for="star-4"></label>
                                                <input class="star star-3" id="star-3" type="radio" name="star"
                                                       value="3" <g:if test="${score == 3}">checked</g:if>/>
                                                <label class="star star-3" for="star-3"></label>
                                                <input class="star star-2" id="star-2" type="radio" name="star"
                                                       value="2" <g:if test="${score == 2}">checked</g:if>/>
                                                <label class="star star-2" for="star-2"></label>
                                                <input class="star star-1" id="star-1" type="radio" name="star"
                                                       value="1" <g:if test="${score == 1}">checked</g:if>/>
                                                <label class="star star-1" for="star-1"></label>
                                                <g:hiddenField name="id" value="${resource.id}"/>
                                                <input type="submit" value="Rate" class="btn-default form-control"
                                                       style="background-color: yellow">

                                            </g:form>

                                        %{--</g:else>--}%

                                    </div>

                                    <div class="col-lg-12"><br><br></div>


                                    <div class="col-lg-12">
                                        <div class="col-lg-12">
                                            <p>akjbcadbcajncanclkaccksdm csdlndcskdncpsdmdc sdlcnklsdclkddnc
                                            sdlcnsdmcpsdpmc esdlc ldnclksdncsld sdlcnsdcklsdcklsdnc scsdncsclsd
                                            csldnfklfc</p>
                                        </div>
                                    </div>

                                    <div class="col-lg-12"><br></div>

                                </div>

                            </div>

                            <div class="col-lg-12">
                                <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                <span class="pull-right" style="margin-right: 0px;color: #007efc">
                                    <g:if test="${session.user != null}">
                                        <a href="${createLink(controller: 'resource', action: 'delete', id: resource.id)}"
                                           class="text-primary" style="text-decoration: underline;">Delete</a>
                                        <a href="#" style="color: #007efc;font-size: 90%">Edit</a>
                                        <a href="#" class="text-primary" style="text-decoration: underline;">
                                            <ls:checkRead resource="${resource}"></ls:checkRead></a>
                                        <g:if test="${resourceType == "LinkResource"}">

                                            <a href="#" class="text-primary"
                                               style="text-decoration: underline;">Download</a>

                                        </g:if>
                                        <g:if test="${resourceType.equals("DocumentResource")}">

                                            <a href="#" class="text-primary"
                                               style="text-decoration: underline;">View Full Site</a>

                                        </g:if>
                                    </g:if>
                                </span>
                            </div>

                        </div>

                    </div>
                </div>

            </div>

        </div>

    </div>

    <div class="col-lg-5">
        trending topic tempalte
    </div>
</div>

</body>
</html>