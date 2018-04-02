<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Title</title>
    <g:layoutHead/>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-inverse  ">


    <a class="navbar-brand col-lg-2 " href="#"><h2 style="margin-top: 0px">LinkSharing</h2></a>

    <p class="col-lg-7"></p>


    <form class="form-inline col-lg-3" style="margin-top: 6px">
        <div class="form-group">
            <input class="form-control" type="search" placeholder="search..">
            <button type=" button " class="btn  btn-default">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </input>

        </div>

    </form>


</nav>

<g:layoutBody/>
<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>