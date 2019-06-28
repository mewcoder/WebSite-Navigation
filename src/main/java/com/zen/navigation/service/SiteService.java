package com.zen.navigation.service;


import com.zen.navigation.dao.SiteDao;
import com.zen.navigation.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteDao siteDao;


    public List<Site> findAll( )throws Exception{

        return siteDao.findAll();

    }

    public void siteSave( Site site)throws Exception{

        siteDao.siteSave( site);

    }

    public void siteDel(int wid)throws Exception{

        siteDao.siteDel(wid);

    }

    public Site siteShow(int wid)throws Exception{

        return siteDao.findByid(wid);

    }


    public void siteUpdate(Site site)throws Exception{

        siteDao.siteUpdate(site);

    }
}
