package linksharingajay

import co.linksharingajay.ResourceSearchCO
import vo.linksharingajay.RatingInfoVO

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
                if(resourceSearchCO.topicId)
                    eq('topic.id', resourceSearchCO.topicId)
                if(resourceSearchCO.visibility)
                    eq('topic.visibility',resourceSearchCO.visibility)

        }
    }
    Integer totalVotes(Resource resource) {
        Integer votes = ResourceRating.createCriteria().count() {

            eq("resource", resource)
        }

        return votes
    }
    def avgScore(Resource resource){
        def average= ResourceRating.createCriteria().get {
            projections{
                avg('score')
            }
            eq("resource",resource)
        }

        return average

    }
    def totalScore(Resource resource){
        def sum1 = ResourceRating.createCriteria().get(){

            projections {
                sum('score')
            }
            eq("resource",resource)
        }

        return sum1
    }
    RatingInfoVO setRatingInfo(Resource resource){
        RatingInfoVO ratingInfoVO1=new RatingInfoVO()
        ratingInfoVO1.averagescore=avgScore(resource)
        ratingInfoVO1.totalScore=totalScore(resource)
        ratingInfoVO1.totalVotes=totalVotes(resource)
        return ratingInfoVO1
    }
}