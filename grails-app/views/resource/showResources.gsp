<%--
  Created by IntelliJ IDEA.
  User: ajay
  Date: 9/4/18
  Time: 1:33 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>view</title>
    <meta name="layout" content="Application">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

                                    <div class="col-lg-5">
                                        <span>${resource.user.firstName} <small
                                                class="text-muted">@${resource.user.userName}  ${resource.dateCreated}</small>
                                        </span>

                                    </div>

                                    <div class="col-lg-7" style="text-align: right">
                                        <p><a href="#" class="pull-right">${resource.topic.name}</a></p><br>

                                        <p>2:45PM, 22FEB 2014</p>
                                        <i class="fa fa-heart" style="font-size:20px;"></i>
                                        <i class="fa fa-heart" style="font-size:20px;"></i>
                                        <i class="fa fa-heart" style="font-size:20px;"></i>
                                        <i class="fa fa-heart-o" style="font-size:20px;"></i>
                                        <i class="fa fa-heart-o" style="font-size:20px;"></i>

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
                                    <a href="${createLink(controller: 'resource', action: 'delete', id: resource.id)}"
                                       class="text-primary" style="text-decoration: underline;">Delete</a>
                                    <a href="#" style="color: #007efc;font-size: 90%">Edit</a>
                                    <a href="#" class="text-primary" style="text-decoration: underline;"><ls:checkRead
                                            resource="${resource}"></ls:checkRead></a>
                                    <g:if test="${resourceType == "LinkResource"}">

                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">Download</a>

                                    </g:if>
                                    <g:if test="${resourceType.equals("DocumentResource")}">

                                        <a href="#" class="text-primary"
                                           style="text-decoration: underline;">View Full Site</a>

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