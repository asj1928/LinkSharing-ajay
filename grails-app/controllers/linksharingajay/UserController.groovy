package linksharingajay

import co.linksharingajay.SearchCO

class UserController {

    def index(SearchCO searchCO) {

        render(session.user.userName)

        render session.user.getUnreadResource(searchCO)
    }
    def show(Integer id){
        if(Topic.count()==0){
            flash.error "Topic is not present"
            redirect controller:'login',action:'index'

        }else {
            if(Topic.findByVisibility(Visibility.PUBLIC)){
                render "success"
            }else {
                if(Subscription.findByTopicAndUser(topic,session.user))
                    render("Subscription Exists")
                else{
                    flash.error="Subscription does not exists"
                    redirect(action:"login/index")
                }


            }
        }

    }
}
