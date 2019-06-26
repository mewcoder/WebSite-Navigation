package com.zen.navigation.controller;


import com.zen.navigation.domain.Site;
import com.zen.navigation.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @RequestMapping("/siteadd")
    public String siteAdd() throws Exception  {

        return "siteadd";
    }


    @RequestMapping("/sitesave")
    public String siteSave(Site site) throws Exception  {

        siteService.siteSave(site);

        return "redirect:/sitelist";
    }

    @RequestMapping("/sitedel")
    public String siteDel(int id) throws Exception  {

        siteService.siteDel(id);

        return "redirect:/sitelist";
    }
}
