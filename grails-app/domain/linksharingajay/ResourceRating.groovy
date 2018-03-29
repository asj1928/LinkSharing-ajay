package linksharingajay

class ResourceRating {
//    Resource resource
//    User user
    Integer score

    Date dateCreated
    Date lastUpdated

    static belongsTo = [resource:Resource, user:User]



    static constraints = {
        user(nullable: false ,unique: true)
        score(inList:[1,2,3,4,5],nullable: false)
        resource(nullable: false)
    }
}
