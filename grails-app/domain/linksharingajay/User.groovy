package linksharingajay

import co.linksharingajay.SearchCO
import vo.linksharingajay.InboxVO

class User {
    String email
    String userName
    transient String name
    String password
    String confirmpassword

    String firstName
    String lastName
    byte photo
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated



    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,resourceRating:ResourceRating,readingItems:ReadingItem]

    static mapping = {
        sort("id": "desc")
        subscriptions fetch: 'join'
        photo(sqlType: "longblob")

    }
    static constraints = {
        email(unique: true ,nullable: false,blank: false, email: true)
        password(nullable: false, blank: false, size: 5..15, validator: { password, obj ->
            println "runnig password validation > " + obj.confirmpassword
            if (obj.confirmpassword) {
                println "inside validation"
                def password2 = obj.confirmpassword
                return (password == password2) ? true : ['invalid.matchingpasswords']
            }
            else
                return true
        })
        firstName(nullable: false,blank: false)
        lastName(nullable: false,blank: false)
        userName(unique: true,nullable: false,blank: false)

        photo(nullable:true)
        admin(nullable:true)
        active(nullable:true)


    }
    List getUnreadResource(SearchCO searchCO){

        if(searchCO.q){
            List<ReadingItem> readingItems= ReadingItem.createCriteria().list(max:10,offset:0){
                ilike('resource.description',this.resources.description)
                eq('isRead',false)
            }
            return  readingItems
        }
    }

    List<Topic> getSubscribedTopic() {
        List<Topic> subscribedTopics = []
        if(this.subscriptions){
            this.subscriptions.each {
                if (it.topic.createdBy != it.user)
                    subscribedTopics.add(it.topic)
            }
        }
        return subscribedTopics
    }
    Integer getSubscriptionCount() {
        if (this.subscriptions)
            return this.subscriptions.size()
        else
            return 0
    }

    Integer getTopicCount() {
        if (topics)
            return this.topics.size()
        else
            return 0
    }
    Integer getScore(Resource resource){
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(this,resource)
        if (resourceRating){
            return resourceRating.score
        }else {
            return 1
        }
    }
    List<InboxVO> getUnReadResources() {

        List<ReadingItem> unReadItems = ReadingItem.createCriteria().list(max: 10, offset: 0) {
            eq('isRead', false)
            eq('user', this)
        }
        List<InboxVO> unReadItemsList = []
        println(unReadItems)
        unReadItems.each{
            unReadItemsList.add(new InboxVO(ownerName: it.resource.user.getName(),
                    ownerUsername: it.resource.user.userName,topicName: it.resource.topic.name,
                    topicId: it.resource.topic.id,resourceDescription: it.resource.description,
                    resourceId: it.resource.id, readingItemId: it.id))
        }
        println(unReadItemsList)
        return unReadItemsList
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
