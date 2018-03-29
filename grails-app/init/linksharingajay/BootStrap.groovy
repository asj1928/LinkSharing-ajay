package linksharingajay

class BootStrap {

    def init = { servletContext ->
        createUsers()

    }


    void createUsers(){
      if(User.count()==0){
          User user=new User()
          user.email="asjodha@gamil.com"
          user.userName="asj"
          user.password="harry192"
          user.firstName="ajay"
          user.lastName="jodha"
          user.admin=true
//        user.save(flush:true,failOnError:true)

          User user2=new User()
          user2.email="asjodha22@gamil.com"
          user2.userName="asj1928"
          user2.password="harry1928"
          user2.firstName="ajaySingh"
          user2.lastName=   "jodha"
          user2.admin=false
//        user2.save(flush:true,failOnError:true)

          if (user.save()) {

              log.info "User ${user} saved successfully"
          } else {
              log.error "Error saving user : ${user.errors.allErrors}"
          }
          if (user2.save()) {

              log.info "User ${user2} saved successfully"
          } else {
              log.error "Error saving user : ${user.errors.allErrors}"
          }
      }
      else {
          println("there is data in the table")
      }
    }
    void creatTopic(){

    }
    def destroy = {
    }
}
