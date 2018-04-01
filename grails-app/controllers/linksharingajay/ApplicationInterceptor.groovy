package linksharingajay


class ApplicationInterceptor {
    ApplicationInterceptor(){
        matchAll()
    }

    boolean before() {

        log.info "param=========$params.toString() checking session.user"
        if(session.user){}
        else {
            flash.error= "session is not active"
        }
        true
    }

    boolean after() {

        log.info "params=======$params.toString()"

        true
    }

    void afterView() {
        // no-op
    }
}
