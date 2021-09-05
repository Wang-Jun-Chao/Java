package wjc.dubbo.rpc.server.provide;

import wjc.dubbo.rpc.api.HelloService;
import wjc.dubbo.rpc.api.entity.URL;
import wjc.dubbo.rpc.register.LocalRegister;
import wjc.dubbo.rpc.register.RegisterType;
import wjc.dubbo.rpc.register.RemoteRegister;
import wjc.dubbo.rpc.register.factory.LocalRegisterFactory;
import wjc.dubbo.rpc.register.factory.RemoteRegisterFactory;
import wjc.dubbo.rpc.server.protocl.Protocl;
import wjc.dubbo.rpc.server.protocl.ProtoclFactory;
import wjc.dubbo.rpc.server.protocl.ProtoclType;


public class Provider {
    public static void main(String[] args) {
            URL url = new URL("localhost",8021);
            //远程服务注册地址
            RemoteRegister register = RemoteRegisterFactory.getRemoteRegister(RegisterType.ZOOKEEPER);
            register.register(HelloService.class.getName(),url);

            //本地注册服务的实现类
            LocalRegister localRegister = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL);
            localRegister.register(HelloService.class.getName(),HelloServiceImpl.class);

            Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.HTTP);
            protocl.start(url);
    }
}
