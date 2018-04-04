<div class="modal-dialog">


    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">pass changed</h4>
        </div>
        <div class="modal-body row">
            <g:form  controller="login" action="validateForgotPassword">
                <div class="form-group col-lg-12">
                    <label class="control-label col-sm-2" for="email1">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email1"  name="email1">
                    </div>
                </div>
                <div class="form-group col-lg-12">
                    <label class="control-label col-sm-2" for="pass1">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pass1"  name="pass1">
                    </div>
                </div>
                <div class="form-group col-lg-12">
                    <label class="control-label col-sm-2" for="cpass">Confirm Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="cpass"  name="cpass">
                    </div>
                </div>



                <br><br>



                <div class="form-group">
                    <br><br>
                    <div class="col-sm-4"></div>
                    <div class=" col-sm-4">
                        <br><br>

                        <button type="submit" class="btn btn-default">Save</button>
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

