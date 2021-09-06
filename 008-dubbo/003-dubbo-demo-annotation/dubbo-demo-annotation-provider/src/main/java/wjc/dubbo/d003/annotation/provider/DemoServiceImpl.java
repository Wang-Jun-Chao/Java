package wjc.dubbo.d003.annotation.provider;


import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wjc.dubbo.demo.api.DemoService;

import java.util.concurrent.CompletableFuture;

@DubboService
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("Hello " + name + ", request from consumer: " + RpcContext.getServiceContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getServiceContext().getLocalAddress();
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }

}
