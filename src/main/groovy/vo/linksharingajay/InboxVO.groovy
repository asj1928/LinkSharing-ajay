package vo.linksharingajay

class InboxVO {
    String ownerName
    String ownerUsername
    String topicName
    Integer topicId
    String resourceDescription
    Integer readingItemId
    Integer resourceId

    @Override
    public String toString() {
        return "InboxVO{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", topicName='" + topicName + '\'' +
                ", topicId=" + topicId +
                ", resourceDescription='" + resourceDescription + '\'' +
                ", readingItemId=" + readingItemId +
                ", resourceId=" + resourceId +
                '}';
    }
}
