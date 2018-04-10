package linksharingajay

class SubscriptionController {


    def index() {}

    def save(Integer id) {
        if (session.user) {
            Topic topic = Topic.read(id)
            Subscription subscription = new Subscription(user: session.user, topics: topic)
            if (subscription.save())
                render("success")
            else
                render("error")
        } else {
            flash.message = "not loged in"
            redirect(controller: 'user', view: 'index')
        }

    }


    def delete(Long id) {
        if (session.user) {

            println(id)
            Subscription subscription = Subscription.load(id)
            if (subscription != null) {
                subscription.delete(flush: true)
                render("success")
            } else
                render("not found")

        } else {
            flash.message = "not loged in"
            redirect(controller: 'user', view: 'index')
        }
    }


    def update(Integer id, String serious) {
        if (session.user) {
            Subscription subscription = Subscription.findByIdAndSeriousness(id, Seriousness.valueOf(serious))
            if (subscription != null) {
                if (subscription.save(flush: true))
                    render("success")
                else
                    render("failure")
            } else
                render("not found")
        }else {
            flash.message = "not loged in"
            redirect(controller: 'user', view: 'index')
        }
    }



}
