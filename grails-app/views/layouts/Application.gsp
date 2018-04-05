<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <g:layoutHead/>

</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="col-lg-4">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">LinkSharing</a>
            </div>
        </div>
        <div class="col-lg-8">


            <g:if test="${session.user!=null}">
            <ul class="nav navbar-nav col-lg-12">
                <!--<li class="col-lg-1"></li>-->
                <li class="col-lg-5 ">
                    <form class="form-inline col-lg-12 " style="margin-top: 12px">
                        <div class="form-group">
                            <input class="form-control" type="search" placeholder="search..">
                            <button type=" button " class="btn  btn-default">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </input>

                        </div>

                    </form>
                </li>


                <li class="col-lg-1 " style="padding: 0px"><a href="#myModal" data-toggle="modal"
                                                              data-target="#myModal"><i class="fa fa-comment-o"
                                                                                        style="font-size:24px"></i></a></li>
                <div id="myModal" class="modal fade" role="dialog">
                    <g:render template="/topic/create"/>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal2" data-toggle="modal"
                                                             data-target="#myModal2"><i class="fa fa-envelope-o"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal2" class="modal fade" role="dialog">

                    <g:render template="/topic/email"/>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal3" data-toggle="modal"
                                                             data-target="#myModal3"><i class="fa fa-link"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal3" class="modal fade" role="dialog">

                    <g:render template="/linkResource/create"/>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal4" data-toggle="modal"
                                                             data-target="#myModal4"><i class="fa fa-file"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal4" class="modal fade" role="dialog">

                    <g:render template="/documentResource/create"/>

                </div>


                <li class="dropdown  col-lg-3" style="padding: 0px">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user-circle-o"
                                                                                  style="font-size:24px"></i>
                        ${session.user.userName}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">profile</a></li>
                        <li><a href="#">users</a></li>
                        <li><a href="#">Topic</a></li>
                        <li><a href="#">post</a></li>
                        <li><g:link controller="login" action="logout">logout</g:link></li>
                    </ul>
                </li>

            </ul>
            </g:if>


        </div>

    </div>
</nav>
<g:if test="${flash.error}">
    <g:message message="${flash.error}"></g:message>

</g:if>
<g:if test="${flash.message}">
    <g:message message="${flash.message}"></g:message>

</g:if>
<g:layoutBody/>
<div class="footer" role="contentinfo">
    <address>
        Copyright © 2017-2018 TO THE NEW. All rights reserved.
    </address>
</div>


</body>
</html>