package wjc.dubbo.rpc.register.factory;


import wjc.dubbo.rpc.register.RegisterType;
import wjc.dubbo.rpc.register.RemoteRegister;
import wjc.dubbo.rpc.register.local.RemoterMapRegister;
import wjc.dubbo.rpc.register.zookeeper.ZookeepRemoteRegister;
import wjc.dubbo.rpc.register.zookeeper.ZookeeperClient;

public class RemoteRegisterFactory  {
    private static RemoterMapRegister remoterMapRegister = new RemoterMapRegister();
    private static ZookeepRemoteRegister zookeepRemoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    public static RemoteRegister getRemoteRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL:return remoterMapRegister;
            case ZOOKEEPER: return zookeepRemoteRegister;
            default:return null;
        }
    }
}
