package linksharingajay

class SubscriptionController {


    def index() {}

    def save(Integer id){
        Topic topic=Topic.read(id)
        Subscription subscription=new Subscription(user: session.user,topics:topic)
        if(subscription.save())
            render("success")
        else
            render("error")

    }


    def delete(Integer id) {
        println(id)
        Subscription subscription = Subscription.load(id)
        if (subscription != null) {
            subscription.delete(flush: true)
            render("success")
        } else
            render("not found")


    }


    def update() {

    }

}
