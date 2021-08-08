package wjc.spring.security.oauth2.distributed.jwt.rsa.uaa;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@SentinelResource
@EnableFeignClients(basePackages = {"wjc.spring.security.oauth2.distributed.jwt.uaa"})
public class UaaJwtRsaServer {
    public static void main(String[] args) {
        SpringApplication.run(UaaJwtRsaServer.class, args);
    }
}
