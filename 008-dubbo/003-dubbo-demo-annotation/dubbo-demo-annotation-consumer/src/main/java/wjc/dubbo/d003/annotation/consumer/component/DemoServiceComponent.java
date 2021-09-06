package wjc.dubbo.d003.annotation.consumer.component;

import org.apache.dubbo.config.annotation.DubboReference;

import org.springframework.stereotype.Component;
import wjc.dubbo.demo.api.DemoService;

import java.util.concurrent.CompletableFuture;

@Component("demoServiceComponent")
public class DemoServiceComponent implements DemoService {
    @DubboReference
    private DemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }
}
