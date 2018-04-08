package linksharingajay

import co.linksharingajay.ResourceSearchCO
import vo.linksharingajay.RatingInfoVO
import vo.linksharingajay.ResourceVO
import vo.linksharingajay.TopPostVO

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

    static List getTopPost() {

        List query = ResourceRating.executeQuery("select ra.resource from Resource r inner join ResourceRating ra on r.id=ra.resource group by r.id order by sum(ra.score) desc",[offset:0,max:5])

        List results =[]
        query.each {
            results.add(it)
        }
        return results

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