package linksharingajay

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
    void "validating user"(){
        setup:
        User user=new User(email: email,userName: uname,name:name ,password:pswd ,firstName: fname,lastName: lname)

        when:
        boolean result=user.validate()






        then:
        result==valid

        where:
        email|uname|name|pswd|fname|lname|valid

        "asjodha22@gmail.com"| "asj1928"|"ajay"|"Harinderdemigod"|"ajay"|"jodha"|true
        null|"asj1928"|"ajay"|"Harinderdemigod"|"ajay"|"jodha"|false
        "asjodha22@gmail.com"|null|"ajay"|"Harinderdemigod"|"ajay"|"jodha"|false
        "asjodha22@gmail.com"|"asj1928"|null|"Harinderdemigod"|"ajay"|"jodha"|true
        "asjodha22@gmail.com"|"asj1928"|"ajay"|"mol"|"ajay"|"jodha"|false
        "asjodha22@gmail.com"|"asj1928"|"ajay"|"mol1235"|null|"jodha"|false
        "asjodha22@gmail.com"|"asj1928"|"ajay"|"mol"|"ajay"|null|false

    }


}

