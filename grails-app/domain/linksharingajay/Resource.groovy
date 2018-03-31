package linksharingajay

abstract class Resource {
    String description
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user:User,topic:Topic]
    static hasMany = [resourceRating:ResourceRating,readingItems:ReadingItem]
    static constraints ={
        description(type:'text')
    }
}