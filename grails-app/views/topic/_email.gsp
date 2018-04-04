<%@ page import="linksharingajay.Topic" %>

<div class="modal-dialog">


        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">send invitation</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="#">
                    <div class=" col-lg-12">
                        <div class="col-lg-2">
                            <label class="control-label " >Email:</label>

                        </div>
                        <div class="col-lg-10">
                            <input type="email" class="form-control" id="email1"  name="email1">
                        </div>
                    </div>


                    <div class="dropdown col-lg-12" >
                        <br><br>
                        <div class="col-lg-2">
                            <label class="control-label " >Topic:</label>

                        </div>
                        <div class="col-lg-10">
                            <select class="form-control ">
                                <g:set var="list" value="${Topic.findAllByCreatedBy(session.user)}"/>
                                <g:each in="${list}" var="it">

                                    <option value="${it}">${it.name}</option>
                                </g:each>

                            </select>
                        </div>


                    </div>
                    <br><br>
                    <br>

                    <div class="form-group">
                        <br><br>
                        <div class="col-sm-4"></div>
                        <div class=" col-sm-4">
                            <br><br>

                            <button type="submit" class="btn btn-default">share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </form>

            </div>

        </div>

    </div>

