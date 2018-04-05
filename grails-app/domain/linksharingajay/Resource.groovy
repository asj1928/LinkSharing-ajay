package linksharingajay

import co.linksharingajay.ResourceSearchCO
import vo.linksharingajay.RatingInfoVO
import vo.linksharingajay.ResourceVO

abstract class Resource {
    String description
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user: User, topic: Topic]
    static hasMany = [resourceRating: ResourceRating, readingItems: ReadingItem]

    RatingInfoVO ratingInfoVO
    static transients = ['ratingInfoVO']

    static constraints = {
        description(type: 'text')
    }
    static namedQueries = {
        search {
            ResourceSearchCO resourceSearchCO ->
                if (resourceSearchCO.topicId)
                    eq('topic.id', resourceSearchCO.topicId)
                if (resourceSearchCO.visibility)
                    eq('topic.visibility', resourceSearchCO.visibility)

        }
    }

    Integer totalVotes(Resource resource) {
        Integer votes = ResourceRating.createCriteria().count() {

            eq("resource", resource)
        }

        return votes
    }

    def avgScore(Resource resource) {
        def average = ResourceRating.createCriteria().get {
            projections {
                avg('score')
            }
            eq("resource", resource)
        }

        return average

    }

    def totalScore(Resource resource) {
        def sum1 = ResourceRating.createCriteria().get() {

            projections {
                sum('score')
            }
            eq("resource", resource)
        }

        return sum1
    }

    RatingInfoVO setRatingInfo(Resource resource) {
        RatingInfoVO ratingInfoVO1 = new RatingInfoVO()
        ratingInfoVO1.averagescore = avgScore(resource)
        ratingInfoVO1.totalScore = totalScore(resource)
        ratingInfoVO1.totalVotes = totalVotes(resource)
        return ratingInfoVO1
    }

    static List<ResourceVO> getTopPost(){
        List<ResourceVO> topPosts = ResourceRating.createCriteria().list{
            projections{
                createAlias('resource', 'r')
                groupProperty('r.id')
                property('r.createdBy')
                property('r.topic')
                count('r.id', 'count')
            }
            order('count', 'desc')
            maxResults(5)
        }
        List result = []
        topPosts.each{
            result.add(new ResourceVO(id: it[0],createdBy: it[1],topic: it[2],count: it[3]))
        }
        println("Returning top posts : " + result)
        return result
    }

    static List<Resource> getRecentShares(){

        List<Resource> recentShares = Resource.createCriteria().list {
            order("dateCreated", "desc")
            maxResults(2)

        }
        println("about to return")
        return recentShares
    }

}