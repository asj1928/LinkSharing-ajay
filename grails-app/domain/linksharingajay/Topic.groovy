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
    static List<TopicVO> getTrendingTopics(){
        List topicList = Resource.createCriteria().list {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.visibility')
                count('t.id', 'topicCount')
                property('t.createdBy')
                property('t.name')
            }
            order('topicCount', 'desc')
            eq('t.visibility',Visibility.PUBLIC)
            order('t.name', 'asc')
            maxResults(5)
        }


        List topicVOList = []
        topicList.each {

            topicVOList.add(new TopicVO(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))


        }
        return topicVOList



    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}

