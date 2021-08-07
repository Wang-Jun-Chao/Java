package wjc.spring.security.oauth2.distributed.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wjc.spring.security.oauth2.distributed.gateway.filter.AuthFilter;

/**
 * @author Administrator
 * @version 1.0
 **/
@Slf4j
@Configuration
public class GatewayConfig {

    @Bean
    public AuthFilter preFileter() {
        return new AuthFilter();
    }


//    @Bean
//    public CorsFilter corsFilter() {
//        log.debug("CORS限制打开");
//        CorsConfiguration config = new CorsConfiguration();
//        // 仅在开发环境设置为*
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setAllowCredentials(true);
//        config.setMaxAge(18000L);
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/**", config);
//        return new CorsFilter(configSource);
//    }
}
