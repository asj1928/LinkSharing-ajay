package linksharingajay

class TopicController {

    def index() {

        render "topic"
        flash.error = "Error"
    }

    def show(ResourceSearchCO resourceSearchCO,Long id){

        User user=User.read(session.user.id)
        //println user.topics
        render(user.topics)
    }


    def delete(Integer id){
        Topic topic=Topic.load(id)
        println(topic)
        if(topic.delete()) {
            flash.message="sucess"
            render(action: 'index')
        }
        else {
            flash.error="error"
        }
    }

    def save(Topic topic) {
        if (topic.save()) {
            render("saved Successfully")
        } else {
            flash.error = "Error"
        }


    }
}
