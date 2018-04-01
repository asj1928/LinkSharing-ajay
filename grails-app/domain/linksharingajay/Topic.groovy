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

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}

