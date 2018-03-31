package linksharingajay

class LoginController {

    def index() {
        if(session.user){
            render(controller:'login',action:'index')
        }else{
            render "failure"
        }
    }

    def loginHandler(String userName,String password){
        User user=User.findByUserNameAndPassword(userName,password)
        if(user!=null){
            if(user.active){
                session.user=user
                redirect action: 'index'

            }else {
                flash.error='Your accoutn is not active'
            }
        }
        else{
            flash.error="User not found"
        }

    }

    def logout(){
        session.invalidate()
        redirect(action:'index')
    }

}
