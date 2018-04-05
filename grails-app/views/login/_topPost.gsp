<%@ page import="linksharingajay.Resource" %>
<div class=" panel panel-default     ">
    <div class="panel-heading  col-lg-12" style="background: #1b1e21">


        <h3 style="color:white " class="col-lg-8">Top Posts</h3>





        <div class="col-lg-3 " >
            <select name="time" class=" form-control  " style=" margin-top: 15px">
                <option value="today">Today</option>
                <option value="1 week">1 Week</option>
                <option value="1 month">1 Month</option>
                <option value="1 year">1 Year</option>
            </select>
        </div>







    </div>
    <div class="panel-body  ">
        

        <g:each in="${Resource.getTopPost()}" var="topPosts">
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

        </g:each>




    </div>
</div>
