package linksharingajay

import grails.gorm.transactions.Transactional
import vo.linksharingajay.Resource1VO
import vo.linksharingajay.Topic1VO
import vo.linksharingajay.UserVO

@Transactional
class UserService {

    def serviceMethod() {

    }
    def showProfile(String username) {
        User user = User.findByUserName(username)
        UserVO userInformation = new UserVO(name: user.getName(), username: user.username,
                subscriptionCount: user.subscriptions.size(), resourceCount: user.resources.size(),
                topicCount: user.topics.size())

        List<Topic> topicList = Topic.findAllByCreatedBy(user)
        List<Topic1VO> userTopics = []
        topicList.each {
            userTopics.add(new Topic1VO(topicId: it.id, topicName: it.name, topicVisibility: it.visibility,
                    ownerName: it.createdBy.getName(), ownerUsername: it.createdBy.username,
                    subscriptionCount: it.subscriptions.size(), resourcesCount: it.resources.size()))
        }

        List<Resource> resourceList = Resource.findAllByUser(user)
        List<Resource1VO> userPosts = []
        resourceList.each {
            userPosts.add(new Resource1VO(resourceId: it.id, topicId: it.topic.id, resourceDescription: it.description,
                    ownerName: it.user.getName(), ownerUsername: it.user.userName, topicName: it.topic.name))
        }

        Map map = [userInformation: userInformation, userTopics: userTopics, userPosts: userPosts]
        return map
    }

    def changeUserCredentials(Map userData, String username) {
        User user = User.findByUsername(username)
        user.firstName = userData.updatedFirstname
        user.lastName = userData.updateLastname
        user.userName = userData.updatedUsername
        if (userData.updatedPhoto)
            user.photo = userData.updatedPhoto.bytes
        if (user.save(flush: true)) {
            log.info("Credentials Updated : $user")
            return true
        } else {
            log.error("Error Updating Credentials : $user")
            user.errors.allErrors.each { println it }
            return false
        }
    }

    def changePassword(Map userData, String username) {
        User user = User.findByUserName(username)
        user.password = userData.updatedPassword
        user.confirmpassword = userData.updatedConfirmPassword
        if (user.save(flush: true)) {
            log.info("Password Changed : $user")
            return true
        } else {
            log.error("Error Changing Password : $user")
            user.errors.allErrors.each { println it }
            return false
        }
    }

    def showAllUsers() {
        List<User> userList = User.findAllByAdmin(false)
        if (userList) {
            List<UserVO> allUsers = []
            userList.each {
                allUsers.add(new UserVO(name: it.getName(), username: it.username,
                        subscriptionCount: it.subscriptions.size(), resourceCount: it.resources.size(),
                        topicCount: it.topics.size(), active: it.active, userId: it.id))
            }
            return allUsers
        } else
            return null
    }

    def activateDeactivate(Integer userId) {
        User user = User.findById(userId)
        if (user.active)
            user.active = false
        else
            user.active = true
        if (user.save(flush: true)) {
            log.info("State Successfully Changed : $user")
            return true
        } else {
            log.error("Unable to Change State : $user")
            user.errors.allErrors.each { println it }
            return false
        }

    }

}
