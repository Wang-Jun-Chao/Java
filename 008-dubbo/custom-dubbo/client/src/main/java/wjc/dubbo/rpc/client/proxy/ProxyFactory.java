package wjc.dubbo.rpc.client.proxy;

import wjc.dubbo.rpc.api.entity.Invocation;
import wjc.dubbo.rpc.api.entity.URL;
import wjc.dubbo.rpc.register.RegisterType;
import wjc.dubbo.rpc.register.RemoteRegister;
import wjc.dubbo.rpc.register.factory.RemoteRegisterFactory;
import wjc.dubbo.rpc.server.protocl.Protocl;
import wjc.dubbo.rpc.server.protocl.ProtoclFactory;
import wjc.dubbo.rpc.server.protocl.ProtoclType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(final ProtoclType protoclType ,final RegisterType registerType, final Class interfaceClass){
       return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Protocl protocl = ProtoclFactory.getProtocl(protoclType);
               Invocation invocation = new Invocation(interfaceClass.getName(),method.getName(),method.getParameterTypes(),args);
               RemoteRegister remoteRegister = RemoteRegisterFactory.getRemoteRegister(registerType);
               URL radomURL = remoteRegister.getRadomURL(interfaceClass.getName());
               System.out.println("调用地址host:"+ radomURL.getHost()+ ",port:"+radomURL.getPort());
               return protocl.invokeProtocl(radomURL,invocation);
           }
       });
    }
}
