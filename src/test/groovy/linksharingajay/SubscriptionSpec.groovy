package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SubscriptionSpec extends Specification implements DomainUnitTest<Subscription> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    void "subscription validation"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(seriousness:seriousnes,user:user,topic:topic)
        when:
        boolean result=subscription.validate()

        then:
        result==valid

        where:
        seriousnes|valid
        Seriousness.SERIOUS|true
        null|false



    }

    void "subscription validation with null user"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(seriousness:Seriousness.CASUAL,user:null,topic:topic)
        when:
        boolean result=subscription.validate()

        then:
        result==false





    }

    void "subscription validation with null topic"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Subscription subscription = new Subscription(seriousness:Seriousness.CASUAL,user:user,topic:null)
        when:
        boolean result=subscription.validate()

        then:
        result==false





    }



}
