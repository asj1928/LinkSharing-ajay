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
        User user=new User(email: "asjodha@gmail.com",userName: "asj1928" ,password:"harry1928" ,firstName: "ajay",lastName: "jodha")
        Topic topic=new Topic(name: "topic1",createdBy: user,visibility:Visibility.PRIVATE)

        when:
            boolean result=topic.validate()
        then:
        result==true
    }
}
