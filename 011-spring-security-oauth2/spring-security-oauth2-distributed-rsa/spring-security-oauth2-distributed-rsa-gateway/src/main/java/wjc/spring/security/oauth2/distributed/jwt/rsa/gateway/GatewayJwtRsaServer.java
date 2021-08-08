package wjc.spring.security.oauth2.distributed.jwt.rsa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication()
public class GatewayJwtRsaServer {

    public static void main(String[] args) {
        SpringApplication.run(GatewayJwtRsaServer.class, args);
    }
}
