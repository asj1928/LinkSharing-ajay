package linksharingajay

import co.linksharingajay.SearchCO

class User {
    String email
    String userName
    transient String name
    String password
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
        subscriptions lazy: false
        photo(sqlType: "longblob")

    }
    static constraints = {
        email(unique: true ,nullable: false,blank: false, email: true)
        password(size: 5..35,nullable: false,blank: false)
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



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
