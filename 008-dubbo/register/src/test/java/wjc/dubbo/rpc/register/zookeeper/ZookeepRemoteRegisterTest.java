package wjc.dubbo.rpc.register.zookeeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wjc.dubbo.rpc.api.HelloService;
import wjc.dubbo.rpc.api.entity.URL;

public class ZookeepRemoteRegisterTest {
    ZookeepRemoteRegister remoteRegister;

    @BeforeEach
    public void setUp() throws Exception {
        remoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    }

    @Test
    public void register() {

        remoteRegister.register(HelloService.class.getName(), new URL("localhost", 8021));
    }


    @Test
    public void getRadomURL() {
        register();
        remoteRegister.getRadomURL(HelloService.class.getName());
    }
}