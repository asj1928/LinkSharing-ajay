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
}
