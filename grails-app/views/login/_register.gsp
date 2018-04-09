<div class=" panel panel-default ">
    <div class="panel-heading  " style="background:#1b1e21">
        <p>

        <h3 style="color:white">Registration</h3></p>
    </div>

    <div class="panel-body ">
        <g:uploadForm controller="login" action="register" method="post" enctype="multipart/form-data">
            <div class="form-group col-lg-10">
                <label for="fname">First Name</label>
                <input class="form-control" type="text" id="fname" placeholder="enter your first name" name="fname">
            </div>

            <div class="col-lg-2"></div>

            <div class="form-group col-lg-10">
                <label for="lname">Last name</label>
                <input class="form-control" type="text" id="lname" name="lname" placeholder="enter your last name">

            </div>

            <div class="form-group col-lg-10">
                <label for="em1">Email</label>
                <input class="form-control" type="email" id="em1" name="email" placeholder="enter your last name">

            </div>

            <div class="form-group col-lg-10">
                <label for="uname">Username</label>
                <input class="form-control" type="text" id="uname" name="uname">

            </div>

            <div class="form-group col-lg-10">
                <label for="psw1">Password</label>
                <input class="form-control" type="password" id="psw1" placeholder="enter password" name="password">

            </div>

            <div class="form-group col-lg-10">
                <label for="cpsw1">Confirm Password</label>
                <input class="form-control" type="password" id="cpsw1" placeholder="confirm your  password" name="confirmPassword">

            </div>

            <div class="form-group col-lg-10">
                <label for="ph">Photo</label>
                <input class="form-control" type="file" id="ph" name="photo">

            </div>

            <div class="form-group col-lg-10">
                <input type="submit" class="form-control btn-default" style="background-color: #5e5e5e;color: white">
            </div>

        </g:uploadForm>

    </div>
</div>
