package linksharingajay

class DocumentResource extends Resource{
    String filePath
    Date dateCreated
    Date lastUpdated


    static constraints = {
        filePath nullable: false
    }
    @Override
     String toString() {
        return "DocumentResource{" +
                "filePath='" + filePath + '\'' +
                '}'
    }
}
