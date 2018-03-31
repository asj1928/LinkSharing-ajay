package linksharingajay

class LoginController {

    def index() {
        if(session.user){
            render(controller:'login',action:'index')
        }else{
            render "failure"
        }
    }

    def loginHandler(){}

    def logout(){
        session.invalidate()
        redirect(action:'index')
    }

}
