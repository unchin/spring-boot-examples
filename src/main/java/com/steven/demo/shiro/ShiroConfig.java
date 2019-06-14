package com.steven.demo.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * 在这里进行 Shiro 的配置主要配置 3 个 Bean ：
     * 1. 需要提供一个 Realm 的实例。
     * 2. 需要配置一个 SecurityManager，在 SecurityManager 中配置 Realm。
     * 3. 配置一个 ShiroFilterFactoryBean ，在 ShiroFilterFactoryBean 中指定路径拦截规则等。
     * 4. 配置登录和测试接口。
     *
     * @author StevenGuo
     * @date 17:12 2019/6/14
     **/

    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }


    /**
     * ShiroFilterFactoryBean 的配置稍微多一些，配置含义如下：
     * setSecurityManager 表示指定 SecurityManager。
     * setLoginUrl 表示指定登录页面。
     * setSuccessUrl 表示指定登录成功页面。
     * 接下来的 Map 中配置了路径拦截规则，注意，要有序。
     *
     * @author StevenGuo
     * @date 17:12 2019/6/14
     **/

    //Java 原生配置
    /*@Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorizedurl");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/doLogin", "anon");
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }*/


    //shiro starter 配置
    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {

        //定义 Shiro 的路径匹配规则
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/doLogin", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }

}
