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
    void "validate and test linkresource"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)

        Resource documentResource =new DocumentResource(description: des,filePath: fl,topic: topic,createdBy: user)


        when:
        def result=documentResource.validate()

        then:
        result==valid

        where:
        des|fl|valid
        "this is dicription of document"|"/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml"|true
        null|"/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml"|false

    }

    void "documentResource validation with null user"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Resource documentResource =new DocumentResource(description: "this is dicription of document",filePath: "/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml",topic: topic,createdBy: null)


        when:
        boolean result=documentResource.validate()

        then:
        result==false





    }
    void "documentResource validation with null topic"(){
        setup:
        User user=new User(email: "askjoa@gmail",userName: "asj123",name:"ajaysingh" ,password:"harinder" ,firstName: "ajay",lastName: "jodha")

        Topic topic=new Topic(name:"topic",visibility: Visibility.PUBLIC, createdBy: user)
        Resource documentResource =new DocumentResource(description: "this is dicription of document",filePath: "/home/ajay/Music/LinkSharing(ajay)/grails-app/conf/application.yml",topic: null,createdBy: user)


        when:
        boolean result=documentResource.validate()

        then:
        result==false





    }

}
