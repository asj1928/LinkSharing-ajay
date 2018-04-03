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
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #1b1e21">
                    <p>
                    <h3 style="color:white">Recent Shares</h3></p>
                </div>
                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>ajay singh jodha  <span style="color: darkgray">@asjodha22</span><span class="pull-right" style="margin-right: 0px;color: blue">grails</span></h6> </p>
                            <p><h5>Lorem ipsum turpis nam auctor elementum tellus cras maecenas leo potenti ligula, eleifend cras curae proin augue donec quam malesuada dictum placerat inceptos blandit fringilla nisi ullamcorper eu habitant sodales curabitur euismod dictum in.</h5></p>

                            <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>

                        </div>
                    </div>

                    <div class="col-lg-12">
                        <hr>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>ajay singh jodha  <span style="color: darkgray">@asjodha22</span><span class="pull-right" style="margin-right: 0px;color: blue">grails</span></h6> </p>
                            <p><h5>Lorem ipsum turpis nam auctor elementum tellus cras maecenas leo potenti ligula, eleifend cras curae proin augue donec quam malesuada dictum placerat inceptos blandit fringilla nisi ullamcorper eu habitant sodales curabitur euismod dictum in.</h5></p>

                            <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>


                        </div>
                    </div>


                </div>
            </div>

        </div>
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading  col-lg-12" style="background: #1b1e21">


                    <h3 style="color:white " class="col-lg-8">Top Posts</h3>





                    <select name="time" class=" col-lg-3 " style=" margin-top: 25px">
                        <option value="today">Today</option>
                        <option value="1 week">1 Week</option>
                        <option value="1 month">1 Month</option>
                        <option value="1 year">1 Year</option>
                    </select>






                </div>
                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>ajay singh jodha  <span style="color: darkgray">@asjodha22</span><span class="pull-right" style="margin-right: 0px;color: blue">grails</span></h6> </p>
                            <p><h5>Lorem ipsum turpis nam auctor elementum tellus cras maecenas leo potenti ligula, eleifend cras curae proin augue donec quam malesuada dictum placerat inceptos blandit fringilla nisi ullamcorper eu habitant sodales curabitur euismod dictum in.</h5></p>

                            <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>

                        </div>
                    </div>




                </div>
            </div>

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
                            <input class="form-control" type="email" name="email" id="em" placeholder="enter your email ID">
                        </div><div class="col-lg-2"></div>
                        <div class="form-group col-lg-10">
                            <label for="psw">Password</label>
                            <input class="form-control" type="password" id="psw" name="password" placeholder="enter your password">

                        </div>
                        <div class="col-lg-12"></div>
                        <div class="form-group col-lg-5" >
                            <p><a href="#">Forgot Password</a></p>
                        </div>
                        <div  class="form-group col-lg-10">
                            <input type="submit" class="form-control btn-primary">
                        </div>


                    </g:form>

                </div>
            </div>
        </div>

        <div class="col-lg-12" style="margin-top: 25px;">
            <div class=" panel panel-default ">
                <div class="panel-heading  " style="background:#1b1e21">
                    <p>
                    <h3 style="color:white">Registration</h3></p>
                </div>
                <div class="panel-body ">
                    <form>
                        <div class="form-group col-lg-10">
                            <label for="fname">First Name</label>
                            <input class="form-control" type="text" id="fname" placeholder="enter your first name">
                        </div><div class="col-lg-2"></div>
                        <div class="form-group col-lg-10">
                            <label for="lname">Last name </label>
                            <input class="form-control" type="text" id="lname" placeholder="enter your last name">

                        </div>
                        <div class="form-group col-lg-10">
                            <label for="em1">Email </label>
                            <input class="form-control" type="email" id="em1" placeholder="enter your last name">

                        </div>
                        <div class="form-group col-lg-10">
                            <label for="uname">Username </label>
                            <input class="form-control" type="text" id="uname" >

                        </div>

                        <div class="form-group col-lg-10">
                            <label for="psw1">Password </label>
                            <input class="form-control" type="password" id="psw1" placeholder="enter password">

                        </div>
                        <div class="form-group col-lg-10">
                            <label for="cpsw1">Confirm Password </label>
                            <input class="form-control" type="password" id="cpsw1" placeholder="confirm your  password">

                        </div>
                        <div class="form-group col-lg-10">
                            <label for="ph">Photo </label>
                            <input class="form-control" type="file" id="ph" >

                        </div>

                        <div  class="form-group col-lg-10">
                            <input type="submit" class="form-control btn-primary">
                        </div>


                    </form>

                </div>
            </div>



        </div>
    </div>

</div>

</body>
</html>