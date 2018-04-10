package linksharingajay

import co.linksharingajay.SearchCO
import vo.linksharingajay.InboxVO
import vo.linksharingajay.UserVO

class UserController {
    UserService userService
    def assetResourceLocator


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
    def showUserListToAdmin(){
        List<UserVO> allUsers= userService.showAllUsers()
        render(view: 'userList', model: [allUsers:allUsers])
    }
    def changeState(){
        println "Printing params- $params.id"
        if(userService.activateDeactivate(new Integer(params.id))){
            flash.message= "State Changed"
        }else
            flash.error= "Unable To Change State"
        redirect(controller: 'user', action: 'showUserListToAdmin')
    }
    def fetchUserImage(){
        def user = User.findByUserName(params.username)
        byte[] photo
        if(!user?.photo){
            println("Photo Not Found")
            photo = assetResourceLocator.findAssetForURI('user.png').byteArray
        }else {
            println("Photo Found")
            photo= user.photo
        }
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
    }
}
