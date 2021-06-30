package wjc.dubbo.rpc.register.zookeeper;

import wjc.dubbo.rpc.api.HelloService;
import wjc.dubbo.rpc.api.entity.URL;
import org.junit.Before;

public class ZookeepRemoteRegisterTest {
    ZookeepRemoteRegister remoteRegister;
    @Before
    public void setUp() throws Exception {
        remoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    }

    @org.junit.Test
    public void register() {

        remoteRegister.register(HelloService.class.getName(),new URL("localhost",8021));
    }

    @org.junit.Test
    public void getRadomURL() {
        register();
        remoteRegister.getRadomURL(HelloService.class.getName());
    }
}