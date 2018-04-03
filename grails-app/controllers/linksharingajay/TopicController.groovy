package linksharingajay

import co.linksharingajay.ResourceSearchCO
import org.hibernate.ObjectNotFoundException

class TopicController {

    def index() { }

    def show(ResourceSearchCO resourceSearchCO){
        def topic = Resource.search(resourceSearchCO).list()
        render("CreatedBy- $topic.createdby.firstname Topicname- $topic.name")
        User user=User.read(session.user.id)
        //println user.topics
        render(user.topics)
    }

    def delete(Long id){
        Topic topic=Topic.load(id)
        topic.delete(flush:true)
        render("sucess")


    }

    def save(Topic topic,String seriousness){
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
