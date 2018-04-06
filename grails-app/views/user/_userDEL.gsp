<%@ page import="linksharingajay.Topic; linksharingajay.Subscription; linksharingajay.User" %>
<div class="panel panel-primary col-lg-12">
    <div class="panel-body">
        <div class="col-sm-12">
            <div class="row">
                <div class="col-sm-3 glyphicon glyphicon-user fa-5x">
                </div>
                <div class="col-sm-9">
                    <g:set var="sub" value="${Subscription.findAllByUser(session.user)}"/>
                    <g:set var="topic"value="${Topic.findAllByCreatedBy(session.user)}"/>
                    <p>${session.user.firstName} ${session.user.lastName}<br>
                        <small class="text-muted">@${session.user.userName}</small>
                    </p>

                    <div class="row">

                        <h6 class="text-muted col-sm-6">Subscriptions
                            <p class="text-primary">${sub.size()}</p>
                        </h6>

                        <h6 class="text-muted col-sm-6">Topics
                            <p class="text-primary">${topic.size()}</p>
                        </h6>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
