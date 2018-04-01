package linksharingajay

class TopicController {

    def index() {

        render "topic"
        flash.error = "Error"
    }

    def show() {


        User user = User.read(session.user.id)
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
            render(action: 'index')
        }
    }

    def save(Topic topic) {
        if (topic.save()) {
            render("saved Successfully")
        } else {
            flash.error = "Error"
            render("error")
        }


    }
}
