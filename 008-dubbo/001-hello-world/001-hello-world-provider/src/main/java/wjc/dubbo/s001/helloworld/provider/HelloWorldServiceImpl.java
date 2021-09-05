package wjc.dubbo.s001.helloworld.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;
import wjc.dubbo.s001.helloworld.api.HelloRequest;
import wjc.dubbo.s001.helloworld.api.HelloResponse;
import wjc.dubbo.s001.helloworld.api.IHelloWorldService;

import java.util.concurrent.CompletableFuture;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-09-05 12:38
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@Slf4j
public class HelloWorldServiceImpl implements IHelloWorldService {

    @Override
    public HelloResponse sayHello(HelloRequest request) {
        log.info("Hello " + request.getName() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return HelloResponse.newBuilder()
                .setMessage("Hello " + request.getName() + ", response from provider: "
                        + RpcContext.getContext().getLocalAddress())
                .build();
    }

    @Override
    public CompletableFuture<HelloResponse> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }
}