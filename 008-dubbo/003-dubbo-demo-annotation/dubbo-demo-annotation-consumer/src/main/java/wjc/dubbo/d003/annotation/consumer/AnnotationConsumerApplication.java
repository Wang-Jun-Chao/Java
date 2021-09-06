package wjc.dubbo.d003.annotation.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import wjc.dubbo.d003.annotation.consumer.component.DemoServiceComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import wjc.dubbo.demo.api.DemoService;

public class AnnotationConsumerApplication {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConsumerConfiguration.class);
        context.start();
        DemoService service = context.getBean("demoServiceComponent", DemoServiceComponent.class);
        String hello = service.sayHello("world");
        System.out.println("result :" + hello);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "wjc.dubbo.d003.annotation.consumer.component")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"wjc.dubbo.d003.annotation.consumer.component"})
    static class ConsumerConfiguration {

    }
}
