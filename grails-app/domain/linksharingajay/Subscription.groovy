package linksharingajay

class Subscription {
//    Topic topic
//    User user

    Seriousness seriousness
    Date dateCreated
    Date lastUpdated



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
}
