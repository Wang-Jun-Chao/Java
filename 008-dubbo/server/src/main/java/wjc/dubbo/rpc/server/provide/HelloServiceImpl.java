package wjc.dubbo.rpc.server.provide;

import wjc.dubbo.rpc.api.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("hello," + name);
        return "hello " + name;
    }
}
