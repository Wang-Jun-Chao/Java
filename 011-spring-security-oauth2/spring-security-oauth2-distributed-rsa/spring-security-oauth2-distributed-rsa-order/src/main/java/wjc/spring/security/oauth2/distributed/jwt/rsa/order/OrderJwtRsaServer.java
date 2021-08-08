package wjc.spring.security.oauth2.distributed.jwt.rsa.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderJwtRsaServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderJwtRsaServer.class, args);
    }
}
