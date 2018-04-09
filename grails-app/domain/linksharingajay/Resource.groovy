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

    static mapping = {
//        topic fetch: 'join'
        topic lazy: false
        user lazy: false
        readingItems lazy: true
        readingItems cascade: 'delete'
        resourceRating cascade: 'delete'
    }

    static namedQueries = {

        search{ ResourceSearchCO co ->
            'topic'{
                eq('visibility',co.visibility)
            }
            eq('topic.id',co.topicId)
        }
    }

    Integer totalVotes(Resource resource) {
        Integer votes = ResourceRating.createCriteria().count() {

            eq("resource", resource)
        }

        return votes
    }

    def avgScore() {
        def average = ResourceRating.createCriteria().get {
            projections {
                avg('score')
            }
            eq("resource", this)
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
//            eq('',Visibility.PUBLIC)
            order("dateCreated", "desc")
            maxResults(2)


        }
        println("about to return")
        println(recentShares)
        return recentShares
    }
    static String findTypeOfResource(Long id){
        Resource resource = Resource.findById(id)
        if(resource.class == LinkResource.class){
            return "LinkResource"
        }
        else if(resource.class == DocumentResource.class){
            return "DocumentResource"
        }
    }

    Boolean canViewBy(User user){
        if (this.topic.canViewedBy(user)){
            return true
        }
        else {
            return false
        }
    }




}