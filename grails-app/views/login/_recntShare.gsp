<%@ page import="linksharingajay.Resource" %>
<div class=" panel panel-default     ">
    <div class="panel-heading " style="background: #1b1e21">
        <p>
        <h3 style="color:white">Recent Shares</h3></p>
    </div>

    <div class="panel-body  ">
        <g:set var="rShare" value="${Resource.getRecentShares()}"/>
        <g:each in="${rShare}" var="itr">
            <div class="col-lg-12">
                %{--image--}%
                <div class="col-lg-3" style="margin-top: 25px">
                    <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                </div>

                %{--detail--}%
                <div class="col-lg-9">
                    <p><h6>${itr.user.firstName} ${itr.user.lastName}   <span style="color: darkgray">@${itr.user.userName} </span><span class="pull-right" style="margin-right: 0px;color: blue"><g:link controller="topic" action="show"  params="[topic:itr]" >${itr.topic.name}</g:link> </span></h6> </p>
                    <p><h5>${itr.description} </h5></p>

                    <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                    <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                    <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>

                </div>
            </div>

            %{--hr--}%
            <div class="col-lg-12">
                <hr>
            </div>

        </g:each>



    </div>
</div>
