package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ResourceRatingSpec extends Specification implements DomainUnitTest<ResourceRating> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

    void "resource rating validation"(){
       setup:
       User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

       Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
       Resource documentResource =new DocumentResource(description: "this is dicription of document",filePath: "/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml",topic: topic,createdBy: user)
       ResourceRating rating=new ResourceRating(score: score,user: user,resource: documentResource)

        when:
        boolean result=rating.validate()

        then:
        result==valid

        where:
        score|valid
        0|false
        1|true
        2|true
        3|true
        4|true
        5|true
        6|false
        7|false




    }
}
