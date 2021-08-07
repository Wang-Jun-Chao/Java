package wjc.spring.security.oauth2.independent.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
public class UAAIndependentServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAIndependentServer.class, args);
    }
}
