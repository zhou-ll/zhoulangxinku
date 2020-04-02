package com.jh.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 *
 * @author jh
 * @date 2020/3/10
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置shiro内置过滤器
        /**
         * shiro过滤器，可以实现权限相关的拦截
         *      常用的过滤器
         *          anon：无需认证（登录）可以访问
         *          authc：必须认证才可以访问
         *          user：如果使用remeberMe功能才可以直接访问
         *          perms：该资源必须得到资源权限才可以访问
         *          role：该资源必须得到角色权限才可以访问
         *
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        //拦截add路径，切记加“/”，斜杠、斜杠、斜杠，重要的事情说三遍
        filterMap.put("/add", "perms[user:add]");
        /**
         * 授权过滤器
         * 注意，当前授权拦截后，shiro会跳转到未授权的页面
         */
        filterMap.put("/update", "perms[user:update]");

        //放行某个路径
        filterMap.put("/toLogin", "anon");

        //拦截所有
        //filterMap.put("/*","authc");
        filterMap.put("/login", "anon");

        //修改登录页面
        shiroFilterFactoryBean.setLoginUrl("toLogin");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("unAuthorization");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
