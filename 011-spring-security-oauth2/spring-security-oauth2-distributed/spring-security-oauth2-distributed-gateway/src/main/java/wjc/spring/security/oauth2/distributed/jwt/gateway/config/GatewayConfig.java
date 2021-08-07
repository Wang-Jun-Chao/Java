package wjc.spring.security.oauth2.distributed.jwt.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wjc.spring.security.oauth2.distributed.jwt.gateway.filter.AuthGlobalFilter;

/**
 * @author Administrator
 * @version 1.0
 **/
@Slf4j
@Configuration
public class GatewayConfig {

    @Bean
    public AuthGlobalFilter preFileter() {
        return new AuthGlobalFilter();
    }
}
