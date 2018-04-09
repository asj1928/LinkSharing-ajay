<%@ page import="linksharingajay.Subscription; linksharingajay.Topic" %>
<div class="panel panel-primary ">
    <div class="panel-heading"><h3 class="panel-title">
        Subscriptions
        <a href="#" class="pull-right">View All</a>
    </h3></div>

    <div class="panel-body">
        <g:each in="${Topic.findAllByCreatedBy(session.user)  }" var="itr">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-3 glyphicon glyphicon-user fa-5x">
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
                                        <h6 class="text-primary">${itr.subscriptions?.size()}</h6>
                                    </div>

                                    <div class="col-sm-3">
                                        <h6 class="text-muted  pull-right">Post
                                            <br>
                                            <br>

                                            <p class="text-primary">${itr.resources?.size()}</p>
                                        </h6>
                                    </div>
                                    <span type="img" class="fa fa-file pull-right fa-2x"
                                          style="margin-left: 10px;  margin-right: 5px;"></span>
                                    <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;">
                                    </span>
                                    <span type="img" class="glyphicon glyphicon-trash pull-right fa-2x"
                                          style="margin-left: 10px;">
                                    </span>
                                    <select class="pull-right">
                                        <option>Serious</option>
                                        <option>Casual</option>
                                        <option>Very Serious</option>
                                    </select>

                                    <div>
                                        <select class="pull-right">
                                            <option>Private</option>
                                            <option>Public</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="col-lg-12"><hr></div>
        </g:each>


        <g:each in="${Subscription.getSubscribedTopics(session.user)}" var="itr">

            <div class="col-lg-12"><hr></div>

            <div class="col-lg-12">
                <div class="row">
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


                                    <span type="img" class="fa fa-envelope pull-right fa-2x"
                                          style="margin-left: 10px; margin-right: 5px;">

                                    </span>
                                    <select class="pull-right">
                                        <option>Serious</option>
                                        <option>Casual</option>
                                        <option>Very Serious</option>
                                    </select>

                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </g:each>


    </div>

</div>
