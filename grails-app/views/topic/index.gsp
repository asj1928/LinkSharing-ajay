<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 5/4/18
  Time: 3:46 PM
--%>

<%@ page import="linksharingajay.Subscription; linksharingajay.User; linksharingajay.Resource; linksharingajay.Topic" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <meta name="layout" content="Application"/>
    <style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
    }

    .topnav {
        overflow: hidden;
        background-color: #e9e9e9;
    }

    .topnav a {
        float: left;
        display: block;
        color: black;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    .topnav a.active {
        background-color: #2196F3;
        color: white;
    }

    .topnav .search-container {
        float: right;
    }

    .topnav input[type=text] {
        padding: 6px;
        margin-top: 8px;
        font-size: 17px;
        border: none;
    }

    .topnav .search-container button {
        float: right;
        padding: 6px 10px;
        margin-top: 8px;
        margin-right: 16px;
        background: #ddd;
        font-size: 17px;
        border: none;
        cursor: pointer;
    }

    .topnav .search-container button:hover {
        background: #ccc;
    }

    @media screen and (max-width: 600px) {
        .topnav .search-container {
            float: none;
        }

        .topnav a, .topnav input[type=text], .topnav .search-container button {
            float: none;
            display: block;
            text-align: left;
            width: 100%;
            margin: 0;
            padding: 14px;
        }

        .topnav input[type=text] {
            border: 1px solid #ccc;
        }
    }
    </style>
</head>

<body>
<g:set var="itr" value="${Topic.findById(params.id)}"/>

<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #1b1e21">
                    <p>

                    <h3 style="color:white">Topic:" ${itr.name}"</h3></p>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>

                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5><a href="#">${itr.name}</a> <span STYLE="color: #9d9d9d ">(${itr.visibility})</span>
                                </h5>
                            </div>

                            <div class="col-lg-12">
                                <div class="col-lg-5">
                                    <p style="color: #9d9d9d">@${itr.createdBy.userName}</p>
                                    <g:if test="${session.user}">
                                        <p1><a href="#">subscribe</a></p1>
                                    </g:if>
                                </div>

                                <div class="col-lg-5">
                                    <p style="color: #9d9d9d">subscriptions</p>
                                    <p1 style="color: #2e6da4">${itr.subscriptions.size()}</p1>

                                </div>

                                <div class="col-lg-2">
                                    <p style="color: #9d9d9d">post</p>
                                    <p1 style="color: #2e6da4">${itr.resources.size()}</p1>
                                </div>
                                <g:if test="${session.user != null}">
                                    <div class="col-lg-12"><br></div>

                                    <div class="col-lg-12">
                                        <div class="col-lg-10">
                                            <select class="pull-right form-control ">
                                                <option>Serious</option>
                                                <option>Casual</option>
                                                <option>Very Serious</option>
                                            </select>
                                        </div>

                                        <div class="col-lg-2">
                                            <span type="img" class="fa fa-envelope pull-right fa-2x"
                                                  style="margin-left: 10px; margin-right: 5px;">

                                            </span>
                                        </div>

                                    </div>
                                </g:if>

                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>
        <g:set var="uitr" value="${Subscription.findAllByTopic(itr)}"/>





        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #1b1e21">
                    <p>

                    <h3 style="color:white">User:"${itr.name}"</h3></p>
                </div>

                <div class="panel-body  ">
                    <g:each in="${uitr}" var="sub">

                        <div class="col-lg-12">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                            </div>

                            <div class="col-lg-9">
                                <div class="col-lg-12">
                                    <h5>${sub.user.firstName} ${sub.user.lastName}</h5>

                                    <p STYLE="color: #9d9d9d ">@${sub.user.userName}</p>
                                </div>

                                <div class="col-lg-12">
                                    <hr>
                                </div>

                                <div class="col-lg-12">
                                    <div class="col-lg-6">
                                        <p style="color: #9d9d9d">subscriptions</p>
                                        <p1><a href="#">${sub.user.subscriptions.size()}</a></p1>
                                    </div>

                                    <div class="col-lg-6">
                                        <p style="color: #9d9d9d">topics</p>
                                        <p1 style="color: #2e6da4">${sub.user.topics.size()}</p1>

                                    </div>

                                </div>

                            </div>
                        </div>

                        <div class="col-lg-12">
                            <hr>
                        </div>
                    </g:each>

                </div>
            </div>

        </div>
    </div>


    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class=" panel panel-default     ">
                    <div class="panel-heading col-lg-12" style="background: #1b1e21;">
                        <div class="col-lg-12">
                            <h3 style="color:white">Posts:"${itr.name}"</h3>
                        </div>

                        <div class="col-lg-12">
                            <div class="col-lg-2"></div>

                            <div class="col-lg-10  ">
                                <form class="form-inline col-lg-12   " style="margin-top: 12px">
                                    <div class="form-group">
                                        <input class="form-control" type="search" placeholder="search..">
                                        <button type=" button " class="btn  btn-default">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </input>

                                    </div>

                                </form>
                            </div>

                        </div>

                    </div>

                    <div class="panel-body  ">

                        <g:set var="res" value="${Resource.findAllByTopic(itr)}"/>
                        <g:each in="${res}" var="rIt">
                            <div class="col-lg-12">
                                <div class="col-lg-3" style="margin-top: 25px">
                                    <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                                </div>

                                <div class="col-lg-9">
                                    <div class="col-sm-12">
                                        <br>

                                        <span>${rIt.user.firstName} ${rIt.user.lastName}  &nbsp;&nbsp;&nbsp;&nbsp;<small
                                                class="text-muted">@${rIt.user.userName}</small>

                                            <a href="#" class="pull-right">${rIt.topic.name}</a>
                                            <br><br>

                                            <div class="col-lg-12">
                                                <p>${rIt.description}</p>
                                            </div>

                                        </span>

                                        <div>
                                            <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                            <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                            <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a
                                                    href="#"
                                                    style="color: #007efc;font-size: 75%">Download</a>
                                                <a href="#" style="color: #007efc;font-size: 75%">Mark as Read</a>
                                                <a href="#" style="color: #007efc;font-size: 75%">View Topic</a></span>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </g:each>

                    </div>
                </div>

            </div>

        </div>
    </div>

</div>

</body>
</html>
