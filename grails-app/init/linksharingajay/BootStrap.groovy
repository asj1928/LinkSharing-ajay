package linksharingajay

class BootStrap {

    def init = { servletContext ->
        createUsers()
        creatTopic()
        createResources()
        subscribeTopicsNotCreatedByUser()

    }


    void createUsers() {
        if (User.count() == 0) {
            User user = new User()
            user.email = "asjodha@gamil.com"
            user.userName = "asj"
            user.password = "harry192"
            user.firstName = "ajay"
            user.lastName = "jodha"
            user.admin = true
//        user.save(flush:true,failOnError:true)

            User user2 = new User()
            user2.email = "asjodha22@gamil.com"
            user2.userName = "asj1928"
            user2.password = "harry1928"
            user2.firstName = "ajaySingh"
            user2.lastName = "jodha"
            user2.admin = false
//        user2.save(flush:true,failOnError:true)

            if (user.save()) {

                log.info "User ${user} saved successfully"
            } else {
                log.error "Error saving user : ${user.errors.allErrors}"
            }
            if (user2.save()) {

                log.info "User ${user2} saved successfully"
            } else {
                log.error "Error saving user : ${user.errors.allErrors}"
            }
        } else {
            println("there is data in the table")
        }
    }

    void creatTopic() {
        List<User> noOfUser = User.getAll()
        noOfUser.each {
            if (Topic?.countByCreatedBy(it) == 0) {
                def a = it
                5.times {
                    Topic topic = new Topic(name: "topic${Math.random()}", visibility: Visibility.PUBLIC, createdBy: a)

                    a.addToTopics(topic)
                    topic.save()

                }
                a.save()
            }
        }

    }

    void createResources() {
        List<Topic> list = Topic.getAll()
        if (Resource?.count() == 0) {
            list.each {
                Resource resource1 = new DocumentResource(filePath: "/home/ajay/Music/LinkSharing(ajay)/grails-app/controllers/linksharingajay/UrlMappings.groovy${Math.random()}", description: "slfvwlfkvm${Math.random()}")
                Resource resource2 = new DocumentResource(filePath: "/home/ajay/Music/LinkSharing(ajay)/grails-app/controllers/linksharingajay/UrlMappings.groovy${Math.random()}", description: "slfvwlfkvm${Math.random()}")
                Resource resource3 = new LinkResource(url: "https://docs.google.com/presentation/d/1tDcEsXzqqtnvJwtRumul5gVIpGE1qOSBJe1iSIX2JSY/edit#slide=id.g10957a6d98_0_961${Math.random()}", description: "${Math.random()} giberish")
                Resource resource4 = new LinkResource(url: "https://docs.google.com/presentation/d/1tDcEsXzqqtnvJwtRumul5gVIpGE1qOSBJe1iSIX2JSY/edit#slide=id.g10957a6d98_0_961${Math.random()}", description: "${Math.random()} giberish")

                it.addToResources(resource1)
                it.createdBy.addToResources(resource1)
                it.addToResources(resource2)
                it.createdBy.addToResources(resource2)
                it.addToResources(resource3)
                it.createdBy.addToResources(resource3)
                it.addToResources(resource4)
                it.createdBy.addToResources(resource4)
                it.save()
                it.createdBy.save()

            }

        } else {
            log.error("Resource Error: ${resource3.errors.allErrors}")
        }

    }

    void subscribeTopicsNotCreatedByUser() {

        List<User> noOfUser = User.getAll()

        noOfUser.each {
            User user ->
                List<Topic> topics = Topic.findAllByCreatedByNotEqual(user)

                topics.each {
                    Subscription subscription = new Subscription(seriousness: Seriousness.CASUAL, user: user, topic: it)
                    if (subscription.save()) {
                       log.info "------------------subscription saved--------"
                    }
                    else {
                        log.error("Error:${subscription.errors.getAllErrors()}")
                    }
                }


        }

    }


    def destroy = {
    }
}
