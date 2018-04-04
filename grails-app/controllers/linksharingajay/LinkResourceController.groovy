package linksharingajay

class LinkResourceController {


    def index() { }

    def save(){
        Resource resource=new LinkResource()
        resource.description=params.des
        resource.url=params.link

        resource.topic=Topic.findByName(params.topic)
        resource.user=session.user
        if (resource.save()){
            println(resource.errors.allErrors)
            flash.message="SAVED"}

        else
            flash.message="ERROR"

        forward(controller:'user', action: 'index')
    }
}
