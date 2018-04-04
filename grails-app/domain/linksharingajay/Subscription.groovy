package linksharingajay

class Subscription {
//    Topic topic
//    User user

    Seriousness seriousness
    Date dateCreated
    Date lastUpdated

    static transients = ['getSubscribedTopics']


    static belongsTo = [user:User, topic:Topic ]
    static constraints = {
        topic(nullable: false ,unique:'user')
        user(nullable: false)
        seriousness(nullable: false)



    }

    static mapping = {
        seriousness defaultValue: Seriousness.SERIOUS
        topic fetch:'join'
        user fetch: 'join'
    }
    static List getSubscribedTopics(User user) {
        List<Subscription> subscribedTopics = Subscription.findAllByUser(user)
        List<Topic> result = []
// List<String> result = []

        subscribedTopics.each {
            Topic topic = Topic.findByCreatedByAndTopicName(it.user, it.topic.topicName)
            if (!topic) {
// result.add(it.topic.topicName)
                result.add(it.topic)
            }
        }
        return result
    }
}
