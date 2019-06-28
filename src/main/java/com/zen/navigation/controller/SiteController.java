package com.zen.navigation.controller;


import com.zen.navigation.domain.Site;
import com.zen.navigation.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SiteController {

    @Autowired
    private SiteService siteService;


    @RequestMapping("/")
    public String index(Model model) throws Exception  {

        List<Site> siteList = siteService.findAll();
        model.addAttribute("sites", siteList);

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
    @RequestMapping(value = "/siteupdate" )
    public String siteUpdate(Site site) throws Exception  {


        siteService.siteUpdate(site);
        return "redirect:/sitelist";
    }


}
/*  @RequestParam(value = "liked") int liked,
            @RequestParam(value = "category ") int category,

                    site.setCategory(category);
        site.setLiked(liked);
*/