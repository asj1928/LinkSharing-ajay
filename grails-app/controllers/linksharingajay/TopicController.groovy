package linksharingajay

import co.linksharingajay.ResourceSearchCO
import org.hibernate.ObjectNotFoundException

class TopicController {

    def index() { }

    def show(){
        render "${}"
    }

    def delete(Long id){
        Topic topic=Topic.load(id)
        topic.delete(flush:true)
        render("sucess")


    }

    def save(){
        Topic topic=new Topic()
        topic.name=params.name1
        if(params.visibility=="public"){
            topic.visibility=Visibility.PUBLIC
        }
        else {
            topic.visibility=Visibility.PRIVATE

        }
        topic.createdBy=session.user
        if(topic.save()){
            flash.message="Saved"

        }
        else{
            flash.error="Error"

        }
        forward(controller:'user', action: 'index')

    }
    def handleObjectNotFoundException(ObjectNotFoundException e) {

        render ("no object found")
    }
}
