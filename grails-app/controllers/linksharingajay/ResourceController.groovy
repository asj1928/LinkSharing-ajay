package linksharingajay

import co.linksharingajay.ResourceSearchCO
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
        RatingInfoVO ratingInfoVO= resource.setRatingInfo(resource)
        render(ratingInfoVO)
    }

}
