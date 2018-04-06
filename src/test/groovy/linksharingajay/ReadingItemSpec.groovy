package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReadingItemSpec extends Specification implements DomainUnitTest<ReadingItem> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    def "isRead shouldnt be null"(){
        setup:
        String email = "ajay.singh@tothenew.com"
        String password = '1928'
        User user = new User(email: email,userName:"ajay",password:password, firstName: "ajay", lastName: "singh",admin:false,active:true)
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        Resource resource=new LinkResource(url: "www.google.com",description: "adncoascpq qs sans sdosd  lsdala",user: user,topic: topic)


        when:
        ReadingItem readingItem=new ReadingItem(isRead: null,user:user,resource:resource)

        readingItem.validate()
        readingItem.save()
        then:
        readingItem.errors.getFieldErrorCount('isRead')==1



    }
    
}
