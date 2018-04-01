package linksharingajay

enum Seriousness {
    SERIOUS, CASUAL, VERY_SERIOUS

    static Seriousness stringToEnum(String seriousness) {
        if (seriousness == seriousness.toLowerCase())
            return Seriousness.valueOf(seriousness.toUpperCase())
        else
            return Seriousness.valueOf(seriousness)

    }
}