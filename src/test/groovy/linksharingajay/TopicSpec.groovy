package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TopicSpec extends Specification implements DomainUnitTest<Topic> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    void "validate topic"(){
        setup:
        User user1=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")
        Topic topic=new Topic(name: nam,createdBy: user1,visibility : Visi)

        when:
        boolean result=topic.validate()

        then:

        result==valid//Visibility.PRIVATE

        where:
        nam|Visi|valid
        "topic1"|Visibility.PRIVATE|true
        "topic1"|null|false
        null|Visibility.PRIVATE|false



    }
    void "validate topic with null user"() {
        setup:
        Topic topic = new Topic(name: "topic", createdBy: null, visibility: Visibility.PRIVATE)

        when:
        boolean result = topic.validate()

        then:

        result ==false//Visibility.PRIVATE
    }
}
