package linksharingajay

import org.hibernate.ObjectNotFoundException

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

}
