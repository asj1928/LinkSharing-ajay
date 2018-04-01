package linksharingajay

class TopicController {

    def index() {
        render "topic"
    }

    def show(){
        Topic topic=Topic.read()
        render("${topic}")


    }

    def delete(Integer id){
        Topic topic=Topic.load(id)
        render("${topic}")

    }
    def save(Topic topic){
        if(topic.save()){
            render("saved Successfully")
        }
        else{
            render("error")
        }


    }
}
