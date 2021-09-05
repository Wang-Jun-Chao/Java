package wjc.dubbo.rpc.client.comsummer;

import wjc.dubbo.rpc.api.HelloService;
import wjc.dubbo.rpc.client.proxy.ProxyFactory;
import wjc.dubbo.rpc.register.RegisterType;
import wjc.dubbo.rpc.server.protocl.ProtoclType;

public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(ProtoclType.HTTP, RegisterType.ZOOKEEPER,HelloService.class);
        String result = helloService.sayHello("wangjunchao");
        System.out.println(result);
    }
}
