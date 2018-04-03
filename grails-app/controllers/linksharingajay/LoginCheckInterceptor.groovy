package linksharingajay


class LoginCheckInterceptor {


    LoginCheckInterceptor(){
//        matchAll().excludes(controller: 'login', action: 'loginHandler')

    }

    boolean before() {
        if (!session.user) {
            flash.error= "NO ACTIVE SESSION"
            //  redirect controller: 'login', action: 'loginHandler'
            false
        }

        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
