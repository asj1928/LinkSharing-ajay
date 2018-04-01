package linksharingajay

import co.linksharingajay.ResourceSearchCO
import co.linksharingajay.SearchCO
import org.hibernate.ObjectNotFoundException
import vo.linksharingajay.RatingInfoVO

class ResourceController {
//    def id=2

    def index() {
        render "resource"
    }

    def delete(Integer id){
        Resource resource=Resource.load(id)
        render("${resource}")
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

}
