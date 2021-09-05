package wjc.dubbo.rpc.server.protocl.dubbo;

import wjc.dubbo.rpc.api.entity.Invocation;
import wjc.dubbo.rpc.api.entity.URL;
import wjc.dubbo.rpc.server.protocl.Protocl;
import wjc.dubbo.rpc.server.protocl.dubbo.client.NettyClient;

public class NettyProtocl implements Protocl {
    public Object invokeProtocl(URL url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHost(),url.getPort(),invocation);
    }

    public void start(URL url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHost(),url.getPort());
    }
}
