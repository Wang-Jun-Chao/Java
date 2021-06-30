package wjc.dubbo.rpc.register.redis;

import wjc.dubbo.rpc.api.entity.URL;
import wjc.dubbo.rpc.register.RemoteRegister;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-07-01 06:47
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class RedisRemoteRegister implements RemoteRegister {
    @Override
    public void register(String interfaceName, URL host) {

    }

    @Override
    public URL getRadomURL(String interfaceName) {
        return null;
    }
}
