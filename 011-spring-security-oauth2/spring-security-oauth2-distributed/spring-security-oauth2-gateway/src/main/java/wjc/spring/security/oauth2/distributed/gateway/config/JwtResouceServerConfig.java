//package wjc.spring.security.oauth2.distributed.gateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
///**
// * <pre>
// *
// * </pre>
// * Author: 王俊超
// * Date: 2021-08-07 12:05
// * Blog: http://blog.csdn.net/derrantcm
// * Github: https://github.com/wang-jun-chao
// * All Rights Reserved !!!
// */
//@EnableResourceServer
//public class JwtResouceServerConfig extends ResourceServerConfigurerAdapter {
//    public static final String RESOUCE_ID_STRING = "res1"; //资源ID
//
//    @Autowired
//    private JwtTokenStore tokenStore;
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(RESOUCE_ID_STRING) //资源id
//                .tokenStore(tokenStore) //JWT 本地校验 令牌
//                .stateless(true);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/res/**").access("#oauth2.hasScope('RES_API')")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/uaa/**")
//                .permitAll()
//                .and().csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //session 不保留
//    }
//}
