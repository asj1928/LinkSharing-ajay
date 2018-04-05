package linksharingajay

class LinksharingTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"


    def readLink = { attr, body ->

        ReadingItem readingItem = ReadingItem.findByUserAndResource(session.user, attr.resource)

        String value = ""
        if (readingItem && readingItem.isRead) {
            value = "Mark As Unread"
        } else {
            value = "Mark As Read"

        }
//        String value = session.user ? "Mark as Read" : "Mark As Unread"

        out << value
    }


    def showSubscribe = {
        attr, body ->

            boolean isSubscribed = User.isSubscribed(attr.topic)
            String value = ""
            if (isSubscribed) {
                value = "UnSubscribe"
            } else {
                value = "Subscribe"

            }
            out << value

    }


    def subscriptionCount = {
        attr, body ->

            Integer count = 0
            List listOfSubscriptions = []
            if (attr.topic) {

                listOfSubscriptions = Subscription.findByTopic(attr.topic)
                return listOfSubscriptions.size()

            } else {

                listOfSubscriptions = Subscription.findByUser(session.user)
                return listOfSubscriptions.size()
            }


    }


    def resourceCount = {
        attr, body ->

            return Resource.countByTopic(attr.topic)
    }


    def topicCount = {
        attr, body ->
            return Topic.countByCreatedBy(session.user)
    }

    def trendingTopics = { attr, body ->


    }
}
