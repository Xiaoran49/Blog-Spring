package com.graduation.synu.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

//为了配置pagehelper分页插件 自定义的配置类
//声明一个类为配置类，用于取代 bean.xml配置文件注册bean对象
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();

        p.setProperty("dialect","Mysql");//设置分页插件的方言，对哪个数据库进行操作

        //offsetAsPageNum，当该参数设置为true时，可以用页面和页面大小两个参数进行分页
        p.setProperty("offsetAsPageNum","true");

        //rowBoundsWithCount,默认为false，当该参数设置为true时，会进行count查询
        p.setProperty("rowBoundsWithCount","true");

        //reasonable，分页合理化开启，
        //启用分页合理化时，如果pageNum <=0 时，会自动查询第一页
        //pageNum > pages(超出总数) 时，会自动查询最后一页
        //禁用分页合理化时，会返回空数据
        p.setProperty("reasonable","true");

        pageHelper.setProperties(p);
        return pageHelper;
    }
}
