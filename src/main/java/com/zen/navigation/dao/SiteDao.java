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


    @Delete("delete from websites where wid=#{wid}")
    public void siteDel(int wid) throws Exception;


    @Results({
            @Result(property = "name", column = "wname"),
    })
    @Select("Select * from websites where wid=#{wid}")
    public Site findByid(int wid) throws Exception;


    @Update("update websites SET wname=#{name},url=#{url},description=#{description}," +
            "category=#{category},state=#{state},liked=#{liked} " +
            "where wid=#{wid}")
    public void siteUpdate(Site site) throws Exception;



    @Update("update websites SET liked=#{count} where wid=#{wid}")
    public void siteUpdateLiked(int wid, int count) throws Exception;


}
