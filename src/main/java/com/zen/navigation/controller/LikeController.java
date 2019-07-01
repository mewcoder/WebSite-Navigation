package com.zen.navigation.controller;

import com.alibaba.fastjson.JSONObject;
import com.zen.navigation.service.LikeService;
import com.zen.navigation.service.SiteService;
import com.zen.navigation.utils.IDUtil;
import com.zen.navigation.utils.MD5Util;
import com.zen.navigation.utils.Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zen.navigation.utils.Util.getJSONString;

/**
 * Created by nowcoder on 2016/7/13.
 */
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    SiteService siteService;

    @RequestMapping("/like")
    @ResponseBody
    public String like(int wid, HttpServletRequest request) throws Exception {

        String id= IDUtil.getId(request);

        long likeCount = likeService.like(id, wid);


        // 更新喜欢数
        siteService.siteUpdateLiked(wid, (int) likeCount);
        //



        return getJSONString(0, String.valueOf(likeCount));
    }

    @RequestMapping("/dislike")
    @ResponseBody
    public String dislike( int wid, HttpServletRequest request) throws Exception {

        String id= IDUtil.getId(request);

        long likeCount = likeService.disLike(id, wid);



        // 更新喜欢数
        siteService.siteUpdateLiked(wid, (int) likeCount);

        return getJSONString(0, String.valueOf(likeCount));
    }
}
