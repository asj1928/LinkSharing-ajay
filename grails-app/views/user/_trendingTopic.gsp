<%@ page import="linksharingajay.Topic" %>
<div class="panel panel-primary ">
    <div class="panel-heading">
        <h3 class="panel-title">
            Trending topics
            <a href="#" class="pull-right">View All</a>
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <g:each in="${Topic.getTrendingTopics()}" var="itr">


                <div class="col-sm-12">

                <div class="row">

                    <div class="col-sm-3 glyphicon glyphicon-user fa-5x">
                        <!--  <img src="avatar.png" class="img-thumbnail"> -->

                    </div>
                    <div class="col-sm-9">
                        <a href="${createLink(controller: 'topic' ,action: 'index',id: itr.id)}" >${itr.name}</a>
                        <br>
                        <div class="row">

                            <div class="col-sm-6">
                                <h6 class="text-muted">@${itr.createdBy.userName}</h6>
                                <a href="#">Unsubscribe</a>
                            </div>


                            <div class="col-sm-3">
                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                <h6 class="text-primary">${itr.subscriptions.size()}</h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>
                                    <p class="text-primary">${itr.resources.size()}</p>
                                </h6>

                            </div>

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
    <hr>
</div>
