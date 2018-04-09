package linksharingajay

import co.linksharingajay.SearchCO

class UserController {

    def index() {
        /*render(session.user.userName)*/
        /* session.user.getUnreadResource()*/
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
        Map map = userService.showProfile(new String(session.user.username))
        render(view: 'editProfile', model: [user: map.userInformation, userTopics: map.userTopics, userPosts: map.userPosts])
    }
}
