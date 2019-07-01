package com.zen.navigation.service;

import com.zen.navigation.utils.JedisAdapter;
import com.zen.navigation.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 如果喜欢返回1  否则返回0
 *
 */
@Service
public class LikeService {

    @Autowired
    JedisAdapter jedisAdapter;

    public int getLikeStatus(String id, int entityId) {
        String likeKey = RedisKeyUtil.getLikeKey(entityId);

        return jedisAdapter.sismember(likeKey, String.valueOf(id)) ? 1 : 0;
    }



    public long like(String id, int entityId) {
        // 在喜欢集合里增加
        String likeKey = RedisKeyUtil.getLikeKey(entityId);
        jedisAdapter.sadd(likeKey, String.valueOf(id));

        return jedisAdapter.scard(likeKey);
    }

    public long disLike(String id, int entityId) {

        // 从喜欢里删除
        String likeKey = RedisKeyUtil.getLikeKey(entityId);
        jedisAdapter.srem(likeKey, String.valueOf(id));
        return jedisAdapter.scard(likeKey);
    }

}
