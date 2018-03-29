package linksharingajay

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
    static hasMany = [topics:Topic, subscriptions:Subscription, readingItems:ReadingItem, resources:Resource]


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
    static mapping = {
        photo(sqlType: "longblob")
    }
}
