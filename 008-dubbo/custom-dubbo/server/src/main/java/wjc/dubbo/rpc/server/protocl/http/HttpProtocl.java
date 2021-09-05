package wjc.dubbo.rpc.server.protocl.http;

import wjc.dubbo.rpc.api.entity.Invocation;
import wjc.dubbo.rpc.api.entity.URL;
import wjc.dubbo.rpc.server.protocl.Protocl;
import wjc.dubbo.rpc.server.protocl.http.client.HttpClient;

public class HttpProtocl implements Protocl {

    public Object invokeProtocl(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHost(),url.getPort(),invocation);
    }

    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHost(),url.getPort());
    }
}
