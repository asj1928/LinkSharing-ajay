package linksharingajay

import grails.gorm.transactions.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    def saveRating(Map resourceData) {
        println("===========")
        Resource resource = Resource.findById(resourceData.resourceId)

        User user=User.findById(resourceData.ratedBy)
        println(resource)
        println(user)
        println("===========1")
        println(resourceData)

        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource)
        println(resourceRating)
//            println(resourceRating.getScore())
        println("===========2")
        if (resourceRating) {
            println("===========3")
            println(resourceData.score)
            println(resourceRating.score)
            resourceRating.score=0
            println(resourceRating.score)
            resourceRating.score = new Integer(resourceData.score)
            println(resourceRating.score)
            println("===========4")
            if (resourceRating.save(flush: true)) {
                println("===========5")
                log.info("Score Updated Successfully : $resourceRating")
                return resourceRating
            } else {
                println("===========6")
                log.error("Score Updation Failed : $resourceRating")
                resourceRating.errors.allErrors.each { println it }
                return null
            }
        } else {
            println("===========7")
            println(resourceData)

            ResourceRating resourceRating1 = new ResourceRating(user: user , resource: resource, score: new Integer(resourceData.score))
            println(resourceRating1)
            if (resourceRating1.save(flush: true)) {
                log.info("Score Saved Successfully : $resourceRating1")
                return resourceRating1
            } else {
                log.error("Error while saving : $resourceRating1")
                resourceRating1.errors.allErrors.each { println(it) }
                return null
            }
        }
    }
}
