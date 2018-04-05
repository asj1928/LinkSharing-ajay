package linksharingajay

import vo.linksharingajay.TopicVO


class Topic {
    String name
//    User createdBy
    Date dateCreated
    Date lastUpdated

    Visibility visibility

    static belongsTo = [createdBy:User]
    static hasMany = [subscriptions:Subscription, resources:Resource]

    static constraints = {
       name(unique:'createdBy',blank: false,nullable: false )
        createdBy(nullable: false)
        visibility(nullable: false)
    }
    def afterInsert(){
        log.info "----------Into After Insert------"
       Topic.withNewSession {

            Subscription subscription= new Subscription(topic: this,seriousness: Seriousness.VERY_SERIOUS,user: this.createdBy)
           if (subscription.save(flush:true)) {
               log.info "------------------subscription saved--------"
           }
           else {

               log.error("Error:${subscription.errors.getAllErrors()}")
           }

        }


    }
    static getTrendingTopics() {
        List<Topic> trendingTopics = Resource.createCriteria().list{
            projections {
                groupProperty('topic')
                count('topic.id', 'count')
            }
            order('count', 'desc')
            maxResults(5)
        }
        List <Topic> result=[]
        trendingTopics.each {result.add(it[0])}
        return result
    }
    static mapping = {
        sort("name": "asc")
        subscriptions lazy: false
    }

    List<User> getSubscribedUsers(){
        List<User> subscribedUsers=this.subscriptions.user.toList()
        return subscribedUsers
    }

    Integer getSubscriptionCount(){
        if(subscriptions)
            return subscriptions.size()
        else
            return 0
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}

