package com.epi.exam.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author YANGCHAO
 * @create 2019-12-05 15:28
 */

@Configuration
public class ShiroConfig {
	@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager( securityManager );
		//拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put( "/doLogin", "anon" );
		filterChainDefinitionMap.put( "/regist/**", "anon" );
		filterChainDefinitionMap.put( "/changePassword/**", "anon" );
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put( "/logout", "logout" );
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put( "/**", "authc" );
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl( "/login" );
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl( "/index" );
		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl( "/403" );
		shiroFilterFactoryBean.setFilterChainDefinitionMap( filterChainDefinitionMap );
		return shiroFilterFactoryBean;
	}

	/**
	 * 配置securityManager 安全管理器，shiro的核心
	 *
	 * @return
	 */
	@Bean(name = "securityManager")
	public DefaultSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm( myShiroRealm() );
		return securityManager;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * ）
	 *
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashAlgorithmName( "md5" );
		//散列的次数
		hashedCredentialsMatcher.setHashIterations( 1 );
		return hashedCredentialsMatcher;
	}

	/**
	 * 配置shiro的生命周期
	 *
	 * @return
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}


	/**
	 * 配置自定义的realm
	 *
	 * @return
	 */

	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher( hashedCredentialsMatcher() );
		return myShiroRealm;
	}


	/**
	 * 开启shiro aop注解支持.
	 * 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager( securityManager );
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 自动创建代理类，若不添加，shiro可能不生效
	 *
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass( true );
		return advisorAutoProxyCreator;

	}

	/**
	 * Session Manager：会话管理
	 * 即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；
	 * 会话可以是普通JavaSE环境的，也可以是如Web环境的；
	 */
	@Bean("sessionManager")
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//设置session过期时间
		sessionManager.setGlobalSessionTimeout( 60 * 60 * 1000 );
		sessionManager.setSessionValidationSchedulerEnabled( true );
		// 去掉shiro登录时url里的JSESSIONID
		sessionManager.setSessionIdUrlRewritingEnabled( false );
		return sessionManager;
	}


}




