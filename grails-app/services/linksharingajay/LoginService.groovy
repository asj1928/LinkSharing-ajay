package linksharingajay

import grails.gorm.transactions.Transactional

@Transactional
class LoginService {

    def serviceMethod() {

    }
    User registerUser(Map userData) {
        User user = new User(firstName: userData.fname, lastName: userData.lname,
                email: userData.email, userName: userData.uname, password: userData.password,
                confirmpassword: userData.confirmPassword, active: true, photo: userData.photo.bytes)
        if (user.save(flush: true)) {
            log.info("User created : $user")
            return user
        } else {
            log.error("Unable To Register User : $user")
            user.errors.allErrors.each { println(it) }
            return null
        }
    }
}
