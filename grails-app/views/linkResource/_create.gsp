<%@ page import="linksharingajay.Topic" %>
    <div class="modal-dialog">


        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">create resource</h4>
            </div>
            <div class="modal-body row">
                <g:form controller="linkResource" action="save">
                    <div class=" col-lg-12">
                        <div class="col-lg-2">
                            <label class="control-label " for="link">link:</label>
                        </div>
                        <div class="col-lg-10">
                            <input type="url" class="form-control" id="link" placeholder="Enter link"
                                   name="link">
                            <br>
                        </div>



                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-12">
                            <label class="control-label " for="descrip">description : </label>
                        </div>
                        <div class="col-lg-12">
                            <textarea class="form-control" rows="5" id="descrip" name="des"></textarea>
                        </div>
                    </div>
                    <div class="dropdown col-lg-12" >
                        <br>
                        <div class="col-lg-2">
                            <label class="control-label " >Topic:</label>

                        </div>
                        <div class="col-lg-10">
                            <select class="form-control " name="topic">
                                <g:set var="list" value="${Topic.findAllByCreatedBy(session.user)}"/>
                                <g:each in="${list}" var="it">

                                    <option value="${it.name}">${it.name}</option>
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

                            <button type="submit" class="btn btn-default">save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </g:form>

            </div>
            <!--<div class="modal-footer">-->
            <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
            <!--</div>-->
        </div>

    </div>
