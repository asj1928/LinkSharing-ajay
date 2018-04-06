package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {

    def setup() {

    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    void "validate and test linkresource"(){
        setup:
        LinkResource linkResource=new LinkResource()
        linkResource.description="description of link resource"
        linkResource.url="http://learning.tothenew.com/ttn/session/show/?sessionId=707"

        when:
        def result=linkResource.validate()

        then:
        result==true


    }

    def " to string of linkResource"(){
        setup:
        String email = "asjodha22@gamil.com"
        String password = 'harinder'
        User user = new User(email: email,userName:"asj1928",password:password, firstName: "ajay", lastName: "jodha",admin:false,active:true)
        Topic topic = new Topic(name:"topic1    ",visibility: Visibility.PUBLIC,createdBy: user)
        LinkResource linkResource=new LinkResource(url:"http://learning.tothenew.com/ttn/session/show/?sessionId=708", user:user,topic: topic,description: "description for linkresource")

        when:
        linkResource.save()
        then:
        linkResource.toString()==
                "LinkResource{url='${linkResource.url}'}"

    }
    def " valid url"(){
        setup:
        String email = "ajay.singh@tothenew.com"
        String password = '1928'
        User user = new User(email: email,userName:"ajay",password:password, firstName: "ajay", lastName: "jodha",admin:false,active:true)
        Topic topic = new Topic(name:"topic1",visibility: Visibility.PUBLIC,createdBy: user)

        when:
        LinkResource linkResource=new LinkResource(url:"www.google.com", user:user,topic: topic,description: "thi is the url for google ")

        topic.addToResources(linkResource)
        user.addToTopics(topic)
        linkResource.validate()
        user.save()

        then:
        User.count==1

        when:
        LinkResource linkResource1=new LinkResource(url:"www", user:user,topic: topic,description: "invalid url")

        topic.addToResources(linkResource1)
        user.addToTopics(topic)
        user.addToResources(linkResource1)
        linkResource1.validate()
        user.save()

        then:
        linkResource1.errors.getFieldErrorCount('url')==1

    }

}
