package com.zen.navigation.controller;


import com.zen.navigation.domain.Site;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AdminController {


    @RequestMapping("/main")
    public String findAll(Model model) throws Exception  {


        return "main";
    }




}
