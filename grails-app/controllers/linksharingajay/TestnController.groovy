package linksharingajay

class TestnController {


    def index(){
        sendMail {
            to "ajay.singh@tothenew.com"
            from "asjodha1928@gmail.com"
            subject "hey der"
            text "this is a test mail"
        }
        flash.message = "Message sent at "+new Date()
    }
}
