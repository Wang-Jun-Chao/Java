package wjc.dubbo.s001.helloworld.api;

import java.util.concurrent.CompletableFuture;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-09-05 14:48
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */

@javax.annotation.Generated(
        value = "by Dubbo generator",
        comments = "Source: hello-world-service.proto")
public interface IHelloWorldService {
    static final String JAVA_SERVICE_NAME = "wjc.dubbo.s001.helloworld.api.IHelloWorldService";
    static final String SERVICE_NAME = JAVA_SERVICE_NAME;

    HelloResponse sayHello(HelloRequest request);

    CompletableFuture<HelloResponse> sayHelloAsync(HelloRequest request);
}
