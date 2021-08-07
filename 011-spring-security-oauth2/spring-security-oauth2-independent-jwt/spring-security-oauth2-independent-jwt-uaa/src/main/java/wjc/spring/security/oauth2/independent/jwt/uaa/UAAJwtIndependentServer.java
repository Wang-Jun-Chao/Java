package wjc.spring.security.oauth2.independent.jwt.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
public class UAAJwtIndependentServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAJwtIndependentServer.class, args);
    }
}
