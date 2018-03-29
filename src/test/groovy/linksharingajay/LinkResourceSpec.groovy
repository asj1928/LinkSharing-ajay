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
}
