package vo.linksharingajay

class Resource1VO {
    Integer resourceId
    Integer topicId
    String resourceDescription
    String ownerName
    String ownerUsername
    String topicName

    @Override
    public String toString() {
        return "Resource1VO{" +
                "resourceId=" + resourceId +
                ", topicId=" + topicId +
                ", resourceDescription='" + resourceDescription + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", topicName='" + topicName + '\'' +
                '}';
    }
}
