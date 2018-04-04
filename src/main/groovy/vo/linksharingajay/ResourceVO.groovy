package vo.linksharingajay

import linksharingajay.Resource
import linksharingajay.Topic
import linksharingajay.User

class ResourceVO {
    Integer id
    Integer count
    User createdBy
    Topic topic


    @Override
    public String toString() {
        return "ResourceVO{" +
                "id=" + id +
                ", count=" + count +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                '}';
    }
}
