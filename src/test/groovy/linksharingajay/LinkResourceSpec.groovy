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
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)

        Resource linkResource=new LinkResource(description: des,url: url,topic: topic,createdBy: user)


        when:
        def result=linkResource.validate()

        then:
        result==valid

        where:
        des|url|valid
        "description of link resource"|"http://learning.tothenew.com/ttn/session/show/?sessionId=707"|true
        null|"http://learning.tothenew.com/ttn/session/show/?sessionId=707"|false
        "description of link resource"|"kjdckasckjscjkajnc"|false

    }

    void "linkresource validation with null user"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Resource linkResource=new LinkResource(description: "description of link resource",url: "http://learning.tothenew.com/ttn/session/show/?sessionId=707",topic: null,createdBy: user)
        when:
        boolean result=linkResource.validate()

        then:
        result==false





    }

    void "linkresource validation with null topic"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Resource linkResource=new LinkResource(description: "description of link resource",url: "http://learning.tothenew.com/ttn/session/show/?sessionId=707",topic: topic,createdBy: null)
        when:
        boolean result=linkResource.validate()

        then:
        result==false





    }



}
