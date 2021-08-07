package wjc.spring.security.oauth2.independent.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
public class OrderIndependentServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderIndependentServer.class, args);
    }
}
