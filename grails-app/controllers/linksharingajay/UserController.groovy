package linksharingajay

import co.linksharingajay.SearchCO
import vo.linksharingajay.InboxVO

class UserController {
    UserService userService


    def index() {
        /*render(session.user.userName)*/
        /* session.user.getUnreadResource()*/
        if (session.user) {
            List<InboxVO> unReadResourcesList = session.user.getUnReadResources()
            println(unReadResourcesList+"====ooooo=======oooooooo==========")
            println(unReadResourcesList.toString()+"************************")
            render(view: 'index', model: [unReadResourcesList: unReadResourcesList])
        }else {
            redirect(controller: 'login', action: 'index')

        }

    }

    def show(Integer id){

        Topic topic=Topic.get(id)
        if(topic.visibility==Visibility.PUBLIC) {
            render("success")
        }
        else{
            if(Subscription.findByTopicAndUser(topic,session.user))
                render("Subscription Exists")
            else
            {
                flash.error="Subscription does not exists"
                redirect(action:"login/index")
            }
        }
    }
    def editProfile() {
        Map map = userService.showProfile(new String(session.user.userName))
        render(view: 'editProfile', model: [user: map.userInformation, userTopics: map.userTopics, userPosts: map.userPosts])
    }
}
