package linksharingajay

class BootStrap {

    def init = { servletContext ->

    }


    void createUsers(){
        User user=new User()
        user.email="asjodha@gamil.com"
        user.userName="asj"
        user.password="harry192"
        user.firstName="ajay"
        user.admin=true
        user.save flush:true,failOnError:true
        User user2=new User()
        user2.email="asjodha22@gamil.com"
        user2.userName="asj1928"
        user2.password="harry1928"
        user2.firstName="ajaySingh"
        user2.admin=false
        user2.save(flush:true,failOnError:true)
    }
    def destroy = {
    }
}
