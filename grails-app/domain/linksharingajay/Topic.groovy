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
    static mapping = {
        sort("name": "asc")
        subscriptions lazy: false
    }
    static getTrendingTopics() {
        List<Topic> trendingTopics = Resource.createCriteria().list() {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                count('t.id', 'count')
                property('t.createdBy')
            }
            eq('t.visibility', Visibility.PUBLIC)
            order('count', 'desc')
            order('t.name', 'asc')
            maxResults(5)
        }

        return trendingTopics
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

