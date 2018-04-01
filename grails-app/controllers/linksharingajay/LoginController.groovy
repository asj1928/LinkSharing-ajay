package linksharingajay

class LoginController {


    def index() {

        if(session.user)
            forward(controller: 'login',action:'index')
        else
            render( 'failure')
    }

    def logout(){
        session.invalidate()
        redirect(action:'index')
    }


    def loginHandler(String userName, String password) {
        println(userName)
        User user = User.findByUserNameAndPassword(userName, password)
        if(user!=null) {
            if(user.active) {
                session.user=user
            }
            else {
                flash.error = "Your account is not active"

            }
        }
        redirect(action: 'index')


    }

}
