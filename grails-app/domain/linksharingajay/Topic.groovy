package linksharingajay


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
            subscription.save()

        }


    }

}

