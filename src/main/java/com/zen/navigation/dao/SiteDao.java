package com.zen.navigation.dao;

import com.zen.navigation.domain.Site;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDao {



    @Results({
            @Result(property = "name", column = "wname"),
    })
    @Select("select * from websites")
    public List<Site> findAll() throws Exception;


    @Insert(
            "insert into websites(wname,url,description,category,state) " +
            "values(#{name},#{url},#{description},#{category},#{state})"
    )
    public void siteSave(Site site) throws Exception;


    @Delete("delete from websites where id='#{wid}'")
    public void siteDel(int wid) throws Exception;
}
