package wjc.spring.security.oauth2.distributed.jwt.rsa.order.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.IOException;

/**
 * @author Administrator
 * @version 1.0
 **/
@Slf4j
@Configuration
public class TokenConfig {
    private final static String PUBLIC_KEY_FILE = "public_key.txt";

    @Bean
    public TokenStore tokenStore() {
        //JWT令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        ClassPathResource classPathResource = new ClassPathResource(PUBLIC_KEY_FILE);

        String publicKey;
        try {
            publicKey= IOUtils.toString(classPathResource.getInputStream(),"UTF-8");
            log.info("public key: {}" , publicKey);
        } catch (IOException e) {
            log.error("load public key error.", e);
            throw new RuntimeException(e);
        }
        jwtAccessTokenConverter.setVerifierKey(publicKey);
        return jwtAccessTokenConverter;
    }
}
