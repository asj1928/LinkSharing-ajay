package linksharingajay

class LinksharingTagLib {

    static defaultEncodeAs = "raw"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"
    def checkRead = { attrs, body ->
        def value
        Boolean aBoolean = new Boolean(attrs.isRead)
        if (session.user) {
            if (aBoolean) {
                value = "Mark as Read"
            } else {
                value = "Mark as Unread"
            }
        } else {
            value = null
        }

        out << body() << value
    }




    def userImage = { attrs, body ->
        out << "<img src='${createLink(controller: 'user', action: 'fetchUserImage', params: [username: attrs.username])}' " +
                " height='${attrs.height}' width='${attrs.width}'>"
    }
}
