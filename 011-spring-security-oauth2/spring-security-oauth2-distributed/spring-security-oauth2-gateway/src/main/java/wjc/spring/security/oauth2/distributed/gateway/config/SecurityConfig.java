package wjc.spring.security.oauth2.distributed.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/**")
                .permitAll()
                .and().csrf().disable().build();
    }
}
