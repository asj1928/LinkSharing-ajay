package linksharingajay

class LoginController {

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


