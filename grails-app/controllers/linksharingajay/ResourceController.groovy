package linksharingajay

import co.linksharingajay.ResourceSearchCO
import co.linksharingajay.SearchCO
import org.hibernate.ObjectNotFoundException
import vo.linksharingajay.RatingInfoVO

class ResourceController {
    ResourceService resourceService
//    def id=2

    def index(Long id) {
        println(id)
        Resource resource = Resource.findById(id)
        println(resource)
        println(session.user)
        if(session.user && resource.canViewBy(session.user)){
            String resourceType = Resource.findTypeOfResource(id)
            render(view: 'showResources',model: [resource:resource,resourceType : resourceType])
        }
        else if(resource.topic.isPublic()){
            println(resource)
            String resourceType = Resource.findTypeOfResource(id)
            render(view: 'showResources',model: [resource:resource,resourceType : resourceType])
        }
        else {
            flash.error = "User cannot view this resource"
            redirect(controller: 'login',view: 'index')
        }
    }

    def handleObjectNotFoundException(ObjectNotFoundException e) {

        render ("no object found")
    }
    def search(){
        ResourceSearchCO resourceSearchCO=new ResourceSearchCO()
        if(resourceSearchCO.q)
            resourceSearchCO.visibility=Visibility.PUBLIC
    }
    def show(Integer id){
        Resource resource=Resource.get(id)
        SearchCO searchCO=new SearchCO(q:"dcdcsd")
        RatingInfoVO ratingInfoVO= resource.getRatingInfoVo(resource)
        println ("------------------------- ${resource.topPost()}")
        println ("=x=x=x=x=x=x=x=x=x=x=x=x= ${session.user.getUnreadResource(searchCO)}")
        render(ratingInfoVO.averagescore)
    }
    def searchResource(){
        println(params.searchKey)

            Topic topic=Topic.findByName(params.searchKey)
        println(topic.toString())
        if (!topic){
            flash.error = "Search not found"
            redirect(controller : 'login' , action : 'index')
        }else {
            SearchCO co = new ResourceSearchCO()
            co.topicId=topic.id
            co.q = topic.visibility
            if(co.q){
                co.visibility=topic.visibility
            }
            println(co.topicId)
            List<Resource> resources = Resource.search(co).list()
            render(view: 'searchResource',model: [resourceList:resources])
        }


    }
    def findTypeOfResource(){
                Resource.findTypeOfResource(2)
                render("sucess")
            }
    def delete(){
        Long id = new Long(params.id)
        println(id)
        Resource resource = Resource.load(id)
        def listOfReadingItems = ReadingItem.findAllByResource(resource)
        def listOfResourceRating = ResourceRating.findAllByResource(resource)
        println(resource)
        if (session.user && (session.user.admin || session.user == resource.user)){

            println(resource.delete(flush:true))//returns null


            flash.message = "Resource deleted successfully"
            redirect(controller: 'user',view: 'index')





        }else{
            flash.error = "Deletion of the Resource : ${resource} is not allowed"
            redirect(controller: 'user',action: 'index')
        }
    }
    def showResources(Long id){

    }

    def storeRating() {
        Map map = [score: params.star,ratedBy: session.user, resourceId: params.id]
        println(map)
        if (resourceService.saveRating(map)) {
            flash.message = "Saved Succesfully"
        } else {
            flash.eror = "Rating Not Saved"
        }
        redirect(controller: 'user', view: 'index')
    }


}
