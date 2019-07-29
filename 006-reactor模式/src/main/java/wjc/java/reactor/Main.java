package wjc.java.reactor;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-29 17:33
 **/
public class Main  {
    public static void main(String[] args) {
        Server server = new Server(1000);
        server.getAcceptor().addNewConnection(new InputSource("data", System.currentTimeMillis()));

    }
}
