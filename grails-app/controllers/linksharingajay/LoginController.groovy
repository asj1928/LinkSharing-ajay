package linksharingajay

class LoginController {
    LoginService loginService

    //    String a="ajay.s.jodha"
    //    String b="lololol"
    def index() {

    }

    def loginHandler(){
//        userName=a
//        password=b
        println(params.email)
        User user=User.findByEmailAndPassword(params.email,params.password)
        if(user!=null){
            print "user is not null"
            if(user.active){
                log.info("user active")
                println("user active")
                session.user=user
                redirect controller:"user",action: 'index'

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
        redirect(view:'index')
    }
    def register() {
        println("printing params : $params")
        User user = loginService.registerUser(params)
        if (user) {
            flash.message = "SUCCESSFULLY REGISTERED"
            session.user = user
            forward(controller: 'User', action: 'index')
        } else {
            flash.error = "UNABLE TO REGISTER USER"
        }
    }
    def validateForgotPassword(){
        println(params.email1)
        println(params.cpass)
        println(params.pass1)
        User u= User.findByEmail(params.email1)
        User u1=User.get(u.id)
        println(u1)
        println(u.password)
        if(params.cpass==params.pass1)
        if(u1!=null){
            u1.password=params.cpass
            if(u.save()){
                println("pass changed")
                println(u.password)
                redirect(controller:'login', action: 'index')

            }else {
                println("pass didnt changed")
                redirect(controller:'login', action: 'index')

            }
        }else {
            println("user is not registered")
            redirect(controller:'login', action: 'index')

        }


    }

}


