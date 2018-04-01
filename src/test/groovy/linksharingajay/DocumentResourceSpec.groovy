package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DocumentResourceSpec extends Specification implements DomainUnitTest<DocumentResource> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    void "validate and test documentresource"(){

        setup:

        DocumentResource resource=new DocumentResource()
        resource.filePath="/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml"
        resource.description="this is dicription of document"

        when:
        def res=resource.validate()

        then:
        res==true

    }
    def "check to string of documentResource"(){
        setup:
        String email = "asjodha222gmail.com"
        String password = 'harinder'
        User user = new User(email: email,userName:"asj1928",password:password, firstName: "ajay", lastName: "jodha",admin:false,active:true)
        Topic topic = new Topic(name:"topic",visibility: Visibility.PUBLIC,createdBy: user)
        DocumentResource documentResource2=new DocumentResource(filePath: "/home/ajay/Music/LinkSharing(ajay)/src/test/groovy/linksharingajay/LoginCheckInterceptorSpec.groovy", user:user,topic: topic,description: "description of document resource")

        when:
        documentResource2.save()
        then:
        documentResource2.toString()==
                "DocumentResource{filePath='${documentResource2.filePath}'}"

    }
}
