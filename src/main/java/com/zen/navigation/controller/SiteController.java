package com.zen.navigation.controller;


import com.zen.navigation.domain.Site;
import com.zen.navigation.service.SiteService;
import com.zen.navigation.utils.IDUtil;
import com.zen.navigation.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SiteController {

    @Autowired
    private SiteService siteService;


    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) throws Exception  {

        List<Site> siteList = siteService.findAll();
        System.out.println(IDUtil.getId(request));
        model.addAttribute("sites", siteList);
 /*
        if (localUserId != 0) {
            model.addAttribute("like", likeService.getLikeStatus(localUserId, EntityType.ENTITY_NEWS, news.getId()));
        } else {
            model.addAttribute("like", 0);
        }
*/
        return "index";
    }

    @RequestMapping("/sitelist")
    public String siteList(Model model) throws Exception  {

        List<Site> siteList = siteService.findAll();


        model.addAttribute("sites", siteList);

        return "sitelist";
    }


    //打开添加页面
    @RequestMapping("/siteadd")
    public String siteAdd(@ModelAttribute Site site) throws Exception  {

        return "siteadd";
    }

    //保存表单数据
    @RequestMapping("/sitesave")
    public String siteSave(Site site ) throws Exception  {

        siteService.siteSave(site);

        return "redirect:/sitelist";
    }

    @RequestMapping("/sitetemp")
    @ResponseBody
    public String sitetemp(Site site ) throws Exception  {

        //siteService.siteSave(site);
        try {

            System.out.println("保存");
            return Util.getJSONString(0, "保存成功");


        } catch (Exception e) {

            return Util.getJSONString(1, "保存异常");
        }
    }

    @RequestMapping("/sitedel")
    public String siteDel(int wid) throws Exception  {

        siteService.siteDel(wid);

        return "redirect:/sitelist";
    }

    //打开编辑页面
    @RequestMapping("/siteedit")
    public String siteShow(int wid,Model model) throws Exception  {

         Site site = siteService.siteShow(wid);
         model.addAttribute(site);
         return "/siteedit";
    }

    //更新网站信息
    @RequestMapping( "/siteupdate" )
    public String siteUpdate(Site site) throws Exception  {


        siteService.siteUpdate(site);
        return "redirect:/sitelist";
    }



    //打开添加
    @RequestMapping("/demo")
    public String demo() throws Exception  {

        return "demo";
    }

}
/*  @RequestParam(value = "liked") int liked,
            @RequestParam(value = "category ") int category,

                    site.setCategory(category);
        site.setLiked(liked);
*/