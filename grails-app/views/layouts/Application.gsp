<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">create topic</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" action="#">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="name1">name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="name1"  name="name1">
                                        </div>
                                    </div>

                                    <div class="dropdown">
                                        <label class="control-label col-sm-2" for="visibility">visibility:</label>

                                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="visibility">visibility
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">private</a></li>
                                            <li><a href="#">public</a></li>

                                        </ul>
                                    </div>

                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">share</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                        </div>
                                    </div>
                                </form>



                            </div>
                            <!--<div class="modal-footer">-->
                            <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
                            <!--</div>-->
                        </div>

                    </div>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal2" data-toggle="modal"
                                                             data-target="#myModal2"><i class="fa fa-envelope-o"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal2" class="modal fade" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">send invitation</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" action="#">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="email1">email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="email1"  name="email1">
                                        </div>
                                    </div>

                                    <div class="dropdown">
                                        <label class="control-label col-sm-2" for="visibility1">visibility:</label>

                                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="visibility1">visibility
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">private</a></li>
                                            <li><a href="#">public</a></li>

                                        </ul>
                                    </div>

                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">share</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                        </div>
                                    </div>
                                </form>

                            </div>

                        </div>

                    </div>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal3" data-toggle="modal"
                                                             data-target="#myModal3"><i class="fa fa-link"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal3" class="modal fade" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">create resource</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" action="#">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="link">link:</label>
                                        <div class="col-sm-10">
                                            <input type="url" class="form-control" id="link" placeholder="Enter link"
                                                   name="link">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="descrip">description:</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" rows="5" id="descrip"></textarea>
                                        </div>
                                    </div>
                                    <div class="dropdown">
                                        <label class="control-label col-sm-2" for="topic">topic:</label>

                                        <button class="btn btn-default dropdown-toggle" type="button"
                                                data-toggle="dropdown" id="topic">topic
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">topictype1</a></li>
                                            <li><a href="#">topictype2</a></li>
                                            <li><a href="#">topictype3</a></li>

                                        </ul>
                                    </div>
                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">share</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                            </button>

                                        </div>
                                    </div>
                                </form>

                            </div>
                            <!--<div class="modal-footer">-->
                            <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
                            <!--</div>-->
                        </div>

                    </div>
                </div>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal4" data-toggle="modal"
                                                             data-target="#myModal4"><i class="fa fa-file"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <div id="myModal4" class="modal fade" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Share document</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" action="#">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="document">document</label>
                                        <div class="col-sm-10">
                                            <input type="file" class="form-control" id="document" name="document">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="descrip1">description:</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" rows="5" id="descrip1"></textarea>
                                        </div>
                                    </div>
                                    <div class="dropdown">
                                        <label class="control-label col-sm-2" for="topic1">topic:</label>

                                        <button class="btn btn-default dropdown-toggle" type="button"
                                                data-toggle="dropdown" id="topic1">topic
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">topictype1</a></li>
                                            <li><a href="#">topictype2</a></li>
                                            <li><a href="#">topictype3</a></li>

                                        </ul>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">share</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                        </div>
                                    </div>
                                </form>
                            </div>






                        </div>

                    </div>

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
                        <li><a href="#">logout</a></li>
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