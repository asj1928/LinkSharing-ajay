package linksharingajay

class LoginController {

    //    String a="ajay.s.jodha"
    //    String b="lololol"
    def index() {
        if(session.user){
            render(controller:'login',action:'index')
        }else{
            render "failure"
        }
    }

    def loginHandler(String userName, String password){
//        userName=a
//        password=b
        User user=User.findByUserNameAndPassword(userName,password)
        if(user!=null){
            print "user is not null"
            if(user.active){
                log.info("user active")
                session.user=user
                redirect action: 'index'

            }else {
                print("user not active")
                flash.error='Your accoutn is not active'
            }
        }
        else{
            print "user is  null"
            flash.error="User not found"
        }

    }

    def logout(){
        session.invalidate()
        redirect(action:'index')
    }
    def register(){
        User admin = new User(email: "ajay@gmail.com", password:"bogasspass", firstName: "ajay", lastName: "singh", userName: 'asj', photo: 121, admin: true, active: true)
        if(admin.save()){
            flash.message="Admin Saved Successfully"
        }
        else {
            flash.error="error"
        }

        User normal = new User(email: "lal@gmail.com", password: "hokaspokas", firstName: "lal", lastName: "Jhala", userName: 'jhala_lal', photo: 122, admin: false, active: true)
        if(normal.save()){
            flash.message="Normal User Saved Successfully"
        }
        else {
            flash.error="error"
        }

        redirect(action: "index")
    }

}


