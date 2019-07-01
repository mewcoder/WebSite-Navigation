package com.zen.navigation.utils;


public class RedisKeyUtil {
    private static String SPLIT = ":";
    private static String BIZ_LIKE = "LIKED";
    private static String BIZ_EVENT = "EVENT";

    public static String getEventQueueKey() {
        return BIZ_EVENT;
    }

    public static String getLikeKey(int entityId) {
        return BIZ_LIKE + SPLIT + String.valueOf(entityId);
    }


}
