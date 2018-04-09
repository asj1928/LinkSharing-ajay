package linksharingajay

import grails.gorm.transactions.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    def saveRating(Map resourceData) {
        println("===========")
        Resource resource = Resource.findById(resourceData.resourceId)
        println(resource)
        println("===========1")

        ResourceRating resourceRating = ResourceRating.findByUserAndResource(resourceData.ratedBy, resource)
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
            resourceRating = new ResourceRating(user: resourceData.ratedBy, resource: resource, score: resourceData.score)
            if (resourceRating.save(flush: true)) {
                log.info("Score Saved Successfully : $resourceRating")
                return resourceRating
            } else {
                log.error("Error while saving : $resourceRating")
                resourceRating.errors.allErrors.each { println(it) }
                return null
            }
        }
    }
}
