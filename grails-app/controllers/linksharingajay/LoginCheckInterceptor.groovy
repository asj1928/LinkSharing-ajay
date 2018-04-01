package linksharingajay


class LoginCheckInterceptor {

    LoginCheckInterceptor(){
        matchAll()excludes(controller:'login', action: 'loginHandler')
    }

    boolean before() {

        if (!session.user) {
            flash.error= "session is not active"
            redirect(controller: "login", action: "index")
        }
        true }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
