package wjc.dubbo.rpc.register.factory;


import wjc.dubbo.rpc.register.LocalRegister;
import wjc.dubbo.rpc.register.RegisterType;
import wjc.dubbo.rpc.register.local.LocalMapRegister;

public class LocalRegisterFactory {

    private static LocalMapRegister localMapRegister = new LocalMapRegister();
    public static LocalRegister getLocalRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL: return localMapRegister;
            default:return null;
        }
    }
}
