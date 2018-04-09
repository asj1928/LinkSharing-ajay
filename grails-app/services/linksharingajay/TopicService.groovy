package linksharingajay

import grails.gorm.transactions.Transactional
import vo.linksharingajay.Resource1VO
import vo.linksharingajay.Topic1VO
import vo.linksharingajay.UserVO

@Transactional
class TopicService {

    def serviceMethod() {

    }
    def getCompleteTopicInfo(Long topicId) {
        Topic topic = Topic.findById(topicId)
        if (topic) {
            Topic1VO topicVO = new Topic1VO(topicId: topicId, topicName: topic.name, topicVisibility: topic.visibility,
                    ownerName: topic.createdBy.getName(), ownerUsername: topic.createdBy.username,
                    subscriptionCount: topic.subscriptions.size(), resourcesCount: topic.resources.size())

            List<Subscription> subscribedUsers = Subscription.findAllByTopic(topic)

            List<UserVO> subscribedUserList = []
            subscribedUsers.each {
                subscribedUserList.add(new UserVO(name: it.user.getName(), username: it.user.username, subscriptionCount: it.user.subscriptions.size(),
                        resourceCount: it.user.resources.size(),topicCount: it.user.topics.size()))
            }

            List<Resource> resources = Resource.findAllByTopic(topic)

            List<Resource1VO> resourceList = []
            resources.each {
                resourceList.add(new Resource1VO(resourceId: it.id, topicId: topicId, resourceDescription: it.description,
                        ownerName: it.user.getName(), ownerUsername: it.user.userName, topicName: it.topic.name))
            }
            def map = ["topicVO": topicVO, "subscribedUserList": subscribedUserList, "resourceList": resourceList]
            return map
        } else
            return null
    }

    def editTopicName(Map topicData){
        Topic topic = Topic.findById(topicData.topicId)
        topic.name= topicData.changedTopicName
        if(topic.save(flush:true)){
            log.info("Topic Name Changed Successfully : $topic")
            return true
        }else
        {
            log.error("Error Changing Topic Name : $topic")
            topic.errors.allErrors.each {println it}
            return false
        }
    }
}
